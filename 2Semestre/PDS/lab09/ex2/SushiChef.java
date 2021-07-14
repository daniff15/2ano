package lab09.ex2;

public class SushiChef extends Chef {

    @Override
    public void request(String plate){
        if (canHandlePlate(plate, "sushi")) {
            System.out.println("SushiChef: Starting to cook " + plate + ". Out in 14 minutes!");
        }
        else{
            System.out.println("SushiChef: I can't cook that.");
            super.request(plate);
        }
    }
    
}
