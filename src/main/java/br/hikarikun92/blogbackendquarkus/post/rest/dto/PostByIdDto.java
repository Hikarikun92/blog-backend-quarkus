package br.hikarikun92.blogbackendquarkus.post.rest.dto;

import br.hikarikun92.blogbackendquarkus.comment.rest.dto.CommentReadDto;
import br.hikarikun92.blogbackendquarkus.post.Post;
import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.Value;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import static br.hikarikun92.blogbackendquarkus.util.CollectionUtils.convertList;

@Value
public class PostByIdDto {
    int id;
    String title;
    String body;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    LocalDateTime publishedDate;
    UserReadDto user;
    List<CommentReadDto> comments;

    public static PostByIdDto fromPost(Post post) {
        final List<CommentReadDto> comments = convertList(post.getComments(), CommentReadDto::fromComment);
        return new PostByIdDto(post.getId(), post.getTitle(), post.getBody(), post.getPublishedDate(), UserReadDto.fromUser(post.getUser()), comments);
    }
}
