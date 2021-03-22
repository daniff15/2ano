import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class G1E6C {

    //Funcional quando se passam os argumentos ca dentro, funcional de chamar as merdas pelo terminal noutro script
    public static void main(String[] args) {
        ArrayList<String[]> definicoes = new ArrayList<>();
        Map<String, String> mapinha = new HashMap<>();
        try {
            File file = new File("dic2.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) { // preencher o mapinha
                String data = sc.nextLine();
                String[] words = data.split(" ");
                String definition = words[1];
                if (words.length > 2) {
                    for (int i = 2; i < words.length; i++)
                        definition += " " + words[i];
                }
                mapinha.put(words[0], definition);
            }
            sc.close();

            for (int i = 0; i < definicoes.size(); i++) {
                String[] linea = definicoes.get(i);
                String palavra = linea[0];
                String definicao = linea[1];
                mapinha.put(palavra, definicao);
            }

            file = new File("texto2.txt");
            sc = new Scanner(file);
            String[] linha;
            String output = "";
            while (sc.hasNextLine()) { // fazer as traducoes
                String data = sc.nextLine();
                linha = data.split(" ");
                for (String string : linha) {
                    if (mapinha.containsKey(string)) {
                        output = output + mapinha.get(string) + " ";
                    } else {
                        output = output + " " + string + " ";
                    }
                }
                // System.out.println(output);
                
                
            }
            String newOutput = "";
            List<String> palavras = new ArrayList<>();
            palavras = checkOutput(mapinha, output, newOutput , palavras);
            StringBuilder sb = new StringBuilder();
            for (String string : palavras) {
                sb.append(string + " ");
            }

            System.out.println(sb);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static List<String> checkOutput(Map<String, String> dic, String lookWord, String newOutput, List<String> palavras) {
        for (String str : lookWord.split(" ")) {
            if (dic.containsKey(str)) {
                checkOutput( dic, dic.get(str), newOutput, palavras);
            } else {
                if (str != null && !str.equals("")) {
                    newOutput = newOutput + str + " ";
                    //newOutupt nao estava a ficar com todos os str chamados do mapa, por isso 
                    //adicionei o array palavras para adicionar as palavras q sao chamadas do mapa
                    palavras.add(str);
                }
            }
        }
        return palavras;
    }
}
