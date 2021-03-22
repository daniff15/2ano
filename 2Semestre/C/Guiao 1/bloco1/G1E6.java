import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G1E6 {
    public static void main(String[] args) {

        ArrayList<String[]> traducoes = new ArrayList<>();
        Map<String, String> mapinha = new HashMap<>();
        try {
            File file = new File("dic1.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) { // preencher o mapinha
                String data = sc.nextLine();
                String[] linha = data.split(" ");
                traducoes.add(linha);
            }
            sc.close();

            for (int i = 0; i < traducoes.size(); i++) {
                String[] linea = traducoes.get(i);
                String tuga = linea[0];
                String britanico = linea[1];
                mapinha.put(tuga, britanico);
            }

            file = new File("texto1.txt");
            sc = new Scanner(file);
            String[] linha;
            while (sc.hasNextLine()) { // fazer as traducoes
                String data = sc.nextLine();
                linha = data.split(" ");
                for (String string : linha) {
                    if (mapinha.containsKey(string)) {
                        System.out.print(mapinha.get(string) + " ");
                    }
                    else{
                        System.out.print(string + " ");
                    }
                }
                System.out.println();
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}