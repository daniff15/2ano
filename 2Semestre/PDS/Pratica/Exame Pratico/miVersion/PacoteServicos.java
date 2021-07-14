package miVersion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import miVersion.AbstractServico;

public class PacoteServicos extends AbstractServico{
    private String name;
    private String description;
    private TipoServico tp;

    List<Servico> servicos = new ArrayList<>();

    public PacoteServicos(String name, String description) {
        super(name, description);
        this.tp = TipoServico.PACOTE;
    }

    public PacoteServicos(String name, String description, double price) {
        super(name, description, price);
    }

    public int discount() {
        Set<String> tiposServicos = new HashSet<>();
        for (Servico servico : servicos) {
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
    public String description() {
        return description;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        double totalPrice = 0;
        for (Servico servico : servicos) {
            totalPrice += servico.price();
        }

        int discount = 100 - discount();
        return (totalPrice * discount) / 100;
    }

    @Override
    public TipoServico type() {
        return tp;
    }

    public boolean add(Servico s){
        if (!servicos.contains(s)) {
            servicos.add(s);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb  = new StringBuilder();
        sb.append("Pacote com " + servicos.size() + " Preco = " + price() + " (discount = " + discount() + "%)\n");
        for (Servico servico : servicos) {
            sb.append("\t" + servico + "\n");
        }

        return sb.toString();
    }

}
