package br.hikarikun92.blogbackendquarkus.comment.rest.dto;

import br.hikarikun92.blogbackendquarkus.comment.Comment;
import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.Value;

@Value
public class CommentReadDto {
    int id;
    String title;
    String body;
    UserReadDto user;

    public static CommentReadDto fromComment(Comment comment) {
        return new CommentReadDto(comment.getId(), comment.getTitle(), comment.getBody(), UserReadDto.fromUser(comment.getUser()));
    }
}
