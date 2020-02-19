/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Cars;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rando
 */
public class CarsDTOConversionTest {

    /**
     * Test of convertFromNormalToDTO method, of class CarsDTOConversion.
     */
    @Test
    public void testConvertFromNormalToDTO() {
        System.out.println("convertFromNormalToDTO");
        CarsDTOConversion convert = new CarsDTOConversion();
        Cars c1 = new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000);
        Cars c2 = new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500);
        List<Cars> carList = new ArrayList();
        carList.add(c1);
        carList.add(c2);
        
        CarsDTO c1DTO = new CarsDTO(new Cars(2000L, "Ford", "FordModel1", "TestOwner1", "VinNumberTest1", 5000));
        CarsDTO c2DTO = new CarsDTO(new Cars(1995L, "VW", "VWModel1", "TestOwner2", "VinNumberTest2", 2500));
        List<CarsDTO> carDTOList = new ArrayList();
        carDTOList.add(c1DTO);
        carDTOList.add(c2DTO);
        
        List<CarsDTO> expCarDTOList = carDTOList;
        List<CarsDTO> actualCarDTOList = convert.convertFromNormalToDTO(carList);
        assertEquals(expCarDTOList.toString(), actualCarDTOList.toString());
    }
    
}
