package com.solrProject.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "users")
public class User implements Serializable {

    @Id
    @Indexed("ID")
    private String id;
    @Indexed(name = "NAME", type = "string")
    private String name;
    @Indexed(name = "SURNAME", type = "string")
    private String surname;
    @Indexed(name = "AGE", type = "string")
    private String age;

}
