package lab07.ex1;

public class TeamLeader extends EmployeeDecorator{
    TeamLeader(EmployeeInterface empInterface) {
        super(empInterface);
    }

    @Override
    public void work(){
        EmpInterface.work();
        System.out.print("como TeamLeader ");
        this.plan();
    }

    public void plan(){
        System.out.println("-- Planeia!");
    }
}