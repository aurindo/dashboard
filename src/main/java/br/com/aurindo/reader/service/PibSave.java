package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;

import java.util.List;

public interface PibSave {

    void save(List<PibFactor> pibs);

}
