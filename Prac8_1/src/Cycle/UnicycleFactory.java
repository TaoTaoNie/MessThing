package Cycle;

public class UnicycleFactory implements CycleFactory {
    public Unicycle getCycle() {
        return new Unicycle();
    }
}
