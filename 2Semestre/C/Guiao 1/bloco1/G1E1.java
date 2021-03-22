import java.util.Scanner;

public class G1E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double resultado;

        //inputs aos utilizador
        System.out.println("Operacao (number op number):");
        double numero1 = sc.nextDouble();
        String operador = sc.next();
        double numero2 = sc.nextDouble();
        sc.close();

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
        default:
            System.err.println("O operador introduzido é inválido");
            //System.exit(1);
            break;
        }
    }
}