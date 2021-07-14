package miVersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.List;

public class BaseCatalogAdmin implements CatalogAdmin{

    Map<String, Servico> cataloguinho = new HashMap<>();

    @Override
    public Map<String, Servico> getServicos() {
        return cataloguinho;
    }

    @Override
    public boolean registarServico(String codigo, Servico servico) {
        cataloguinho.put(codigo , servico);
        return true;
    }

    @Override
    public Servico removerServico(String codigo) {
        Servico s = null;
        if (verificarServico(codigo)) {
            s = cataloguinho.get(codigo);
            cataloguinho.remove(codigo);
        }
        return s;
    }

    @Override
    public Servico selecionarServico(String codigo) {
        Servico s = null;
        if (verificarServico(codigo)) {
            s = cataloguinho.get(codigo);
        }
        return s;
    }

    @Override
    public boolean verificarServico(String codigo) {
        if (cataloguinho.containsKey(codigo)) {
            return true;
        }
        return false;
    }

    public Iterator<String> iterator(){
        List<String> servicosString = new ArrayList<>();
        for (Servico servico : cataloguinho.values()) {
            servicosString.add(servico.toString());
        }

        return servicosString.iterator();
    }
    
}
