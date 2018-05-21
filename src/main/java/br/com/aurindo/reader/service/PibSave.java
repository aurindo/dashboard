package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;

import java.util.Set;

public interface PibSave {

    void save(Set<PibFactor> pibs);

}
