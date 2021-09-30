package br.hikarikun92.blogbackendquarkus.user;

import br.hikarikun92.blogbackendquarkus.user.jpa.UserCredentialsEntity;
import br.hikarikun92.blogbackendquarkus.user.jpa.UserEntity;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static br.hikarikun92.blogbackendquarkus.util.CollectionUtils.convertList;

@ApplicationScoped
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager entityManager;

    public List<User> findAll() {
        final List<UserEntity> entities = entityManager.createNamedQuery("User.findAll", UserEntity.class)
                .getResultList();
        return convertList(entities, this::toUser);
    }

    private User toUser(UserEntity entity) {
        return new User(entity.getId(), entity.getUsername());
    }

    public Optional<UserCredentials> findCredentialsByUsername(String username) {
        final List<UserCredentialsEntity> credentialsList = entityManager.createNamedQuery("UserCredentials.findCredentialsByUsername", UserCredentialsEntity.class)
                .setParameter("username", username)
                .getResultList();

        if (credentialsList.isEmpty()) {
            return Optional.empty();
        }

        final UserCredentialsEntity credentialsEntity = credentialsList.get(0);
        final UserEntity userEntity = credentialsEntity.getUser();
        return Optional.of(new UserCredentials(toUser(userEntity), credentialsEntity.getPassword(), userEntity.getRoles()));
    }
}
