package Testes.TESTE2020.DEUMERDA;

public class Aventura extends AbsServico {

    private TipoServico tp;

    public Aventura(String name, String description, double price) {
        super(name, description, price);
        this.tp = TipoServico.AVENTURA;
    }

    @Override
    public String toString() {
        return "Aventura " + super.toString() + " ]";
    }

    @Override
    public TipoServico type() {
        return tp;
    }
}
