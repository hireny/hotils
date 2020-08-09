package org.hotilsframework.inject.qualifier;

import org.hotilsframework.inject.Named;
import org.hotilsframework.inject.Qualifier;
import org.hotilsframework.inject.Typed;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Objects;

/**
 * Quailfiers
 *
 * 限定符工具类
 *
 * @author hireny
 * @create 2020-08-07 23:09
 */
public class Qualifiers {

    private Qualifiers() {}

    /**
     * 生成一个注解，用于标记
     * @param name
     * @return
     */
    public static Named named(String name) {
        return new InternalNamed(name);
    }

    public static Typed typed(Class<?>... classes) {
        return new InternalTyped(classes);
    }

    /**
     * 按名称标识
     * @param name
     * @return
     */
    public static Qualifier byName(String name) {
        return new NamedQualifier(name);
    }

    /**
     * 按注解标识
     * @param annotation
     * @return
     */
    public static Qualifier byAnnotation(Annotation annotation) {
        if (Typed.class == annotation.annotationType()) {
            Typed typed = (Typed) annotation;
            return byType(typed.value());
        } else if (javax.inject.Named.class == annotation.annotationType()) {
            javax.inject.Named named = (javax.inject.Named) annotation;
            return byName(named.value());
        } else if (Named.class == annotation.annotationType()) {
            Named named = (Named) annotation;
            return byName(named.value());
        }
        return new AnnotationQualifier(annotation);
    }

    public static Qualifier byType(Class<?>... typeArguments) {
        return new TypeAnnotationQualifier(typeArguments);
    }

    private static class InternalTyped implements Typed {

        private final Class<?>[] classes;

        private InternalTyped(Class<?>[] classes) {
            this.classes = classes;
        }

        @Override
        public Class<?>[] value() {
            return this.classes;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return Typed.class;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            InternalTyped that = (InternalTyped) o;
            return Arrays.equals(classes, that.classes);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(classes);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("@");
            sb.append(Typed.class.getName());
            sb.append("(classes=").append(Arrays.toString(classes));
            sb.append(')');
            return sb.toString();
        }
    }

    private static class InternalNamed implements Named {

        private final String value;

        private InternalNamed(String value) {
            this.value = value;
        }

        @Override
        public String value() {
            return this.value;
        }

        @Override
        public Class<? extends Annotation> annotationType() {
            return Named.class;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            InternalNamed that = (InternalNamed) o;
            return Objects.equals(value, that.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("@");
            sb.append(Named.class.getName());
            sb.append("(value='").append(value).append('\'');
            sb.append(')');
            return sb.toString();
        }
    }
}
