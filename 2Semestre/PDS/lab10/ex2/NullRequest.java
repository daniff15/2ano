package lab10.ex2;

public class NullRequest extends Employee {

    public NullRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return "Error: Non-existent employee " + this.name;
    }
    
    
}
