package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;
import br.com.aurindo.reader.repository.PibRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PibSaveImpl implements PibSave {

    @Autowired
    private PibRepository pibRepository;

    @Override
    public void save(Set<PibFactor> pibs) {
        pibs.parallelStream().forEach(pib -> {
            pibRepository.save(pib);
        });
    }
}
