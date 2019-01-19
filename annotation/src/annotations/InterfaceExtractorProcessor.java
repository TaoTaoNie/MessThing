package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.declaration.MethodDeclaration;
import com.sun.mirror.declaration.Modifier;
import com.sun.mirror.declaration.ParameterDeclaration;
import com.sun.mirror.declaration.TypeDeclaration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author leetHuam
 * @version 1.0
 */
public class InterfaceExtractorProcessor implements AnnotationProcessor{
    private final AnnotationProcessorEnvironment environment;
    private ArrayList<MethodDeclaration> interfaceMethods = new ArrayList<>();
    public InterfaceExtractorProcessor(AnnotationProcessorEnvironment environment) {
        this.environment = environment;
    }
    public void process() {
        for (TypeDeclaration typeDeclaration : environment.getSpecifiedTypeDeclarations()) {
            ExtractInterface annotation = typeDeclaration.getAnnotation(ExtractInterface.class);
            if (annotation == null)
                break;
            for (MethodDeclaration m : typeDeclaration.getMethods())
                if (m.getModifiers().contains(Modifier.PUBLIC) && !(m.getModifiers().contains(Modifier.STATIC)))
                    interfaceMethods.add(m);
            if (interfaceMethods.size() > 0) {
                try {
                    PrintWriter writer = environment.getFiler().createSourceFile(annotation.value());
                    writer.println("package " + typeDeclaration.getPackage().getQualifiedName() + ";");
                    writer.println("public interface " + annotation.value() + " {");
                    for (MethodDeclaration m : interfaceMethods) {
                        writer.print("  public ");
                        writer.print(m.getReturnType() + " ");
                        writer.print(m.getSimpleName() + " (");
                        int i = 0;
                        for (ParameterDeclaration parameterDeclaration : m.getParameters()) {
                            writer.print(parameterDeclaration.getType() + " " + parameterDeclaration.getSimpleName());
                            if (++i < m.getParameters().size())
                                writer.print(", ");
                        }
                        writer.println(");");
                    }
                    writer.println("}");
                    writer.close();
                }catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
