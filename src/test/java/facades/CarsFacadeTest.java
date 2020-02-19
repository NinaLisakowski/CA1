///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facades;
//
//import dto.CarsDTO;
//import entities.Cars;
//import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import utils.EMF_Creator;
//import utils.EMF_Creator.DbSelector;
//import utils.EMF_Creator.Strategy;
//
///**
// *
// * @author rando
// */
//public class CarsFacadeTest {
//
//    private static EntityManagerFactory emf;
//    private static CarsFacade facade;
//    private Cars c1;
//    private Cars c2;
//
//    @BeforeAll
//    public static void setUpClass() {
//        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
//        facade = CarsFacade.getCarsFacade(emf);
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//
//    // Setup the DataBase in a known state BEFORE EACH TEST
//    //TODO -- Make sure to change the script below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        c1 = new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000);
//        c2 = new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500);
//        try {
//            em.getTransaction().begin();
//            em.createQuery("DELETE FROM Cars").executeUpdate();
//            em.persist(c1);
//            em.persist(c2);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
////        Remove any data after each test was run
//    }
//
//    /**
//     * Test of createCars method, of class CarsFacade.
//     */
//    @Test
//    public void testCreateCars() {
//        System.out.println("createCars");
//        Long year = 0L;
//        String make = "";
//        String model = "";
//        String owner = "";
//        String vin = "";
//        int price = 0;
//        CarsFacade instance = null;
//        Cars expResult = null;
//        Cars result = instance.createCars(year, make, model, owner, vin, price);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCarByID method, of class CarsFacade.
//     */
//    @Test
//    public void testGetCarByID() {
//        System.out.println("getCarByID");
//        CarsDTO car = facade.getCarByID(c1.getId());
//        assertEquals(car.getYear(), c1.getYear());
//    }
//
//    /**
//     * Test of getCarByYear method, of class CarsFacade.
//     */
//    @Test
//    public void testGetCarByYear() {
//        System.out.println("getCarByYear");
//        CarsDTO car = facade.getCarByYear(c1.getYear());
//        assertEquals(car.getId(), c1.getId());
//    }
//
//    /**
//     * Test of getCarByMake method, of class CarsFacade.
//     */
//    @Test
//    public void testGetCarByMake() {
//        System.out.println("getCarByMake");
//        String make = "";
//        CarsFacade instance = null;
//        CarsDTO expResult = null;
//        CarsDTO result = instance.getCarByMake(make);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCarByModel method, of class CarsFacade.
//     */
//    @Test
//    public void testGetCarByModel() {
//        System.out.println("getCarByModel");
//        String model = "";
//        CarsFacade instance = null;
//        CarsDTO expResult = null;
//        CarsDTO result = instance.getCarByModel(model);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCarByPrice method, of class CarsFacade.
//     */
//    @Test
//    public void testGetCarByPrice() {
//        System.out.println("getCarByPrice");
//        int price = 0;
//        CarsFacade instance = null;
//        CarsDTO expResult = null;
//        CarsDTO result = instance.getCarByPrice(price);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllCars method, of class CarsFacade.
//     */
//    @Test
//    public void testGetAllCars() {
//        System.out.println("getAllCars");
//        CarsFacade instance = null;
//        List<CarsDTO> expResult = null;
//        List<CarsDTO> result = instance.getAllCars();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of populateDB method, of class CarsFacade.
//     */
//    @Test
//    public void testPopulateDB() {
//        System.out.println("populateDB");
//        CarsFacade instance = null;
//        instance.populateDB();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//}
