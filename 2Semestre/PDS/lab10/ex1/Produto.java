package lab10.ex1;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Produto {
    private static int contador = 1;
    private int codigo;
    private String descricao;
    private Estados estado = Estados.STOCK;
    private double preco;
    private List<Observer> observers = new ArrayList<>();
    private int tempoMax = 0;
    private Date tempoInicio;

    public Produto(String descricao, double preco) {
        this.codigo = contador++;
        this.descricao = descricao;
        this.preco = preco;
    }

    public void registerObserver(Observer obs) {
        if (estado==Estados.LEILAO) {
            observers.add(obs);
        }
    }

    public void addToAuction(int mxTime) {
        estado = Estados.LEILAO;
        tempoInicio = new Date();
        tempoMax = mxTime;
    }

    public boolean takeBid(double bid, Observer obs) {
        Date currentTime = new Date();
        int segundosCurrentTime = 0;
        if (tempoInicio!=null) {
            segundosCurrentTime = (int) ((currentTime.getTime() - tempoInicio.getTime()) / 1000);
        }

        if (segundosCurrentTime > tempoMax) {
            estado = Estados.VENDAS;
            return false;
        }

        if (bid <= preco || estado != Estados.LEILAO || !obs.getClass().getName().split("\\.")[2].equals("Cliente")) {
            return false;
        }
        else{
            preco = bid;
            aviso("Nova licitacao feita por " + obs.getName() + " de valor " + preco + "€ ao produto " + descricao);
        }
        return true;
    }

    public void aviso(String string){
        for (Observer observer : observers) {
            observer.update(observer.getClass().getName().split("\\.")[2] + " " + observer.getName() + ": " + string );
        }
    }
}
