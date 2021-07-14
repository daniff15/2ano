package lab03.ex2;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*
Autoria:
Daniel Figueiredo N98498
Eva Bartolomeu N98513
*/

public class Ex2 {
    public static Map<String, Voo> voos;

    public static void main(String[] args) {
        voos = new HashMap<>();
        Scanner sc;
        String[] argumentos = null;
        boolean flag;

        //enquanto a linha de comandos estiver a ser lida o sc é referente a ele, quando já existir linhas o sc estará referente ao System.in
        if(args.length == 1){ // verificar se se passou um argmento    
            String tmp = leituraComandos(args[0]);
            sc = new Scanner(tmp);
            flag = true;
        }
        else{
            sc = new Scanner(System.in);
            flag = false;
        }

        while (true){           
            if(flag){
                if(!sc.hasNextLine()){
                    sc = new Scanner(System.in);
                    flag = false;
                    System.out.println("Escolha uma opcao: (H para ajuda)");           
                }
            }else{
                System.out.println("Escolha uma opcao: (H para ajuda)");
            }
            argumentos = sc.nextLine().split(" ");
            switch (argumentos.length) {
            case 1:
                //Verificar as opcoes possiveis que tem tamanho 1
                if (argumentos[0].equalsIgnoreCase("H")) {
                    System.out.println("H: apresenta as opções do menu");
                    System.out.println("I filename: Lê um ficheiro de texto contento informação sobre um voo");
                    System.out.println("M flight_code: exibe o mapa das reservas de um voo");
                    System.out.println("F flight_code num_seats_executive num_seats_tourist: acrescenta um novo voo");
                    System.out.println("R flight_code class number_seats: acrescenta uma nova reserva a um voo");
                    System.out.println("C reservation_code: cancela uma reserva");
                    System.out.println("Q: termina o programa");
                    System.out.println();
                } else if (argumentos[0].equalsIgnoreCase("Q")) {
                    System.out.println("O programa terminou!");
                    sc.close();
                    System.exit(0);
                } else
                    System.out.println("Argumentos inválidos!");

                break;
            case 2:
                //Verificar as opcoes possiveis que tem tamanho 2
                if (argumentos[0].equalsIgnoreCase("I")) {
                    // Meter caminho do ficheiro de texto
                    leituraReservas(argumentos[1]);
                    System.out.println();

                } else if (argumentos[0].equalsIgnoreCase("M")) {
                    if (voos.containsKey(argumentos[1])) {
                        System.out.println(voos.get(argumentos[1]));
                        System.out.println();
                    }else{
                        System.out.println("O voo com o código " + argumentos[1] + "nao existe");
                    }
                } else if (argumentos[0].equalsIgnoreCase("C")) {
                    if (voos.containsKey(argumentos[1].split(":")[0])) {
                        Voo voo = voos.get(argumentos[1].split(":")[0]);
                        voo.cancelaReserva(argumentos[1]);
                    }else{
                        System.out.println("O voo com o código " + argumentos[1] + "nao existe");
                    }
                } else
                    System.out.println("Argumentos inválidos!");
                break;
            case 3:
                //Verificar as opcoes possiveis que tem tamanho 3
                if (argumentos[0].equalsIgnoreCase("F")) {
                    if (!voos.containsKey(argumentos[1]) && argumentos[1].matches("[0-9a-zA-Z]+") && argumentos[2].matches("[1-9][0-9]*x[1-9][0-9]*")) {
                        Voo voo = new Voo(argumentos[1], argumentos[2]);
                        voos.put(voo.getCodigo(), voo);
                    }
                    else{
                        System.out.println("Argumentos da opçao F inválidos");
                    }
                    
                } else
                    System.out.println("Argumentos inválidos!");
                break;

            case 4:
                //Verificar as opcoes possiveis que tem tamanho 4
                if (argumentos[0].equalsIgnoreCase("F")) {
                    if (!voos.containsKey(argumentos[1]) && argumentos[1].matches("[0-9a-zA-Z]+") && argumentos[2].matches("[1-9][0-9]*x[1-9][0-9]*") && argumentos[3].matches("[1-9][0-9]*x[1-9][0-9]*")) {
                        Voo voo = new Voo(argumentos[1], argumentos[2], argumentos[3]);
                        voos.put(voo.getCodigo(), voo);
                    }
                    else{
                        System.out.println("Argumentos da opçao F inválidos");
                    }
                } else if (argumentos[0].equalsIgnoreCase("R")) {
                    if (voos.containsKey(argumentos[1]) && argumentos[2].matches("[TE]") && argumentos[3].matches("[1-9][0-9]*") ) {
                        Voo voo = voos.get(argumentos[1]);
                        voo.reservar( Classe.getEnum(argumentos[2]), Integer.parseInt(argumentos[3]));
                        System.out.println();
                    }else{
                        System.out.println("Argumentos da opçao R inválidos");
                    }
                } else
                    System.out.println("Argumentos inválidos!");
                break;

            default:
                System.out.println("Argumentos inválidos!");
                break;
            }
                
        }
        

    }

    public static String leituraComandos(String file) {
        String commands = "";
        try (Scanner input = new Scanner(new FileReader(file))) {
            while (input.hasNextLine()) {
                commands += input.nextLine() + "\n";
            }

        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }

        return commands;
    }

    public static void leituraReservas(String file) {
        try (Scanner input = new Scanner(new FileReader(file))) {
            String[] firstLine = input.nextLine().split(" ");
            String codigo = firstLine[0].split(">")[1];
            if(firstLine.length == 3 && firstLine[0].startsWith(">")){
                if (!voos.containsKey(codigo) && codigo.matches("[0-9a-zA-Z]+") && firstLine[1].matches("[1-9][0-9]*x[1-9][0-9]*") && firstLine[2].matches("[1-9][0-9]*x[1-9][0-9]*")) {
                    Voo voo = new Voo(codigo, firstLine[1], firstLine[2]);
                    voos.put(voo.getCodigo(), voo);
    
                    voo.reservar(input);
                }
                else{
                    System.out.println("O voo na opçao I nao foi criado!");
                }
            }
            else if(firstLine.length == 2 && firstLine[0].startsWith(">")){
                if (!voos.containsKey(codigo) && codigo.matches("[0-9a-zA-Z]+") && firstLine[1].matches("[1-9][0-9]*x[1-9][0-9]*") ) {
                    Voo voo = new Voo(codigo, firstLine[1]);
                    voos.put(voo.getCodigo(), voo);

                    voo.reservar(input);
                }
                else{
                    System.out.println("O voo na opçao I nao foi criado!");
                }
            }
            else{
                System.out.println("[Erro: Opcao I] Primeira linha não tinha o código do avião!");
                return;
            }

        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }

}
