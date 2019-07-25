package com.solrProject.solr.model.solr;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyNumber implements Serializable {

    @Id
    @Field
    private String id;
    @Indexed(name = "number", type = "integer")
    @Field
    private Integer number;

    @Indexed(name = "email", type = "string")
    @Field
    private String email;

    public MyNumber(String s) {

        java.lang.reflect.Field[] fields = this.getClass().getDeclaredFields();
        int start = s.indexOf("(");
        int end = s.lastIndexOf(")");
        String substring = null;
        if (start > 0 && end > 0) {
            substring = s.substring(start, end);
        }

        if (substring != null) {
            for (java.lang.reflect.Field field : fields) {
                String key = field.getName();
                field.setAccessible(true);

                int valueStartIndex = substring.indexOf(key) + key.length() + 1;

                if (valueStartIndex > 0) {
                    int endValue = substring.indexOf(",");
                    String value;
                    if (endValue > 0) {
                        value = substring.substring(valueStartIndex, endValue);
                    } else {
                        value = substring.substring(valueStartIndex);
                    }

                    try {
                        Class<?> type = field.getType();
                        if (type.equals(Integer.class)) {
                            field.set(this, Integer.parseInt(value));
                        } else {
                            field.set(this, value);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    substring = substring.substring(endValue + 1);
                }

                field.setAccessible(false);
            }
        }
    }

}
