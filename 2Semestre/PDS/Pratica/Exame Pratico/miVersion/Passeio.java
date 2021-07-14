package miVersion;

import miVersion.TipoServico;

public class Passeio extends AbstractServico{

    public Passeio(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public TipoServico type() {
        return TipoServico.PASSEIO;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
