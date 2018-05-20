package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;
import br.com.aurindo.reader.repository.CotacaoDolarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CotacaoDolarSaveImpl implements CotacaoDolarSave {

    @Autowired
    private CotacaoDolarRepository cotacaoDolarRepository;

    @Override
    public void save(Set<CotacaoDolarFactor> cotacaoDolarSet) {
        cotacaoDolarSet.parallelStream().forEach(cotacaoDolar -> {
            cotacaoDolarRepository.save(cotacaoDolar);
        });
    }

}
