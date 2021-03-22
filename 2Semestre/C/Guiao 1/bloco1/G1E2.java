import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G1E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> mapa = new HashMap<>();
        double resultado;

        //inputs aos utilizador
        System.out.println("Operacao (number op number):");
        double numero1 = sc.nextDouble();
        if(sc.hasNext("+*/-=")){
            String operador = sc.next();
        }
        else if(sc.hasNext("[A-Z][a-z]")){
            String letra = sc.next();
        }
        else{
            System.err.println("Erro, caracter inserido inválido");
            System.exit(1);
        }
        double numero2 = sc.nextDouble();
        sc.close();

        /*
        switch (operador) {
        case "+":
            resultado = numero1 + numero2;
            System.out.printf("%.1f %s %.1f = %.1f\n", numero1, operador, numero2, resultado);
            break;
        case "-":
            resultado = numero1 - numero2;
            System.out.printf("%.1f %s %.1f = %.1f\n", numero1, operador, numero2, resultado);
            break;
        case "*":
            resultado = numero1 * numero2;
            System.out.printf("%.1f %s %.1f = %.1f\n", numero1, operador, numero2, resultado);
            break;
        case "/":
            resultado = numero1 / numero2;
            System.out.printf("%.1f %s %.1f = %.1f\n", numero1, operador, numero2, resultado);
            break;
        case "=":
            
            break;
        default:
            System.err.println("O operador introduzido é inválido");
            //System.exit(1);
            break;
        }*/
    }
}