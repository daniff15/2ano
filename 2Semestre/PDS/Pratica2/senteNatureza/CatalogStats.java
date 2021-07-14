package Testes.TESTE2020.DEUMERDA;

public class CatalogStats {

    private CatologAdmin catAdmin;

    public CatalogStats(CatologAdmin catAdmin) {
        this.catAdmin = catAdmin;
    }

    public double getAveragePriveActivities() {
        double totalPrice = 0;
        int counter = 0;
        for (Servico servico : catAdmin.getServicos().values()) {
            counter += 1;
            if (servico.type() != TipoServico.ALOJAMENTO) {
                if (servico.type() != TipoServico.PACOTE) {
                    totalPrice += servico.price();
                }
            }
        }
        return totalPrice / counter;
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
