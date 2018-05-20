package br.com.aurindo.reader.repository;

import br.com.aurindo.reader.model.desemprego.DesempregoFactor;
import org.springframework.data.repository.CrudRepository;

public interface DesempregoRepository extends CrudRepository<DesempregoFactor, Long> {
}
