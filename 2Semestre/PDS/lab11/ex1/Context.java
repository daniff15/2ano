package lab11.ex1;

public class Context {
    private Strategy strategy;
    private Phone[] phones;

    public Context(Strategy strategy , Phone[] phones){
        this.phones = phones;
        this.strategy = strategy;
    }

    public Phone[] sort(String caracteristic){
        return strategy.sort(phones, caracteristic);
    }

    public void setStrategy(Strategy strategy){
        this.strategy = strategy;
    }
}
