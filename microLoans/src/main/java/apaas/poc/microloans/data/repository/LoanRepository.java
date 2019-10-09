package apaas.poc.microloans.data.repository;

import org.springframework.data.repository.CrudRepository;

import apaas.poc.microloans.data.model.LoanDbModel;

public interface LoanRepository extends CrudRepository<LoanDbModel, String> {	
	
}
