package lab03.ex2;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Voo {
    private String codigo;
    private int[][] lugaresExecutiva;// colunas representam as filas
    private int[][] lugaresTuristica;// colunas representam as filas
    private boolean contemExecutiva = false;
    private int numReserva = 1;
    private Map<String, Reserva> reservas = new HashMap<>(); // mapa key->codigo da reserva, value-> reserva


    public Voo(String codigo, String lugares1 , String lugares2) {
        this.codigo = codigo;

        String[] tmp = lugares1.split("x"); //tmp[0] -> filas; tmp[1]-> numero de lugares de cada fila
        this.lugaresExecutiva = new int[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])];
        tmp = lugares2.split("x"); //tmp[0] -> filas; tmp[1]-> numero de lugares de cada fila
        this.lugaresTuristica = new int[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])];
        this.contemExecutiva = true;
    }

    public Voo(String codigo, String lugares2) {
        this.codigo = codigo;

        String[] tmp = lugares2.split("x");//tmp[0] -> filas; tmp[1]-> numero de lugares de cada fila
        this.lugaresTuristica = new int[Integer.parseInt(tmp[1])][Integer.parseInt(tmp[0])];
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void cancelaReserva(String codigoReserva){
        if (reservas.containsKey(codigoReserva)) { //verificar se a reserva a cancelar existe
            Reserva reserva = reservas.get(codigoReserva);

            if (reserva.getClasse() == Classe.E) {  //verificar a classe da reserva
                for (int i = 0; i < lugaresExecutiva.length; i++) {
                    for (int j = 0; j < lugaresExecutiva[0].length; j++) {
                        if (lugaresExecutiva[i][j]==reserva.getNumReserva()) {
                            lugaresExecutiva[i][j] = 0;     //retirar a reserva
                        }
                    }
                }
            } else {
                for (int i = 0; i < lugaresTuristica.length; i++) {
                    for (int j = 0; j < lugaresTuristica[0].length; j++) {
                        if (lugaresTuristica[i][j]==reserva.getNumReserva()) {
                            lugaresTuristica[i][j] = 0; //retirar a reserva
                        }
                    }
                }
            }

            reservas.remove(codigoReserva);
        }else{
            System.out.println("O voo nao contêm a reserva de código: " + codigoReserva);
        }
    }

    public void reservar(Scanner input){
        lugares_Disponiveis();  //print dos lugares disponiveis
        
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] firstLine = line.split(" ");

            if ( firstLine.length==2 && firstLine[0].matches("[TE]") && firstLine[1].matches("[1-9][0-9]*") ) { // verificar os argumentos da reserva
                boolean reservou = checkReserva(Classe.getEnum(firstLine[0]), Integer.parseInt(firstLine[1]));  //verificar se a reserva foi feita

                if (reservou) {
                    Reserva reserva = new Reserva(Classe.getEnum(firstLine[0]), codigo, numReserva);
                    reservas.put(reserva.getCodigo(), reserva); //atualizar mapa
                    numReserva++;
                }

            }else{
                System.out.println("Argumentos de reserva na opcao I inválidos");
            }
                
        }
    }

    public void reservar(Classe classe, int numPassageiros){
        boolean reservou =checkReserva(classe, numPassageiros); //verificar se a reserva foi feita
        String string = "";
        if (reservou) {
            Reserva reserva = new Reserva(classe, codigo, numReserva);
            reservas.put(reserva.getCodigo(), reserva); //atualizar mapa
            numReserva++;

            string = reserva.getCodigo() + " = ";
            
            //construir string do output da opcao reserva
            if (classe == Classe.T) {
                for (int i = 0; i < lugaresTuristica.length; i++) {
                    for (int j = 0; j < lugaresTuristica[0].length; j++) {
                        if (lugaresTuristica[i][j] == reserva.getNumReserva() && contemExecutiva) {
                            string+= j+1+lugaresExecutiva[0].length + Character.toString((char)(65+i)) + " | ";
                        }    
                        else if (lugaresTuristica[i][j] == reserva.getNumReserva()){
                            string+= j+1 + Character.toString((char)(65+i)) + " | ";
                        }
                        
                    }
                }
            }else{
                for (int i = 0; i < lugaresExecutiva.length; i++) {
                    for (int j = 0; j < lugaresExecutiva[0].length; j++) {
                        if (lugaresExecutiva[i][j] == reserva.getNumReserva() ) {
                            string+= j+1 + Character.toString((char)(65+i)) + " | ";
                        }
                    }
                }
            }
            string = string.substring(0,string.length()-3);
            System.out.println(string); 
        }
    }


    public boolean checkReserva(Classe classe, int numPassageiros){
        int copyNumPass = numPassageiros;   //numero de passageiros a reservar

        int[][] lugares;
        int[][] lugares_tmp;

        if (classe == Classe.E && contemExecutiva){
            lugares = copiaVector(lugaresExecutiva);// vetor temporario de lugaresExecuitiva
            lugares_tmp = copiaVector(lugaresExecutiva);// vetor temporario de lugaresExecuitiva
            
        }
        else if (classe == Classe.T){
            lugares = copiaVector(lugaresTuristica);// vetor temporario de lugaresTuristica
            lugares_tmp = copiaVector(lugaresTuristica);// vetor temporario de lugaresTuristica
        }
        else{
            System.out.println("Classe executiva não disponível neste voo.");
            return false;
        }
        
        for (int i = 0; i < lugares[0].length; i++) {
            boolean filaVazia = true;
            for (int j = 0; j < lugares.length; j++) {  //verfificar se existe fila vazia
                if (lugares[j][i]!=0) {
                    filaVazia = false;
                }
            }

            if (filaVazia) {// se existir fila vazia, preencher com a reserva no vetor temporario
                for (int j = 0; j < lugares.length; j++) {
                    lugares_tmp[j][i] = numReserva;
                    numPassageiros--;
                    if (numPassageiros==0){// se a reserva já foi feita, atualizar os vetores
                        if (classe == Classe.E)
                            lugaresExecutiva = lugares_tmp;// vetor temporario de lugaresExecuitiva
                        else if (classe == Classe.T)
                            lugaresTuristica = lugares_tmp;// vetor temporario de lugaresTuristica
                        return true;
                    }

                }
            }

        }
        
        lugares = copiaVector(lugares_tmp); //atualizar vetor temporario lugares

        
        for (int i = 0; i < lugares[0].length; i++) {
            for (int j = 0; j < lugares.length; j++) {
                if (lugares[j][i]==0) { // se houver lugar vazio preencher com a reserva 
                    lugares_tmp[j][i] = numReserva;
                    numPassageiros--;
                    if (numPassageiros==0){// se a reserva já foi feita, atualizar os vetores
                        if (classe == Classe.E)
                            lugaresExecutiva = lugares_tmp;// vetor temporario de lugaresExecuitiva
                        else if (classe == Classe.T)
                            lugaresTuristica = lugares_tmp;// vetor temporario de lugaresTuristica
                        return true;
                    }
                }
                
            }
        }
        

        if(numPassageiros==0){// se a reserva já foi feita, atualizar os vetores
            if (classe == Classe.E)
                lugaresExecutiva = lugares_tmp;// vetor temporario de lugaresExecuitiva
            else if (classe == Classe.T)
                lugaresTuristica = lugares_tmp;// vetor temporario de lugaresTuristica
        
            return true;
        }

        System.out.printf("Não foi possível obter lugares para a reserva: %s %d\n", classe, copyNumPass);
        return false;
    }

    public static int[][] copiaVector(int[][] vetor){
        int[][] vector = new int[vetor.length][vetor[0].length];
        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < vetor[0].length; j++) {
            vector[i][j] = vetor[i][j]; 
            }
        }
        return vector;
    }


    public void lugares_Disponiveis(){
        System.out.printf("Código de voo %s. Lugares disponíveis: ", codigo);

        int numLugares=0;
        if (contemExecutiva) {
            for (int i = 0; i < lugaresExecutiva.length; i++) {
                for (int j = 0; j < lugaresExecutiva[0].length; j++) {
                    if (lugaresExecutiva[i][j]==0) {
                        numLugares++;
                    }
                }
            }

            System.out.printf("%d lugares em classe Executiva; ", numLugares);
        }

        numLugares = 0;
        for (int i = 0; i < lugaresTuristica.length; i++) {
            for (int j = 0; j < lugaresTuristica[0].length; j++) {
                if (lugaresTuristica[i][j]==0) {
                    numLugares++;
                }
            }
        }

        System.out.printf("%d lugares em classe Turística.\n",numLugares);

    }
    
    @Override
    public String toString() {
        //retornar string do print de um voo
        String string = " "; //a primeira linha começa por " "
        int numLinhas, numFilas;

        if(contemExecutiva){
            numFilas = lugaresExecutiva[0].length + lugaresTuristica[0].length;//numero de filas do string é a soma das filas dos lugares 
            numLinhas = Math.max(lugaresExecutiva.length,lugaresTuristica.length );//numero de linhas é o numero maximo de linhas entre os dois tipos de lugar  

        }else{
            numFilas = lugaresTuristica[0].length; //numero de filas do string é o numero de colunas de lugaresTuristica
            numLinhas = lugaresTuristica.length; 
            
        }

        int ascii_A = 65;//ASCII de A
        String[] letras = new String[numLinhas]; //letras da string de retorno
        for (int i = 0; i < numLinhas; i++) {
            int tmp = ascii_A++; //somar ao ASCII anterior 1, de modo a gerar o ASCII da letra seguinte
            letras[i] = Character.toString((char)tmp);  //transformar o ASCII em String e guardar no vetor de letras
        }

        for (int i = 0; i < numFilas; i++) {
            string+= " " + String.format("%2d" , i+1);   //construir a primeira linha da string de retorno
        }
        string += "\n"; //mudar para a próxima linha

        for (int i = 0; i < numLinhas; i++) {   //este for constrói linha a linha 
            string += letras[i];    //começa por somar a letra

            if (contemExecutiva) {  //verificar se contem lugares executivos
                for (int j = 0; j < lugaresExecutiva[0].length; j++) {
                    if (i < lugaresExecutiva.length) {  //se o numero de linha que estamos a analisar for um indice possivel do vetor lugaresExecutiva
                        string += " " + String.format("%2d" , lugaresExecutiva[i][j]); //adicionar à string o valor do lugaresExecutiva[i][j]
                    }else{
                        string += "   "; //se nao, adicionar espaço
                    }
    
                }   
            }

            for (int j = 0; j < lugaresTuristica[0].length; j++) {
                if (i < lugaresTuristica.length) {  //se o numero de linha que estamos a analisar for um indice possivel do vetor lugaresTuristica
                    string += " " + String.format("%2d" , lugaresTuristica[i][j]); //adicionar à string o valor do lugaresTuristica[i][j]
                }else{
                    string += "   "; //se nao, adicionar espaço
                }
            }

            if (numLinhas-1!=i)
                string += "\n"; //no fim adicionar a mudança de linha
        }

        return string;
    }

}
