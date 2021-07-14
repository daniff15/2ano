package lab07.ex2;

import java.text.Normalizer;

public class NormalizationFilter extends TextReaderDecorator{

    public NormalizationFilter(TextReaderInterface textInterface) {
        super(textInterface);
    }

    @Override
    public String next() {
        return Normalizer.normalize(super.next(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("[\"#$%&'()*+,-./:;<=>?@\\[\\[^_`{|}~]", "");
    }
    
}