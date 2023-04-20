package tests.peopleAnalyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopleAnalyzer.PeopleAnalyzer;
import peopleAnalyzer.analyzers.AgeAggregator;
import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;
import peopleAnalyzer.reporters.SystemOutputReporter;
import peopleAnalyzer.repositories.ObjectRepository;
import sample.SampleClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleAnalyzerTests {

    class MockPeopleRepository implements IPeopleRepository {

        private boolean getPeopleCalled = false;
        private List<Person> peopleToReturn = null;

        @Override
        public List<Person> getPeople() {
            getPeopleCalled = true;
            return peopleToReturn;
        }

        public boolean wasGetPeopleCalled() {
            return getPeopleCalled;
        }

        public void setPeopleToReturn(List<Person> people) {
            peopleToReturn = people;
        }
    }

    class MockAnalyzer implements IAnalyzer {

        private boolean analyzeCalled = false;
        private List<Person> argumentPassedToAnalyze;

        @Override
        public Analysis analyze(List<Person> people) {
            analyzeCalled = true;
            argumentPassedToAnalyze = people;
            return new Analysis("Hello World", 420);
        }

        public boolean wasAnalyzeCalled() {
            return analyzeCalled;
        }

        public List<Person> getArgumentPassedToAnalyze() {
            return argumentPassedToAnalyze;
        }
    }

    @Test
    public void testRunRetrievesPeopleData() throws IOException {
        MockPeopleRepository repository = new MockPeopleRepository();
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Felicia", 25));
        repository.setPeopleToReturn(people);

        IAnalyzer analyzer = new AgeAggregator();
        IReporter reporter = new SystemOutputReporter();
        PeopleAnalyzer peopleAnalyzer = new PeopleAnalyzer(repository, analyzer, reporter);

        peopleAnalyzer.run();

        assertEquals(true, repository.wasGetPeopleCalled());
    }

    @Test
    public void testRunAnalyzesThePeopleRetrieved() throws IOException {
        MockPeopleRepository repository = new MockPeopleRepository();
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Felicia", 25));
        repository.setPeopleToReturn(people);

        MockAnalyzer analyzer = new MockAnalyzer();
        IReporter reporter = new SystemOutputReporter();
        PeopleAnalyzer peopleAnalyzer = new PeopleAnalyzer(repository, analyzer, reporter);

        peopleAnalyzer.run();

        assertEquals(true, analyzer.wasAnalyzeCalled());
        assertEquals(people, analyzer.getArgumentPassedToAnalyze());
    }

}
