package lab08.ex1.alineaA;

public class ProxyBankAccount implements BankAccount {

    private BankAccount banco;

    public ProxyBankAccount(BankAccount banco) {
        this.banco = banco;
    }

    @Override
    public void deposit(double amount) {
        banco.deposit(amount);
    }

    public BankAccount getBanco() {
        return banco;
    }

    @Override
    public double balance() {
        if (Company.user == User.OWNER) {
            return banco.balance();
        } else {
            System.out.println("Nao pode aceder ao balance");
            return Double.NaN;
        }

    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.OWNER) {
            return banco.withdraw(amount);
        } else {
            System.out.println("Nao pode aceder ao withdraw");
            return false;
        }
    }

}
