package com.solrProject.solr.service.account;

import com.solrProject.solr.model.Account;
import com.solrProject.solr.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAll(){
        Iterable<Account> all = accountRepository.findAll();
        List<Account> result = new ArrayList<>();
        all.forEach(result::add);
        return result;
    }

    @Override
    public boolean save(Account account){
        Account save = accountRepository.save(account);
        return save != null;
    }
}
