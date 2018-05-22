package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;

import java.util.List;

public interface CotacaoDolarReadService {

    List<CotacaoDolarFactor> readJSon(String path);

}
