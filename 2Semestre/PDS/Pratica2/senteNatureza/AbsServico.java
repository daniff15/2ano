package Testes.TESTE2020.DEUMERDA;


public class AbsServico implements Servico {

    private String name;
    private String description;
    private double price;
    private TipoServico tp;

    
    public AbsServico(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public AbsServico(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public double price() {
        return price;
    }

    @Override
    public TipoServico type() {
        return tp;
    }

    @Override
    public String toString() {
        return "[name = " + name + ", description = " + description + ", price = " + price;
    }
}
