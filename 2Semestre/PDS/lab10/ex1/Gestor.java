package lab10.ex1;

import java.util.ArrayList;
import java.util.List;

public class Gestor implements Observer{

    private String name;
    private List<Produto> produtos = new ArrayList<>();
    
    public Gestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String string) {
        System.out.println(string);
    }

    @Override
    public String getName() {
        return name;
    }

    public void addProduto(Produto produto){
        produtos.add(produto);
        produto.registerObserver(this);
    }

    public void comecarLeilao(Produto p, int tempoMax){
        p.addToAuction(tempoMax);
    }
    
}
