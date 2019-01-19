package polymorphism.shape;

public class Son extends Father {
    public void set() {
        m += 3;
    }
    public static void main(String[] args) {
        Father f = new Son();
        System.out.println(f.m);
    }
}
