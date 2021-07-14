package lab07.ex3;

public class Conserva extends Product{
    private String name;
    private double weight;

    public Conserva(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Conserva" + name + " - Weight : " + weight;
    }

    public double getWeight() {
        return weight;
    }
}
