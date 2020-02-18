package facades;

import dtos.JokeDTO;
import entities.Joke;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;

/**
 *
 * @author carol
 */
public class JokeFacadeTest {

    private static EntityManagerFactory emf;
    private static JokeFacade facade;
    private Joke j1;
    private Joke j2;
    private Joke j3;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST,
                EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = JokeFacade.getFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Joke.deleteAllRows").executeUpdate();
            em.getTransaction().commit();
        } finally {
            em.close();
        }
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

    /**
     * Test of getAllJokes method, of class JokeFacade.
     */
    @Test
    public void testGetAllJokes() {
        List<JokeDTO> exp = new ArrayList<>();
        exp.add(new JokeDTO(j1));
        exp.add(new JokeDTO(j2));
        exp.add(new JokeDTO(j3));

        List<JokeDTO> result = facade.getAllJokes();
        assertTrue(result.containsAll(exp));
    }

    /**
     * Test of getJokeById method, of class JokeFacade.
     */
    @Test
    public void testGetJokeById() {
        JokeDTO exp = new JokeDTO(j1);
        JokeDTO result = facade.getJokeById(j1.getId());
        assertEquals(exp, result);
    }

    /**
     * Test of getRandomJoke method, of class JokeFacade.
     */
    @Test
    public void testGetRandomJoke() {
        List<JokeDTO> expList = new ArrayList<>();
        expList.add(new JokeDTO(j1));
        expList.add(new JokeDTO(j2));
        expList.add(new JokeDTO(j3));
        JokeDTO result = facade.getRandomJoke();
        assertTrue(expList.contains(result));
    }

}
