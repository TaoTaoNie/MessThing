package annotations;

import com.sun.mirror.apt.AnnotationProcessor;
import com.sun.mirror.apt.AnnotationProcessorEnvironment;
import com.sun.mirror.apt.AnnotationProcessorFactory;
import com.sun.mirror.declaration.AnnotationTypeDeclaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

/**
 * @author leetHuam
 * @version 1.0
 */
public class InterfaceExtractorProcessorFactory implements AnnotationProcessorFactory{
    @Override
    public AnnotationProcessor getProcessorFor(Set<AnnotationTypeDeclaration> set, AnnotationProcessorEnvironment annotationProcessorEnvironment) {
        return new InterfaceExtractorProcessor(annotationProcessorEnvironment);
    }

    @Override
    public Collection<String> supportedAnnotationTypes() {
        return Collections.singleton("annotations.ExtractInterface");
    }

    @Override
    public Collection<String> supportedOptions() {
        return Collections.emptySet();
    }
}
