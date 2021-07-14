package miVersion;

public class Transporte extends AbstractServico {

    public Transporte(String name, String description, double price) {
        super(name, description, price);
    }
    
    @Override
    public TipoServico type() {
        return TipoServico.TRANSPORTE;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
