package com.solrProject.solr.model.elastic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "article")
public class Article implements Serializable {

    @Id
    private String id;
    private String title;
    private String content;
}
