package com.solrProject.solr.config;

import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;

@Configuration
public class SolrConfig {

    @Value("${solr.home.url}")
    private String SOLR_URL;

    @Bean
    public HttpSolrClient solrServerFactoryBean() {
        return new HttpSolrClient.Builder(SOLR_URL).build();
    }

    @Bean
    public SolrOperations solrTemplate() {
        return new SolrTemplate(solrServerFactoryBean());
    }

}
