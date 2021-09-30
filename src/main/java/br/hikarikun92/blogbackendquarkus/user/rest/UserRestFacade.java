package br.hikarikun92.blogbackendquarkus.user.rest;

import br.hikarikun92.blogbackendquarkus.user.User;
import br.hikarikun92.blogbackendquarkus.user.UserService;
import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

import static br.hikarikun92.blogbackendquarkus.util.CollectionUtils.convertList;

@ApplicationScoped
@RequiredArgsConstructor
public class UserRestFacade {
    private final UserService service;

    public List<UserReadDto> findAll() {
        final List<User> users = service.findAll();
        return convertList(users, UserReadDto::fromUser);
    }
}
