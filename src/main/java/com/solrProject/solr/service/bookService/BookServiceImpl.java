package com.solrProject.solr.service.bookService;

import com.solrProject.solr.model.solr.Book;
import com.solrProject.solr.repository.solr.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll(){
        Iterable<Book> all = bookRepository.findAll();
        List<Book> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }
}
