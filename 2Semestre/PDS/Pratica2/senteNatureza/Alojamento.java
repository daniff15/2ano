package Testes.TESTE2020.DEUMERDA;

public class Alojamento extends AbsServico {

    private int nOcupantes;
    private TipoServico tp;
    
    public Alojamento(String name, String description, double price, int nOcupantes) {
        super(name, description, price);
        this.nOcupantes = nOcupantes;
        this.tp = TipoServico.ALOJAMENTO;
    }

    public int getnOcupantes() {
        return nOcupantes;
    }

    public void setnOcupantes(int nOcupantes) {
        this.nOcupantes = nOcupantes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + nOcupantes;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alojamento other = (Alojamento) obj;
        if (nOcupantes != other.nOcupantes)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Alojamento " + super.toString() + ", nOcupantes= " + nOcupantes + "]";
    }


    @Override
    public TipoServico type() {
        return tp;
    }
    
}
