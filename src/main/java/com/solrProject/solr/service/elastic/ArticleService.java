package com.solrProject.solr.service.elastic;

import com.solrProject.solr.model.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAll();
    Article getById(String id);
    boolean save(Article article);
}
