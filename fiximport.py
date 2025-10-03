import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.symbolsolver.javaparsermodel.JavaParserFacade;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaFixer {

    private static CombinedTypeSolver typeSolver;

    // Initialize SymbolSolver with Reflection + source path
    public static void initSymbolSolver(String sourceRootPath) {
        typeSolver = new CombinedTypeSolver();
        typeSolver.add(new ReflectionTypeSolver()); // JDK classes
        typeSolver.add(new JavaParserTypeSolver(new File(sourceRootPath))); // Your project sources
    }

    public static void fixUnusedImports(CompilationUnit cu) {
        List<ImportDeclaration> imports = new ArrayList<>(cu.getImports());

        for (ImportDeclaration imp : imports) {
            String qualifiedName = imp.getNameAsString(); // e.g., java.util.List
            String simpleName = imp.getName().getIdentifier(); // e.g., List

            // Check if symbol is actually referenced in the code
            boolean isUsed = cu.findAll(com.github.javaparser.ast.expr.Name.class).stream()
                    .anyMatch(nameExpr -> {
                        try {
                            return JavaParserFacade.get(typeSolver)
                                    .solve(nameExpr)
                                    .getCorrespondingDeclaration()
                                    .getQualifiedName()
                                    .equals(qualifiedName);
                        } catch (Exception e) {
                            return false;
                        }
                    });

            if (!isUsed) {
                cu.getImports().remove(imp);
            }
        }
    }
}
