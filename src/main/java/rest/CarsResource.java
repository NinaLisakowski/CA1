package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CarsDTO;
import facades.CarsFacade;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cars")
public class CarsResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/startcode",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);

    private static final CarsFacade FACADE = CarsFacade.getCarsFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @GET
    @Path("/populate/database")
    @Produces(MediaType.APPLICATION_JSON)
    public String populateDB() {
        FACADE.populateDB();
        String msg = "Updated DB";
        return GSON.toJson(msg);
    }

    @GET
    @Path("/all")
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllCars() {
        List<CarsDTO> cars = FACADE.getAllCars();
        return GSON.toJson(cars);
    }


//        @GET
//    @Path("/highestpaid")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson3() {
//        EmployeeFacade ef = getEmployeeFacade(Persistence.createEntityManagerFactory("pu"));
//        List<EmployeeDTO> employee = ef.getEmployeeWithHighestSalary();
//        return new Gson().toJson(employee);
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson1(@PathParam("id") Long id) {
//        Movie movie = FACADE.getMovie(id);
//        return new Gson().toJson(movie);
//    }
//    
//    @GET
//    @Path("/name/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getJson2(@PathParam("name") String name) {
//        List<Movie> movie = FACADE.getMoviesByName(name);
//        return new Gson().toJson(movie);
//    }
}
