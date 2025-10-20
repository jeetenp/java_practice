package com.yourorg.recipes;

import org.openrewrite.Recipe;
import org.openrewrite.TreeVisitor;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.marker.Markers;

import java.util.regex.Pattern;

public class RemoveCommentedOutCodeRecipe extends Recipe {

    @Override
    public String getDisplayName() {
        return "Remove commented-out code (S125)";
    }

    @Override
    public String getDescription() {
        return "Remove commented-out Java code fragments based on Sonar rule java:S125.";
    }

    @Override
    public TreeVisitor<?, ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {
            private final Pattern codeLikePattern = Pattern.compile(
                "(if\\s*\\()|(for\\s*\\()|(while\\s*\\()|(public\\s+class)|(private\\s+static)|(System\\.out)|(int\\s+\\w+\\s*\\=)|(return\\s+)");

            @Override
            public J.CompilationUnit visitCompilationUnit(J.CompilationUnit cu, ExecutionContext ctx) {
                J.CompilationUnit c = super.visitCompilationUnit(cu, ctx);
                if (c.getComments() != null) {
                    c = c.withComments(c.getComments().stream()
                            .filter(comment -> !codeLikePattern.matcher(comment.getText()).find())
                            .toList());
                }
                return c;
            }
        };
    }
}