/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.CarsDTO;
import entities.Cars;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import utils.EMF_Creator;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

/**
 *
 * @author rando
 */
public class CarsFacadeTest {

    private static EntityManagerFactory emf;
    private static CarsFacade facade;
    private Cars c1;
    private Cars c2;

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = CarsFacade.getCarsFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        c1 = new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000);
        c2 = new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500);
        try {
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Cars").executeUpdate();
            em.persist(c1);
            em.persist(c2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }
    
    @Test
    public void testGetAllCars(){
        List<CarsDTO> cars = facade.getAllCars();
        assertThat(cars, everyItem(hasProperty("model")));
    }

    /**
     * Test of createCars method, of class CarsFacade.
     */
    @Test
    public void testCreateCars() {
        System.out.println("createCars");
        Long year = 3050L;
        String make = "MakeCar";
        String model = "ModelCar";
        String owner = "OwnerCar";
        String vin = "VINNumberCar";
        int price = 10;
        Cars car = facade.createCars(year, make, model, owner, vin, price);
        assertEquals(3, facade.getAllCars().size());
        }

    /**
     * Test of populateDB method, of class CarsFacade.
     */
    @Test
    public void testPopulateDB() {
        System.out.println("populateDB");
        facade.populateDB();
        assertEquals(7, facade.getAllCars().size());
    }
}
