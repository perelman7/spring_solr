package com.solrProject.solr.service.templ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserTemplServiceImpl implements UserTemplService {

    @Autowired
    private SolrTemplate solrTemplate;


}
