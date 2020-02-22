package facades;

import dto.CarsDTO;
import dto.CarsDTOConversion;
import entities.Cars;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rando
 */
public class CarsFacade {

    private static CarsFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CarsFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CarsFacade getCarsFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CarsFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    //CRUD
    //C:
    public Cars createCars(Long year, String make, String model, String owner, String vin, int price) {
        Cars car = new Cars(year, make, model, owner, vin, price);
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
            return car;
        } finally {
            em.close();
        }
    }

    //R: BY(id, year, make, model, price), (All)
    /*
    public CarsDTO getCarByID(Long id) {
        EntityManager em = getEntityManager();
        try {
            Cars car = em.find(Cars.class, id);
            return new CarsDTO(car);
        } finally {
            em.close();
        }
    }

    public CarsDTO getCarByYear(Long year) {
        EntityManager em = getEntityManager();
        try {
            Cars car = em.find(Cars.class, year);
            return new CarsDTO(car);
        } finally {
            em.close();
        }
    }

    public CarsDTO getCarByMake(String make) {
        EntityManager em = getEntityManager();
        try {
            Cars car = em.find(Cars.class, make);
            return new CarsDTO(car);
        } finally {
            em.close();
        }
    }

    public CarsDTO getCarByModel(String model) {
        EntityManager em = getEntityManager();
        try {
            Cars car = em.find(Cars.class, model);
            return new CarsDTO(car);
        } finally {
            em.close();
        }
    }

    public CarsDTO getCarByPrice(int price) {
        EntityManager em = getEntityManager();
        try {
            Cars car = em.find(Cars.class, price);
            return new CarsDTO(car);
        } finally {
            em.close();
        }
    }
*/
    public List<CarsDTO> getAllCars() {
        EntityManager em = getEntityManager();
        CarsDTOConversion convert = new CarsDTOConversion();
        List<Cars> carList = em.createQuery("SELECT c FROM Cars c").getResultList();
        List<CarsDTO> carListConverted = convert.convertFromNormalToDTO(carList);
        return carListConverted;
    }

    //U: - Update a car.. example could be price.
    //D: - Delete car.

    public void populateDB() {
        EntityManager em = getEntityManager();
        //Add Cars to DB
        Cars c1 = createCars(1997L, "Ford", "E350", "Allan", "1FLHE83KXMN109168", 3000);
        Cars c2 = createCars(1999L, "Chevy", "Venture", "Nina", "2KSOU26QOEK862970", 4900);
        Cars c3 = createCars(2000L, "Chevy", "Venture", "Caroline", "3KQUC61NETB034876", 5000);
        Cars c4 = createCars(1996L, "Jeep", "Grand Cherokee", "Lars", "4NATC25JECP384762", 4799);
        Cars c5 = createCars(2005L, "Volvo", "V70", "Tunoc", "5NECO92NEHD876134", 44799);
        Cars c6 = createCars(2008L, "Lamborghini", "Urus", "Tunoc", "3EKSO64NSBT863279", 1000000);
        Cars c7 = createCars(2016L, "Lamborghini", "Adventadore", "Allan", "8NEBK20NEDO673180", 9999999);
        Cars c8 = createCars(2003L, "Dodge", "Challenger SR3 Hellcat", "Tunoc", "8AUCO64MANC876530", 10);
        Cars c9 = createCars(1201L, "VW", "Golf", "Nina", "9NAVB10LENA013267", 8000);
        Cars c10 = createCars(2003L, "Kia", "Picanto", "Caroline", "7QOCE67UDBR648273", 6000);
    }

}
