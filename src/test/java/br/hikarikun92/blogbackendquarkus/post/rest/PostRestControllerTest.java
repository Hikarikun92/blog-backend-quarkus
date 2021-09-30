package br.hikarikun92.blogbackendquarkus.post.rest;

import br.hikarikun92.blogbackendquarkus.comment.Comment;
import br.hikarikun92.blogbackendquarkus.post.Post;
import br.hikarikun92.blogbackendquarkus.user.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static br.hikarikun92.blogbackendquarkus.factory.PostFactory.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class PostRestControllerTest {
    @Test
    void testFindById() {
        given()
                .get("/posts/{id}", POST_1_WITH_COMMENTS.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(toJson(POST_1_WITH_COMMENTS)));

        given()
                .get("/posts/{id}", POST_2_WITH_COMMENTS.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(toJson(POST_2_WITH_COMMENTS)));

        given()
                .get("/posts/{id}", POST_3_WITH_COMMENTS.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(toJson(POST_3_WITH_COMMENTS)));

        given()
                .get("/posts/{id}", 42)
                .then()
                .statusCode(404);
    }

    private String toJson(Post post) {
        final StringBuilder commentsBuilder = new StringBuilder("[");
        for (Iterator<Comment> it = post.getComments().iterator(); it.hasNext(); ) {
            commentsBuilder.append(toJson(it.next()));
            if (it.hasNext()) {
                commentsBuilder.append(',');
            }
        }
        final String comments = commentsBuilder.append(']').toString();

        return "{\"body\":\"" + post.getBody() + "\",\"comments\":" + comments + ",\"id\":" + post.getId() +
                ",\"title\":\"" + post.getTitle() + "\",\"user\":" + toJson(post.getUser()) + "}";
    }

    private String toJson(Comment comment) {
        return "{\"body\":\"" + comment.getBody() + "\",\"id\":" + comment.getId() +
                ",\"title\":\"" + comment.getTitle() + "\",\"user\":" + toJson(comment.getUser()) + "}";
    }

    private String toJson(User user) {
        return "{\"id\":" + user.getId() + ",\"username\":\"" + user.getUsername() + "\"}";
    }
}
