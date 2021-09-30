package br.hikarikun92.blogbackendquarkus.user.rest;

import br.hikarikun92.blogbackendquarkus.user.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

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
}