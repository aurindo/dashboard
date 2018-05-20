package service;

import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import br.com.aurindo.reader.service.DesempregoReadService;
import br.com.aurindo.reader.service.DesempregoReadServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ReadCSVServiceTest {

    private DesempregoReadService readCSVService;

    @BeforeEach
    public void init() {
        readCSVService = new DesempregoReadServiceImpl();
    }

    @Test
    public void t() {

        String pathFile = "/Users/aurindoferreira/Desktop/dashboard/taxadesempregoTest.csv";

        Set<DesempregoFactor> result = readCSVService.readCSV(pathFile);
    }

}
