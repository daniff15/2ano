package pds2020_ap1_v2d;

public class Aventura extends AbstractServico {

  public Aventura(String name, String description, double price) {
    super(name, description, price);
    // TODO Auto-generated constructor stub
  }

  @Override
  public TipoServico type() {
    return TipoServico.AVENTURA;
  }

}
