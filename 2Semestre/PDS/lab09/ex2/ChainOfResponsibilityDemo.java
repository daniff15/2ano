package lab09.ex2;

import java.util.ArrayList;
import java.util.List;


public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        List<String> plateList = new ArrayList<>();
        plateList.add("veggie burger");
        plateList.add("Pasta Carbonara");
        plateList.add("PLAIN pizza, no toppings!");
        plateList.add("sushi nigiri and sashimi");
        plateList.add("salad with tuna");
        plateList.add("strawberry ice cream and waffles dessert");

        Chef chef = new SushiChef().setProximo(new PastaChef().setProximo(new BurgerChef().setProximo(new PizzaChef().setProximo(new DessertChef()))));

        for (String plateName : plateList) {
            System.out.println("Can I please get a " + plateName +"?");
            chef.request(plateName);
            System.out.println();
        }
    }
}
