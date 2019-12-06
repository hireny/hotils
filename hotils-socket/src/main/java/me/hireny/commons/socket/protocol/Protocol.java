package me.hireny.commons.socket.protocol;

/**
 * @ClassName: Protocol
 * @Author: hireny
 * @Date: Create in 2019/12/07 02:51
 * @Description: TODO   协议接口
 * 通过实现此接口完成纤细的编码和解码
 *
 * <p>
 *     所有Socket使用相同协议对象，类成员变量和对象成员变量易造成并发读写问题。
 * </p>
 */
public interface Protocol<T> extends MessageEncoder<T>, MessageDecoder<T> {
}
