import java.util.*;

public class BasicCamperService implements ICamperService {

    Map<Cliente , ICamper> alugueres = new HashMap<>();
    static List<ICamper> campersDisp = new ArrayList<>();
    List<Utilizador> users = new ArrayList<>();
    
    @Override
    public void registaUtilizador(Utilizador u){
        if(!users.contains(u)){
            users.add(u);
        }
    }

    @Override
    public ICamper registaCamper(int lugares, String descricao){
        ICamper iCamper = new ICamperMode(lugares, descricao);
        if(!campersDisp.contains(iCamper)){
            campersDisp.add(iCamper); 
            iCamper.setEstado(Estado.Disponivel);
        }

        return iCamper;
    }

    @Override
    public String registaAluguer(Cliente u, ICamper c){
        alugueres.put(u , c);
        c.setEstado(Estado.Reservado);
        return "Utilizador " + u.toString() + " alugou " + c.toString();

    }

    @Override
    public String terminaAluguer(Cliente u, ICamper c){
        alugueres.remove(u);
        c.setEstado(Estado.Disponivel);
        return "Utilizador " + u.toString() + " devolveu " + c.toString();
    }

    public List<ICamper> getCampersDisponiveis(){
        List<ICamper> disponiveis = new ArrayList<>();
        for(ICamper icamper : campersDisp){
            if(icamper.getEstado() == Estado.Disponivel){
                if(!disponiveis.contains(icamper)){
                    disponiveis.add(icamper);
                }
            }
        }
        return disponiveis;
    }
}
