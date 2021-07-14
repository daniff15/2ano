package miVersion;

public class CatalogStats {

    private CatalogAdmin catAdmin;

    public CatalogStats(CatalogAdmin catAdmin) {
        this.catAdmin = catAdmin;
    }

    public double getAveragePriveActivities() {
        double totalPrice = 0;
        int count = 0;
        for (Servico servico : catAdmin.getServicos().values()) {
            count++;
            if (servico.type() != TipoServico.PACOTE) {
                if (servico.type() != TipoServico.ALOJAMENTO) {
                    totalPrice += servico.price();
                }
            }
        }

        return totalPrice / count;

    }

    public double getMinimumPrice(TipoServico tipoServico) {
        double min = 100000;
        for (Servico servico : catAdmin.getServicos().values()) {
            if (servico.type() == tipoServico) {
                if (servico.price() < min) {
                    min = servico.price();
                }
            }
        }
        return min;
    }

}
