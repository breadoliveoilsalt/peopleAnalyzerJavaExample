import peopleAnalyzer.PeopleAnalyzer;
import peopleAnalyzer.analyzers.AgeAggregator;
import peopleAnalyzer.interfaces.IAnalyzer;
import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.reporters.FileOutputReporter;
import peopleAnalyzer.reporters.SystemOutputReporter;
import peopleAnalyzer.repositories.CSVRepository;
import peopleAnalyzer.repositories.ObjectRepository;

public class App {
    public static void main(String[] args) {
        System.out.println("Starting People Analyzer");
        System.out.println("=========================================");

//        IPeopleRepository repository = new CSVRepository();
        IPeopleRepository repository = new ObjectRepository();
        IAnalyzer analyzer = new AgeAggregator();
//        IReporter reporter = new SystemOutputReporter();
        IReporter reporter = new FileOutputReporter();

        new PeopleAnalyzer(
            repository,
            analyzer,
            reporter
        ).run();

        System.out.println("=========================================");
        System.out.println("Done!");
    }
}
