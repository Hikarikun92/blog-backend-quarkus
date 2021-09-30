package br.hikarikun92.blogbackendquarkus.user.rest.dto;

import br.hikarikun92.blogbackendquarkus.user.User;
import lombok.Value;

@Value
public class UserReadDto {
    int id;
    String username;

    public static UserReadDto fromUser(User user) {
        return new UserReadDto(user.getId(), user.getUsername());
    }
}
