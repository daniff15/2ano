package lab08.ex2;

import java.util.List;
import java.util.ArrayList;

public class Insurance {
    
    private List<Person> insurances = new ArrayList<>();

    public void register(Person person){
        insurances.add(person);
    }

}
