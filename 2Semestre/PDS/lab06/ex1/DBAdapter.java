package lab06.ex1;

import lab06.ex1.Database;
import lab06.ex1.Employee;
import lab06.ex1.Empregado;
import lab06.ex1.InterfacePst;
import lab06.ex1.Worker;
import java.util.List;
import java.util.ArrayList;


public class DBAdapter implements InterfacePst {

    private Database database;

    public DBAdapter(Database database) {
        this.database = database;
    }

    @Override
    public void addEmployee(Worker emp){
        database.addEmployee(new Employee(emp.nome() + " " + emp.apelido(), emp.codigo() , emp.salario()));
    }

    @Override
    public void removeEmployee(int codigo){
        database.deleteEmployee(Long.valueOf(codigo));
    }

    @Override
    public boolean belongsCompany(int codigo){
        for (Employee employee : database.getAllEmployees()) {
            if(employee.getEmpNum() == Long.valueOf(codigo)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void allEmployees(){
        StringBuilder sb = new StringBuilder();
        Employee[] employees = database.getAllEmployees();

        for (Employee employee : employees) {
            sb.append(employee);
        }

        System.out.println(sb.toString());
    }
}