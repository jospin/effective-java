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
    private final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   99999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
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

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, prefix, lineNum);
    }
}
