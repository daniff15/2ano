package lab11.ex1;

public class SelectionSort implements Strategy {

    @Override
    public Phone[] sort(Phone[] phones, String caracteristic) {
        switch (caracteristic) {
            case "preco":
                for (int i = 0; i < phones.length - 1; i++) {
                    int min_idx = i;
                    for (int j = i + 1; j < phones.length; j++)
                        if (phones[j].getPreco() < phones[min_idx].getPreco())
                            min_idx = j;

                    Phone temp = phones[min_idx];
                    phones[min_idx] = phones[i];
                    phones[i] = temp;
                }

                return phones;

            case "memoria":
                for (int i = 0; i < phones.length - 1; i++) {
                    int min_idx = i;
                    for (int j = i + 1; j < phones.length; j++)
                        if (phones[j].getMemoria() < phones[min_idx].getMemoria())
                            min_idx = j;

                    Phone temp = phones[min_idx];
                    phones[min_idx] = phones[i];
                    phones[i] = temp;
                }

                return phones;

            case "camara":
                for (int i = 0; i < phones.length - 1; i++) {
                    int min_idx = i;
                    for (int j = i + 1; j < phones.length; j++)
                        if (phones[j].getCamara().compareTo(phones[min_idx].getCamara()) < 0)
                            min_idx = j;

                    Phone temp = phones[min_idx];
                    phones[min_idx] = phones[i];
                    phones[i] = temp;
                }

                return phones;
            case "processador":
                for (int i = 0; i < phones.length - 1; i++) {
                    int min_idx = i;
                    for (int j = i + 1; j < phones.length; j++)
                        if (phones[j].getProcessador().compareTo(phones[min_idx].getProcessador()) < 0)
                            min_idx = j;

                    Phone temp = phones[min_idx];
                    phones[min_idx] = phones[i];
                    phones[i] = temp;
                }

                return phones;

            default:
                return null;
        }

    }
}
