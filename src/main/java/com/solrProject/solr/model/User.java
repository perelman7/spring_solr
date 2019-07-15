package com.solrProject.solr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "users")
public class User implements Serializable {

    @Id
    @Field("ID")
    private String id;
    @Field("NAME")
    private String name;
    @Field("SURNAME")
    private String surname;
    @Field("AGE")
    private int age;

}
