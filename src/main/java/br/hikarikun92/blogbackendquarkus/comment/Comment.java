package br.hikarikun92.blogbackendquarkus.comment;

import br.hikarikun92.blogbackendquarkus.user.User;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Comment {
    Integer id;
    String title;
    String body;
    LocalDateTime publishedDate;
    User user;
}
