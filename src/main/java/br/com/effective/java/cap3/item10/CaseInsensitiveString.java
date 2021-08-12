package br.com.effective.java.cap3.item10;

import java.util.Objects;

/**
 * Symmetry — The second requirement says that any two objects must agree on
 * whether they are equal. Unlike the first requirement, it’s not hard to imagine
 * violating this one unintentionally. For example, consider the following class,
 * which implements a case-insensitive string. The case of the string is preserved
 * by toString but ignored in equals comparisons:
 * @author Lucien Jospin
 */
public class CaseInsensitiveString {
    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    // Broken - violates symmetry!
//    @Override public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString)
//            return s.equalsIgnoreCase(
//                    ((CaseInsensitiveString) o).s);
//        if (o instanceof String)  // One-way interoperability!
//            return s.equalsIgnoreCase((String) o);
//        return false;
//    }

    // Fixed equals method
    @Override public boolean equals(Object o) {
        return o instanceof CaseInsensitiveString &&
                ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
    }

}
