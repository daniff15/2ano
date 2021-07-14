package lab11.ex3;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Java Anti-Stress" , "Omodionah" , 123456, 2001);
        Livro livro2 = new Livro("Guerra dos Padroes" , "Jorge Omel" , 456, 2021);
        Livro livro3 = new Livro("A Procura da Luz" , "Khumatkli" , 153456, 2004);

        List<Livro> livros = new ArrayList<>();

        livros.add(livro1);
        livros.add(livro2);
        livros.add(livro3);

        Biblioteca biblioteca = new Biblioteca(livros);

        biblioteca.run();

    }
}
