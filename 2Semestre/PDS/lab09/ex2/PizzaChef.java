package lab09.ex2;

public class PizzaChef extends Chef{
    @Override
    public void request(String plate){
        if (canHandlePlate(plate, "pizza")) {
            System.out.println("PizzaChef: Starting to cook " + plate + ". Out in 7 minutes!");
        }
        else{
            System.out.println("PizzaChef: I can't cook that.");
            super.request(plate);
        }
    }
}
