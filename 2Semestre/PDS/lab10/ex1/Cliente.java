package lab10.ex1;

public class Cliente implements Observer{

    private String name;

    public Cliente(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(String string) {
        System.out.println(string);
    }

    public void licitar(Produto p, double bid){
        p.takeBid(bid, this);
    }

}
