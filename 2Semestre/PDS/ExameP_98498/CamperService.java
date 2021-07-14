import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CamperService {

    Proprietario p;
    BasicCamperService bsService;

    public CamperService() {
        p = new Proprietario("Olavo Fala", "Gemeses", 44);
    }

    public ICamper registaCamper(int lugares, String descricao){
        ICamper icamper = new ICamperMode(lugares, descricao);
        if (!BasicCamperService.campersDisp.contains(icamper)) {
            BasicCamperService.campersDisp.add(icamper);
        }

        return icamper;
    }

    public String registaPedido(Cliente u, ICamper c){
        return p.registaPedido(u , c); 
    }

    public String cancelaPedido(Cliente u, ICamper c){
        return p.cancelaPedido(u, c); 
    }

    public String aceitaPedido(Cliente u, ICamper c){
        return p.aceitaPedido(u, c); 
    }

    public String rejeitaPedido(Cliente u, ICamper c){
        return p.rejeitaPedido(u, c); 
    }

    public String registaDevolucao(Cliente u, ICamper c){
        return p.registaDevolucao(u, c);
    }

    public List<ICamper> getCampersDisponiveis(){
        return bsService.campersDisp;
    }



}
