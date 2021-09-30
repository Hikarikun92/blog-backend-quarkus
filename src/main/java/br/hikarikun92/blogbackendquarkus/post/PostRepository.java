package br.hikarikun92.blogbackendquarkus.post;

import br.hikarikun92.blogbackendquarkus.comment.Comment;
import br.hikarikun92.blogbackendquarkus.post.jpa.PostEntity;
import br.hikarikun92.blogbackendquarkus.user.User;
import br.hikarikun92.blogbackendquarkus.user.jpa.UserEntity;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static br.hikarikun92.blogbackendquarkus.util.CollectionUtils.convertList;

@ApplicationScoped
@RequiredArgsConstructor
public class PostRepository {
    private final EntityManager entityManager;

    public List<Post> findByUserId(int userId) {
        final List<PostEntity> postEntities = entityManager.createNamedQuery("Post.findByUserId", PostEntity.class)
                .setParameter("userId", userId)
                .getResultList();
        return convertList(postEntities, this::toPost);
    }

    private Post toPost(PostEntity entity) {
        final UserEntity userEntity = entity.getUser();
        final User user = new User(userEntity.getId(), userEntity.getUsername());
        return new Post(entity.getId(), entity.getTitle(), entity.getBody(), user, null);
    }

    public Optional<Post> findById(int id) {
        final List<PostEntity> postEntities = entityManager.createNamedQuery("Post.findById", PostEntity.class)
                .setParameter("id", id)
                .getResultList();

        if (postEntities.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(toPostWithComments(postEntities.get(0)));
    }

    private Post toPostWithComments(PostEntity postEntity) {
        final UserEntity userEntity = postEntity.getUser();

        final User user = new User(userEntity.getId(), userEntity.getUsername());

        final List<Comment> comments = convertList(postEntity.getComments(), commentEntity -> {
            final UserEntity commentUserEntity = commentEntity.getUser();
            final User commentUser = new User(commentUserEntity.getId(), commentUserEntity.getUsername());

            return new Comment(commentEntity.getId(), commentEntity.getTitle(), commentEntity.getBody(), commentUser);
        });

        return new Post(postEntity.getId(), postEntity.getTitle(), postEntity.getBody(), user, comments);
    }
}
