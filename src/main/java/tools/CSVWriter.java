package tools;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import lombok.NoArgsConstructor;




@NoArgsConstructor
public class CSVWriter {

//    public static void main(String[] args) throws IOException, CsvException {
//
//
//        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
//        try(CSVReader reader = new CSVReaderBuilder(
//                new FileReader("src/main/resources/expectingTestDataForTests.csv"))
//                .withCSVParser(csvParser)   // custom CSV parser
//                .withSkipLines(1)           // skip the first line, header info
//                .build()){
//            List<String[]> r = reader.readAll();
//            r.forEach(x -> System.out.println(Arrays.toString(x)));
//        }
//    }
}