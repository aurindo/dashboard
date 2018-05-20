package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import br.com.aurindo.reader.repository.DesempregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SaveDesempregoImpl implements SaveDesemprego {

    @Autowired
    private DesempregoRepository desempregoRepository;

    @Override
    public void save(Set<DesempregoFactor> desempregoFactorSet) {
        desempregoFactorSet.parallelStream().forEach(desemprego -> {
            desempregoRepository.save(desemprego);
        });
    }
}
