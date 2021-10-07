package br.hikarikun92.blogbackendquarkus.comment.rest.dto;

import br.hikarikun92.blogbackendquarkus.comment.Comment;
import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.Value;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDateTime;

@Value
public class CommentReadDto {
    int id;
    String title;
    String body;
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    LocalDateTime publishedDate;
    UserReadDto user;

    public static CommentReadDto fromComment(Comment comment) {
        return new CommentReadDto(comment.getId(), comment.getTitle(), comment.getBody(), comment.getPublishedDate(), UserReadDto.fromUser(comment.getUser()));
    }
}
