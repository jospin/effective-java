package br.com.effective.java;

import br.com.effective.java.item1.Item1;
import br.com.effective.java.item2.NutritionFacts;
import br.com.effective.java.item2.hierarchical.Car;
import br.com.effective.java.item2.hierarchical.Ford;
import com.fasterxml.jackson.core.JsonProcessingException;
public class App {

    public static void main(String[] args) throws JsonProcessingException {
        runItem1();
        runItem2();
    }

    private static void runItem1() {
        System.out.println(Item1.from(1l));
        System.out.println(Item1.of("teste", "teste2", "teste3"));
        System.out.println(Item1.valueOf(Integer.MAX_VALUE));
        System.out.println(Item1.getInstance());

    }

    private static void runItem2() throws JsonProcessingException {
        NutritionFacts cocaCola = new NutritionFacts.Builder(240,8).fat(2).calories(100).sodium(35).carbohydrate(27).build();
        System.out.println(cocaCola);
        Ford fiesta = new Ford.Builder(Ford.Color.BLACK).withName("Fiesta").addType(Car.Type.SUV).build();
        Ford fiestaSedan = new Ford.Builder(Ford.Color.BLACK).withName("Fiesta Sedan").addType(Car.Type.SEDAN).build();

        System.out.println(fiesta);
        System.out.println(fiestaSedan);
    }

}