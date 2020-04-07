package example.reflect;

/**
 * @author hireny
 * @className ExtandsReflectExample
 * @create 2020-03-31 15:09
 */
public class ExtandsReflectExample extends ReflectExample {

    private int extandsIntField;

    protected ExtandsReflectExample(int intField) {
        super(intField);
        extandsIntField = intField;
    }

    public ExtandsReflectExample(int intField, Object objectField, Double doubleField, Character characterField, String stringField) {
        super(intField, objectField, doubleField, characterField, stringField);
    }

//    @Override
//    public void methodInterface() {
//        System.out.println("method interface");
//    }
//
//    @Override
//    public void methodInterface(String arg1, String arg2, String... args) {
//        System.out.println("method interface parameter: arg1-" + arg1 + ", arg2-" + arg2 + ", args-" + args);
//    }
//
//    @Override
//    public Object methodInterface2(String arg1, String... args) {
//        System.out.println("method interface parameter: arg1-" + arg1+ ", args-" + args);
//        return "method interface 2";
//    }

    public Object currentMethod() {
        return "current method";
    }
}
