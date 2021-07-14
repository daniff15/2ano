package pds2020_ap1_v2d;

public class MundoRural extends AbstractServico {

  public MundoRural(String name, String description, double price) {
    super(name, description, price);
    // TODO Auto-generated constructor stub
  }

  @Override
  public TipoServico type() {
    return TipoServico.MUNDORURAL;
  }

}
