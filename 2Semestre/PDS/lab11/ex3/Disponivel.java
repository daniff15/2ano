package lab11.ex3;

public class Disponivel implements State{

    @Override
    public void cancelaReserva(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");        
    }

    @Override
    public void devolve(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");        
    }

    @Override
    public void regista(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");        
    }

    @Override
    public void requisita(Livro livro) {
        livro.setCurrentState(new Emprestado());
    }

    @Override
    public void reserva(Livro livro) {
        livro.setCurrentState(new Reservado());
    }

    @Override
    public String toString() {
        return "[Disponivel]";
    }

    
    
}
