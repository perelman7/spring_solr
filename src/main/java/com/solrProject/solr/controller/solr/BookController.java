package com.solrProject.solr.controller.solr;

import com.solrProject.solr.model.solr.Book;
import com.solrProject.solr.service.bookService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity getAll(){
        List<Book> all = bookService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
