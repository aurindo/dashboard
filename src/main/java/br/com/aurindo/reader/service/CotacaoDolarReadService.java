package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;

import java.util.Set;

public interface CotacaoDolarReadService {

    Set<CotacaoDolarFactor> readJSon(String path);

}
