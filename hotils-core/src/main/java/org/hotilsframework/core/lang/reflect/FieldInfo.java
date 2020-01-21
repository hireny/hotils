package org.hotilsframework.core.lang.reflect;

import java.io.Serializable;

/**
 * 字段属性
 * @ClassName: FieldInfo
 * @Author: hireny
 * @Date: Created in 2020-01-21 8:35
 * @Version: 1.0
 */
public final class FieldInfo implements Serializable {
    private static final long serialVersionUID = -683611774269877454L;
    private String fieldName;
    private Class<?> fieldType;
    private Object firstValue;
    private Object secondValue;

    public FieldInfo() {}

    public FieldInfo(String fieldName, Class<?> fieldType, Object firstValue, Object secondValue) {
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Class<?> getFieldType() {
        return fieldType;
    }

    public void setFieldType(Class<?> fieldType) {
        this.fieldType = fieldType;
    }

    public Object getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(Object firstValue) {
        this.firstValue = firstValue;
    }

    public Object getSecondValue() {
        return secondValue;
    }

    public void setSecondValue(Object secondValue) {
        this.secondValue = secondValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FieldInfo fieldInfo = (FieldInfo) o;

        if (fieldName != null ? !fieldName.equals(fieldInfo.fieldName) : fieldInfo.fieldName != null) return false;
        if (fieldType != null ? !fieldType.equals(fieldInfo.fieldType) : fieldInfo.fieldType != null) return false;
        if (firstValue != null ? !firstValue.equals(fieldInfo.firstValue) : fieldInfo.firstValue != null) return false;
        return secondValue != null ? secondValue.equals(fieldInfo.secondValue) : fieldInfo.secondValue == null;
    }

    @Override
    public int hashCode() {
        int result = fieldName != null ? fieldName.hashCode() : 0;
        result = 31 * result + (fieldType != null ? fieldType.hashCode() : 0);
        result = 31 * result + (firstValue != null ? firstValue.hashCode() : 0);
        result = 31 * result + (secondValue != null ? secondValue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FieldInfo{" +
                "fieldName='" + fieldName + '\'' +
                ", fieldType=" + fieldType +
                ", firstValue=" + firstValue +
                ", secondValue=" + secondValue +
                '}';
    }
}
