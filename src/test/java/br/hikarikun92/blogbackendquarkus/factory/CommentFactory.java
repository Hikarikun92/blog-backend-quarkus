package br.hikarikun92.blogbackendquarkus.factory;

import br.hikarikun92.blogbackendquarkus.comment.Comment;

import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_2;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_3;

public final class CommentFactory {
    private CommentFactory() {
        throw new AssertionError();
    }

    public static final Comment COMMENT_1 = new Comment(1, "Example comment 1", "Praesent sapien leo, viverra sed.", USER_2);
    public static final Comment COMMENT_2 = new Comment(2, "Great article", "Nice example!", USER_3);
    public static final Comment COMMENT_3 = new Comment(3, "Nulla sit amet ante in", "Curabitur ut maximus augue. Nunc luctus nibh risus.", USER_3);
    public static final Comment COMMENT_4 = new Comment(4, "Maecenas non sapien a elit", "Integer pulvinar nunc elit, eu interdum nisi ornare.", USER_2);
    public static final Comment COMMENT_5 = new Comment(5, "Curabitur viverra blandit finibus", "Nullam maximus risus vel urna mattis sollicitudin. Curabitur.", USER_3);
}
