package lab05.ex2;

public interface CakeBuilder{

    public void setCakeShape(Shape shape);

    public void addMessage(String m);

    public void createCake();

    public Cake getCake();
}