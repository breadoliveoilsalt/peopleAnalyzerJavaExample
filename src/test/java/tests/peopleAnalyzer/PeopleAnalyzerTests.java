package tests.peopleAnalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopleAnalyzer.PeopleAnalyzer;
import peopleAnalyzer.analyzers.AgeAggregator;
import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;
import tests.mocks.MockAnalyzer;
import tests.mocks.MockPeopleRepository;
import tests.mocks.MockReporter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleAnalyzerTests {

    @Test
    public void testRunGetsAListOfPeople() throws IOException {
        MockPeopleRepository repository = new MockPeopleRepository();
        IAnalyzer analyzer = new MockAnalyzer();
        IReporter reporter = new MockReporter();
        PeopleAnalyzer app = new PeopleAnalyzer(repository, analyzer, reporter);

        app.run();

        assertEquals(1, repository.getNumberOfCallsToGetPeople());
    }

    @Test
    public void testRunAnalyzesThePeople() throws IOException {
        List<Person> people = generatePeopleList();
        MockPeopleRepository repository = new MockPeopleRepository();
        repository.setPeopleToReturn(people);

        MockAnalyzer analyzer = new MockAnalyzer();
        IReporter reporter = new MockReporter();
        PeopleAnalyzer app = new PeopleAnalyzer(repository, analyzer, reporter);

        app.run();

        assertEquals(1, analyzer.getNumberOfCallsToAnalyze());
        assertEquals(people, analyzer.getPeoplePassedInAsArgument());
    }

    private List<Person> generatePeopleList() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Felicia", 25));
        people.add(new Person("Alice", 29));
        return people;
    }

}
