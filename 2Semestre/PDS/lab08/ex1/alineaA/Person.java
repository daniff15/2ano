package lab08.ex1.alineaA;

public class Person {

    private String name;
    private BankAccount bankAccount;

    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia" , 0);
    }

    public String getName() {
        return name;
    }

    public BankAccount getBankAccount() {
        return new ProxyBankAccount(bankAccount);
    }
}
