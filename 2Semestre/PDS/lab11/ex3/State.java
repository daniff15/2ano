package lab11.ex3;

public interface State{

    public void regista(Livro livro);
    public void requisita(Livro livro);
    public void devolve(Livro livro);
    public void cancelaReserva(Livro livro);
    public void reserva(Livro livro);

}