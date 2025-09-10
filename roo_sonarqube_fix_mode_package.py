# Package: roo_sonarqube_fix_mode
# This single-file package document contains a plug-and-play Roo Code mode implementation.
# Each file is separated by a header: "### FILE: <path>" so you can copy files into a repo.

### FILE: pyproject.toml
[build-system]
requires = ["setuptools", "wheel"]
build-backend = "setuptools.build_meta"

[project]
name = "roo-sonarqube-fix-mode"
version = "0.1.0"
authors = [ { name = "Roo Code Extension" } ]
license = { text = "MIT" }
description = "Roo Code mode: fetch SonarQube issues and apply hybrid AST+LLM fixes"
readme = "README.md"
requires-python = ">=3.10"

[project.scripts]
roo-sonar-fix = "roo_sonarqube_fix_mode.cli:main"

### FILE: README.md
# Roo SonarQube Fix Mode

This package provides a Roo Code "mode" that:

- Fetches issues from SonarQube for a given project
- Applies deterministic AST-based fixes for supported rules
- When needed, orchestrates LLM-driven fixes using configurable prompt templates
- Offers a CLI entrypoint and a Dockerfile for enterprise deployment

See `CONFIG.md` below for configuration and secrets handling.

### FILE: CONFIG.md
- `SONAR_URL` - SonarQube base URL (e.g. https://sonarqube.example.com)
- `SONAR_TOKEN` - A SonarQube user token with `api` access
- `LLM_PROVIDER` - `openai` or `internal` (configures how to call the LLM)
- `LLM_API_KEY` - API key for the LLM provider (kept secret)
- `RULES_MAPPING` - JSON or file mapping of Sonar rule keys to handlers

Secrets: Use environment variables or a secrets manager. Don't store tokens in source control.

### FILE: roo_sonarqube_fix_mode/__init__.py
# Package entry

__all__ = [
    "mode",
    "sonar_client",
    "fixer",
    "config",
]

### FILE: roo_sonarqube_fix_mode/config.py
import os
from typing import Dict

DEFAULTS = {
    "SONAR_URL": os.getenv("SONAR_URL", "http://localhost:9000"),
    "SONAR_TOKEN": os.getenv("SONAR_TOKEN", ""),
    "LLM_PROVIDER": os.getenv("LLM_PROVIDER", "openai"),
    "LLM_API_KEY": os.getenv("LLM_API_KEY", ""),
    # map Sonar rule keys to handler names
    "RULES_MAPPING": {
        "S1172": "remove_unused_param",
        "S125": "remove_commented_code",
        "python:D001": "add_docstring",
    }
}

def load_config() -> Dict:
    # Could be extended to load from YAML/JSON or a central config store
    return DEFAULTS

### FILE: roo_sonarqube_fix_mode/sonar_client.py
import requests
from typing import Dict, Any

class SonarQubeClient:
    def __init__(self, base_url: str, token: str):
        self.base_url = base_url.rstrip("/")
        self.token = token
        self._auth = (self.token, "") if self.token else None

    def _get(self, path: str, params: Dict[str, Any] = None) -> Dict:
        url = f"{self.base_url}{path}"
        resp = requests.get(url, params=params, auth=self._auth, timeout=30)
        resp.raise_for_status()
        return resp.json()

    def fetch_issues(self, project_key: str, page_size: int = 100) -> Dict:
        params = {"componentKeys": project_key, "ps": page_size}
        return self._get("/api/issues/search", params=params)

    def fetch_file_content(self, file_path: str, branch: str = None) -> str:
        # Sonar doesn't store raw source in issue payload; in some setups you may need
        # to fetch from VCS. This method is a placeholder to show where to integrate
        # with Git or an artifact store.
        raise NotImplementedError("Integrate with your VCS or artifact storage to fetch files")

### FILE: roo_sonarqube_fix_mode/fixer/ast_rules.py
import ast
from ast import NodeTransformer
from typing import Optional

class DocstringAdder(NodeTransformer):
    """Simple AST transformer that adds placeholder docstrings to functions missing them."""
    def visit_FunctionDef(self, node: ast.FunctionDef) -> ast.FunctionDef:
        if not ast.get_docstring(node):
            doc = ast.Expr(value=ast.Constant(value="TODO: add docstring"))
            node.body.insert(0, doc)
        return self.generic_visit(node)


def apply_ast_docstring_fix(source: str) -> str:
    tree = ast.parse(source)
    tree = DocstringAdder().visit(tree)
    ast.fix_missing_locations(tree)
    return ast.unparse(tree)

### FILE: roo_sonarqube_fix_mode/fixer/llm_rules.py
from typing import Dict
import json

# NOTE: This file contains a pluggable LLM layer. You must implement `call_llm` for your provider.

DEFAULT_PROMPT_TEMPLATE = (
    "You are an expert Python developer.\n"
    "SonarQube rule: {rule}\n"
    "Issue message: {message}\n"
    "File path: {path}\n"
    "Provide a fixed version of the code below. Keep formatting and comments. "
    "If you cannot safely make the change, explain why.\n\n"
    "CODE:\n"""{code}"""
)


def call_llm(prompt: str, max_tokens: int = 1024) -> str:
    """Adapter method. Implement provider-specific call here.
    For OpenAI, you'd call the completions/chat endpoint with the prompt.
    For internal enterprise LLMs, use your internal SDK.
    """
    # Placeholder: raise to force integration.
    raise NotImplementedError("Call your LLM provider here. Replace call_llm implementation.")


def fix_with_llm(code: str, issue: Dict) -> str:
    prompt = DEFAULT_PROMPT_TEMPLATE.format(
        rule=issue.get("rule"),
        message=issue.get("message"),
        path=issue.get("component"),
        code=code,
    )
    return call_llm(prompt)

### FILE: roo_sonarqube_fix_mode/fixer/orchestrator.py
from typing import Dict
from .ast_rules import apply_ast_docstring_fix
from .llm_rules import fix_with_llm

# Lightweight orchestrator: try AST fixes first, fall back to LLM when needed.

AST_RULES = {"python:D001": apply_ast_docstring_fix}


def fix_code(source: str, issue: Dict) -> Dict[str, str]:
    """Return dict: {"strategy": str, "fixed": str, "notes": str}
    strategy: one of ["ast","llm","skip"]
    """
    rule = issue.get("rule")
    if rule in AST_RULES:
        try:
            fixed = AST_RULES[rule](source)
            return {"strategy": "ast", "fixed": fixed, "notes": "ast rule applied"}
        except Exception as e:
            return {"strategy": "skip", "fixed": source, "notes": f"ast failed: {e}"}

    # fallback to LLM
    try:
        fixed = fix_with_llm(source, issue)
        return {"strategy": "llm", "fixed": fixed, "notes": "llm suggested change"}
    except Exception as e:
        return {"strategy": "skip", "fixed": source, "notes": f"llm failed: {e}"}

### FILE: roo_sonarqube_fix_mode/mode.py
import os
from typing import Dict
from roo_sonarqube_fix_mode.sonar_client import SonarQubeClient
from roo_sonarqube_fix_mode.fixer.orchestrator import fix_code
from roo_sonarqube_fix_mode.config import load_config

class SonarQubeFixMode:
    """Roo Code Mode: fetch issues and apply fixes.

    This class is written to be imported and registered in Roo Code's mode registry.
    """
    name = "sonarqube-fix"

    def __init__(self, config: Dict = None):
        self.config = config or load_config()
        self.client = SonarQubeClient(self.config["SONAR_URL"], self.config["SONAR_TOKEN"])

    def _resolve_filepath(self, component: str, repo_root: str) -> str:
        # Sonar's component often contains '<project_key>:path/to/file'
        if ":" in component:
            path = component.split(":", 1)[1]
        else:
            path = component
        return os.path.join(repo_root, path)

    def run(self, repo_root: str, project_key: str, dry_run: bool = True):
        issues_payload = self.client.fetch_issues(project_key)
        issues = issues_payload.get("issues", [])
        results = []
        for issue in issues:
            file_path = self._resolve_filepath(issue.get("component"), repo_root)
            if not os.path.exists(file_path):
                results.append({"issue": issue, "status": "missing_file"})
                continue

            with open(file_path, "r", encoding="utf-8") as fh:
                src = fh.read()

            outcome = fix_code(src, issue)
            if outcome["strategy"] == "skip":
                results.append({"issue": issue, "status": "skipped", "notes": outcome.get("notes")})
                continue

            if dry_run:
                results.append({"issue": issue, "status": "dry_run", "strategy": outcome["strategy"], "notes": outcome.get("notes")})
            else:
                with open(file_path, "w", encoding="utf-8") as fh:
                    fh.write(outcome["fixed"])
                results.append({"issue": issue, "status": "fixed", "strategy": outcome["strategy"]})

        return results

### FILE: roo_sonarqube_fix_mode/cli.py
import argparse
import json
from roo_sonarqube_fix_mode.mode import SonarQubeFixMode
from roo_sonarqube_fix_mode.config import load_config


def main():
    parser = argparse.ArgumentParser(description="Roo Code SonarQube Fix Mode CLI")
    parser.add_argument("--repo-root", required=True, help="Path to repository root")
    parser.add_argument("--project-key", required=True, help="SonarQube project key")
    parser.add_argument("--no-dry-run", action="store_true", help="Apply changes to files")
    parser.add_argument("--output", help="Path to write JSON report")
    args = parser.parse_args()

    cfg = load_config()
    mode = SonarQubeFixMode(cfg)
    results = mode.run(args.repo_root, args.project_key, dry_run=not args.no_dry_run)

    out = json.dumps(results, indent=2)
    if args.output:
        with open(args.output, "w") as fh:
            fh.write(out)
        print(f"Report written to {args.output}")
    else:
        print(out)

if __name__ == "__main__":
    main()

### FILE: requirements.txt
requests>=2.28

### FILE: Dockerfile
FROM python:3.11-slim
WORKDIR /app
COPY . /app
RUN pip install --no-cache-dir -r requirements.txt
ENTRYPOINT ["roo-sonar-fix"]

### FILE: .github/workflows/ci.yml
name: CI
on: [push, pull_request]
jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v4
      - name: Set up Python
        uses: actions/setup-python@v4
        with:
          python-version: '3.11'
      - name: Install
        run: pip install -r requirements.txt
      - name: Lint
        run: python -m pip install astpretty && python -m pyflakes . || true

### FILE: tests/test_mode_basic.py
import tempfile
import os
from roo_sonarqube_fix_mode.mode import SonarQubeFixMode


def test_dry_run_no_files(monkeypatch):
    # create a fake Sonar client that returns an issue pointing to a missing file
    class FakeClient:
        def __init__(self, *a, **k):
            pass
        def fetch_issues(self, project_key, page_size=100):
            return {"issues": [{"component": "proj:missing.py", "rule": "python:D001", "message": "Missing docstring"}]}

    monkeypatch.setattr('roo_sonarqube_fix_mode.mode.SonarQubeClient', FakeClient)
    mode = SonarQubeFixMode({"SONAR_URL":"x","SONAR_TOKEN":""})
    tmp = tempfile.mkdtemp()
    results = mode.run(tmp, "proj", dry_run=True)
    assert results[0]["status"] == "missing_file"

### FILE: USAGE.md
Basic usage:

```bash
# dry run
roo-sonar-fix --repo-root . --project-key my_project

# apply changes
roo-sonar-fix --repo-root . --project-key my_project --no-dry-run --output report.json
```

### FILE: NOTES.md
- LLM integration intentionally abstracted. Implement `call_llm` in `fixer/llm_rules.py` using your enterprise provider or OpenAI.
- VCS/file fetching: Sonar often reports file paths; integrate with your Git host (GitHub/GitLab/Bitbucket) to fetch exact file content at the commit referenced by Sonar.
- Permissions & safety: Always run in dry-run mode during initial rollout. Add approval gates (PR creation) rather than direct rewrites for high-risk repos.

# End of package
