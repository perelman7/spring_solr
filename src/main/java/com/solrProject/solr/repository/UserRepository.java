package com.solrProject.solr.repository;

import com.solrProject.solr.model.User;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends SolrCrudRepository<User, String> {

    @Query(name = "users.findById")
    List<User> getById(String id);

    @Query(name = "users.findByNameOrSurname")
    List<User> getByNameOrSurname(String name);
}
