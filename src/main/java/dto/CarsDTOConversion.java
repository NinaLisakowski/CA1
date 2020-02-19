package dto;

import entities.Cars;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rando
 */
public class CarsDTOConversion {
    //Converts from regular cars to DOT's
    public List<CarsDTO> convertFromNormalToDTO(List<Cars> carList) {
        List<CarsDTO> listOfCarsDTO;
        listOfCarsDTO = new ArrayList<>();
        carList.forEach((car) -> {
            listOfCarsDTO.add(new CarsDTO(car));
        });
        return listOfCarsDTO;
    }    
}
