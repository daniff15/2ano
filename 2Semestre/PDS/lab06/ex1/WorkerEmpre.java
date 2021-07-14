package lab06.ex1;

public class WorkerEmpre extends Empregado implements Worker{

    public WorkerEmpre(String nome, String apelido, int codigo, double salario) {
        super(nome, apelido, codigo, salario);
    }
    
    @Override
    public int codigo(){
        return super.codigo();
    }

    @Override
    public String nome(){
        return super.nome();
    }

    @Override
    public double salario(){
        return super.salario();
    }
    
    @Override
    public String apelido(){
        return super.apelido();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
