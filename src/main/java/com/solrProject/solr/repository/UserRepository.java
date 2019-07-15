package com.solrProject.solr.repository;

import com.solrProject.solr.model.User;
import org.springframework.data.solr.repository.SolrRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends SolrRepository<User, String> {

    List<User> findBySurname(String surname);
}
