package ma.emsi.sadik.tp3sadik.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.sadik.tp3sadik.llm.LlmClient;

@Path("/guide")
@Produces(MediaType.APPLICATION_JSON)
public class GuideTouristiqueResource {

    @Inject
    private LlmClient llmClient;

    @GET
    @Path("/lieu/{villeOuPays}")
    public Response villeOuPays(@PathParam("villeOuPays") String villeOuPays) {
        try {
            String resultat = llmClient.getInformations(villeOuPays);
            return Response.ok(resultat).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("{\"erreur\":\"" + e.getMessage() + "\"}")
                    .build();
        }
    }
}
