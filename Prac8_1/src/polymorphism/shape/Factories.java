package polymorphism.shape;

public class Factories {
    public static void serviceConsumer(ServiceFactory serviceFactory) {
        Service service = serviceFactory.getService();
        service.method1();
        service.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());
        serviceConsumer(new Implementation2Factory());
    }
}
