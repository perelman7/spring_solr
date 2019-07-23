package com.solrProject.solr.controller.solr;

import com.solrProject.solr.model.Account;
import com.solrProject.solr.service.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity getAll(){
        List<Account> all = accountService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Account account){
        boolean save = accountService.save(account);
        return save ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
