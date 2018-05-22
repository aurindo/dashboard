package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;

import java.util.List;

public interface PibRead {

    List<PibFactor> read(String pibPath);
}
