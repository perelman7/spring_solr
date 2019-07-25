package com.solrProject.solr.service.templUser;

import com.solrProject.solr.model.solr.User;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.StatsPage;

import java.util.List;

public interface UserTemplService {

    List<User> getAll();
    HighlightPage<User> highlighting(String name);
    StatsPage<User> stat();
    Page<User> filtered(String value);
    Page<User> facet();
    Page<User> join();
}
