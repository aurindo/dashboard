package br.com.aurindo.reader.repository;

import br.com.aurindo.reader.model.ipca.IpcaFactor;
import org.springframework.data.repository.CrudRepository;

public interface IpcaRepository extends CrudRepository<IpcaFactor, Long> {
}
