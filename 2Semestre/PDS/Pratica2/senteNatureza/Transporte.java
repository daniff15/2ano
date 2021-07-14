package Testes.TESTE2020.DEUMERDA;

public class Transporte extends AbsServico{

    private TipoServico tp;

    public Transporte(String name, String description, double price) {
        super(name, description, price);
        this.tp = TipoServico.TRANSPORTE;
    }

    @Override
    public String toString() {
        return "Transporte " + super.toString() + " ]";
    }

    @Override
    public TipoServico type() {
        return tp;
    }
    
}
