package com.solrProject.solr.controller.elastic;

import com.solrProject.solr.model.Article;
import com.solrProject.solr.service.elastic.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/all")
    public ResponseEntity<List<Article>> getAll() {
        List<Article> all = articleService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Article> getById(@PathVariable String id){
        if(id != null && !id.isEmpty()){
            Article byId = articleService.getById(id);
            return new ResponseEntity<>(byId, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Article article){
        if(article != null){
            boolean save = articleService.save(article);
            return save ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
