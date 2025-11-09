package ma.emsi.sadik.tp3sadik.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
@Produces(MediaType.APPLICATION_JSON)
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    public Response getLieu(@PathParam("ville_ou_pays") String lieu) {
        String[] result = {lieu};
        return Response.ok(result).build();
    }
}
