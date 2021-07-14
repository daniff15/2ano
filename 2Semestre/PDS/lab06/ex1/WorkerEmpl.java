package lab06.ex1;
import lab06.ex1.Employee;

public class WorkerEmpl extends Employee implements Worker{

    private String apelido;

    public WorkerEmpl(String name,String apelido ,long emp_num, double salary) {
        super(name, emp_num, salary);
        this.apelido = apelido;
    }

    @Override
    public String apelido() {
        return apelido;
    }

    @Override
    public int codigo(){
        return (int)super.getEmpNum();
    }

    @Override
    public String nome(){
        return super.getName();
    }

    @Override
    public double salario(){
        return super.getSalary();
    }


    @Override
    public String toString() {
        return super.toString();
    }

}
