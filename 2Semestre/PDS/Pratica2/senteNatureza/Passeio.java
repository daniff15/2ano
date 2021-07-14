package Testes.TESTE2020.DEUMERDA;

public class Passeio extends AbsServico {

    private TipoServico tp;


    public Passeio(String name, String description, double price) {
        super(name, description, price);
        this.tp = TipoServico.PASSEIO;
    }

    @Override
    public String toString() {
        return "Passeio " + super.toString() + " ]";
    }

    @Override
    public TipoServico type() {
        return tp;
    }
}
