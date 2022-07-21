package peopleAnalyzer.repositories;

import org.apache.commons.beanutils.BeanPropertyValueEqualsPredicate;
import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.models.Person;

import java.util.ArrayList;
import java.util.List;

public class ObjectRepository implements IPeopleRepository {
    @Override
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Felicia", 25));
        people.add(new Person("Alice", 29));
        people.add(new Person("Joe", 79));
        people.add(new Person("Sam", 10));
        people.add(new Person("Jimmy", 50));
        return people;
    }
}
