package peopleAnalyzer.reporters;

import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.models.Analysis;

public class SystemOutputReporter implements IReporter {
    @Override
    public void generateReport(Analysis analysis) {
        System.out.println(analysis.getMessage());
        System.out.println(analysis.getNumber());
    }
}
