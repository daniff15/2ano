package lab07.ex3;

public class Bebida extends Product{

    private String name;
    private double weight;
    
    
    public Bebida(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Bebida" +  name + " - Weight : " + weight;
    }


    public double getWeight() {
        return weight;
    }

}
