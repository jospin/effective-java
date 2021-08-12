package br.com.effective.java.cap3.item10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PhoneNumberTest {

    @Test
    void testAssertionEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97387, 5066);
        Assertions.assertEquals(p1, p2);
        Assertions.assertEquals(p2, p1);
    }

    @Test
    void testLineNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97387, 5067);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

    @Test
    void testPrefixNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97388, 5066);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

    @Test
    void testAreaNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(012, 97387, 5066);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

}