package br.com.effective.java.cap2.item3;

/**
 * Enum singleton - the preferred approach
 * @author Lucien Jospin
 */
public enum SingletonEnumType {
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Whoa baby, Singleton Enum Type!");
    }
}
