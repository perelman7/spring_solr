package com.solrProject.solr.service.repoUser;

import com.solrProject.solr.model.solr.User;
import com.solrProject.solr.repository.solr.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserRepServiceImpl implements UserRepService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        Iterable<User> all = repository.findAll();
        List<User> users = new ArrayList<>();
        for(User user: all){
            users.add(user);
        }
        return users;
    }

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public boolean save(User user) {
        if(user != null && user.getId() != null){
            User save = repository.save(user);
            return save != null;
        }
        return false;
    }

    @Override
    public boolean update(User user){
        if(user != null){
            Optional<User> byId = repository.findById(user.getId());
            if(byId.isPresent()){
                User save = repository.save(user);
                return save != null;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User user){
        if(user != null){
            repository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public List<User> findById(String id){
        if(id != null && !id.isEmpty()){
            List<User> byId = repository.getById(id);
            return byId;
        }
        return null;
    }

    @Override
    public List<User> findByNameOrSurname(String name){
        if(name != null && !name.isEmpty()){
            return repository.getByNameOrSurname(name);
        }
        return null;
    }
}
