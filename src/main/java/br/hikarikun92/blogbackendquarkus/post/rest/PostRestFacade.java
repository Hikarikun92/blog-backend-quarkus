package br.hikarikun92.blogbackendquarkus.post.rest;

import br.hikarikun92.blogbackendquarkus.post.Post;
import br.hikarikun92.blogbackendquarkus.post.PostService;
import br.hikarikun92.blogbackendquarkus.post.rest.dto.PostByIdDto;
import br.hikarikun92.blogbackendquarkus.post.rest.dto.PostByUserDto;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.Optional;

import static br.hikarikun92.blogbackendquarkus.util.CollectionUtils.convertList;

@ApplicationScoped
@RequiredArgsConstructor
public class PostRestFacade {
    private final PostService service;

    public List<PostByUserDto> findByUserId(int userId) {
        final List<Post> posts = service.findByUserId(userId);
        return convertList(posts, PostByUserDto::fromPost);
    }

    public Optional<PostByIdDto> findById(int id) {
        return service.findById(id)
                .map(PostByIdDto::fromPost);
    }
}
