package org.hotilsframework.inject.internal;

import java.util.Objects;

/**
 * StackTraceElements
 * 类描述
 *
 * @author hireny
 * @create 2020-08-03 0:11
 */
public class StackTraceElements {

    public static InMemoryStackTraceElement[] convertToInMemoryStackTraceElement(StackTraceElement[] stackTraceElements) {
        if (stackTraceElements.length == 0) {
            return new InMemoryStackTraceElement[0];
        }
        InMemoryStackTraceElement[] inMemoryStackTraceElements = new InMemoryStackTraceElement[stackTraceElements.length];
        for (int i = 0; i < stackTraceElements.length; i++) {
            inMemoryStackTraceElements[i] = new InMemoryStackTraceElement(stackTraceElements[i]);
        }
        return inMemoryStackTraceElements;
    }

    public static class InMemoryStackTraceElement {
        private String declaringClass;
        private String methodName;
        private int lineNumber;

        InMemoryStackTraceElement(StackTraceElement ste) {
            this(ste.getClassName(), ste.getMethodName(), ste.getLineNumber());
        }

        InMemoryStackTraceElement(String declaringClass, String methodName, int lineNumber) {
            this.declaringClass = declaringClass;
            this.methodName = methodName;
            this.lineNumber = lineNumber;
        }

        public String getDeclaringClass() {
            return declaringClass;
        }

        public String getMethodName() {
            return methodName;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            InMemoryStackTraceElement that = (InMemoryStackTraceElement) o;
            return lineNumber == that.lineNumber &&
                    Objects.equals(declaringClass, that.declaringClass) &&
                    Objects.equals(methodName, that.methodName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(declaringClass, methodName, lineNumber);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("InMemoryStackTraceElement{");
            sb.append("declaringClass='").append(declaringClass).append('\'');
            sb.append(", methodName='").append(methodName).append('\'');
            sb.append(", lineNumber=").append(lineNumber);
            sb.append('}');
            return sb.toString();
        }
    }
}
