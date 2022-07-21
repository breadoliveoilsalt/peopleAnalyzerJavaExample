package peopleAnalyzer;

import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.models.Analysis;
import peopleAnalyzer.models.Person;

import java.util.List;

public class PeopleAnalyzer {
    private IPeopleRepository repository;
    private IAnalyzer analyzer;
    private IReporter reporter;

    public PeopleAnalyzer(IPeopleRepository repository, IAnalyzer analyzer, IReporter reporter) {
        this.repository = repository;
        this.analyzer = analyzer;
        this.reporter = reporter;
    }

    public void run() {
        List<Person> people = repository.getPeople();
        Analysis analysis = analyzer.analyze(people);
        reporter.generateReport(analysis);
    }
}

