package Cycle;

public class Tricycle implements Cycle {
    public int wheels() {return 3;}

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Tricycle();
        }
    };
}
