package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;

import java.util.Set;

public interface PibRead {

    Set<PibFactor> read(String pibPath);
}
