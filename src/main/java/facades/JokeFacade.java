package facades;

import dtos.JokeDTO;
import dtos.JokeListDTO;
import entities.Joke;
import java.util.List;
import java.util.Random;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author carol
 */
public class JokeFacade {

    private static JokeFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private JokeFacade() {
    }

    public static JokeFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new JokeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<JokeDTO> getAllJokes() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Joke> q = em.createNamedQuery("Joke.getAll", Joke.class);
            return new JokeListDTO(q.getResultList()).getDtoList();
        } finally {
            em.close();
        }
    }

    public Joke getJokeById(int id) {
        EntityManager em = getEntityManager();
        try {
            Joke joke = em.find(Joke.class, id);
            return joke;
        } finally {
            em.close();
        }
    }

    public Joke getRandomJoke() {
        Random ran = new Random();
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Joke> q = em.createNamedQuery("Joke.getAll", Joke.class);
            List<Joke> jokes = q.getResultList();
            Joke joke = jokes.get(ran.nextInt(jokes.size()));
            return joke;
        } finally {
            em.close();
        }
    }
}
