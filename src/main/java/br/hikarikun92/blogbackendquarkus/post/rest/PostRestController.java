package br.hikarikun92.blogbackendquarkus.post.rest;

import br.hikarikun92.blogbackendquarkus.post.rest.dto.PostByIdDto;
import lombok.RequiredArgsConstructor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("/posts")
@RequiredArgsConstructor
public class PostRestController {
    private final PostRestFacade facade;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") int id) {
        final Optional<PostByIdDto> optional = facade.findById(id);
        if (optional.isPresent()) {
            return Response.ok(optional.get()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
