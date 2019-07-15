package com.solrProject.solr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.EmbeddedSolrServerFactoryBean;

@Configuration
@EnableSolrRepositories
public class SolrConfig {

    @Value("${solr.home.url}")
    private String SOLR_URL;

    @Bean
    public EmbeddedSolrServerFactoryBean solrServerFactoryBean() {
        EmbeddedSolrServerFactoryBean factory = new EmbeddedSolrServerFactoryBean();
        factory.setSolrHome(SOLR_URL);
        return factory;
    }

    @Bean
    public SolrOperations solrTemplate() {
        return new SolrTemplate(solrServerFactoryBean());
    }
}
