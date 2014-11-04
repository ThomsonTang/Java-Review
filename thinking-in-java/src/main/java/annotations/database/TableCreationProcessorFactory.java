package annotations.database;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.SimpleElementVisitor6;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * The database example using Visitor.
 * <p>
 * This is the SQL table generator again, this using a factory and a processor
 * that makes use of the Visitor pattern.
 *
 * @author Thomson Tang
 */
public class TableCreationProcessorFactory implements Processor {

    @Override public Set<String> getSupportedOptions() {
        return Collections.emptySet();
    }

    @Override public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Arrays.asList(
            "annotations.database.DBTable",
            "annotations.database.Constraints",
            "annotations.database.SqlInteger",
            "annotations.database.SqlString"
        ));
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

    private static class TableCreationProcessor extends AbstractProcessor {
        private final ProcessingEnvironment environment;
        private String sql = "";

        public TableCreationProcessor(ProcessingEnvironment environment) {
            this.environment = environment;
        }

        @Override public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
            for (TypeElement typeElement : annotations) {
            }
            return true;
        }

        private class TableCreationVisitor extends SimpleElementVisitor6 {

            @Override public Object visitType(TypeElement e, Object o) {
                DBTable dbTable = e.getAnnotation(DBTable.class);
                if (null != dbTable) {
                    sql += "CREATE TABLE ";
                    sql += (dbTable.name().length() < 1)
                        ? e.getSimpleName().toString().toUpperCase()
                        : dbTable.name();
                    sql += " (";
                }
                return sql;
            }
        }
    }
}
