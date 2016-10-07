package generics.bounds;

import java.awt.*;

/**
 * Bounds
 *
 * the bounds allows you to call a method.
 *
 * @author Thomson Tang
 * @version Created ：2016-05/10/2016-20:51
 */
interface HasColor {
    Color getColor();
}

class Colored<T extends HasColor> {
    private T item;

    public Colored(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    Color getColor() {
        return item.getColor();
    }
}

class Dimension {
    public int x, y, z;
}

// This wasn't work -- class must be first, then interfaces
//class ColoredDimension <T extends HasColor & Dimension> {}

// Multiple bounds
class ColoredDimension<T extends Dimension & HasColor> {
    private T item;

    public ColoredDimension(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color getColor() {
        return item.getColor();
    }

    public int getX() {
        return item.x;
    }

    public int getY() {
        return item.y;
    }

    public int getZ() {
        return item.z;
    }
}

interface Weight {
    int weight();
}

// As with inheritance, you can have only one concrete class but multiple interfaces
class Solid<T extends Dimension & HasColor & Weight> {
    private T item;

    public Solid(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public Color getColor() {
        return item.getColor();
    }

    public int getX() {
        return item.x;
    }

    public int weight() {
        return item.weight();
    }
}

class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public Color getColor() {
        return null;
    }

    @Override
    public int weight() {
        return 0;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.getColor();
        solid.getX();
        solid.weight();
    }
}
