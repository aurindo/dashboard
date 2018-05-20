package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.desemprego.DesempregoFactor;

import java.util.Set;

public interface DesempregoReadService {

    Set<DesempregoFactor> readCSV(String path);

}
