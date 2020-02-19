package entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "GroupMember.deleteAllRows", query = "DELETE from GroupMember")
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String studentid;
    private String favouriteColour;
    private String favouriteAnimal;
    private String eyeColour;
    private int height;
    private int shoeSize;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public void setFavouriteColour(String favouriteColour) {
        this.favouriteColour = favouriteColour;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public void setFavouriteAnimal(String favouriteAnimal) {
        this.favouriteAnimal = favouriteAnimal;
    }

    public String getEyeColor() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColor) {
        this.eyeColour = eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public GroupMember() {
    }

    public GroupMember(String name, String studentid, String favouriteColour, String favouriteAnimal, String eyeColor, int height, int shoeSize) {
        this.name = name;
        this.studentid = studentid;
        this.favouriteColour = favouriteColour;
        this.favouriteAnimal = favouriteAnimal;
        this.eyeColour = eyeColor;
        this.height = height;
        this.shoeSize = shoeSize;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.studentid);
        hash = 67 * hash + Objects.hashCode(this.favouriteColour);
        hash = 67 * hash + Objects.hashCode(this.favouriteAnimal);
        hash = 67 * hash + Objects.hashCode(this.eyeColour);
        hash = 67 * hash + this.height;
        hash = 67 * hash + this.shoeSize;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GroupMember other = (GroupMember) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.height != other.height) {
            return false;
        }
        if (this.shoeSize != other.shoeSize) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.studentid, other.studentid)) {
            return false;
        }
        if (!Objects.equals(this.favouriteColour, other.favouriteColour)) {
            return false;
        }
        if (!Objects.equals(this.favouriteAnimal, other.favouriteAnimal)) {
            return false;
        }
        if (!Objects.equals(this.eyeColour, other.eyeColour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GroupMember{" + "id=" + id + ", name=" + name + ", studentid=" + studentid + ", favouriteColour=" + favouriteColour + ", favouriteAnimal=" + favouriteAnimal + ", eyeColor=" + eyeColour + ", height=" + height + ", shoeSize=" + shoeSize + '}';
    }
   
}
