package lab07.ex1;

public class TeamMember extends EmployeeDecorator{

    TeamMember(EmployeeInterface empInterface) {
        super(empInterface);
    }

    @Override
    public void work(){
        EmpInterface.work();
        System.out.print("como TeamMember ");
        this.colaborate();
    }

    public void colaborate(){
        System.out.println("-- Colabora!");
    }

}