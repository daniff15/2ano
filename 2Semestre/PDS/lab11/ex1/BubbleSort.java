package lab11.ex1;

public class BubbleSort implements Strategy {

    @Override
    public Phone[] sort(Phone[] phones, String caracteristic) {
        switch (caracteristic) {
            case "preco":
                for (int i = 0; i < phones.length - 1; i++)
                    for (int j = 0; j < phones.length - i - 1; j++)
                        if (phones[j].getPreco() > phones[j + 1].getPreco()) {
                            Phone temp = phones[j];
                            phones[j] = phones[j + 1];
                            phones[j + 1] = temp;
                        }

                return phones;

            case "memoria":
                for (int i = 0; i < phones.length - 1; i++)
                    for (int j = 0; j < phones.length - i - 1; j++)
                        if (phones[j].getMemoria() > phones[j + 1].getMemoria()) {
                            Phone temp = phones[j];
                            phones[j] = phones[j + 1];
                            phones[j + 1] = temp;
                        }

                return phones;

            case "camara":
                for (int i = 0; i < phones.length - 1; i++)
                    for (int j = 0; j < phones.length - i - 1; j++)
                        if (phones[j].getCamara().compareTo(phones[j + 1].getCamara()) > 0) {
                            Phone temp = phones[j];
                            phones[j] = phones[j + 1];
                            phones[j + 1] = temp;
                        }

                return phones;

            case "processador":
                for (int i = 0; i < phones.length - 1; i++)
                    for (int j = 0; j < phones.length - i - 1; j++)
                        if (phones[j].getProcessador().compareTo(phones[j + 1].getProcessador()) > 0) {
                            Phone temp = phones[j];
                            phones[j] = phones[j + 1];
                            phones[j + 1] = temp;
                        }

                return phones;

            default:
                return null;
        }
    }

}