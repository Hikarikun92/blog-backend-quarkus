package br.hikarikun92.blogbackendquarkus.factory;

import br.hikarikun92.blogbackendquarkus.post.Post;

import java.time.LocalDateTime;
import java.util.List;

import static br.hikarikun92.blogbackendquarkus.factory.CommentFactory.*;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_2;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.USER_3;

public final class PostFactory {
    private PostFactory() {
        throw new AssertionError();
    }

    public static final Post POST_1 = new Post(1, "Example post no. 1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse placerat.",
            LocalDateTime.of(2021, 1, 1, 12, 3, 18), USER_2, null);
    public static final Post POST_1_WITH_COMMENTS = new Post(POST_1.getId(), POST_1.getTitle(), POST_1.getBody(),
            POST_1.getPublishedDate(), POST_1.getUser(), List.of(COMMENT_1, COMMENT_2));

    public static final Post POST_2 = new Post(2, "Another example post", "Integer malesuada lorem non nunc.",
            LocalDateTime.of(2021, 3, 15, 17, 53, 7), USER_2, null);
    public static final Post POST_2_WITH_COMMENTS = new Post(POST_2.getId(), POST_2.getTitle(), POST_2.getBody(),
            POST_2.getPublishedDate(), POST_2.getUser(), List.of());

    public static final Post POST_3 = new Post(3, "Writing example applications in Kotlin", "Kotlin methods are fun",
            LocalDateTime.of(2021, 7, 12, 23, 50, 46), USER_3, null);
    public static final Post POST_3_WITH_COMMENTS = new Post(POST_3.getId(), POST_3.getTitle(), POST_3.getBody(),
            POST_3.getPublishedDate(), POST_3.getUser(), List.of(COMMENT_3, COMMENT_4, COMMENT_5));
}
