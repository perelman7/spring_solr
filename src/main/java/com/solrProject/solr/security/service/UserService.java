package com.solrProject.solr.security.service;

import com.solrProject.solr.security.dto.singin.UserSinginDto;
import com.solrProject.solr.security.model.Role;
import com.solrProject.solr.security.model.User;
import java.util.List;

public interface UserService {

    User register(UserSinginDto user);

    Role createRole(String role);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    void delete(Long id);
}
