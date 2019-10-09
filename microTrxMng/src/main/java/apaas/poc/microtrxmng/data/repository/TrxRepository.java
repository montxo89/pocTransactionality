package apaas.poc.microtrxmng.data.repository;

import org.springframework.data.repository.CrudRepository;

import apaas.poc.microtrxmng.data.model.TrxDbModel;

public interface TrxRepository extends CrudRepository<TrxDbModel, String> {

}
