package br.hikarikun92.blogbackendquarkus.user.rest;

import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserRestFacade facade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserReadDto> findAll() {
        return facade.findAll();
    }
}
