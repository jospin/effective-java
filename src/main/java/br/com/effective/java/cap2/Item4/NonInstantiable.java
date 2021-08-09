package br.com.effective.java.cap2.Item4;

public class NonInstantiable {

    // Suppress default constructor for Non Instantiability
    private NonInstantiable() {
        throw new AssertionError();
    }

    public static void test() {
        System.out.println("Test Non Instantiability class");
    }
}
