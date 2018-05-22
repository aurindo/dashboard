package br.com.aurindo.reader.service;

import br.com.aurindo.reader.factory.PibFactorFactory;
import br.com.aurindo.reader.model.pib.PibFactor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PibReadImpl implements PibRead {

    @Override
    public List<PibFactor> read(String path) {
        List<PibFactor> cotacaoDolarSet = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();

        try (
                InputStream inputFS = new FileInputStream(path);
        ) {

            Map<String, List> map = mapper.readValue(inputFS, Map.class);

            List<LinkedHashMap<String, Object>> values = map.get("valores");

            cotacaoDolarSet = values.stream().map(linkedHashMap -> {
                return wrapCotacaoDolarFactor(linkedHashMap);
            }).collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cotacaoDolarSet;
    }

    private PibFactor wrapCotacaoDolarFactor(LinkedHashMap<String, Object> linkedHashMap) {

        BigDecimal valor = new BigDecimal((Long) linkedHashMap.get("valor"));
        Integer ano = (Integer)linkedHashMap.get("ano");

        return PibFactorFactory.create(valor, ano);

    }

}
