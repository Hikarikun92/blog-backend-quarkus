package br.hikarikun92.blogbackendquarkus.post;

import br.hikarikun92.blogbackendquarkus.comment.Comment;
import br.hikarikun92.blogbackendquarkus.user.User;
import lombok.Value;

import java.util.List;

@Value
public class Post {
    Integer id;
    String title;
    String body;
    User user;
    List<Comment> comments;
}
