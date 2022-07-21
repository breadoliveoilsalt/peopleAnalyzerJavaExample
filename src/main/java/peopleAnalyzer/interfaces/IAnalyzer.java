package peopleAnalyzer.interfaces;

import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;

import java.util.List;

public interface IAnalyzer {
    Analysis analyze(List<Person> people);
}
