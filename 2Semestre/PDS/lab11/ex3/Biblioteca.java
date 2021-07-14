package lab11.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public void run() {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        do {
            if (flag) {
                System.out.println("*** Biblioteca ***");

                int counter = 1;
                for (Livro livro : livros) {
                    System.out.printf("%-5d %s\n", counter, livro);
                    counter++;
                }

                System.out
                        .println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
                System.out.println();
            }
            System.out.print(">> ");
            flag = true;

            String input = sc.nextLine();

            String[] args = input.split(",");
            int livro = Integer.parseInt(args[0]);
            int opcao = Integer.parseInt(args[1]);

            switch (opcao) {
                case 1:
                    try {
                        livros.get(livro - 1).regista();
                    } catch (Exception e) {
                        flag = false;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 2:
                    try {
                        livros.get(livro - 1).requisita();
                    } catch (Exception e) {
                        flag = false;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 3:
                    try {
                        livros.get(livro - 1).devolve();
                    } catch (Exception e) {
                        flag = false;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 4:
                    try {
                        livros.get(livro - 1).reserva();
                    } catch (Exception e) {
                        flag = false;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;
                case 5:
                    try {
                        livros.get(livro - 1).cancelaReserva();
                    } catch (Exception e) {
                        flag = false;
                        System.out.println(e.getMessage() + "\n");
                    }
                    break;

            }

        } while (true);
    }

}
