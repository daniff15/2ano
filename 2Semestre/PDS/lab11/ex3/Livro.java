package lab11.ex3;

public class Livro {
    private State currentState;
    private String titulo, autor;
    private int iSBN, ano;
    
    public Livro(String titulo, String autor, int iSBN, int ano) {
        currentState = new Inventario();
        this.titulo = titulo;
        this.autor = autor;
        this.iSBN = iSBN;
        this.ano = ano;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public void regista(){
        currentState.regista(this);
    }


    public void requisita(){
        currentState.requisita(this);
    }

    public void devolve(){
        currentState.devolve(this);
    }

    public void cancelaReserva(){
        currentState.cancelaReserva(this);
    }

    public void reserva(){
        currentState.reserva(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return String.format("%-22s %-15s %15s", getTitulo() , getAutor(), getCurrentState());
    }

}
