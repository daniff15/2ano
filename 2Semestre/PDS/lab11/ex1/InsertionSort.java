package lab11.ex1;

public class InsertionSort implements Strategy {
    @Override
    public Phone[] sort(Phone[] phones, String caracteristic) {
        switch (caracteristic) {
            case "preco":
                for (int i = 1; i < phones.length; ++i) {
                    Phone key = phones[i];
                    int j = i - 1;

                    while (j >= 0 && phones[j].getPreco() > key.getPreco()) {
                        phones[j + 1] = phones[j];
                        j = j - 1;
                    }
                    phones[j + 1] = key;
                }

                return phones;

            case "memoria":
                for (int i = 1; i < phones.length; ++i) {
                    Phone key = phones[i];
                    int j = i - 1;

                    while (j >= 0 && phones[j].getMemoria() > key.getMemoria()) {
                        phones[j + 1] = phones[j];
                        j = j - 1;
                    }
                    phones[j + 1] = key;
                }

                return phones;

            case "camara":
                for (int i = 1; i < phones.length; ++i) {
                    Phone key = phones[i];
                    int j = i - 1;

                    while (j >= 0 && phones[j].getCamara().compareTo(key.getCamara()) > 0) {
                        phones[j + 1] = phones[j];
                        j = j - 1;
                    }
                    phones[j + 1] = key;
                }

                return phones;

            case "processador":
                for (int i = 1; i < phones.length; ++i) {
                    Phone key = phones[i];
                    int j = i - 1;

                    while (j >= 0 && phones[j].getProcessador().compareTo(key.getProcessador()) > 0) {
                        phones[j + 1] = phones[j];
                        j = j - 1;
                    }
                    phones[j + 1] = key;
                }

                return phones;

            default:
                return null;
        }
    }

}
