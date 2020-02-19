package entities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;

/**
 *
 * @author rando
 */
public class CarsTest {

    private Cars c1 = new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000);
    private Cars c2 = new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500);

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void cleanup() {
        c1 = new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000);
        c2 = new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500);
    }

    /**
     * Test of getId method, of class Cars.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Long expId = null;
        Long actualId = c1.getId();
        assertEquals(expId, actualId);
    }

    /**
     * Test of setId method, of class Cars.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Long expId = id;
        c2.setId(id);
        Long actualId = c2.getId();
        assertEquals(expId, actualId);
    }

    /**
     * Test of getYear method, of class Cars.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Long expYear = 2000L;
        Long actualYear = c1.getYear();
        assertEquals(expYear, actualYear);
    }

    /**
     * Test of setYear method, of class Cars.
     */
    @Test
    public void testSetYear() {
        System.out.println("setYear");
        Long year = 853L;
        Long expYear = year;
        c2.setYear(year);
        Long actualYear = c2.getYear();
        assertEquals(expYear, actualYear);
    }

    /**
     * Test of getMake method, of class Cars.
     */
    @Test
    public void testGetMake() {
        System.out.println("getMake");
        String expMake = "Ford";
        String actualMake = c1.getMake();
        assertEquals(expMake, actualMake);
    }

    /**
     * Test of setMake method, of class Cars.
     */
    @Test
    public void testSetMake() {
        System.out.println("setMake");
        String make = "Make?";
        String expMake = make;
        c2.setMake(make);
        String actualMake = c2.getMake();
        assertEquals(expMake, actualMake);
    }

    /**
     * Test of getModel method, of class Cars.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        String expModel = "FordModel1";
        String actualModel = c1.getModel();
        assertEquals(expModel, actualModel);
    }

    /**
     * Test of setModel method, of class Cars.
     */
    @Test
    public void testSetModel() {
        System.out.println("setModel");
        String model = "NewModelSet";
        String expModel = model;
        c2.setModel(model);
        String actualModel = c2.getModel();
        assertEquals(expModel, actualModel);
    }

    /**
     * Test of getPrice method, of class Cars.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        int expPrice = 5000;
        int actualPrice = c1.getPrice();
        assertEquals(expPrice, actualPrice);
    }

    /**
     * Test of setPrice method, of class Cars.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        int price = 753951;
        int expPrice = price;
        c2.setPrice(price);
        int actualPrice = c2.getPrice();
        assertEquals(expPrice, actualPrice);
    }

    /**
     * Test of getVinNr method, of class Cars.
     */
    @Test
    public void testGetVinNR() {
        System.out.println("getVinNR");
        String expVinNr = "VinNumberTest1";
        String actualVinNr = c1.getVinNR();
        assertEquals(expVinNr, actualVinNr);
    }

    /**
     * Test of setVinNr method, of class Cars.
     */
    @Test
    public void testSetVinNR() {
        System.out.println("setVinNR");
        String vinNr = "NewVinRegistry";
        String expVinNr = vinNr;
        c2.setVinNR(vinNr);
        String actualVinNr = c2.getVinNR();
        assertEquals(expVinNr, actualVinNr);
    }

    /**
     * Test of getOwner method, of class Cars.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        String expOwner = "TestOwner1";
        String actualOwner = c1.getOwner();
        assertEquals(expOwner, actualOwner);
    }

    /**
     * Test of setOwner method, of class Cars.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        String owner = "NewTestOwner";
        String expOwner = owner;
        c2.setOwner(owner);
        String actualOwner = c2.getOwner();
        assertEquals(expOwner, actualOwner);
    }

}
