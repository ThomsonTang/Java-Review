package annotations;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * APT-base annotation processing.
 * This is the processor to do the extraction.
 *
 * implements AnnotationProcessor >>>>>>>>  need tools.jar
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 9/4/13
 */
public class InterfaceExtractorProcessor implements Processor{
    @Override public Set<String> getSupportedOptions() {
        return null;
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        return null;
    }

    @Override public SourceVersion getSupportedSourceVersion() {
        return null;
    }

    @Override public void init(ProcessingEnvironment processingEnv) {

    }

    @Override public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }

    @Override public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member,
        String userText) {
        return null;
    }
}
