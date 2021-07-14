package Testes.TESTE2020.DEUMERDA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacoteServicos extends AbsServico{

    private String name;
    private String description;
    private TipoServico tp;

    StringBuilder sb = new StringBuilder();
    List<Servico> pacoteList = new ArrayList<>();

    public PacoteServicos(String name, String description) {
        super(name, description);
        this.tp = TipoServico.PACOTE;
    }

    public void add(Servico s) {
        pacoteList.add(s);
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String description() {
        return description;
    }

    public int discount() {
        Set<String> tiposServicos = new HashSet<>();
        for (Servico servico : pacoteList) {
            tiposServicos.add(servico.getClass().getName());
        }
        int discount = tiposServicos.size() * 3;
        if (discount <= 10) {
            return discount;
        } else {
            return 10;
        }
    }

    @Override
    public double price() {
        double totalPrice = 0;
        for (Servico servico : pacoteList) {
            totalPrice += servico.price();
        }

        int discount = 100 - discount();
        return (totalPrice * discount) / 100;
    }

    @Override
    public String toString() {
        sb.append("Pacote com " + pacoteList.size() + " Preco = " + price() + " (discount = " + discount() + "%)\n");
        for (Servico servico : pacoteList) {
            sb.append("\t" + servico + "\n");
        }
        return sb.toString();
    }


    @Override
    public TipoServico type() {
        return tp;
    }
    
    
    
}
