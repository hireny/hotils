package me.hireny.commons.core.design;

import java.io.Serializable;

/**
 * @ClassName: IdKey
 * @Author: hireny
 * @Date: Create in 2019/12/07 01:32
 * @Description: TODO
 * Wrap an identity key (System.identityHashCode()) so that an object can only be equal() to itself.
 * This is necessary to disambiguate the occasional duplicate identityHashCodes that can occur.
 */
public class IdKey implements Serializable {
    private static final long serialVersionUID = -1506414937135781944L;

    private final Object value;
    private final int id;

    /**
     * Constructor for IDKey
     *
     * @param value The value
     */
    public IdKey(final Object value) {
        // This is the Object hashcode
        id = System.identityHashCode(value);
        // There have been some cases (LANG-459) that return the
        // same identity hash code for different objects. So
        // the value is also added to disambiguate these cases.
        this.value = value;
    }

    /**
     * returns hashcode - i.e. the system identity hashcode.
     *
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return id;
    }

    /**
     * checks if instances are equal
     *
     * @param other The other object to compare to
     * @return if the instances are for the same object
     */
    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof IdKey)) {
            return false;
        }
        final IdKey idKey = (IdKey) other;
        if (id != idKey.id) {
            return false;
        }
        // Note that identity equals is used.
        return value == idKey.value;
    }
}
