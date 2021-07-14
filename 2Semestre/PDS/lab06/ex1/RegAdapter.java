package lab06.ex1;

import lab06.ex1.InterfacePst;
import lab06.ex1.Registos;
import lab06.ex1.Employee;
import lab06.ex1.Empregado;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;


public class RegAdapter implements InterfacePst {

    private Registos registos;

    public RegAdapter(Registos registos) {
        this.registos = registos;
    }

    @Override
    public void addEmployee(Worker emp) {
        registos.insere(new Empregado(emp.nome(), emp.apelido(), emp.codigo(), emp.salario()));
    }

    @Override
    public void removeEmployee(int codigo) {
        registos.remove(codigo);
    }

    @Override
    public boolean belongsCompany(int codigo) {
        return registos.isEmpregado(codigo);
    }

    @Override
    public void allEmployees() {
        List<Empregado> tmpEmpregados = registos.listaDeEmpregados();
        System.out.println(tmpEmpregados);
    }

}
