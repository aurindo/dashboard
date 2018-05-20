package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DesempregoProcessServiceImpl implements DesempregoProcessService {

    @Autowired
    private DesempregoReadService readCSVService;

    @Autowired
    private SaveDesemprego saveDesemprego;

    public void processDesemprego(String path) {

        Set<DesempregoFactor> desempregoFactorSet = readCSVService.readCSV(path);
        saveDesemprego.save(desempregoFactorSet);

    }

}
