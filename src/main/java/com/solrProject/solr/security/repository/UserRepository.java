package com.solrProject.solr.security.repository;

import com.solrProject.solr.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("authuserRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
