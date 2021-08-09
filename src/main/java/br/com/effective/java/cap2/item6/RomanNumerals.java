package br.com.effective.java.cap2.item6;

import java.util.regex.Pattern;

/**
 * @author Lucien Jospin
 * While String.matches is the easiest way to check if a string matches a regular expression,
 * it’s not suitable for repeated use in performance-critical situations
 */
public class RomanNumerals {

    // Reusing expensive object for improved performance (Page 23)
    private static final Pattern ROMAN = Pattern.compile(
            "^(?=.)M*(C[MD]|D?C{0,3})"
                    + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    /**
     * Performance can be greatly improved! (Page 22)
     * Is roman numeral Slow
     * @param string to test
      */
    public static boolean isRomanNumeralSlow(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})"
                + "(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    public static boolean isRomanNumeralFast(String s) {
        return ROMAN.matcher(s).matches();
    }

}