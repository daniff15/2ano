package lab08.ex2;

public class Employee {
    private double salary;
    private Person person;
    private BankAccount bankAccount;

    public Employee(Person n, double s) {
        person = n;
        salary = s;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount(){
        return bankAccount;
    }
}
