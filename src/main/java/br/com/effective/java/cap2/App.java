package br.com.effective.java.cap2;

import br.com.effective.java.cap2.Item4.NonInstantiable;
import br.com.effective.java.cap2.Item5.Lexicon;
import br.com.effective.java.cap2.Item5.SpellChecker;
import br.com.effective.java.cap2.item1.Item1;
import br.com.effective.java.cap2.item2.NutritionFacts;
import br.com.effective.java.cap2.item2.hierarchical.Car;
import br.com.effective.java.cap2.item2.hierarchical.Ford;
import br.com.effective.java.cap2.item3.SingletonEnumType;
import br.com.effective.java.cap2.item3.SingletonField;
import br.com.effective.java.cap2.item3.SingletonStaticFactory;
import com.fasterxml.jackson.core.JsonProcessingException;

public class App {

    public static void main(String[] args) throws JsonProcessingException {
        runItem1();
        runItem2();
        runItem3();
        runItem4();
        runItem5();
    }

    private static void runItem5() {
        Lexicon lexicon = new Lexicon();
        SpellChecker spellChecker = new SpellChecker(lexicon);
        spellChecker.callMethod();
    }

    private static void runItem4() {
        NonInstantiable.test();
    }

    private static void runItem3() {
        SingletonField singletonField = SingletonField.INSTANCE;
        singletonField.leaveTheBuilding();

        SingletonEnumType singletonEnumType = SingletonEnumType.INSTANCE;
        singletonEnumType.leaveTheBuilding();

        SingletonStaticFactory singletonStaticFactory = SingletonStaticFactory.getInstance();
        singletonStaticFactory.leaveTheBuilding();
    }

    private static void runItem1() {
        System.out.println(Item1.from(1l));
        System.out.println(Item1.of("teste", "teste2", "teste3"));
        System.out.println(Item1.valueOf(Integer.MAX_VALUE));
        System.out.println(Item1.getInstance());

    }

    private static void runItem2() throws JsonProcessingException {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240, 8).fat(2).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);
        Ford fiesta = new Ford.Builder(Ford.Color.BLACK).withName("Fiesta").addType(Car.Type.SUV).build();
        Ford fiestaSedan = new Ford.Builder(Ford.Color.BLACK).withName("Fiesta Sedan").addType(Car.Type.SEDAN).build();
        br.com.effective.java.cap2.item2.telescoping.NutritionFacts bread = new br.com.effective.java.cap2.item2.telescoping.NutritionFacts(240, 8, 120);

        System.out.println(fiesta);
        System.out.println(fiestaSedan);
        System.out.println(bread);
    }

}