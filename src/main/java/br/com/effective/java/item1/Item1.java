package br.com.effective.java.item1;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 *  Consider static factory methods instead of constructors
 *  One advantage of static factory methods is that, unlike constructors, they have names
 *  A second advantage of static factory methods is that, unlike constructors, they are not required to create a new object each time they’re invoked
 *  A third advantage of static factory methods is that, unlike constructors, they can return an object of any subtype of their return type
 *  A fourth advantage of static factories is that the class of the returned object can vary from call to call as a function of the input parameters
 *  A fifth advantage of static factories is that the class of the returned object need not exist when the class containing the method is written.
 *
 *
 * @author <Lucien Carbonare Jospin> lucien.carbonare@gmail.com
 * @since 08/2021
 *
 */
public class Item1 {
    /**
     *  A type-conversion method that takes a single parameter and returns a
     * corresponding instance of this type,
     * @param item (Number received to convert for string)
     * @return String
     */
    public static String from(Long item) {
        return "1";
    }

    /**
     * An aggregation method that takes multiple parameters and returns an
     * instance of this type that incorporates them
     * @param param1
     * @param param2
     * @param param3
     * @return Set<String>
     */
    public static Set<String> of(String param1, String param2, String param3) {
        Set<String> stringSet = new HashSet<>();
        stringSet.add(param1);
        stringSet.add(param2);
        stringSet.add(param3);
        return stringSet;
    }

    /**
     * A more verbose alternative to from and of
     * @param valueToConvert
     * @return BigInteger
     */
    public static BigInteger valueOf(Integer valueToConvert) {
        return BigInteger.valueOf(valueToConvert);
    }

    /**
     * Returns an instance that is described by its
     * parameters (if any) but cannot be said to have the same value
     * @return Item1
     */
    public static Class<Item1> getInstance() {
        return Item1.class;
    }

}
