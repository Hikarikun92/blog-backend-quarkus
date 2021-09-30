package br.hikarikun92.blogbackendquarkus.user;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static br.hikarikun92.blogbackendquarkus.factory.UserCredentialsFactory.*;
import static br.hikarikun92.blogbackendquarkus.factory.UserFactory.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
class UserRepositoryTest {
    @Inject
    UserRepository repository;

    @Test
    void testFindAll() {
        final List<User> users = repository.findAll();
        final List<User> expected = List.of(USER_1, USER_2, USER_3);
        assertEquals(expected, users);
    }

    @Test
    void testFindCredentialsByUsername() {
        final Optional<UserCredentials> credentials1 = repository.findCredentialsByUsername(USER_1.getUsername());
        assertEquals(Optional.of(USER_CREDENTIALS_1), credentials1);

        final Optional<UserCredentials> credentials2 = repository.findCredentialsByUsername(USER_2.getUsername());
        assertEquals(Optional.of(USER_CREDENTIALS_2), credentials2);

        final Optional<UserCredentials> credentials3 = repository.findCredentialsByUsername(USER_3.getUsername());
        assertEquals(Optional.of(USER_CREDENTIALS_3), credentials3);

        final Optional<UserCredentials> nonExisting = repository.findCredentialsByUsername("non-existing");
        assertTrue(nonExisting.isEmpty());
    }
}