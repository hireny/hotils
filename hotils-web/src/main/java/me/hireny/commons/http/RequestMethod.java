package me.hireny.commons.http;

/**
 * @ClassName: RequestMethod
 * @Author: hireny
 * @Date: Create in 2019/11/08 21:47
 * @Description: TODO   请求方法
 */
public enum RequestMethod {
    /**
     * Get方法
     * 获取资源
     */
    GET,
    /**
     * HEAD方法
     * 获取报文首部
     * 和GET方法类似，但是不返回报文实体主体部分。
     * 主要用于确认URL的有效性以及资源更新的日期时间等。
     */
    HEAD,
    /**
     * Post方法
     * 传输实体主体
     * POST主要用来传输数据，而GET主要用来获取资源
     */
    POST,
    /**
     * Put方法
     * 上传文件
     * 由于自身不带验证机制，任何人都可以上传文件，因此存在安全性问题，一般不使用该方法
     */
    PUT,
    /**
     * Patch方法
     * 对资源进行部分修改
     * PUT也可以用于修改资源，但是只能完全替代原始资源，PATCH允许部分修改。
     */
    PATCH,
    /**
     * Delete方法
     * 删除文件
     * 与PUT功能相反，并且同样不带验证机制
     */
    DELETE,
    /**
     * Options方法
     * 查询支持的方法
     * 查询指定的URL能够支持的方法。
     * 会返回Allow:GET,POST,HEAD,OPTIONS这样的内容。
     */
    OPTIONS,
    /**
     * CONNECT方法
     * 要求在与代理服务器通信时建立隧道
     * 使用SSL(Secure Sockets Layer,安全套接层)和TLS(Transport Layer Security,传输层安全)协议把通信内容加密后经网络隧道传输。
     */
    CONNECT,
    /**
     * TRACE方法
     * 追踪路径
     * 服务器会将通信路径返回给客户端。
     * 发送请求时，在Max-forwards首部字段中填入数值，每经过一个服务器就会减1，当数值为0时就停止传输。
     * 通常不会使用TRACE，并且它容易受到XST攻击(Cross-Site Tracing，跨站追踪)。
     */
    TRACE;
}
