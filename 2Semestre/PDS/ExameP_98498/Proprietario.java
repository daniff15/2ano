import java.util.Map;
import java.util.HashMap;

public class Proprietario extends Utilizador{

    BasicCamperService bcService;
    
    Map<Cliente , ICamper> pedidos = new HashMap<>();

    public Proprietario(String nome, String localidade , int idade) {
        super(nome, localidade, idade);
    }

    public String registaPedido(Cliente u, ICamper c){
        if (!pedidos.containsKey(u)) {
            pedidos.put(u, c);
        }

        return "Pedido de " + u.toString() + " para " + c.toString() + ": Pendente\n"; 
    }

    public String cancelaPedido(Cliente u, ICamper c){
        if (pedidos.containsKey(u)) {
            pedidos.remove(u);
        }

        return "Pedido de " + u.toString() + " para "  + c.toString() + ": Cancelado\n"; 
    }

    public String aceitaPedido(Cliente u, ICamper c){
        c.setEstado(Estado.Reservado);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Aceite\n";
    }

    public String rejeitaPedido(Cliente u, ICamper c){
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Rejeitado\n";
    }

    public String registaDevolucao(Cliente u, ICamper c){
        c.setEstado(Estado.Disponivel);
        return "Pedido de " + u.toString() + " para " + c.toString() + ": Devolucao\n";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
