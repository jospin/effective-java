package br.com.effective.java.cap3.item10.composition;

import br.com.effective.java.cap3.item10.Color;
import br.com.effective.java.cap3.item10.Point;

import java.util.Objects;

/**
 * While there is no satisfactory way to extend an instantiable class and add a
 * value component, there is a fine workaround: Follow the advice of Item 18,
 * “Favor composition over inheritance.” Instead of having ColorPoint extend
 * Point, give ColorPoint a private Point field and a public view method
 * (Item 6) that returns the point at the same position as this color point:
 * @author Lucien Jospin
 */
public class ColorPoint {
    private final Point point;
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        point = new Point(x, y);
        this.color = Objects.requireNonNull(color);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        ColorPoint cp = (ColorPoint) o;
        return cp.point.equals(point) && cp.color.equals(color);
    }
}
