package lab07.ex1;

import java.lang.Comparable;

public class Data implements Comparable<Data> {
    private int dia;
    private int mes;
    private int ano;
    // .....

    public Data(int dia, int mes, int ano) {
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

    @Override
    public int compareTo(Data o) {
        int res=0;
        if (ano>o.ano){
            res=1;
        }
        else if (ano<o.ano){
            res=-1;
        }
        else if (mes>o.mes){
            res=1;
        }
        else if(mes<o.mes){
            res=-1;
        }
        else if(dia>o.dia){
            res=1;
        }
        else if (dia<o.dia){
            res=-1;
        }
        return res;
    }
}