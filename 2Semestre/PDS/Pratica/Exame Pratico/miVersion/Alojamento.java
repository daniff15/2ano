package miVersion;

import miVersion.AbstractServico;

public class Alojamento extends AbstractServico {

    private int ocupacaoMax;

    public Alojamento(String name, String description, double price, int ocupacaoMax) {
        super(name, description, price);
        this.ocupacaoMax = ocupacaoMax;
    }

    @Override
    public TipoServico type() {
        return TipoServico.ALOJAMENTO;
    }

    public int ocupacaoMax() {
        return ocupacaoMax;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length() - 1) + ", ocupacao maxima=" + ocupacaoMax + "]";
    }

}
