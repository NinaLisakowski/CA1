package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.JokeDTO;
import facades.JokeFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

/**
 *
 * @author carol
 */
@Path("joke")
public class JokeResource {

    private static final EntityManagerFactory EMF 
            = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE =  JokeFacade.getFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return GSON.toJson(FACADE.getAllJokes());
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") int id) {
        JokeDTO joke;
        try {
        joke = FACADE.getJokeById(id);
        } catch (NullPointerException e) {
            return Response.status(404).entity("{\"code\":404,\"msg\":\"Joke"
                    + " not found\"}").build();
        }
        
        return Response.ok(GSON.toJson(joke)).build();
    }
 
    @GET
    @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getRandom() {
        return GSON.toJson(FACADE.getRandomJoke());
    }
    
}

