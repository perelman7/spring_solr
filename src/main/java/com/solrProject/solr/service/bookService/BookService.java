package com.solrProject.solr.service.bookService;

import com.solrProject.solr.model.solr.Book;
import org.springframework.data.solr.core.query.result.HighlightPage;

import java.util.List;

public interface BookService {

    List<Book> getAll();
    HighlightPage<Book> highlighting(String value);
}
