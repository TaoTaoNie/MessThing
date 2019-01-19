package polymorphism.shape;

public class Shape {
    private int wheels = 3;
    public void draw() {}
    public void erase() {}
    public void print() {System.out.println("Shape.print()");}
    public int getWheels() {
        return wheels;
    }
}
