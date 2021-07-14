package lab07.ex2;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class TextReader implements TextReaderInterface {
    private String fileName;
    private Scanner input;

    TextReader(String fileName) {
        this.fileName = fileName;
        try {
            input = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
    }

    @Override
    public boolean hasNext() {
        return input.hasNextLine();
    }

    @Override
    public String next() {
        String paragraph = null;
        if (hasNext()) {
            paragraph = input.nextLine();
        }
        return paragraph;
    }

}