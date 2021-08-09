package br.com.effective.java.cap2.item3;

/**
 * Singleton with public final field
 * @author Lucien Jospin
 */
public class SingletonField {

    public static final SingletonField INSTANCE = new SingletonField();

    private SingletonField() { }

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, Singleton Fields!");
    }
}
