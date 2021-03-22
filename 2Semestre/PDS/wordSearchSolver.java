import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wordSearchSolver {

    static ArrayList<String> words;
    static char[][] sopaLetras;
    static String[] palavrasPorLinha;
    static ArrayList<String> palavras = new ArrayList<>();
    static ArrayList<String> checkPalavras = new ArrayList<>();
    static char[][] pontosSopa;
    static List<String[]> info = new ArrayList<>();

    public static void main(String[] args) {

        try {
            int maxPuzzleSize = 40;
            words = new ArrayList<>();
            File myObj = new File("sopaLetras.txt");
            Scanner scanner = new Scanner(myObj);

            while (scanner.hasNextLine()) {
                String nextWord = scanner.nextLine();
                if (!nextWord.trim().isEmpty() && isUpper(nextWord) && nextWord.length() <= maxPuzzleSize
                        && checkAlphabetic(nextWord)) // Checkar se as letras misturadas satisfazem as condiçoes
                    words.add(nextWord);// adcionar as linhas q satisfazem essas conds
                else if (!isUpper(nextWord) && nextWord.length() > 3 && !checkAlphabetic(nextWord)) { // caso nao
                                                                                                       // cumpram,
                                                                                                       // significa que
                                                                                                       // chegamos as
                                                                                                       // palavras q
                                                                                                       // estao
                                                                                                       // escondidas na
                                                                                                       // sopa de letras
                    palavrasPorLinha = nextWord.split(",|\\ |\\;");
                    for (int i = 0; i < palavrasPorLinha.length; i++) {
                        palavras.add(palavrasPorLinha[i].toUpperCase()); // adicionar as palavras ao array e metê-las em
                                                                         // maiuscula para que posteriormente se possa
                                                                         // fazer a comparacao
                    }
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        if (!checkPuzzle(words)) {
            System.out.println("O puzzle não é quadrado ou não verifica o tamanho necessário (4x4 minímo)"); // Checkar se o puzzle é quadradro
            System.exit(0);
        }
        sopaLetras = new char[words.get(0).length()][words.get(0).length()];// Inicializacao do bidimensional array
        for (int i = 0; i < words.size(); i++) {
            sopaLetras[i] = words.get(i).toCharArray(); // Preencher bidimensional array com as letras misturadas
        }

        /*
         * wordInChar = new char[palavras.size()][]; // Inicializar array para meteres
         * as palavras num array de char int idc = 0; for (String palvra : palavras) {
         * wordInChar[idc] = palvra.toCharArray(); // Adicionar ao array de caracteres
         * as palavras q se pretendem // encontrar na sopa de letras idc++; }
         */ // Desnecessário, mais facil usar charAt()

        /*
         * for (int i = 0; i < palavras.size(); i++) { for (int j = 0; j <
         * palavras.get(i).length(); j++) { System.out.print(wordInChar[i][j]); }
         * System.out.println(); }
         */
        pontosSopa = new char[words.get(0).length()][words.get(0).length()];
        encontrarPalavra(sopaLetras, palavras, checkPalavras, info);
        pontosSopa = preencherArray(pontosSopa, sopaLetras);
        pontosSopa = printarEncontradas(pontosSopa, info);

        for (int i = 0; i < pontosSopa.length; i++) {
            for (int j = 0; j < pontosSopa.length; j++) {
                System.out.print(pontosSopa[i][j]);
            }
            System.out.println();
        }

    }

    private static boolean isUpper(String word) {
        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(chars[i]))
                return false;
        }

        return true;
    }

    private static boolean checkAlphabetic(String input) {
        for (int i = 0; i != input.length(); ++i) {
            if (!Character.isLetter(input.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkPuzzle(ArrayList<String> words) {

        int firstWordSize = words.get(0).length();

        if (firstWordSize != words.size() || words.size() <= 3)
            return false;

        return true;
    }

    private static void encontrarPalavra(char[][] sopaLetras, ArrayList<String> palavras,
            ArrayList<String> checkPalavras, List<String[]> info) {
        for (String palavra : palavras) {
            char primeiraLetra = palavra.charAt(0);
            char segundaLetra = palavra.charAt(1);
            for (int linha = 0; linha < sopaLetras.length; linha++) {
                for (int coluna = 0; coluna < sopaLetras.length; coluna++) {
                    if (primeiraLetra == sopaLetras[linha][coluna]) {

                        int linhaCerta = linha;
                        int colunaCerta = coluna;
                        // pesquisar cima
                        if (linha != 0 && segundaLetra == sopaLetras[linha - 1][coluna]) {
                            // Chamar a funcao q vai para cima so a partir do terceiro caracter
                            cima(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar baixo
                        if (linha != sopaLetras.length - 1 && segundaLetra == sopaLetras[linha + 1][coluna]) {
                            // Chamar a funcao q vai para baixo so a partir do terceiro caracter
                            baixo(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar direita
                        if (coluna != sopaLetras.length - 1 && segundaLetra == sopaLetras[linha][coluna + 1]) {
                            // Chamar a funcao q vai para direita so a partir do terceiro caracter
                            direita(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar esquerda
                        if (coluna != 0 && segundaLetra == sopaLetras[linha][coluna - 1]) {
                            // Chamar a funcao q vai para esquerda so a partir do terceiro caracter
                            esquerda(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar direita diagonal cima
                        if (linha != 0 && coluna != sopaLetras.length - 1
                                && segundaLetra == sopaLetras[linha - 1][coluna + 1]) {
                            // Chamar a funcao q vai para diagonal direita cima so a partir do terceiro
                            // caracter
                            direitaCima(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar esquerda diagonal cima
                        if (linha != 0 && coluna != 0 && segundaLetra == sopaLetras[linha - 1][coluna - 1]) {
                            // Chamar a funcao q vai para diagonal esquerda cima so a partir do terceiro
                            // caracter
                            esquerdaCima(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar direita diagonal baixo
                        if (linha != sopaLetras.length - 1 && coluna != sopaLetras.length - 1
                                && segundaLetra == sopaLetras[linha + 1][coluna + 1]) {
                            // Chamar a funcao q vai para diagonal direita baixo so a partir do terceiro
                            // caracter
                            direitaBaixo(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                        // pesquisar esquerda diagonal baixo
                        if (linha != sopaLetras.length - 1 && coluna != 0
                                && segundaLetra == sopaLetras[linha + 1][coluna - 1]) {
                            // Chamar a funcao q vai para diagonal esquerda baixo so a partir do terceiro
                            // caracter
                            esquerdaBaixo(sopaLetras, palavra, colunaCerta, linhaCerta, checkPalavras, info);
                        }
                    }
                }
            }
        }
    }

    private static void cima(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta - 2 < 0)) {
                if (!checkPalavras.contains(palavra) && sopaLetras[linhaCerta - 2][colunaCerta] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tUp");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "Up" };
                    info.add(intel);
                }
            } else {
                return;
            }
        }
    }

    private static void baixo(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta + 2 > sopaLetras.length))
                if (!checkPalavras.contains(palavra) && sopaLetras[linhaCerta + 2][colunaCerta] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tDown");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "Down" };
                    info.add(intel);

                } else {
                    return;
                }
        }
    }

    private static void direita(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(colunaCerta + 2 > sopaLetras.length))
                if (!checkPalavras.contains(palavra) && sopaLetras[linhaCerta][colunaCerta + 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tRigth");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "Right" };
                    info.add(intel);
                } else {
                    return;
                }
        }
    }

    private static void esquerda(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(colunaCerta - 2 < 0))
                if (!checkPalavras.contains(palavra) && sopaLetras[linhaCerta][colunaCerta - 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tLeft");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "Left" };
                    info.add(intel);

                } else {
                    return;
                }
        }
    }

    private static void direitaCima(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta - 2 < 0 || colunaCerta + 2 > sopaLetras.length))
                if (!checkPalavras.contains(palavra)
                        && sopaLetras[linhaCerta - 2][colunaCerta + 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tUpRight");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "UpRight" };
                    info.add(intel);

                } else {
                    return;
                }
        }
    }

    private static void esquerdaCima(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta - 2 < 0 || colunaCerta - 2 < 0))
                if (!checkPalavras.contains(palavra)
                        && sopaLetras[linhaCerta - 2][colunaCerta - 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tUpLeft");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "UpLeft" };
                    info.add(intel);

                } else {
                    return;
                }
        }
    }

    private static void direitaBaixo(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta + 2 > sopaLetras.length || colunaCerta + 2 > sopaLetras.length))
                if (!checkPalavras.contains(palavra)
                        && sopaLetras[linhaCerta + 2][colunaCerta + 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tDownRight");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "DownRight" };
                    info.add(intel);

                } else {
                    return;
                }
        }
    }

    private static void esquerdaBaixo(char[][] sopaLetras, String palavra, int colunaCerta, int linhaCerta,
            ArrayList<String> checkPalavras, List<String[]> info) {

        for (int i = 2; i < palavra.length(); i++) {
            if (!(linhaCerta + 2 > sopaLetras.length || colunaCerta - 2 < 0)) {
                if (!checkPalavras.contains(palavra)
                        && sopaLetras[linhaCerta + 2][colunaCerta - 2] == palavra.charAt(i)) {
                    checkPalavras.add(palavra);
                    int coordenada1 = linhaCerta + 1;
                    int coordenada2 = colunaCerta + 1;
                    System.out.println(palavra.toLowerCase() + "\t" + palavra.length() + "\t" + coordenada1 + ","
                            + coordenada2 + "\tDownLeft");
                    String[] intel = { palavra.toLowerCase(), String.valueOf(palavra.length()),
                            String.valueOf(coordenada1), String.valueOf(coordenada2), "DownLeft" };
                    info.add(intel);

                } else {
                    return;
                }
            }
        }
    }

    private static char[][] preencherArray(char[][] pontosSopa, char[][] sopaLetras) {
        ;
        for (int i = 0; i < sopaLetras.length; i++) {

            for (int j = 0; j < sopaLetras.length; j++) {
                pontosSopa[i][j] = '.';
            }
        }

        return pontosSopa;
    }

    private static char[][] printarEncontradas(char[][] pontosSopa, List<String[]> info) {
        for (String[] string : info) {
            if (string[4] == "Up") {
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y < 0)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y--][x] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "Down"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y > pontosSopa.length)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y++][x] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "Right"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(x > pontosSopa.length)){
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y][x++] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "Left"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(x < 0)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y][x--] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "UpLeft"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y < 0 || x < 0)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y--][x--] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "UpRight"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y < 0 || x > sopaLetras.length)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y--][x++] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "DownLeft"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y > pontosSopa.length || x < 0)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y++][x--] = Character.toUpperCase(letra);
                    }
                }
            }
            else if(string[4] == "DownRight"){
                int y = Integer.parseInt(string[2]) - 1; // linha
                int x = Integer.parseInt(string[3]) - 1; // coluna
                for (int i = 0; i < Integer.parseInt(string[1]); i++) {
                    if (!(y > sopaLetras.length || x > sopaLetras.length)) {
                        char letra = (char)string[0].charAt(i);
                        pontosSopa[y++][x++] = Character.toUpperCase(letra);
                    }
                }
            }

        }

    return pontosSopa;
}

}
