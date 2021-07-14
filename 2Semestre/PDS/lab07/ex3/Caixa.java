package lab07.ex3;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Product {
    private List<Product> products = new ArrayList<>();
    private String name;
    private double weight;

    public Caixa(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        double total = weight;
        for (Product product : products) {
            total += product.getWeight();
        }

        return total;
    }

    @Override
    public String toString() {
        return "* Caixa " + name + "[Weight: " + weight + "; Total: " + getWeight() + "]";
    }

    public void add(Product product) {
        products.add(product);
    }

    public void draw(){
        System.out.println(indent.toString() + toString());
        indent.append("   ");
        for (Product product : products) {
            if(product instanceof Caixa){
                ((Caixa)product).draw();
            }
            else{
                System.out.println(indent.toString() + product.toString());
            }
        }

        indent.setLength(indent.length() - 3);

    }

}
