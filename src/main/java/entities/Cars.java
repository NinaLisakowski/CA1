package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author rando
 */
@Entity
public class Cars implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long year;
    private String make;
    private String model;
    private String owner;
    private String vinNR;
    private int price;

    //Constructors
    public Cars(Long year, String make, String model, String owner, String vinNR, int price) {
        this.year = year;
        this.make = make;
        this.model = model;
        this.owner = owner;
        this.vinNR = vinNR;
        this.price = price;
    }

    //Default costructor
    public Cars() {
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getVinNR() {
        return vinNR;
    }

    public void setVinNR(String vinNR) {
        this.vinNR = vinNR;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cars{" + "id=" + id + ", year=" + year + ", make=" + make + ", model=" + model + ", owner=" + owner + ", vinNR=" + vinNR + ", price=" + price + '}';
    }

}
