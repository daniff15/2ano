package lab07.ex1;

public class Employee implements EmployeeInterface {

    private String name;

    Employee(String name) {
        this.name = name;
    }

    @Override
    public void start (Data data){
        System.out.println(name + " começou a trabalhar: " + data);
    }

    @Override
    public void terminate(Data data){
        System.out.println(name + " acabou de trabalhar: " + data);
    }

    @Override
    public void work(){
        System.out.print(name + " trabalha ");
    }
}