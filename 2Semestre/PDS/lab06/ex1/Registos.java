package lab06.ex1;

import java.util.List;
import java.util.ArrayList;



public class Registos{
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }

    public void insere(Empregado emp) {
        // Code to insert employee
        if (!empregados.contains(emp)) {
            empregados.add(emp);
        }
    }

    public void remove(int codigo){
        Empregado tmpEmployee = null;
        for (Empregado employee : empregados) {
            if (codigo == employee.codigo()){
                tmpEmployee = employee; 
                break;                
            }
        }

        empregados.remove(tmpEmployee);
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (Empregado employee : empregados) {
            if(employee.codigo() == codigo){
                return true;
            }
        }
        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        List<Empregado> tmpEmpregados = new ArrayList<Empregado>();
        
        for (Empregado empregado : empregados) {
            tmpEmpregados.add(empregado);
        }

        return tmpEmpregados;
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Empregado empregado : empregados) {
            sb.append(empregado);
        }
        return sb.toString();
    }


    
}
