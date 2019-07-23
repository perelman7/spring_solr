package com.solrProject.solr.controller.exception.exceptionHandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice(basePackages = {"com.solrProject.solr.controller.exception.exceptController"})
public class ExceptionAdviceController {

    @ExceptionHandler
    public String excep(Exception ex){
        return "Exception : " + ex.getMessage();
    }

    @ExceptionHandler
    public String ioexception(ArithmeticException ex) {
        return "ArithmeticException : " + ex.getMessage();
    }

    @ExceptionHandler
    public String illigal(IllegalStateException ex) {
        return "IllegalStateException : " + ex.getMessage();
    }

    @ExceptionHandler
    public String ioe(IOException ex) {
        return "IOException : " + ex.getMessage();
    }
}
