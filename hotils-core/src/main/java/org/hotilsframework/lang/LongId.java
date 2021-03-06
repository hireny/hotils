package org.hotilsframework.lang;

/**
 * LongID - 智能和简单的Java UUID生成器
 *
 * 替换自动递增ID，特别是在多服务器多数据中心环境中。
 *
 * 它是为了回应 Snowflake 和 Snowizard的复杂性而创建的，只是一个单一的类，
 *
 * 实例化serverId(0-4095)，以100%保证唯一性
 *
 * 每台服务器每秒256.000个唯一ID
 *
 * 适用于 1970 - 2557 年
 *
 * longId 包含时间戳和serverId
 *
 * int serverId = 4095
 * LongId = new LongId(serverId);
 * longId.getNewId()
 */

/**
 * Generates a unique numeric ID based on current milliseconds and an optional server/instance ID.
 * Suitable for use as a database primary key in a distributed app, as new IDs are guaranteed
 * to be unique and will always be added at or near the end of the table.
 * <p>
 * Builds the following as a hex string and converts to a long:
 *    <code>(11 hex digits timestamp) (2 hex digits counter) (3 hex digits server ID)</code>
 * Server IDs can range from 0 - 4095.
 * A counter resolves collisions where two or more IDs are created within the same millisecond.
 * We can extract the timestamp or server ID from any ID generated using this scheme.
 * </p>
 *
 * <p>
 *     Usage:
 * </p>
 *
 * <ul>
 *   <li>LongId lid = new LongId()    - creates an instance to generate IDs with the embedded server ID 0.
 *   <li>LongId lid = new LongId(123) - creates an instance to generate IDs with the embedded server ID 123.
 *   <li>lid.getNewId() - generates IDs with the embedded server ID on the instance.
 * </ul>
 *
 * <p>
 *     Once you have a generated id, you can retrieve information from it, with or without an instance.
 * <ul>
 *   <li>LongId.getDate(id) - extract the timestamp from the ID.
 *   <li>LongId.getServerId(id) - extract the server ID from the ID.
 * </ul>
 */

import java.util.Date;

/**
 * LongId
 * 生成Long类型的ID
 *
 * @author hireny
 * @create 2020-08-12 0:12
 */
public class LongId {
    // How many hex digits we use for each component of the ID
    private static final int MILLIS_HEX_DIGITS  = 11;
    private static final int COUNTER_HEX_DIGITS = 2;
    private static final int SERVER_HEX_DIGITS  = 3;

    private static final int COUNTER_MAX = 255;
    private static final int SERVER_MAX  = 4095;
    // For padding
    private static final String ZEROES = "00000000000";

    // State variables, used to ensure unique IDs when called within the same millisecond.
    // Shared across instances, so even if you create two objects with the same server, the IDs will still be unique
    private long millisPrevious = 0;
    private long counterWithinThisMilli = 0;

    // Optional server ID will be 0. Can be set by creating a new LongId(serverId);
    private final String serverIdAsHex;

    /**
     * Create a new instance with default serverId: 0.
     */
    public LongId() {
        this(0);
    }

    /**
     * Create a new instance for a specific server/app instance. Ensures each instance generates a unique set of IDs.
     *
     * @param  serverId Numeric ID indicating which server is generating this ID.
     */
    public LongId(long serverId) {
        if (serverId > SERVER_MAX || serverId < 0) {
            throw new IllegalArgumentException("Server Id must be in the range 0-" + SERVER_MAX);
        }

        // convert serverId to hex, padded with zeroes as needed.
        String asHex = Long.toHexString(serverId);
        serverIdAsHex = ZEROES.substring(0, SERVER_HEX_DIGITS-asHex.length() ) + asHex;
    }

    /**
     * Generate a new ID. Synchronized so that each thread will wait for the previous one to finish, allowing us
     * to maintain state and guarantee a unique ID when two threads hit within the same millisecond.
     *
     * If we hit the counter limit within a millisecond, we sleep for a millisecond and start over.
     *
     * @return A unique ID suitable for use as a database key
     */
    public synchronized long getNewId() {
        // store the current millis since epoch
        long millisCurrent = System.currentTimeMillis();

        // if NOT within the same milli, reset static vars  (safe since Synchronized)
        if (millisPrevious != millisCurrent) {
            millisPrevious = millisCurrent;
            counterWithinThisMilli = 0;
        }
        // if counter is maxed out, sleep 1ms, then call self recursively
        else if (counterWithinThisMilli >= COUNTER_MAX) {
            try { Thread.sleep(1); }
            // sleep throws a checked exception, so we have to deal with it here or else kick it upstairs and force the caller to deal with it.
            catch (InterruptedException e) { throw new RuntimeException(e); }
            return getNewId(); // recursive call
        }
        // if within the same milli, increment counter
        else {
            counterWithinThisMilli++;
        }

        // store counter
        millisPrevious = millisCurrent;

        // convert millisCurrent to hex. No need to pad it since it's going to be at the beginning.
        String millisAsHex = Long.toHexString(millisCurrent);

        // convert counter to hex, padded with zeroes as needed.
        String counterAsHex = Long.toHexString(counterWithinThisMilli);
        counterAsHex = ZEROES.substring(0,COUNTER_HEX_DIGITS-counterAsHex.length()) + counterAsHex;

        // concatenate them together and decode to Long
        return Long.decode("0x" + millisAsHex + counterAsHex + serverIdAsHex);
    }

    /**
     * Get the date/time that a LongId was generated.
     *
     * @param  longId The numeric form of a LongId generated with this class. Does not have to be generated by this instance.
     * @return Date object representing the time that the LongId was generated.
     */
    public static Date getDate(long longId) {
        // Convert to hex, then drop the last 6 hex digits. The rest will be the timestamp
        String hexInput = Long.toHexString(longId);
        if (hexInput.length() < COUNTER_HEX_DIGITS+SERVER_HEX_DIGITS + 1) {
            throw new IllegalArgumentException("Input is too short to be a LongId");
        }
        return new Date(Long.decode("0x" + hexInput.substring(0, hexInput.length()-(COUNTER_HEX_DIGITS+SERVER_HEX_DIGITS) )));
    }

    /**
     * Get the server/instance ID on which a LongId was generated.
     *
     * @param  longId The numeric form of a LongId generated with this class. Does not have to be generated by this instance.
     * @return Numeric ID of the server/instance that generated the LongId
     */
    public static long getServerId(long longId) {
        // Convert number to hex. Take the last few hex digits. Convert them back to a number. That's the server Id.
        String hexInput = Long.toHexString(longId);
        if (hexInput.length() < COUNTER_HEX_DIGITS+SERVER_HEX_DIGITS + 1) {
            throw new IllegalArgumentException("Input is too short to be a LongId");
        }
        return Long.decode("0x" + hexInput.substring(hexInput.length()-SERVER_HEX_DIGITS) );
    }

    /**
     * Get the same-millisecond counter from a LongId. Not useful except for debugging.
     *
     * @param  longId The numeric form of a LongId generated with this class. Does not have to be generated by this instance.
     * @return Numeric counter
     */
    public static long getCounter(long longId) {
        // Convert to hex, remove the server digits, then look at the last few remaining for the hex digits.
        String hexInput = Long.toHexString(longId);
        if (hexInput.length() < COUNTER_HEX_DIGITS+SERVER_HEX_DIGITS + 1) {
            throw new IllegalArgumentException("Input is too short to be a LongId");
        }
        return Long.decode("0x" + hexInput.substring(hexInput.length()-(COUNTER_HEX_DIGITS+SERVER_HEX_DIGITS),hexInput.length()-SERVER_HEX_DIGITS) );
    }
}
