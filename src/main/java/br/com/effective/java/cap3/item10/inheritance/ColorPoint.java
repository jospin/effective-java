package br.com.effective.java.cap3.item10.inheritance;

import br.com.effective.java.cap3.item10.Color;
import br.com.effective.java.cap3.item10.Point;

public class ColorPoint extends Point {

    private final Color color;
    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    // Broken - violates symmetry!  (Page 41)
    @Override public boolean equals(Object o) {
        if (!(o instanceof ColorPoint))
            return false;
        return super.equals(o) && ((ColorPoint) o).color == color;
    }

    // Broken - violates transitivity! (page 42)
//    @Override public boolean equals(Object o) {
//        if (!(o instanceof Point))
//            return false;
//
//        // If o is a normal Point, do a color-blind comparison
//        if (!(o instanceof ColorPoint))
//            return o.equals(this);
//
//        // o is a ColorPoint; do a full comparison
//        return super.equals(o) && ((ColorPoint) o).color == color;
//    }
}
