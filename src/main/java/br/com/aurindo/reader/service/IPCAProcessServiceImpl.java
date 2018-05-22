package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.ipca.IpcaFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class IPCAProcessServiceImpl implements IPCAProcessService {

    @Autowired
    private IPCAReadService readIPCAService;

    @Autowired
    private SaveIPCAService saveIPCAService;

    @Override
    public void processIPCA(List<String> ipcaPathSet) {

        ipcaPathSet.parallelStream().forEach(ipcaPath -> {
            List<IpcaFactor> ipcaFactorSet = readIPCAService.read(ipcaPath);
            saveIPCAService.save(ipcaFactorSet);
        });

    }
}
