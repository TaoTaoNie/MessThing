package Cycle;

public class Unicycle implements Cycle {
    public int wheels() {return 1;}

    public static CycleFactory factory = new CycleFactory() {
        @Override
        public Cycle getCycle() {
            return new Unicycle();
        }
    };
}
