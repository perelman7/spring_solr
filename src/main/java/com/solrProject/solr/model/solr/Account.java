package com.solrProject.solr.model.solr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SolrDocument(collection = "account")
public class Account implements Serializable {

    @Id
    @Indexed("id")
    @Field
    private String id;

    @Indexed(name = "name", type = "string")
    @Field
    private String name;

    @Indexed(name = "my_number")
    private MyNumber number;
}
