package lab09.ex2;

public class PastaChef extends Chef{
    @Override
    public void request(String plate){
        if (canHandlePlate(plate, "pasta")) {
            System.out.println("PastaChef Starting to cook " + plate + ". Out in 14 minutes!");
        }
        else{
            System.out.println("PastaChef: I can't cook that.");
            super.request(plate);
        }
    }
}
