package br.com.effective.java.cap3.item10;

import java.util.Objects;

/**
 * When you are finished writing your equals method, ask yourself three
 * questions: Is it symmetric? Is it transitive? Is it consistent? And don’t just
 * ask yourself; write unit tests to check, unless you used AutoValue to
 * generate your equals method, in which case you can safely omit the tests. If
 * the properties fail to hold, figure out why, and modify the equals method
 * accordingly. Of course your equals method must also satisfy the other two
 * properties (reflexivity and non-nullity), but these two usually take care of
 * themselves.
 * @author Lucien Jospin
 */
public class PhoneNumber {
    private final int areaCode, prefix, lineNum;

    // hashCode method with lazily initialized cached hash code
    private int hashCode; // Automatically initialized to 0
    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   99999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static int rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PhoneNumber))
            return false;
        PhoneNumber pn = (PhoneNumber)o;
        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    /**
     * Hash code on Effective Java
     * @return int hash
     */
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = Integer.hashCode(areaCode);
            result = result * 31 + Integer.hashCode(prefix);
            result = result * 31 + Integer.hashCode(lineNum);
            hashCode = result;
        }
        return result;
    }


    /**
     * hashCode to intelijj
     * One-line hashCode method - mediocre performance
     * @return hash
     */
//    @Override
//    public int hashCode() {
//        return Objects.hash(areaCode, prefix, lineNum);
//    }

    /**
     * Returns the string representation of this phone number.
     * The string consists of twelve characters whose format is
     * "XXX-YYYYY-ZZZZ", where XXX is the area code, YYY is the
     * prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single decimal digit.
     * If any of the three parts of this phone number is too small
     * to fill up its field, the field is padded with
     * @return string format
     */
    @Override public String toString() {
        return String.format("%03d-%05d-%04d",
                areaCode, prefix, lineNum);
    }
}
