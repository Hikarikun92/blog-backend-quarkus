package br.hikarikun92.blogbackendquarkus.user.rest;

import br.hikarikun92.blogbackendquarkus.post.Post;
import br.hikarikun92.blogbackendquarkus.user.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static br.hikarikun92.blogbackendquarkus.factory.PostFactory.*;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserRestControllerTest {
    @Test
    void testFindAll() {
        final String expectedBody = "[" +
                toJson(USER_1) + "," +
                toJson(USER_2) + "," +
                toJson(USER_3) +
                "]";

        given()
                .get("/users")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(expectedBody));
    }

    private String toJson(User user) {
        return "{\"id\":" + user.getId() + ",\"username\":\"" + user.getUsername() + "\"}";
    }

    @Test
    void testFindPostsByUserId() {
        final String expectedBody1 = "[]";

        given()
                .get("/users/{userId}/posts", USER_1.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(expectedBody1));

        final String expectedBody2 = "[" +
                toJson(POST_1) + "," +
                toJson(POST_2) +
                "]";

        given()
                .get("/users/{userId}/posts", USER_2.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(expectedBody2));

        final String expectedBody3 = "[" +
                toJson(POST_3) +
                "]";

        given()
                .get("/users/{userId}/posts", USER_3.getId())
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(is(expectedBody3));
    }

    private String toJson(Post post) {
        return "{\"body\":\"" + post.getBody() + "\",\"id\":" + post.getId() + ",\"title\":\"" + post.getTitle() + "\"}";
    }
}
