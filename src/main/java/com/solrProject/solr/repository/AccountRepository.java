package com.solrProject.solr.repository;

import com.solrProject.solr.model.Account;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends SolrCrudRepository<Account, String> {
}
