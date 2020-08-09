package org.hotilsframework.inject.qualifier;

import org.hotilsframework.inject.Qualifier;
import org.hotilsframework.inject.Typed;

import java.util.*;

/**
 * TypeAnnotationQualifier
 * 类描述
 *
 * @author hireny
 * @create 2020-08-08 0:05
 */
public class TypeAnnotationQualifier implements Qualifier {

    private final List<Class<?>> types;

    public TypeAnnotationQualifier(Class<?>... types) {
        if (types != null) {
            this.types = new ArrayList<>(types.length);
            for (Class<?> type : types) {
                Typed typed = type.getAnnotation(Typed.class);
                if (typed != null) {
                    this.types.addAll(Arrays.asList(typed.value()));
                } else {
                    this.types.add(type);
                }
            }
        } else {
            this.types = Collections.emptyList();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TypeAnnotationQualifier that = (TypeAnnotationQualifier) o;
        return Objects.equals(types, that.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(types);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("@Qualifier(");
        sb.append("types=").append(types);
        sb.append(')');
        return sb.toString();
    }
}
