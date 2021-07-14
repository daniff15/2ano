package lab08.ex2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private Insurance insurance = new Insurance();
    private Parking parking = new Parking();
    private SocialSecurity socialSecurit = new SocialSecurity();
    private List<EmployeeCard> employeeCards = new ArrayList<>();

    public void admitEmployee(Person person, double salary) {
        Employee e = new Employee(person, salary);
        emps.add(e);

        socialSecurit.register(person);

        insurance.register(person);

        EmployeeCard employeeCard = new EmployeeCard(person);
        employeeCards.add(employeeCard);

        if(salary > avgSalary()){
            parking.allow(person);
        }

    }

    public double avgSalary(){
        double totalSalary = 0;
        int count = 0;
        for (Employee employee : emps) {

            totalSalary += employee.getSalary();
            count++;
        }

        return totalSalary/count;
    }

    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }

    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }
}
