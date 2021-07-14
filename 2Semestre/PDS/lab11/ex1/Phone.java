package lab11.ex1;

public class Phone {
    private String processador;
    private double preco;
    private double memoria;
    private String camara; 

    public Phone(String processador, double preco, double memoria, String camara) {
        this.processador = processador;
        this.preco = preco;
        this.memoria = memoria;
        this.camara = camara;
    }

    public String getProcessador() {
        return processador;
    }

    public double getPreco() {
        return preco;
    }

    public double getMemoria() {
        return memoria;
    }

    public String getCamara() {
        return camara;
    }

    @Override
    public String toString() {
        return "Phone [camara=" + camara + ", memoria=" + memoria + ", preco=" + preco + ", processador=" + processador
                + "]";
    }
    
}