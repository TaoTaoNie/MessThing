package Item8;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Test {
    private Room room = new Room();
    public class Fuck {
        public Fuck() {
            System.out.println("Fuck!");
        }
    }
    public Test() {
        System.out.println("Test!");
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.new Fuck();
    }
}
