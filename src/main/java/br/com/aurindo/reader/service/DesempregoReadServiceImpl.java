package br.com.aurindo.reader.service;

import br.com.aurindo.reader.factory.DesempregoItemFactory;
import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DesempregoReadServiceImpl implements DesempregoReadService {

    private static final String COMMA = ";";

    @Override
    public Set<DesempregoFactor> readCSV(String path) {

        Set<DesempregoFactor> inputList = new HashSet<>();

        File inputF = new File(path);

        try (
                InputStream inputFS = new FileInputStream(inputF);
                BufferedReader br = new BufferedReader(new InputStreamReader(inputFS));
        ) {
            inputList = br.lines().skip(1).map(mapToItem).collect(Collectors.toSet());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputList;
    }

    private Function<String, DesempregoFactor> mapToItem = (line) -> {
        String[] p = line.split(COMMA);

        int ano = new Integer(p[0]);
        String sexo = p[6];
        String cor = p[7];
        double valorAbsoluto = new Double(p[8]);
        double valorPercentual = new Double(p[9]);

        return DesempregoItemFactory.createDesempregoItemReaded(ano,
                sexo,
                cor,
                valorAbsoluto,
                valorPercentual);
    };

}
