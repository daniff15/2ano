package lab08.ex2;

import java.util.List;
import java.util.ArrayList;

public class SocialSecurity {
    
    private List<Person> socialSecurities = new ArrayList<>();

    public void register(Person person){
        socialSecurities.add(person);
    }

}
