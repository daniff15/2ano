import java.util.ArrayList;
import java.util.Scanner;

public class G1E3 {
    public static void main(String[] args) {
        System.out.println("Operaçao (Reverse  Polish  Notation)");
        Scanner sc = new Scanner(System.in);

        String linha = sc.nextLine();
        sc.close();

        String[] values = linha.split(" ");
        ArrayList<Double> stack = new ArrayList<>();
        ArrayList<String> operadores = new ArrayList<>();
        // 1 2 3 + *
        for (int i = 0; i < values.length; i++) {
            if (values[i].matches("[0-9]+")) {
                stack.add(Double.parseDouble(values[i]));
            } else {
                operadores.add(values[i]);
            }
        }

        if (stack.size() != operadores.size() + 1) {
            System.err.println("Tem de haver menos um operador do que ha de numeros");
            System.exit(1);
        }

        double resultado = 0;
        int idx = operadores.size();
        for (int i = 0; i < operadores.size(); i++) {

            String operador = operadores.get(i);
            switch (operador) {
            case "+":
                // 2 4 5 + +
                resultado = (stack.get(idx)+stack.get(idx - 1));
                stack.remove(idx);
                stack.remove(idx - 1);
                stack.add(resultado);
                idx--;
                break;
            case "-":
                resultado = (stack.get(idx)-stack.get(idx - 1));
                stack.remove(idx);
                stack.remove(idx - 1);
                stack.add(resultado);
                idx--;

                break;
            case "*":
                resultado = (stack.get(idx)*stack.get(idx - 1));
                stack.remove(idx);
                stack.remove(idx - 1);
                stack.add(resultado);
                idx--;
                break;
            case "/":
                resultado = (stack.get(idx)/stack.get(idx - 1));
                stack.remove(idx);
                stack.remove(idx - 1);
                stack.add(resultado);
                idx--;
                break;
            default:
                System.err.println("O operador introduzido é inválido");
                // System.exit(1);
                break;
            }
            // resultado = resultado + (stack[stack.size() - i + 1]);
        }

        System.out.println(resultado);

    }
}