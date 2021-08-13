package br.com.effective.java.cap3.item10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class PhoneNumberTest {

    @Test
    void assertionEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97387, 5066);
        Assertions.assertEquals(p1, p2);
        Assertions.assertEquals(p2, p1);
    }

    @Test
    void lineNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97387, 5067);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

    @Test
    void prefixNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97388, 5066);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

    @Test
    void areaNotEquals() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(012, 97387, 5066);
        Assertions.assertNotEquals(p1, p2);
        Assertions.assertNotEquals(p2, p1);
    }

    @Test
    void sameObjectsHasSameHash() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(011, 97387, 5066);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(p1, "Jenny");
        Assertions.assertEquals("Jenny", m.get(p2));
        Assertions.assertEquals("Jenny", m.get(p1));
    }

    @Test
    void differentObjectsHasDifferentHash() {
        PhoneNumber p1 = new PhoneNumber(011, 97387, 5066);
        PhoneNumber p2 = new PhoneNumber(012, 97388, 5067);
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(p1, "Jenny");
        m.put(p2, "Jenny2");
        Assertions.assertNotEquals("Jenny", m.get(p2));
        Assertions.assertNotEquals("Jenny2", m.get(p1));
        Assertions.assertEquals("Jenny2", m.get(p2));
        Assertions.assertEquals("Jenny", m.get(p1));

    }

}