package lab07.ex2;

public class CapitalizationFilter extends TextReaderDecorator{

    public CapitalizationFilter(TextReaderInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String next() {
        // TODO Auto-generated method stub
        String word = super.next().toLowerCase();
        switch (word.length()) {
            case 0:
            case 1:
            case 2:
                return word.toUpperCase();
            default:
                String firstLetter = String.valueOf(word.charAt(0)).toUpperCase();
                String lastLetter = String.valueOf(word.charAt(word.length()-1)).toUpperCase();
                word = word.substring(1, word.length()-1);
                return (new StringBuilder()).append(firstLetter).append(word).append(lastLetter).toString(); 
        }
       
    }
    
}