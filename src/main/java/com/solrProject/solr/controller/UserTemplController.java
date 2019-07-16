package com.solrProject.solr.controller;

import com.solrProject.solr.model.User;
import com.solrProject.solr.service.templ.UserTemplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.StatsPage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/temp")
public class UserTemplController {

    @Autowired
    private UserTemplService userTemplService;

    @GetMapping("/all")
    public ResponseEntity getAll(){
        List<User> all = userTemplService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/hightlight/{name}")
    public ResponseEntity hightlight(@PathVariable String name){
        HighlightPage<User> highlighting = userTemplService.highlighting(name);
        return new ResponseEntity<>(highlighting, HttpStatus.OK);
    }

    @GetMapping("/stat")
    public ResponseEntity stat(){
        StatsPage<User> stat = userTemplService.stat();
        return new ResponseEntity<>(stat, HttpStatus.OK);
    }

    @GetMapping("/facet")
    public ResponseEntity facet(){
        Page<User> facet = userTemplService.facet();
        return new ResponseEntity<>(facet, HttpStatus.OK);
    }

    @GetMapping("/filter/{name}")
    public ResponseEntity filter(@PathVariable String name){
        Page<User> filtered = userTemplService.filtered(name);
        return new ResponseEntity<>(filtered, HttpStatus.OK);
    }
}
