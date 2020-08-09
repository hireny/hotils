package org.hotilsframework.inject.qualifier;

import java.lang.annotation.Annotation;
import java.util.Objects;

/**
 * AnnotationQualifier
 * 类描述
 *
 * @author hireny
 * @create 2020-08-07 23:39
 */
public class AnnotationQualifier extends NamedQualifier {

    private final Annotation qualifier;

    public AnnotationQualifier(Annotation qualifier) {
        super(qualifier.annotationType().getSimpleName());
        this.qualifier = qualifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        AnnotationQualifier that = (AnnotationQualifier) o;
        return Objects.equals(qualifier, that.qualifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), qualifier);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("@Qualifier(");
        sb.append("qualifier=").append(qualifier);
        sb.append(')');
        return sb.toString();
    }
}
