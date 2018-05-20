package br.com.aurindo.reader.repository;

import br.com.aurindo.reader.model.cotacaoDolar.CotacaoDolarFactor;
import org.springframework.data.repository.CrudRepository;

public interface CotacaoDolarRepository extends CrudRepository<CotacaoDolarFactor, Long> {
}
