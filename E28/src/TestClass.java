/**
 * @author leetHuam
 * @version 1.0
 */
public class TestClass extends A{
    public static final String s = "taobao";
    static {
        System.out.println("static B");
    }
    {
        System.out.println("I'm B class");
    }
    public TestClass() {

    }
    private static void method() {
        System.out.println("test method!");
    }
    public static void main(String[] args) {
//        ((TestClass)null).method();
//        new TestClass();
        String a = "tao" + "bao";
        String b = "tao";
        String c = "bao";
        System.out.println(a == s);
        System.out.println((b + c).intern() == s);
    }

}

class A {
    static {
        System.out.println("static A");
    }
    {
        System.out.println("I'm A class");
    }
    public A() {

    }
}
