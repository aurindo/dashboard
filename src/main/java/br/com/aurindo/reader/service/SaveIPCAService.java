package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;

import java.util.Set;

public interface SaveIPCAService {
    void save(Set<IpcaFactor> ipcaFactorSet);
}
