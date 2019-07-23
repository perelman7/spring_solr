package com.solrProject.solr.repository.elastic;

import com.solrProject.solr.model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends ElasticsearchCrudRepository<Article, String> {
}
