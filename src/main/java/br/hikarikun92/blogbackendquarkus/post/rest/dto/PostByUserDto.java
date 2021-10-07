package br.hikarikun92.blogbackendquarkus.post.rest.dto;

import br.hikarikun92.blogbackendquarkus.post.Post;
import lombok.Value;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

@Value
public class PostByUserDto {
    int id;
    String title;
    String body;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    LocalDateTime publishedDate;

    public static PostByUserDto fromPost(Post post) {
        return new PostByUserDto(post.getId(), post.getTitle(), post.getBody(), post.getPublishedDate());
    }
}
