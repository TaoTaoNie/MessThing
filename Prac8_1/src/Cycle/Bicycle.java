package Cycle;

public class Bicycle implements Cycle {
    public int wheels() {return 2;}

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Bicycle();
        }
    };
}
