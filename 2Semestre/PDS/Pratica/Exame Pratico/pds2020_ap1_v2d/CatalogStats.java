package pds2020_ap1_v2d;

public class CatalogStats {
  private CatalogAdmin ctg;

  public CatalogStats(CatalogAdmin ctg) {
    this.ctg = ctg;
  }

  public double getAveragePriveActivities() {
    double priceTot = 0;

    for (Servico srv : ctg.getServicos().values())
      priceTot += srv.price();

    return priceTot / ctg.getServicos().size();
  }

  public double getMinimumPrice(TipoServico tp) {
    double min = -1;

    for (Servico srv : ctg.getServicos().values())
      if (tp == srv.type() && (min < 0 || srv.price() < min))
        min = srv.price();

    return min;
  }

}
