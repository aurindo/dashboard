package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;

import java.util.List;
import java.util.Set;

public interface CotacaoDolarSave {

    void save(List<CotacaoDolarFactor> cotacaoDolarSet);
}
