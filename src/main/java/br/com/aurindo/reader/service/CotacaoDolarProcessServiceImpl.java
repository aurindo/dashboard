package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CotacaoDolarProcessServiceImpl implements CotacaoDolarProcessService {

    @Autowired
    private CotacaoDolarReadService cotacaoDolarReadService;

    @Autowired
    private CotacaoDolarSave cotacaoDolarSave;

    @Override
    public void processCotacaoDolar(String path) {
        Set<CotacaoDolarFactor> cotacaoDolarFactorSet = cotacaoDolarReadService.readJSon(path);

        cotacaoDolarSave.save(cotacaoDolarFactorSet);
    }

}
