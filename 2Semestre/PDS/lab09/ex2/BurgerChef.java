package lab09.ex2;

public class BurgerChef extends Chef {
    @Override
    public void request(String plate){
        if (canHandlePlate(plate, "burger")) {
            System.out.println("BurgerChef: Starting to cook " + plate + ". Out in 19 minutes!");
        }
        else{
            System.out.println("BurgerChef: I can't cook that.");
            super.request(plate);
        }
    }
}
