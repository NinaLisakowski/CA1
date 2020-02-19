package rest;

import dto.JokeDTO;
import entities.Joke;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author carol
 */
public class JokeResourceTest {

    private static final int SERVER_PORT = 7777;
    private static final String SERVER_URL = "http://localhost/api";
    //Read this line from a settings-file  since used several places
    private static final String TEST_DB = "jdbc:mysql://localhost:3307/startcode";

    static final URI BASE_URI = UriBuilder.fromUri(SERVER_URL).port(SERVER_PORT).build();
    private static HttpServer httpServer;
    private static EntityManagerFactory emf;
    private Joke j1;
    private Joke j2;
    private Joke j3;

    static HttpServer startServer() {
        ResourceConfig rc = ResourceConfig.forApplication(new ApplicationConfig());
        return GrizzlyHttpServerFactory.createHttpServer(BASE_URI, rc);
    }

    @BeforeAll
    public static void setUpClass() {
        EMF_Creator.startREST_TestWithDB();
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.CREATE);

        //Set System property so the project executed by the Grizly-server wil use this same database
        System.setProperty("IS_TEST", TEST_DB);
        httpServer = startServer();

        //Setup RestAssured
        RestAssured.baseURI = SERVER_URL;
        RestAssured.port = SERVER_PORT;
        RestAssured.defaultParser = Parser.JSON;
    }

    @AfterAll
    public static void closeTestServer() {
        EMF_Creator.endREST_TestWithDB();
        httpServer.shutdownNow();
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        j1 = new Joke("A user interface is like a joke. If you have to explain it, "
                + "it's not that good.",
                "https://hackernoon.com/30-jokes-only-programmers-will-get-a901e1cea549",
                "Programmer joke");
        j2 = new Joke("Chuck Norris writes code... that optimizes itself!",
                "https://www.hongkiat.com/blog/programming-jokes/",
                "Programmer joke/Chuck Norris joke");
        j3 = new Joke("A SQL Query goes into a bar, walks up to two tables and asks: "
                + "\"Can I join you?\"", "https://www.hongkiat.com/blog/programming-jokes/",
                "Programmer Joke");

        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.persist(j1);
            em.persist(j2);
            em.persist(j3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Test
    public void testServerConnection() {
        given().when()
                .get("/joke").
                then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("msg", is("Hello World"));
    }

    /**
     * Test of getAll method, of class JokeResource.
     */
    @Test
    public void testGetAll() {
        given().when()
                .get("/joke/all").
                then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("", hasSize(3))
                .body("joke", hasItems(j1.getJoke(), j2.getJoke(), j3.getJoke()))
                .body("reference", hasItems(j1.getReference(), j2.getReference(),
                        j3.getReference()))
                .body("type", hasItems(j1.getType(), j2.getType(), j3.getType()));
    }

    /**
     * Test of getById method, of class JokeResource.
     */
    @Test
    public void testGetById() {
        given().when()
                .get("/joke/{id}", j1.getId()).
                then()
                .assertThat()
                .statusCode(HttpStatus.OK_200.getStatusCode())
                .body("joke", is(j1.getJoke()))
                .body("reference", is(j1.getReference()))
                .body("type", is(j1.getType()));
    }

    /**
     * Test of getById method with wrong id, of class JokeResource.
     */
    @Test
    public void testGetById_wrongId() {
        given().when()
                .get("/joke/{id}", Integer.MAX_VALUE).
                then()
                .assertThat()
                .statusCode(404)
                .body("code", is(404))
                .body("msg", is("Movie not found"));
    }

    /**
     * Test of getRandom method, of class JokeResource.
     */
    @Test
    public void testGetRandom() {
        List<JokeDTO> jokes = new ArrayList<>();
        jokes.add(new JokeDTO(j1));
        jokes.add(new JokeDTO(j2));
        jokes.add(new JokeDTO(j3));
        List<JokeDTO> randomJokes = new ArrayList<>();
        
        boolean allJokesFound = false;
        while (!allJokesFound) {
            randomJokes.add(given()
                    .get("joke/random").
                    then()
                    .assertThat()
                    .statusCode(HttpStatus.OK_200.getStatusCode()).
                    extract()
                    .as(JokeDTO.class));
            
            if(randomJokes.containsAll(jokes)) {
                allJokesFound = true;
            }
        }
    }

}
