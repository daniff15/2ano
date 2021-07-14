package lab09.ex3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        Add<String> commandAdd = new Add<String>(lst);
        Remove<String> commandRemove = new Remove<String>(lst);

        commandAdd.execute("first");
        commandAdd.execute("Second");
        commandAdd.execute("Third");

        System.out.println("Tamanho depois de 3 commandAdd : "+ lst.size());
        System.out.println("Elemento do indice 0: " + lst.get(0));
        System.out.println("Elemento do indice 1: " + lst.get(1));
        System.out.println("Elemento do indice 2: " + lst.get(2));
        System.out.println();

        commandAdd.undo();
        commandAdd.undo();
        System.out.println("Tamanho depois de 2 undo's no commandAdd: " + lst.size());
        System.out.println("Elemento do indice 0: " + lst.get(0));
        System.out.println();
       
        commandRemove.execute("first");
        System.out.println("Tamanho depois de 1 commandRemove da string first: " + lst.size());
        System.out.println();

        commandRemove.undo();
        System.out.println("Tamanho depois de 1 undo no commandRemove: " + lst.size());
        System.out.println("Elemento do indice 0: " + lst.get(0));
	}
}
