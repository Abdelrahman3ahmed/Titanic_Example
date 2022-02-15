package commonscsv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommonsCSVExample {
    String path = "src/main/resources/persons.csv";

    public static void main(String[] args) {
        CommonsCSVExample commonsCSVExample = new CommonsCSVExample ();
        try {
            commonsCSVExample.readCSV (commonsCSVExample.path);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void readCSV(String path) throws IOException {
        List<Person> result = new ArrayList<> ();
        Path csvFile = Paths.get (path);
        try (BufferedReader reader = Files.newBufferedReader (csvFile, StandardCharsets.UTF_8)) {
            CSVFormat csv = CSVFormat.RFC4180.withHeader ();
            try (CSVParser parser = csv.parse (reader)) {
                Iterator<CSVRecord> it = parser.iterator ();
                it.forEachRemaining (rec -> {
                    String name = rec.get ("name");
                    String email = rec.get ("email");
                    String country = rec.get ("country");
                    double salary = Double.parseDouble (rec.get ("salary").substring (1));
                    int experience = Integer.parseInt (rec.get ("experience"));
                    Person person = new Person (name, email, country, experience, salary);
                    result.add (person);
                });
            }
        }
        result.stream ().forEach (System.out::println);
    }

}
