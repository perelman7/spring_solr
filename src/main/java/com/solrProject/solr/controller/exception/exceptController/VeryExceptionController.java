package com.solrProject.solr.controller.exception.exceptController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception2")
public class VeryExceptionController {

    @GetMapping("/{value}")
    public ResponseEntity test (@PathVariable String value) throws Exception {
        if(value.equals("1")){
            throw new IllegalStateException("SSSSSSSS");
        }else if (value.equals("2")){
            throw new Exception("Value is 2");
        }
        return new ResponseEntity<>("VSE OK", HttpStatus.OK);
    }
}
