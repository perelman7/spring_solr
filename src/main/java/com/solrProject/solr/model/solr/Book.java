package com.solrProject.solr.model.solr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "book")
public class Book {

    @Id
    @Indexed(name = "id", type = "string")
    private String id;

    @Indexed(name = "name", type = "text_general")
    private String name;

    @Indexed(name = "description", type = "text_general")
    private String description;
}
