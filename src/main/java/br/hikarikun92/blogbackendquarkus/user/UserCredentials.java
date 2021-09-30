package br.hikarikun92.blogbackendquarkus.user;

import lombok.Value;

import java.util.Set;

@Value
public class UserCredentials {
    User user;
    String password;
    Set<String> roles;
}
