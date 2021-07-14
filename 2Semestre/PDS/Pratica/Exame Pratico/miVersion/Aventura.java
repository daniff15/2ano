package miVersion;

import miVersion.AbstractServico;

public class Aventura extends AbstractServico {

    public Aventura(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public TipoServico type() {
        return TipoServico.AVENTURA;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
