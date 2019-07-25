package com.solrProject.solr.repository.solr;

import com.solrProject.solr.model.solr.Book;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends SolrCrudRepository<Book, String> {
}
