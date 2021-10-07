package br.hikarikun92.blogbackendquarkus.factory;

import br.hikarikun92.blogbackendquarkus.comment.Comment;

import java.time.LocalDateTime;

import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_2;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_3;

public final class CommentFactory {
    private CommentFactory() {
        throw new AssertionError();
    }

    public static final Comment COMMENT_1 = new Comment(1, "Example comment 1", "Praesent sapien leo, viverra sed.",
            LocalDateTime.of(2021, 1, 1, 18, 42, 32), USER_2);
    public static final Comment COMMENT_2 = new Comment(2, "Great article", "Nice example!",
            LocalDateTime.of(2021, 2, 28, 7, 38, 12), USER_3);
    public static final Comment COMMENT_3 = new Comment(3, "Nulla sit amet ante in", "Curabitur ut maximus augue. Nunc luctus nibh risus.",
            LocalDateTime.of(2021, 7, 15, 15, 43, 41), USER_3);
    public static final Comment COMMENT_4 = new Comment(4, "Maecenas non sapien a elit", "Integer pulvinar nunc elit, eu interdum nisi ornare.",
            LocalDateTime.of(2021, 7, 18, 9, 53, 34), USER_2);
    public static final Comment COMMENT_5 = new Comment(5, "Curabitur viverra blandit finibus", "Nullam maximus risus vel urna mattis sollicitudin. Curabitur.",
            LocalDateTime.of(2021, 8, 1, 11, 28, 39), USER_3);
}
