package com.solrProject.solr.service.account;

import com.solrProject.solr.model.solr.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();
    boolean save(Account account);
}
