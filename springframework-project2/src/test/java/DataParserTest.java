import com.nhnacademy.edu.springframework.parser.CsvDataParser;
import com.nhnacademy.edu.springframework.parser.DataParser;
import org.junit.jupiter.api.Test;

public class DataParserTest {
    @Test
    void readFile() {
        DataParser dataParser = new CsvDataParser();
        dataParser.parseCsv("Tariff_20220331.csv");
        dataParser.parseJson("Tariff_20220331.json");
    }
}
