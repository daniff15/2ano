import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G1E5 {
    static String[] data;

    public static void main(String[] args) {

        Map<String, Integer> traducoes = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        /*
         * while (sc.hasNextLine()) { data = sc.nextLine().split("[- ]"); } int valor =
         * 0; Map<String, Integer> valores = new HashMap<>();
         * 
         * for (String string : data) {
         * 
         * }
         */

        try (Scanner input = new Scanner(new File("numbers.txt"))) {
            while (input.hasNextLine()) {
                String[] tab = input.nextLine().split(" - ");
                traducoes.put(tab[1], Integer.parseInt(tab[0]));
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        String[] frase = sc.nextLine().split("[ -]"); // Ler a frase q se quer converter
        ArrayList<String> numeros = new ArrayList<>();
        for (int i = 0; i < frase.length; i++) {
            if(!frase[i].equals("and")){
                
                numeros.add(frase[i]);
            }
        }
        int valor = 0;
        int num = 1;
        for (int i = 0; i < numeros.size(); i++) {
            if (traducoes.containsKey(numeros.get(i))) {
                if (traducoes.get(numeros.get(i)) == 1000000 || traducoes.get(numeros.get(i)) == 1000
                        || traducoes.get(numeros.get(i)) == 100) {
                    num = num * traducoes.get(numeros.get(i));
                    if(!(i+1 == numeros.size() && traducoes.get(numeros.get(i+1)) == 1000000 || traducoes.get(numeros.get(i+1)) == 1000
                    || traducoes.get(numeros.get(i+1)) == 100)){
                        valor += num;
                    }
                }else if(i == numeros.size() - 1){
                    valor += traducoes.get(numeros.get(i));
                } 
                else {
                    num = traducoes.get(numeros.get(i));
                    if(!(i+1 == numeros.size() || traducoes.get(numeros.get(i+1)) == 1000000 || traducoes.get(numeros.get(i+1)) == 1000
                    || traducoes.get(numeros.get(i+1)) == 100)){
                        valor += num;
                    }
                }
            }

        }
        for (int i = 0; i < frase.length; i++) {
            System.out.print(frase[i] + " ");
        }
        System.out.println("-> " + valor);

        sc.close();

    }
}