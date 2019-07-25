package com.solrProject.solr.service.elastic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.solrProject.solr.model.elastic.Article;
import com.solrProject.solr.repository.elastic.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    @Qualifier("template")
    private ElasticsearchOperations template;

    @PostConstruct
    private void init() {
        if (!template.indexExists(Article.class)) {
            template.createIndex(Article.class);
        }
        long count = repository.count();
        if(count == 0){
            List<Article> articles = this.generateArticles();
            Iterable<Article> savedArticles = repository.saveAll(articles);
            if (savedArticles.iterator().hasNext()) {
                log.info("Generated successfully");
            }
        }
    }

    @Override
    public List<Article> getAll() {
        Iterable<Article> all = repository.findAll();
        List<Article> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Article getById(String id) {
        if (id != null && !id.isEmpty()) {
            return repository.findById(id).get();
        }
        return null;
    }

    @Override
    public boolean save(Article article) {
        if (article != null) {
            Article save = repository.save(article);
            return save != null;
        }
        return false;
    }

    private List<Article> generateArticles() {
        List<Article> result = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String json = new String(Files.readAllBytes(Paths.get("src/main/resources/atricles.json")));
            result = objectMapper.readValue(json, new TypeReference<List<Article>>() {
            });
        } catch (IOException ex) {
            log.info("Can`t read bytes from json file, message: " + ex.getMessage());
        }
        log.info("Result size is: " + result.size());
        return result;
    }
}
