package org.hotilsframework.core.escape;

import org.hotilsframework.utils.Assert;

/**
 * 字符过滤
 * @ClassName: CharEscaper
 * @Author: hireny
 * @Date: Created in 2020-01-13 19:50
 * @Version: 1.0
 */
public abstract class CharEscaper extends Escaper {

    protected CharEscaper() {}

    @Override
    public String escape(String string) {
        Assert.notNull(string);
        int length = string.length();
        for (int index = 0; index < length; index++) {
            if (escape(string.charAt(index)) != null) {
                return escapeSlow(string, index);
            }
        }
        return null;
    }

    protected abstract char[] escape(char c);

    protected final String escapeSlow(String s, int index) {
        int slen = s.length();

        // Get a destination buffer and setup some loop variables.
        char[] dest =  Platform.charBufferFromThreadLocal();
        int destSize = dest.length;
        int destIndex = 0;
        int lastEscape = 0;

        // Loop through the rest of the string, replacing when needed into the
        // destination buffer, which gets grown as needed as well.
        for (; index < slen; index++) {

            // Get a replacement for the current character.
            char[] r = escape(s.charAt(index));

            // If no replacement is needed, just continue.
            if (r == null) {
                continue;
            }

            int rlen = r.length;
            int charsSkipped = index - lastEscape;

            // This is the size needed to add the replacement, not the full size
            // needed by the string. We only regrow when we absolutely must, and
            // when we do grow, grow enough to avoid excessive growing. Grow.
            int sizeNeeded = destIndex + charsSkipped + rlen;
            if (destSize < sizeNeeded) {
                destSize = sizeNeeded + DEST_PAD_MULTIPLIER * (slen - index);
                dest = growBuffer(dest, destIndex, destSize);
            }

            // If we have skipped any characters, we need to copy them now.
            if (charsSkipped > 0) {
                s.getChars(lastEscape, index, dest, destIndex);
                destIndex += charsSkipped;
            }

            // Copy the replacement string into the dest buffer as needed.
            if (rlen > 0) {
                System.arraycopy(r, 0, dest, destIndex, rlen);
                destIndex += rlen;
            }
            lastEscape = index + 1;
        }

        // Copy leftover characters if there are any.
        int charsLeft = slen - lastEscape;
        if (charsLeft > 0) {
            int sizeNeeded = destIndex + charsLeft;
            if (destSize < sizeNeeded) {

                // Regrow and copy, expensive! No padding as this is the final copy.
                dest = growBuffer(dest, destIndex, sizeNeeded);
            }
            s.getChars(lastEscape, slen, dest, destIndex);
            destIndex = sizeNeeded;
        }
        return new String(dest, 0, destIndex);
    }

    /**
     * Helper method to grow the character buffer as needed, this only happens once in a while so it's
     * ok if it's in a method call. If the index passed in is 0 then no copying will be done.
     */
    private static char[] growBuffer(char[] dest, int index, int size) {
        if (size < 0) { // overflow - should be OutOfMemoryError but GWT/j2cl don't support it
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] copy = new char[size];
        if (index > 0) {
            System.arraycopy(dest, 0, copy, 0, index);
        }
        return copy;
    }

    /** The multiplier for padding to use when growing the escape buffer. */
    private static final int DEST_PAD_MULTIPLIER = 2;
}
