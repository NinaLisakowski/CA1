package dto;

import entities.Cars;

/**
 *
 * @author rando
 */
public class CarsDTO {

    private Long id;
    private Long year;
    private String make;
    private String model;
    private int price;

    //Constructors
    public CarsDTO(Cars car) {
        this.id = car.getId();
        this.year = car.getYear();
        this.make = car.getMake();
        this.model = car.getModel();
        this.price = car.getPrice();
    }

    public CarsDTO() {
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CarsDTO{" + "id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + ", price=" + price + '}';
    }

    
}
