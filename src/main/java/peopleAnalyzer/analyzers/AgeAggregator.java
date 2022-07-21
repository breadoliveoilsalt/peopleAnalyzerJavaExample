package peopleAnalyzer.analyzers;

import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;

import java.util.List;

public class AgeAggregator implements IAnalyzer {


    @Override
    public Analysis analyze(List<Person> people) {
        int aggregateAge = 0;
        for (Person person : people) {
            aggregateAge += person.getAge();
        }

        return new Analysis("The Aggregate Age of all people is: ", aggregateAge);
    }
}
