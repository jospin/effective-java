package br.com.effective.java.cap2.item3;

/**
 * Singleton with static factory
 * This code would normally appear outside the class
 * @author Lucien Jospin
 *
 */
public class SingletonStaticFactory {

    private static final SingletonStaticFactory INSTANCE = new SingletonStaticFactory();
    private SingletonStaticFactory() { }
    public static SingletonStaticFactory getInstance() { return INSTANCE; }
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, Sngleton Static Factory!");
    }

}
