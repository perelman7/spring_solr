package com.solrProject.solr.controller.exception.exceptController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/exception1")
public class ExceptionController {

    @GetMapping("/{value}")
    public ResponseEntity test(@PathVariable(required = false) String value) throws IOException {
        System.out.println(value);
        if (value.equals("1")) {
            throw new IllegalStateException("String value is 1");
        } else if (value.equals("2")) {
            throw new ArithmeticException("String value is 2");
        }else if(value.equals("3")){
            throw new IOException("String value is 3");
        }

        return new ResponseEntity<>("Hello world!!!!", HttpStatus.OK);

    }
}
