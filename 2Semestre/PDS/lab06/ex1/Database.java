package lab06.ex1;

import java.util.Vector;

import lab06.ex1.Employee;

public class Database{
    private Vector<Employee> employees; // Stores the employees

    public Database() {
        employees = new Vector<>();
    }

    public boolean addEmployee(Employee employee) {
        // Code to add employee
        if (employees.contains(employee))
            return false;
        employees.add(employee);
        return true;
    }

    public void deleteEmployee(long emp_num) {
        Employee tmpEmployee = null;
        for (int i = 0; i < employees.size(); i++) {
            if (emp_num == employees.get(i).getEmpNum()) {
                tmpEmployee = employees.get(i); 
            }
        }
        employees.remove(tmpEmployee);

    }

    
    public Employee[] getAllEmployees() {
        // Code to retrieve collection
        Employee[] allEmployees = new Employee[employees.size()];
        int count = 0;
        for (Employee employee : employees) {
            allEmployees[count] = employee;
            count++;
        }

        return allEmployees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Employee employee : employees) {
            sb.append(employee);
        }
        return sb.toString();
    }


    
}