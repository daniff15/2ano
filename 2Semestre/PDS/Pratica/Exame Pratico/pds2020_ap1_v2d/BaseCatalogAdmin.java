package pds2020_ap1_v2d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BaseCatalogAdmin implements CatalogAdmin {
  Map<String, Servico> servicos = new LinkedHashMap<>();

  @Override
  public Iterator<String> iterator() {
    List<String> servicosString = new ArrayList<>();
    for (Servico servico : servicos.values())
      servicosString.add(servico.toString());

    return servicosString.iterator();
  }

  @Override
  public boolean registarServico(String codigo, Servico servico) {
    if (servicos.containsKey(codigo))
      return false;

    servicos.put(codigo, servico);
    return false;
  }

  @Override
  public boolean verificarServico(String codigo) {
    return servicos.containsKey(codigo);
  }

  @Override
  public Servico selecionarServico(String codigo) {
    return servicos.get(codigo);
  }

  @Override
  public Servico removerServico(String codigo) {
    return servicos.remove(codigo);
  }

  @Override
  public Map<String, Servico> getServicos() {
    return servicos;
  }

}
