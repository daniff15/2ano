package lab07.ex2;

public class VowelFilter extends TextReaderDecorator{

    
    public VowelFilter(TextReaderInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String next() {
        // TODO Auto-generated method stub
        return super.next().replaceAll("[aeiouAEIOU]", "");
    }
    
}