package com.solrProject.solr.service.templ;

import com.solrProject.solr.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.query.*;
import org.springframework.data.solr.core.query.result.HighlightEntry;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.core.query.result.StatsPage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserTemplServiceImpl implements UserTemplService {

    @Autowired
    private SolrOperations solrTemplate;

    @Override
    public List<User> getAll() {
        FacetQuery query = new SimpleFacetQuery(new SimpleStringCriteria("*:*"));
        Page<User> users = solrTemplate.query("users", query, User.class);
        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        return result;
    }

    @Override
    public HighlightPage<User> highlighting(String name) {
        SimpleHighlightQuery query = new SimpleHighlightQuery(new SimpleStringCriteria("NAME:" + name));
        HighlightOptions highlightOptions = new HighlightOptions();
        highlightOptions.setSimplePrefix("<highlight>");
        highlightOptions.setSimplePostfix("</highlight>");
        query.setHighlightOptions(highlightOptions);
        HighlightPage<User> users = solrTemplate.queryForHighlightPage("users", query, User.class);
        return users;
    }

    @Override
    public StatsPage<User> stat() {
        StatsOptions statsOptions = new StatsOptions().addField("AGE");
        SimpleQuery statsQuery = new SimpleQuery("*:*");
        statsQuery.setStatsOptions(statsOptions);
        StatsPage<User> users = solrTemplate.queryForStatsPage("users", statsQuery, User.class);
        return users;
    }

    @Override
    public Page<User> filtered(String value) {
        Query query = new SimpleQuery(new Criteria("name").is(value));
        SimpleFilterQuery filterQuery = new SimpleFilterQuery();
        filterQuery.addCriteria(new SimpleStringCriteria("AGE:[20 TO 50]"));
        query.addFilterQuery(filterQuery);
        Page<User> users = solrTemplate.query("users", query, User.class);
        return users;
    }

    @Override
    public Page<User> facet() {
        FacetQuery query = new SimpleFacetQuery(new Criteria("NAME").is("alex"))
                .setFacetOptions(new FacetOptions().addFacetOnField("AGE").setFacetLimit(3));
        Page<User> users = solrTemplate.query("users", query, User.class);
        return users;
    }


}
