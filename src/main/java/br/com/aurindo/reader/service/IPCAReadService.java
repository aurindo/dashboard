package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;

import java.util.Set;

public interface IPCAReadService {
    Set<IpcaFactor> read(String ipcaPath);
}
