package br.com.aurindo.reader.factory;

import br.com.aurindo.reader.model.pib.DataPibDim;
import br.com.aurindo.reader.model.pib.PibFactor;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PibFactorFactory {

    private static final Map<Integer, DataPibDim> anos = new HashMap<>();

    private PibFactorFactory(){}

    public static PibFactor create(BigDecimal valor, Integer ano) {
        if (anos.get(ano) == null) {
            anos.put(ano, new DataPibDim(ano));
        }
        return new PibFactor(valor, anos.get(ano));
    }

}
