package peopleAnalyzer.interfaces;

import peopleAnalyzer.models.Person;

import java.util.List;

public interface IPeopleRepository {
    List<Person> getPeople();
}
