package me.hireny.commons.core.security.hash;

import me.hireny.commons.core.security.MessageDigest;
import me.hireny.commons.core.security.MessageDigestConstants;

/**
 * @Author: hireny
 * @Date: Create in 2019/10/03 20:02
 */
public class Sha1Hash extends MessageDigest {

    /**
     * SHA1编码
     * @param data
     * @return
     */
    @Override
    public byte[] encrypt(byte[] data) {
        return this.encrypt(data, MessageDigestConstants.SHA_KEY);
    }
}
