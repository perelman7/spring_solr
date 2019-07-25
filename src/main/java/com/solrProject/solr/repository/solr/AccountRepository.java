package com.solrProject.solr.repository.solr;

import com.solrProject.solr.model.solr.Account;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends SolrCrudRepository<Account, String> {
}
