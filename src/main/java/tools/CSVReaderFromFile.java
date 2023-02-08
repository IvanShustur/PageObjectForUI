package tools;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;


@NoArgsConstructor
public class CSVReaderFromFile {

    public static List<String[]> parseCSVFile(File file) throws IOException, CsvException {
        List<String[]> r;
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try (
                CSVReader reader = new CSVReaderBuilder(
                        new FileReader(file))
                        .withCSVParser(csvParser)
                        .build()) {
             r = reader.readAll();
           // r.forEach(x -> System.out.println(Arrays.toString(x)));
        }
        return r;
    }
}
