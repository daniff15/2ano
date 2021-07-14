package lab07.ex1;

public class TodosFazem {
    public static void main(String[] args) {
        EmployeeInterface empInterface = new Employee("Joaquim");

        TeamLeader teamLeader = new TeamLeader(empInterface);
        TeamMember teamMember = new TeamMember(new Employee("Mario Calaixo"));
        Manager manager = new Manager(new Employee("Margarida Augusto"));

        TeamLeader teamLeader2 = new TeamLeader(new TeamMember(new Employee("Ana Maria")));

        EmployeeInterface empList[] = {teamLeader , teamMember, manager, teamLeader2};

        for (EmployeeInterface employeeInterface : empList) {
            employeeInterface.start(new Data(10, 4, 2020));
            employeeInterface.terminate(new Data(10, 5, 2021));
            employeeInterface.work();
        }
    }
}