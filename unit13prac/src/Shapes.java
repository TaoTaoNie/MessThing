import java.util.Arrays;
import java.util.List;

/**
 * @author leetHuam
 * @version 1.0
 */
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapes = Arrays.asList(new Circle(), new Square());
        for (Shape shape : shapes)
            shape.draw();
    }
}
