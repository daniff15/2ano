package lab07.ex2;

import java.util.ArrayList;

public abstract class TextReaderDecorator implements TextReaderInterface {

    protected TextReaderInterface textInterface;
    private ArrayList<String> paragrafo;

    TextReaderDecorator(TextReaderInterface textInterface) {
        this.textInterface = textInterface;
        paragrafo = new ArrayList<>();
    }

    @Override
    public boolean hasNext() {
        // TODO Auto-generated method stub
        if (paragrafo.size() != 0) {
            return true;
        }
        return textInterface.hasNext();
    }

    private void addParagrafo() {
        String line[] = textInterface.next().split(" ");
        for (String string : line) {
            paragrafo.add(string);
        }

    }

    @Override
    public String next() {
        String word = null;
        // TODO Auto-generated method stub
        if (hasNext()) {

            if (paragrafo.size() < 1) {
                addParagrafo();
            }

            word = paragrafo.get(0);
            paragrafo.remove(0);

        }
        return word;
    }

}