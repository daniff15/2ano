package lab03;

import java.util.HashMap;
import java.util.ArrayList;

public class Voo {
    private String codigo;
    // filas e colunas de lugares: dims[0] -> fila; dims[1] -> colunas
    private int[] dimsTuristico = new int[2];
    private int[] dimsExecutivo = new int[2];
    private int turisticosDisponiveis, executivosDisponiveis;
    private Executivo[][] lugaresExecutivos;
    private Turistico[][] lugaresTuristicos;
    // Is this ideal?
    private static int reservaTracker = 0;
    private HashMap<Integer, ArrayList<Lugar>> reservas = new HashMap<>();

    /**
     * Método fábrica para a classe Voo
     * @param codigo Código identificador do voo
     * @param lugaresE Dimensões da classe executiva, no formato "FILASxCOLUNAS"
     * @param lugaresT Dimensões da classe turística, no formato "FILASxCOLUNAS"
     * @return Objeto Voo
     */
    public static Voo criarVoo(String codigo, String lugaresE, String lugaresT) {
    	
    	if(!lugaresE.matches("\\d+x\\d+") || !lugaresT.matches("\\d+x\\d+")) {
    		System.err.println("ERROR: Invalid input");
    		return null;
    	}
    	
    	
    	String[] lE = lugaresE.split("x");
    	String[] lT = lugaresT.split("x");
    	int linE = Integer.parseInt(lE[0]);
    	int colE = Integer.parseInt(lE[1]);
    	int linT = Integer.parseInt(lT[0]);
    	int colT = Integer.parseInt(lT[1]);
    	
    	return new Voo(codigo,linE,colE,linT,colT);
    }
    
    /**
     * Método fábrica para a classe Voo
     * @param codigo Código identificador do voo
     * @param lugaresT Dimensões da classe turística, no formato "FILASxCOLUNAS"
     * @return Objeto Voo
     */
    public static Voo criarVoo(String codigo, String lugaresT) {
    	return criarVoo(codigo,"0x0",lugaresT);
    }
    

    /**
     * Criar voo com número de filas e colunas para lugares executivos e turísticos
     * @param cod Código identificador do voo
     * @param e_lin Número de filas executivas
     * @param e_col Número de lugares por fila executiva
     * @param t_lin Número de filas turísticas
     * @param t_col Número de lugares por fila turística
     */
    private Voo(String cod, int e_lin, int e_col, int t_lin, int t_col) {
        codigo = cod;
        dimsExecutivo[0] = e_lin;
        dimsExecutivo[1] = e_col;
        dimsTuristico[0] = t_lin;
        dimsTuristico[1] = t_col;

        // Inicializar lugares executivos
        executivosDisponiveis = e_lin * e_col;
        lugaresExecutivos = new Executivo[e_lin][e_col];
        for (int i = 0; i < e_lin; i++) {
            for (int j = 0; j < e_col; j++) {
                lugaresExecutivos[i][j] = new Executivo(i, j);
            }
        }

        // Inicializar lugares turisticos
        turisticosDisponiveis = t_lin * t_col;
        lugaresTuristicos = new Turistico[t_lin][t_col];
        for (int i = 0; i < t_lin; i++) {
            for (int j = 0; j < t_col; j++) {
                lugaresTuristicos[i][j] = new Turistico(i+e_lin, j);  // offset na fila devido a executivos
            }
        }
    }

    /**
     * Reservar lugares no voo, em lugares consecutivos se possível
     * @param num Número de lugares a reservar
     * @param executivo Reservar lugares executivos
     * @return True se foi possível reservar, False caso contrário
     */
    public boolean reservarLugares(int num, boolean executivo) {
        // Existem lugares que chegue para fazer a reserva?
        if (num >  (executivo ? executivosDisponiveis : turisticosDisponiveis) )
            return false;

        // Escolher o array de lugares no qual operar
        Lugar[][] lugares = executivo ? lugaresExecutivos : lugaresTuristicos;
        int[] dims = executivo ? dimsExecutivo : dimsTuristico;
        
        // Percorrer os lugares
        int[] pos = {0, 0};
   
        // Tentar encontrar filas vazias consecutivas suficientes
        // e definir o pos como o inicio da primeira fila caso se encontre
        int req_filas = num / dims[1] + ( num % dims[1] > 0 ? 1 : 0);
        int fil_counter = 0;

        for (int i = 0; i < dims[0]; i++) {
            fil_counter++;

            for (int j = 0; j < dims[1]; j++) {
                if (lugares[i][j].isReservado()) {
                    fil_counter = 0;
                    pos[0] = i+1;
                    break;
                }
            }

            if (fil_counter == req_filas) break;
        }
        // atribuir os lugares, começando em pos
        // para garantir a atribuição em sequencia se for possível
        if (fil_counter != req_filas) {
            // reset pos se não foi encontrada atribuição em sequencia
            pos[0] = 0;
            pos[1] = 0;
        }
        ArrayList<Lugar> reservados = new ArrayList<Lugar>();
        reservaTracker++;
        int spots = 0;
        do {
            // reservar o lugar se estiver livre
            if (! lugares[pos[0]][pos[1]].isReservado()) {
                lugares[pos[0]][pos[1]].reservarLugar(reservaTracker);
                reservados.add(lugares[pos[0]][pos[1]]);
                if (executivo)
                    executivosDisponiveis--;
                else 
                    turisticosDisponiveis--;
                spots++;
            }
            // increment pos
            pos[1]++;
            if (pos[1] == dims[1]) {
                pos[0]++;
                pos[1] = 0;
            }
        }
        while (spots < num);

        reservas.put(reservaTracker, reservados);
        return true;
    }

    /**
     * Anula a reserva dada
     * @param num Número da reserva
     * @return true se a reversa foi removida com sucesso, false se a reserva não existia
     */
    public boolean anularReserva(int num) {
        // remover reserva do mapa
        ArrayList<Lugar> lugares = reservas.remove(num);
        // iterar lugares da reserva removida
        if (lugares != null) {
            for (Lugar l : lugares) {
                l.anularReserva();
                if (l instanceof Executivo)
                    executivosDisponiveis++;
                else
                    turisticosDisponiveis++;
            }
            return true;
        }
        return false;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getExecutivosDisponiveis() {
        return executivosDisponiveis;
    }

    public int getTuristicosDisponiveis() {
        return turisticosDisponiveis;
    }

    public int getTotalExecutivos() {
        return dimsExecutivo[0] * dimsExecutivo[1];
    }

    public int getTotalTuristicos() {
        return dimsTuristico[0] * dimsTuristico[1];
    }


    @Override
    public String toString() {
    	StringBuilder str = new StringBuilder();
    	char linAlpha = 'A';
    	int colMax = dimsTuristico[0] + dimsExecutivo[0];
    	int filMax = dimsTuristico[1] > dimsExecutivo[1] ? dimsTuristico[1] : dimsExecutivo[1];
    	
    	for(int i = 0; i < filMax + 1; i++) {
    		for(int j = 0; j < colMax + 1; j++) {
    			if(i == 0 && j == 0) {
    				str.append(" ");
    			}
    			else if( i == 0 && j > 0) {
        			str.append(String.format("%3d", j));
        		}
        		else if(i > 0 && j == 0) {
        			str.append(linAlpha++);
        		}
        		else {
        			if(i <= dimsExecutivo[1] && j <= dimsExecutivo[0] ) {
        				str.append(String.format("%3s", lugaresExecutivos[j-1][i-1]));
        			}
        			else if( j > dimsExecutivo[0]) {
        				str.append(String.format("%3s", lugaresTuristicos[j - dimsExecutivo[0] -1][i - 1]));
        			}
        			else {
        				str.append("   ");
        			}
        		}    			
    			if(j == colMax) {
    				str.append("\n");
    			}
        	}
    	}
        return str.toString();
    }
}
