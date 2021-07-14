package lab08.ex2;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Person> parkings = new ArrayList<>();

    public void allow(Person person){
        parkings.add(person);
    }
    
}
