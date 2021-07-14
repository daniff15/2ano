package pds2020_ap1_v2d;

public class Passeio extends AbstractServico {

  public Passeio(String name, String description, double price) {
    super(name, description, price);
    // TODO Auto-generated constructor stub
  }

  @Override
  public TipoServico type() {
    return TipoServico.PASSEIO;
  }

}
