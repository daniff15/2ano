package lab07.ex1;

abstract class EmployeeDecorator implements EmployeeInterface {

    protected EmployeeInterface EmpInterface;

    EmployeeDecorator(EmployeeInterface empInterface) {
        EmpInterface = empInterface;
    }

    @Override
    public void start (Data data){
        EmpInterface.start(data);
    }

    @Override
    public void terminate(Data data){
        EmpInterface.terminate(data);
    }

    @Override
    public void work(){
        EmpInterface.work();
    }
}