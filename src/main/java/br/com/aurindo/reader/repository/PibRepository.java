package br.com.aurindo.reader.repository;

import br.com.aurindo.reader.model.pib.PibFactor;
import org.springframework.data.repository.CrudRepository;

public interface PibRepository extends CrudRepository<PibFactor, Long> {
}
