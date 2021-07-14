package lab07.ex3;

public class Doce extends Product {
    private String name;
    private double weight;

    public Doce(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Doce" + name + " - Weight : " + weight;
    }

    public double getWeight() {
        return weight;
    }

}
