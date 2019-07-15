package com.solrProject.solr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@SpringBootApplication
@EnableSolrRepositories
public class SolrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolrApplication.class, args);
	}

}
