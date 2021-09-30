package br.hikarikun92.blogbackendquarkus.post.rest.dto;

import br.hikarikun92.blogbackendquarkus.post.Post;
import lombok.Value;

@Value
public class PostByUserDto {
    int id;
    String title;
    String body;

    public static PostByUserDto fromPost(Post post) {
        return new PostByUserDto(post.getId(), post.getTitle(), post.getBody());
    }
}
