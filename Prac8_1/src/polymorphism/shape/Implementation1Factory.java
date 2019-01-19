package polymorphism.shape;

public class Implementation1Factory implements ServiceFactory {
    public Service getService() {
        return new Implementation1();
    }
}
