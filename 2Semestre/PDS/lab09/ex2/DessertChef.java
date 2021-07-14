package lab09.ex2;

public class DessertChef extends Chef {
    @Override
    public void request(String plate){
        if (canHandlePlate(plate, "dessert")) {
            System.out.println("DessertChef: Starting to cook " + plate + ". Out in 17 minutes!");
        }
        else{
            System.out.println("DessertChef: I can't cook that.");
            super.request(plate);
        }
    }
}
