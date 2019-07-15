package com.solrProject.solr.controller;

import com.solrProject.solr.model.User;
import com.solrProject.solr.service.repo.UserRepService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/repo")
@Slf4j
public class UserRepController {

    @Autowired
    private UserRepService userRepService;

    @GetMapping
    public ResponseEntity getAll(){
        List<User> all = userRepService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable String id){
        User byId = userRepService.findById(id);
        return new ResponseEntity<>(byId, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody User user){
        boolean save = userRepService.save(user);
        return save ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity update(@RequestBody User user){
        boolean update = userRepService.update(user);
        return update ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody User user){
        boolean delete = userRepService.delete(user);
        return delete ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
