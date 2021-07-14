package lab07.ex2;

public class TextProcessor {
    public static void main(String[] args) {
        TextReaderInterface reader = new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt");

        System.out.println("Existe um paragrafo por ler no texto 1? " + reader.hasNext());
        int count = 1;
        while(reader.hasNext()){
            System.out.println("Paragrafo " + count + " do texto 1: " + reader.next());
            count++;
        }

        System.out.println("\nTodas as palavras do texto 1 sem acentos e pontuaçao: ");
        reader = new NormalizationFilter(new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt"));
        while(reader.hasNext()){
            System.out.println(reader.next());
        }

        System.out.println("\nTodas as palavras do texto 1 sem vogais: ");
        reader = new VowelFilter(new TermFilter(new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt")));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        System.out.println("\nTodas as palavras do texto 1 com a primeira e ultima letra em maiúsculas: ");
        reader = new CapitalizationFilter(new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt"));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        System.out.println("\nTodas as palavras do texto 1 com a primeira e ultima letra em maiúsculas e sem vogais: ");
        reader = new VowelFilter(new CapitalizationFilter(new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt")));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        System.out.println("\nTodas as palavras do texto 1 sem vogais e com a primeira e ultima letra em maiúsculas: ");
        reader = new CapitalizationFilter(new VowelFilter(new TextReader("lab07/ex2/ficheirosLeitura/texto1.txt")));
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
