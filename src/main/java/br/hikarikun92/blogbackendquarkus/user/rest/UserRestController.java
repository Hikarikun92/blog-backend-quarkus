package br.hikarikun92.blogbackendquarkus.user.rest;

import br.hikarikun92.blogbackendquarkus.post.rest.PostRestFacade;
import br.hikarikun92.blogbackendquarkus.post.rest.dto.PostByUserDto;
import br.hikarikun92.blogbackendquarkus.user.rest.dto.UserReadDto;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
@RequiredArgsConstructor
public class UserRestController {
    private final UserRestFacade facade;
    private final PostRestFacade postRestFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserReadDto> findAll() {
        return facade.findAll();
    }

    //Note: Quarkus apparently doesn't allow this method to be in PostRestController with this URI
    @GET
    @Path("{userId}/posts")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostByUserDto> findPostsByUserId(@PathParam("userId") int userId) {
        return postRestFacade.findByUserId(userId);
    }
}
