package lab07.ex1;

class Manager extends EmployeeDecorator{
    Manager(EmployeeInterface empInterface) {
        super(empInterface);
    }

    @Override
    public void work(){
        EmpInterface.work();
        System.out.print("como Manager ");
        this.manage();
    }

    public void manage(){
        System.out.println("-- Manage!");
    }
}