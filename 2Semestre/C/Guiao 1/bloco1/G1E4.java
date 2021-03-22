import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class G1E4 {
  static Map<String, String> mapinha = new HashMap<>();

  public static void main(String[] args) {
    Scanner scaninho = new Scanner(System.in);
    System.out.println("Lista de números: ");
    String listaNum = scaninho.nextLine();
    scaninho.close();

    String[] numerosExtenso = listaNum.split("[ -:]");

    try {
      File file = new File("numbers.txt");
      Scanner sc = new Scanner(file);
      while (sc.hasNextLine()) {
        String[] data = sc.nextLine().split(" - ");
        mapinha.put(data[1], data[0]);
      }
      sc.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();

    }

    StringBuilder sb = new StringBuilder();
    sb.append("");
    
    for (int i = 0; i < numerosExtenso.length; i++) {
      if(mapinha.containsKey(numerosExtenso[i])){
        sb.append(mapinha.get(numerosExtenso[i]) + " ");
      }

    }

    System.out.println(sb.toString());
  }
}
