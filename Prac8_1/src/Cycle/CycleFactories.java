package Cycle;

public class CycleFactories {
    private static void ride(CycleFactory factory) {
        Cycle c = factory.getCycle();
        System.out.println("Num of wheels: " + c.wheels());
    }

    public static void main(String[] args) {
        ride(Unicycle.factory);
        ride(Bicycle.factory);
        ride(Tricycle.factory);
    }
}
