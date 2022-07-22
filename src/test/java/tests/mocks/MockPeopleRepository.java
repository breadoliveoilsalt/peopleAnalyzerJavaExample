package tests.mocks;

import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.models.Person;

import java.util.List;

public class MockPeopleRepository implements IPeopleRepository {

    private int numberOfCallsToGetPeople = 0;
    private List<Person> peopleToReturn;

    @Override
    public List<Person> getPeople() {
        numberOfCallsToGetPeople++;
        return peopleToReturn;
    }

    public int getNumberOfCallsToGetPeople() {
        return numberOfCallsToGetPeople;
    }

    public void setPeopleToReturn(List<Person> people) {
        peopleToReturn = people;
    }
}
