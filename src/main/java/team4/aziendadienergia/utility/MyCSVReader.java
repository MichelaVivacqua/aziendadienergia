package team4.aziendadienergia.utility;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.stereotype.Service;
import team4.aziendadienergia.exceptions.CSVReadingException;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class MyCSVReader {

    public List<String[]> readCsv(Path path) throws Exception {
        try (Reader reader = Files.newBufferedReader(path);
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withCSVParser(new CSVParserBuilder()
                             .withSeparator(';')
                             .build())
                     .build()) {
            return csvReader.readAll();
        }
    }
}
