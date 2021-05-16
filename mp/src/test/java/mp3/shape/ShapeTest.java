package mp3.shape;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ShapeTest {

    @Test
    void area() {
        List<Shape> shapes = new ArrayList<>();
        Circle circle1 = new Circle("circle1", 2);
        Circle circle2 = new Circle("circle2", 3);
        Square square1 = new Square("square1", 2);
        Square square2 = new Square("square2", 3);
        shapes.add(circle1);
        shapes.add(circle2);
        shapes.add(square1);
        shapes.add(square2);
        for (Shape shape : shapes) {
            System.out.println(shape.getName() + " area = " + shape.area());
        }
    }
}