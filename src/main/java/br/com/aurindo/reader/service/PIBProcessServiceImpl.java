package br.com.aurindo.reader.service;

import br.com.aurindo.reader.model.pib.PibFactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PIBProcessServiceImpl implements PIBProcessService {

    @Autowired
    private PibRead pibRead;

    @Autowired
    private PibSave pibSave;

    @Override
    public void processPIB(String pibPath) {
        Set<PibFactor> pibs = pibRead.read(pibPath);
        pibSave.save(pibs);
    }

}
