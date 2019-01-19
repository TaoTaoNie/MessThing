package Cycle;

public class BicycleFactory implements CycleFactory {
    public Bicycle getCycle() {
        return new Bicycle();
    }
}
