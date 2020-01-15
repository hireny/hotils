package me.hireny.commons.core.net;

import me.hireny.commons.core.lang.Objects;
import me.hireny.commons.utils.ObjectUtils;
import me.hireny.commons.utils.StringUtils;
import me.hireny.commons.utils.Assert;

import java.io.Serializable;

/**
 * @Author: hireny
 * @Date: Create in 2019/09/30 01:42
 */
public final class HostAndPort implements Serializable {

    /** Magic value indicating the absence of a port number. */
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 1089419575331919825L;

    /**
     * 默认最小端口,1024
     */
    public static final int PORT_RANGE_MIN = 1024;
    /**
     * 默认最大端口，65535
     */
    public static final int PORT_RANGE_MAX = 0xFFFF;

    /** Hostname, IPv4/IPv6 literal, or unvalidated nonsense. */
    private final String host;

    /** Validated port number in the range [0..65535], or NO_PORT */
    private final int port;

    /** True if the parsed host has colons, but no surrounding brackets. */
    private final boolean hasBracketlessColons;

    private HostAndPort(String host, int port, boolean hasBracketlessColons) {
        this.host = host;
        this.port = port;
        this.hasBracketlessColons = hasBracketlessColons;
    }

    /**
     * 返回该实例中应该表示的主机名或者 IPv4/IPv6 文本的部分。
     * @return
     */
    public String getHost() {
        return host;
    }

    /**
     * 如果此实例具有定义的端口，返回true。
     * @return
     */
    public boolean hasPort() {
        return port >= 0;
    }

    /**
     * 获取当前端口号，如果没有定义端口，则失败。
     * @return
     */
    public int getPort() {
        Assert.state(hasPort());
        return port;
    }

    /**
     * 返回当前端口号，如果没有定义端口，则使用默认值。
     * @param defaultPort
     * @return
     */
    public int getPortOrDefault(int defaultPort) {
        return hasPort() ? port : defaultPort;
    }

    /**
     * 使用主机和端口值构建一个HostAndPort实例
     * @param host
     * @param port
     * @return
     */
    public static HostAndPort fromParts(String host, int port) {
        Assert.isTrue(Networks.isValidPort(port), "Port out of range: " + port);
        HostAndPort parsedHost = fromString(host);
        Assert.isTrue(!parsedHost.hasPort(), "Host has a port: " + host);
        return new HostAndPort(parsedHost.host, port,parsedHost.hasBracketlessColons);
    }

    /**
     * 仅从主机构建一个HostAndPort实例
     * @param host
     * @return
     */
    public static HostAndPort fromHost(String host) {
        HostAndPort parsedHost = fromString(host);
        Assert.isTrue(!parsedHost.hasPort(), "Host has a port: " + host);
        return parsedHost;
    }

    /**
     * 在没有严格验证的情况下，将自由格式字符串拆分为主机和端口。
     * @param hostPortString
     * @return
     */
    public static HostAndPort fromString(String hostPortString) {
        Assert.checkNotNull(hostPortString);
        String host;
        String portString = null;
        boolean hasBracketlessColons = false;

        if (hostPortString.startsWith("[")) {
            String[] hostAndPort = getHostAndPortFromBracketedHost(hostPortString);
            host = hostAndPort[0];
            portString = hostAndPort[1];
        } else {
            int colonPos = hostPortString.indexOf(':');
            if (colonPos >= 0 && hostPortString.indexOf(':', colonPos + 1) == -1) {
                // Exactly 1 colon. Split into host:port.
                host = hostPortString.substring(0, colonPos);
                portString = hostPortString.substring(colonPos + 1);
            } else {
                // 0 or 2+ colons. Bare hostname or IPv6 literal.
                host = hostPortString;
                hasBracketlessColons = (colonPos >= 0);
            }
        }

        int port = NO_PORT;
        if (!StringUtils.isNullOrEmpty(portString)) {
            // Try to parse the whole port string as a number.
            // JDK7 accepts leading plus signs. We don't want to.
            Assert.isTrue(!portString.startsWith("+"), "Unparseable port number: " + hostPortString);
            try {
                port = Integer.parseInt(portString);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Unparseable port number: " + hostPortString);
            }
            Assert.isTrue(Networks.isValidPort(port), "Port number out of range: " + hostPortString);
        }

        return new HostAndPort(host, port, hasBracketlessColons);
    }

    /**
     * 解析括起来的主机端口号字符串，如果解析失败，则抛出IllegalArgumentException异常。
     * @param hostPortString
     * @return
     */
    private static String[] getHostAndPortFromBracketedHost(String hostPortString) {
        int colonIndex = 0;
        int closeBracketIndex = 0;
        Assert.isTrue(hostPortString.charAt(0) == '[',
                "Bracketed host-port string must start with a bracket: " + hostPortString);
        colonIndex = hostPortString.indexOf(':');
        closeBracketIndex = hostPortString.lastIndexOf(']');
        Assert.isTrue(colonIndex > -1 && closeBracketIndex > colonIndex,
                "Invalid bracketed host/port: " + hostPortString);

        String host = hostPortString.substring(1, closeBracketIndex);
        if (closeBracketIndex + 1 == hostPortString.length()) {
            return new String[] {host, ""};
        } else {
            Assert.isTrue(hostPortString.charAt(closeBracketIndex + 1) == ':',
                    "Only a colon may follow a close bracket: " + hostPortString);
            for (int i = closeBracketIndex + 2; i < hostPortString.length(); ++i) {
                Assert.isTrue( Character.isDigit(hostPortString.charAt(i)),
                        "Port must be numeric: " + hostPortString);
            }
            return new String[] {host, hostPortString.substring(closeBracketIndex + 2)};
        }
    }

    /**
     * 如果解析后的字符串只包含一个主机，则提供一个默认端口。
     * @param defaultPort
     * @return
     */
    public HostAndPort withDefaultPort(int defaultPort) {
        // 验证端口号是否有效
        Assert.state(Networks.isValidPort(defaultPort));
        if (hasPort()) {
            return this;
        }
        return new HostAndPort(host, defaultPort, hasBracketlessColons);
    }

    /**
     * 如果主机可能是一个无括号IPv6文字就生成一个错误的。
     * @return
     */
    public HostAndPort requireBracketsForIPv6() {
        Assert.state(!hasBracketlessColons,"Possible bracketless IPv6 literal: " + host);
        return this;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof HostAndPort) {
            HostAndPort that = (HostAndPort) other;
            return ObjectUtils.equals(this.host, that.host) && that.port == ((HostAndPort) other).port;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return ObjectUtils.hashCode(host, port);
    }

    /***
     * 重新生成 host port 字符串，必要时包括方括号
     * @return
     */
    @Override
    public String toString() {
        // "[]:12345" requires 8 extra bytes.
        StringBuilder builder = new StringBuilder(host.length() + 8);
        if (host.indexOf(':') >= 0) {
            builder.append('[').append(host).append(']');
        } else {
            builder.append(host);
        }
        if (hasPort()) {
            builder.append(':').append(port);
        }
        return builder.toString();
    }
}
