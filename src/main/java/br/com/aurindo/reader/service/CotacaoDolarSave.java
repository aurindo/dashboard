package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;

import java.util.Set;

public interface CotacaoDolarSave {

    void save(Set<CotacaoDolarFactor> cotacaoDolarSet);
}
