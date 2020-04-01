package example.reflect;

/**
 * @author hireny
 * @className ReflectInterface
 * @create 2020-03-31 15:10
 */
public interface ReflectInterface {

    String stringInterfaceField = "string interface field";

    void methodInterface();
    void methodInterface(String arg1, String arg2, String... args);
    Object methodInterface2(String arg1, String... args);
    default String defaultMethod() {
        return "default method";
    }
}
