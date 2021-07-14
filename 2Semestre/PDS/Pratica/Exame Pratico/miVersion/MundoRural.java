package miVersion;

import miVersion.AbstractServico;

public class MundoRural extends AbstractServico{

    public MundoRural(String name, String description, double price) {
        super(name, description, price);
    }

    @Override
    public TipoServico type() {
        return TipoServico.MUNDORURAL;
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
