package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;

import java.util.List;
import java.util.Set;

public interface IPCAReadService {
    List<IpcaFactor> read(String ipcaPath);
}
