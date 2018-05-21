package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CotacaoDolarReadServiceImpl implements CotacaoDolarReadService {

    @Override
    public Set<CotacaoDolarFactor> readJSon(String path) {

        Set<CotacaoDolarFactor> cotacaoDolarSet = new HashSet<>();

        ObjectMapper mapper = new ObjectMapper();

        try (
                InputStream inputFS = new FileInputStream(path);
        ) {

            Map<String, List> map = mapper.readValue(inputFS, Map.class);

            List<LinkedHashMap<String, Object>> values = map.get("value");

            cotacaoDolarSet = values.stream().map(linkedHashMap -> {
                return wrapCotacaoDolarFactor(linkedHashMap);
            }).collect(Collectors.toSet());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cotacaoDolarSet;
    }

    private CotacaoDolarFactor wrapCotacaoDolarFactor(LinkedHashMap<String, Object> linkedHashMap) {
        Double cotacaoCompra = (Double)linkedHashMap.get("cotacaoCompra");
        Double cotacaoVenda = (Double)linkedHashMap.get("cotacaoVenda");
        String dataHoraCotacao = (String) linkedHashMap.get("dataHoraCotacao");

        String[] periodArray = dataHoraCotacao.substring(0, 10).split("-");

        return new CotacaoDolarFactor(
                cotacaoCompra,
                cotacaoVenda,
                new Integer(periodArray[0]),
                periodArray[1],
                new Integer(periodArray[2]));
    }

}
