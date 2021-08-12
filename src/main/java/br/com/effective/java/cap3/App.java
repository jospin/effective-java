package br.com.effective.java.cap3;

import br.com.effective.java.cap3.item10.CaseInsensitiveString;
import br.com.effective.java.cap3.item10.Color;
import br.com.effective.java.cap3.item10.Point;
import br.com.effective.java.cap3.item10.inheritance.ColorPoint;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        tunItem10();
    }

    private static void tunItem10() {
        symmetry();
        transitivity();
        solvedWithComposition();
    }

    private static void solvedWithComposition() {
        // Second equals function violates transitivity
        br.com.effective.java.cap3.item10.composition.ColorPoint p1 = new br.com.effective.java.cap3.item10.composition.ColorPoint(1, 2, Color.BLUE);
        Point p2 = new Point(1, 2);
        br.com.effective.java.cap3.item10.composition.ColorPoint p3 = new br.com.effective.java.cap3.item10.composition.ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }

    private static void transitivity() {
        // First equals function violates symmetry
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);
        System.out.println(p.equals(cp) + " " + cp.equals(p));

        // Second equals function violates transitivity
        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
        System.out.printf("%s %s %s%n",
                p1.equals(p2), p2.equals(p3), p1.equals(p3));
    }

    private static void symmetry() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);

        System.out.println(list.contains(s));
    }
}
