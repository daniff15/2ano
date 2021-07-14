package lab11.ex1;

public class Demo {
    public static void main(String[] args) {

        Phone[] phones = {new Phone("AA123", 10.5, 500.0, "3 camaras brutais"), new Phone("ABC444", 500.0 , 10, "Lente Macro") , new Phone("Intel Core i5" , 45, 50, "Lente Micro"), new Phone("Asus Lenovo" , 450 , 56.7, "Camarazinha")};

        System.out.println("TESTAR INSERTION SORT:");
        System.out.println();
        Context context = new Context(new InsertionSort(), phones);
        
        System.out.println("ORDENADO POR PROCESSADOR: ");
        Phone[] phonesSortedProcessador = context.sort("processador");

        for (Phone phone : phonesSortedProcessador) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("ORDENADO POR PRECO: ");
        Phone[] phonesSortedPreco = context.sort("preco");

        for (Phone phone : phonesSortedPreco) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("TESTAR SELECTION SORT:");
        System.out.println();
        context = new Context(new SelectionSort(), phones);
        
        System.out.println("ORDENADO POR PROCESSADOR: ");
        phonesSortedProcessador = context.sort("processador");

        for (Phone phone : phonesSortedProcessador) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("ORDENADO POR PRECO: ");
        phonesSortedPreco = context.sort("preco");

        for (Phone phone : phonesSortedPreco) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("TESTAR BUBBLE SORT:");
        System.out.println();
        context = new Context(new SelectionSort(), phones);
        
        System.out.println("ORDENADO POR PROCESSADOR: ");
        phonesSortedProcessador = context.sort("processador");

        for (Phone phone : phonesSortedProcessador) {
            System.out.println(phone);
        }

        System.out.println();
        System.out.println("ORDENADO POR PRECO: ");
        phonesSortedPreco = context.sort("preco");

        for (Phone phone : phonesSortedPreco) {
            System.out.println(phone);
        }


    }
}
