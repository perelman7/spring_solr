package com.solrProject.solr.security.dto.singin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSinginDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<String> roles;
}
