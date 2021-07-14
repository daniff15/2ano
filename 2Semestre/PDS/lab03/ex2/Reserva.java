package lab03.ex2;

public class Reserva {
    private Classe classe;
    private String codigo;
    private int numReserva;

    public Reserva(Classe classe, String codigoVoo, int numReserva) {
        this.classe = classe;
        this.codigo = codigoVoo + ":" + numReserva;
        this.numReserva = numReserva;
    }

    public Classe getClasse() {
        return classe;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getNumReserva() {
        return numReserva;
    }

}
