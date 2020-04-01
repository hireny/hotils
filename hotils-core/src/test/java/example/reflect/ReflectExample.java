package example.reflect;

/**
 * @author hireny
 * @className ReflectExample
 * @create 2020-03-31 15:07
 */
public  class ReflectExample extends ReflectAbstract {

    private static int counter = 0;

    public static int getStaticIntField() {
        return staticIntField;
    }

    private static final int staticIntField = 2;
    public static double staticDoubleField = 3.235;
    private int intField;
    private Object objectField;
    public Double doubleField;
    protected Character characterField;
    public String stringField;
    public String parameter;

    public ReflectExample() {

    }

    protected ReflectExample(int intField) {
        this.intField = intField;
        this.parameter = "带一个参数";
    }

    public ReflectExample(int intField,
                          Object objectField,
                          Double doubleField,
                          Character characterField,
                          String stringField) {
        this.intField = intField;
        this.objectField = objectField;
        this.doubleField = doubleField;
        this.characterField = characterField;
        this.stringField = stringField;
        this.parameter = "带五个参数";
    }

    public int getIntField() {
        return intField;
    }

    public void setIntField(int intField) {
        this.intField = intField;
    }

    public Object getObjectField() {
        return objectField;
    }

    public void setObjectField(Object objectField) {
        this.objectField = objectField;
    }

    public Double getDoubleField() {
        return doubleField;
    }

    public void setDoubleField(Double doubleField) {
        this.doubleField = doubleField;
    }

    public Character getCharacterField() {
        return characterField;
    }

    public void setCharacterField(Character characterField) {
        this.characterField = characterField;
    }

    public String getStringField() {
        return stringField;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public void reflectMethod() {
        System.out.println("reflect method");
    }

    private String reflectMethod2() {
        System.out.println("reflect method 2");
        return "reflectMethod2";
    }

    protected String reflectMethod2(String name) {
        System.out.println("reflect method 2 :" + name);
        return "reflectMethod2 parameter";
    }

    public static void staticReflectMethod(String name) {
        System.out.println("static reflect method :" + name);
    }

    @Override
    public String toString() {
        return "ReflectExample object " + ++counter + " " + parameter;
    }

    @Override
    public void methodInterface() {

    }

    @Override
    public void methodInterface(String arg1, String arg2, String... args) {

    }

    @Override
    public Object methodInterface2(String arg1, String... args) {
        return null;
    }
}
