package br.hikarikun92.blogbackendquarkus.post;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static br.hikarikun92.blogbackendquarkus.factory.PostFactory.*;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class PostRepositoryTest {
    @Inject
    PostRepository repository;

    @Test
    void testFindByUserId() {
        final List<Post> user1Posts = repository.findByUserId(USER_1.getId());
        final List<Post> expected1 = List.of();
        assertEquals(expected1, user1Posts);

        final List<Post> user2Posts = repository.findByUserId(USER_2.getId());
        final List<Post> expected2 = List.of(POST_1, POST_2);
        assertEquals(expected2, user2Posts);

        final List<Post> user3Posts = repository.findByUserId(USER_3.getId());
        final List<Post> expected3 = List.of(POST_3);
        assertEquals(expected3, user3Posts);

        final List<Post> nonExistingPosts = repository.findByUserId(42);
        final List<Post> expectedNonExisting = List.of();
        assertEquals(expectedNonExisting, nonExistingPosts);
    }

    @Test
    void testFindById() {
        final Optional<Post> optional1 = repository.findById(POST_1.getId());
        assertEquals(Optional.of(POST_1_WITH_COMMENTS), optional1);

        final Optional<Post> optional2 = repository.findById(POST_2.getId());
        assertEquals(Optional.of(POST_2_WITH_COMMENTS), optional2);

        final Optional<Post> optional3 = repository.findById(POST_3.getId());
        assertEquals(Optional.of(POST_3_WITH_COMMENTS), optional3);

        final Optional<Post> optionalNonExisting = repository.findById(1234);
        assertTrue(optionalNonExisting.isEmpty());
    }
}
