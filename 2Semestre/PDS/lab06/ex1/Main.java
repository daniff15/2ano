package lab06.ex1;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();

        Main.alinea1();
        Main.alinea2();

    }

    public static void alinea1(){
        System.out.println("----------------- ALINEA 1 -----------------");

        System.out.println("PETISCO");

        Empregado empregado1 = new Empregado("Maria", "Freitas", 678, 10);
        Empregado empregado2 = new Empregado("Margarida", "Augusto", 123, 15);
        Empregado empregado3 = new Empregado("Paulo", "Seixo", 666, 4000.50);
        Empregado empregado4 = new Empregado("Mario", "Ladeiras", 555, 3.7);

        Registos registos = new Registos();

        registos.insere(empregado1);
        registos.insere(empregado2);
        registos.insere(empregado3);
        registos.insere(empregado4);

        System.out.println("\nInsercao dos empregados");
        System.out.println(registos);

        registos.remove(666);
        System.out.println("Remocao do empregado com o codigo 666");
        System.out.println(registos);
        
        System.out.printf("Empregado numero 678 esta na empresa?");
        if (registos.isEmpregado(678) == true) {
            System.out.printf(" Sim\n");
        } else {
            System.out.printf(" Nao\n");
        }

        System.out.printf("\nEmpregado numero 15 esta na empresa?");
        if (registos.isEmpregado(15) == true) {
            System.out.printf(" Sim\n");
        } else {
            System.out.printf(" Nao\n");
        }

        System.out.println("\nSweets");

        Employee employee1 = new Employee("Miguel Silva", 12345, 1234);
        Employee employee2 = new Employee("Filipe Freixo", 30000, 5552.12);
        Employee employee3 = new Employee("Mehdi Taremi", 12, 13);
        Employee employee4 = new Employee("Carlos Trindade", 67, 1);
        Employee employee5 = new Employee("Goncalo Veiga", 45, 888);

        Database database = new Database();

        System.out.println("\nAdd employees");
        database.addEmployee(employee1);
        database.addEmployee(employee2);
        database.addEmployee(employee3);
        database.addEmployee(employee4);
        database.addEmployee(employee5);

        System.out.println(database);

        System.out.println("\nRemove an Employee");
        database.deleteEmployee(67);
        System.out.println(database);
    }

    public static void alinea2(){
        System.out.println("----------------- ALINEA 2 -----------------");
        Database database = new Database();
        InterfacePst DBPst = new DBAdapter(database);

        Worker empregado1 = new WorkerEmpre("Maria", "Freitas", 678, 10);
        Worker empregado2 = new WorkerEmpre("Margarida", "Augusto", 123, 15);
        Worker employee1 = new WorkerEmpl("Joao", "Carlos", 555, 1000);
        Worker employee2 = new WorkerEmpl("Mario", "Ana", 666, 669);

        System.out.println("Lista Empregados");

        DBPst.addEmployee(employee1);
        DBPst.addEmployee(employee2);
        DBPst.addEmployee(empregado2);
        DBPst.addEmployee(empregado1);
        DBPst.allEmployees();

        DBPst.removeEmployee(555);
        System.out.println("Depois da remocao do empregado 555");
        DBPst.allEmployees();

        System.out.print("Empregado 555 pertence à empresa? ");
        if(DBPst.belongsCompany(555)){
            System.out.println("Sim");
        }
        else{
            System.out.println("Nao");
        }

        System.out.print("Empregado 666 pertence à empresa? ");
        if(DBPst.belongsCompany(666)){
            System.out.println("Sim");
        }
        else{
            System.out.print("Nao");
        }

    }

}
