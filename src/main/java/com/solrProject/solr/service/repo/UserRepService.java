package com.solrProject.solr.service.repo;

import com.solrProject.solr.model.User;

import java.util.List;

public interface UserRepService {

    List<User> getAll();
    boolean save(User user);
    boolean update(User user);
    boolean delete(User user);
    List<User> findById(String id);
    List<User> findByNameOrSurname(String name);
}
