package effective.classesandinterfaces.item20;

/**
 * Prefer class hierarchies to tagged class
 * <p/>
 * Tagged class - vastly inferior to a class hierarchy.
 *
 * @author Thomson Tang
 * @version 1.0-SNAPSHOT
 * @version 8/12/13
 */
public class Figure {
    enum Shape {RECTANGLE, CIRCLE}

    //Tag field - the shape of this figure
    final Shape shape;

    //These fields are used only if shape is RECTANGLE
    double length;
    double width;

    // This field if used only if shape is CIRCLE
    double radius;

    // Constructor for circle
    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    // Constructor for RECTANGLE
    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}
