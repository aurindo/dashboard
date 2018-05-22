package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;
import br.com.aurindo.reader.repository.IpcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveIPCAImplService implements SaveIPCAService {

    @Autowired
    private IpcaRepository ipcaRepository;

    @Override
    public void save(List<IpcaFactor> ipcaFactorSet) {
        ipcaFactorSet.stream().forEach(ipcaFactor -> ipcaRepository.save(ipcaFactor));
    }
}
