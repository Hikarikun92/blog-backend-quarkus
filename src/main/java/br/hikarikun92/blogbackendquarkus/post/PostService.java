package br.hikarikun92.blogbackendquarkus.post;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@RequiredArgsConstructor
public class PostService {
    private final PostRepository repository;

    public List<Post> findByUserId(int userId) {
        return repository.findByUserId(userId);
    }

    public Optional<Post> findById(int id) {
        return repository.findById(id);
    }
}
