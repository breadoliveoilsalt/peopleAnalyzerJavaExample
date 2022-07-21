package tests.peopleAnalyzer.analyzers;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopleAnalyzer.analyzers.AgeAggregator;
import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AgeAggregatorTests {
    private IAnalyzer analyzer;

    @BeforeEach
    public void testInit() {
        this.analyzer = new AgeAggregator();
    }

    @Test
    public void testAnalyzeAggregatesAllOfTheAgesOfPeople() throws IOException {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person("Felicia", 25));
        people.add(new Person("Alice", 29));
        people.add(new Person("Joe", 79));

        Analysis analysis = analyzer.analyze(people);

        assertEquals("The Aggregate Age of all people is: ", analysis.getMessage());
        assertEquals(133, analysis.getNumber());
    }

}
