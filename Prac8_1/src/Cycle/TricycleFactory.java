package Cycle;

public class TricycleFactory implements CycleFactory {
    public Tricycle getCycle() {
        return new Tricycle();
    }
}
