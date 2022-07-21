package peopleAnalyzer.reporters;

import peopleAnalyzer.interfaces.IReporter;
import peopleAnalyzer.models.Analysis;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputReporter implements IReporter {
    public void generateReport(Analysis analysis) {
        String file = "report.txt";
        String report = analysis.getMessage() + analysis.getNumber() + "\n";
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.append(report);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
