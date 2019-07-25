package com.solrProject.solr.service.bookService;

import com.solrProject.solr.model.solr.Book;
import com.solrProject.solr.repository.solr.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.HighlightOptions;
import org.springframework.data.solr.core.query.SimpleHighlightQuery;
import org.springframework.data.solr.core.query.SimpleStringCriteria;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private SolrOperations solrOperations;

    @Override
    public List<Book> getAll() {
        Iterable<Book> all = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }

    @Override
    public HighlightPage<Book> highlighting(String value) {
        SimpleHighlightQuery query = new SimpleHighlightQuery(new SimpleStringCriteria("description:" + value));
        HighlightOptions highlightOptions = new HighlightOptions();
        highlightOptions.addField("description");
        highlightOptions.setSimplePrefix("<highlight>");
        highlightOptions.setSimplePostfix("</highlight>");
        query.setHighlightOptions(highlightOptions);
        return solrOperations.queryForHighlightPage("books", query, Book.class);
    }
}
