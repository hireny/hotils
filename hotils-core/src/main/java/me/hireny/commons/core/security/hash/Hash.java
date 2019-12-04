package me.hireny.commons.core.security.hash;


import me.hireny.commons.core.security.ByteSource;

/**
 * Hash
 * Hash接口
 * @Author: hireny
 * @Date: Create in 2019/10/13 19:43
 */
public interface Hash extends ByteSource {

    /**
     * Returns the name of the algorithm used to hash the input source, for example, {@code SHA-256}, {@code MD5}, etc.
     * <p/>
     * The name is expected to be a {@link java.security.MessageDigest MessageDigest} algorithm name.
     *
     * @return the the name of the algorithm used to hash the input source, for example, {@code SHA-256}, {@code MD5}, etc.
     * @since 1.1
     */
    String getAlgorithmName();

    /**
     * Returns a salt used to compute the hash or {@code null} if no salt was used.
     *
     * @return a salt used to compute the hash or {@code null} if no salt was used.
     * @since 1.2
     */
    ByteSource getSalt();

    /**
     * Returns the number of hash iterations used to compute the hash.
     *
     * @return the number of hash iterations used to compute the hash.
     * @since 1.2
     */
    int getIterations();
}
