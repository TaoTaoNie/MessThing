/**
 * @author leetHuam
 * @version 1.0
 */
public class FullConstruct {
    public static void f() throws MyException {
        System.out.println("Throwing MyException from f()");
        throw new MyException();
    }

    public static void g() throws MyException {
        System.out.println("Throwing MyException from g()");
        throw new MyException("Originated in g()");
    }

    public static void main(String[] args) {
//        try{
//            f();
//        }catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
//        try{
//            g();
//        }catch (Exception e) {
//            e.printStackTrace(System.err);
//        }
        try {
            throw new Exception("Hello World!");
        }catch (Exception e){
            e.printStackTrace(System.err);
        }finally {
            System.out.println("");
        }
    }
}
