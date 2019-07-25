package com.solrProject.solr.service.repoUser;

import com.solrProject.solr.model.solr.User;

import java.util.List;

public interface UserRepService {

    List<User> getAll();
    boolean save(User user);
    boolean update(User user);
    boolean delete(User user);
    List<User> findById(String id);
    List<User> findByNameOrSurname(String name);
}
