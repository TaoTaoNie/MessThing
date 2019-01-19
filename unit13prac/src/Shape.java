/**
 * @author leetHuam
 * @version 1.0
 */
public abstract class Shape {
    public Shape() {
        System.out.println("shape被实例化");
    }
    void draw() {System.out.println(this + ".draw()");}
    public abstract String toString();
}
