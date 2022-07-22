package tests.mocks;

import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;

import java.util.List;

public class MockAnalyzer implements IAnalyzer {
    private int numberOfCallsToAnalyze = 0;
    private List<Person> peoplePassedInAsArgument;

    @Override
    public Analysis analyze(List<Person> people) {
        numberOfCallsToAnalyze++;
        peoplePassedInAsArgument = people;
        return null;
    }

    public int getNumberOfCallsToAnalyze() {
        return numberOfCallsToAnalyze;
    }

    public List<Person> getPeoplePassedInAsArgument() {
        return peoplePassedInAsArgument;
    }

}
