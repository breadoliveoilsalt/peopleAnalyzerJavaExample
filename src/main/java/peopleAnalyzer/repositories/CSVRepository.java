package peopleAnalyzer.repositories;

import peopleAnalyzer.interfaces.IPeopleRepository;
import peopleAnalyzer.models.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVRepository implements IPeopleRepository {
    @Override
    public List<Person> getPeople() {
        String file = "people.csv";
        List<List<String>> records = new ArrayList<>();
        List<Person> people = new ArrayList<Person>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < records.size(); i++) {
            List<String> record = records.get(i);
            String name = record.get(0);
            int age = Integer.parseInt(record.get(1));
            people.add(new Person(name, age));
        }
        return people;
    }
}
