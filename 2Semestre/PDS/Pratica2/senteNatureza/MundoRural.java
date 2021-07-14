package Testes.TESTE2020.DEUMERDA;

public class MundoRural extends AbsServico {

    private TipoServico tp;


    public MundoRural(String name, String description, double price) {
        super(name, description, price);
        this.tp = TipoServico.MUNDORURAL;
    }

    @Override
    public String toString() {
        return "MundoRural " + super.toString() + " ]";
    }
    @Override
    public TipoServico type() {
        return tp;
    }    
}
