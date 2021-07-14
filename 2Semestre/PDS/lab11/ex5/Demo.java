package lab11.ex5;

public class Demo {

    public static void main(String[] args) {

        if (args.length < 0) {
            System.out.println("Erro! Tem de indicar um PATH");
            System.exit(1);
        }

        int count = 0;
        boolean recursive = false;
        if (args.length >= 2) {

            for (String i : args) {

                if (i.equals("-r")) {
                    count++;
                    recursive = true;
                }

            }
        }

        System.out.println("A analisar: " + args[count].split("/")[args[count].split("/").length - 1]);
        TamanhoCalc tamanhoCalc = new TamanhoCalc();
        System.out.println("Total: " + tamanhoCalc.getSize(args[count], recursive) + "kB");
    }

}
