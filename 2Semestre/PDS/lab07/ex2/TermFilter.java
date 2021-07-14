package lab07.ex2;

import java.util.Scanner;

public class TermFilter extends TextReaderDecorator {
    private Scanner input;

    TermFilter(TextReaderInterface textInterface) {
        super(textInterface);
    }
    
}