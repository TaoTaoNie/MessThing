package ntt;

/**
 * @author leetHuam
 * @version 1.0
 */
public class OuterClass {
    private int i = 10;
    private void f() {
        System.out.println("OuterClass.f");
    }

    class Inner{
        private int j = 10;
        void g() {
            i++;
            f();
        }
    }

    public void h() {
        Inner inner = new Inner();
        inner.g();
        System.out.println("i = " + i + " j = " + inner.j);
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.h();
    }
}
