package apaas.poc.microaccounts.data.repository;

import org.springframework.data.repository.CrudRepository;

import apaas.poc.microaccounts.data.model.Account;

public interface AccountsRepository extends CrudRepository<Account, String>  {

}
