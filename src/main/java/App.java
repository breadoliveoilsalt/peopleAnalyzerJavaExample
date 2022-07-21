import peopleAnalyzer.PeopleAnalyzer;
import peopleAnalyzer.analyzers.AgeAggregator;
import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.reporters.SystemOutputReporter;
import peopleAnalyzer.repositories.ObjectRepository;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting People Analyzer");
        System.out.println("=========================================");

        IPeopleRepository repository = new ObjectRepository();
        IAnalyzer analyzer = new AgeAggregator();
        IReporter reporter = new SystemOutputReporter();

        new PeopleAnalyzer(
            repository,
            analyzer,
            reporter
        ).run();

        System.out.println("=========================================");
        System.out.println("Done!");
    }
}
