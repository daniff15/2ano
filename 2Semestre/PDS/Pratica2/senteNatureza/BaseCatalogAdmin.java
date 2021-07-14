package Testes.TESTE2020.DEUMERDA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class BaseCatalogAdmin implements CatologAdmin {

    Map<String, Servico> catalogo = new HashMap<>();

    @Override
    public boolean registarServico(String codigo, Servico servico) {
        if (!catalogo.containsKey(codigo)) {
            catalogo.put(codigo, servico);
            return true;
        }
        return false;
    }

    @Override
    public boolean verificarServico(String codigo) {
        if (catalogo.containsKey(codigo)) {
            return true;
        }
        return false;
    }

    @Override
    public Servico removerServico(String codigo) {
        Servico s = catalogo.get(codigo);
        if (verificarServico(codigo)) {
            catalogo.remove(codigo);
        } else {
            return null;
        }
        return s;
    }

    public Iterator<String> iterator() {
        List<String> servicosString = new ArrayList<>();
        for (Servico servico : catalogo.values())
            servicosString.add(servico.toString());

        return servicosString.iterator();
    }

    @Override
    public Servico selecionarServico(String chave) {
        for (String key : catalogo.keySet()) {
            if (key.equals(chave)) {
                return catalogo.get(key);
            }
        }
        return null;
    }

    public Map<String, Servico> getServicos() {
        return catalogo;
    }
}
