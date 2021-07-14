package pds2020_ap1_v2d;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PacoteServicos implements Servico {
  private String name;
  private String description;
  private List<Servico> servicos = new ArrayList<>();

  public PacoteServicos(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public void add(Servico s) {
    servicos.add(s);
  }

  public int desconto() {
    int desconto = 3 * servicos.size();
    if (desconto > 10)
      return 10;
    return desconto;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String description() {
    return description;
  }

  @Override
  public double price() {
    // TODO Auto-generated method stub
    double price = 0;
    for (Servico servico : servicos)
      price += servico.price();

    return price * (100 - desconto()) / 100;
  }

  @Override
  public TipoServico type() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String toString() {
    String str = "Pacote com " + servicos.size() + " AbstractServicos de " + new HashSet<>(servicos).size()
        + " tipos. Preco (desconto = " + desconto() + "%): " + price() + "\n";

    for (Servico servico : servicos)
      str += servico + "\n";

    return str;
  }

}
