package lab11.ex3;

public class Reservado implements State {

    @Override
    public void cancelaReserva(Livro livro) {
        livro.setCurrentState(new Disponivel());
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
        throw new UnsupportedOperationException("Operação não disponível");        
    }

    @Override
    public void reserva(Livro livro) {
        throw new UnsupportedOperationException("Operação não disponível");        
    }

    @Override
    public String toString() {
        return "[Reservado]";
    }

    
    
}
