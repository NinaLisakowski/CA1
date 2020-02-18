/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.GroupMember;

/**
 *
 * @author allan
 */
public class GroupMemberDTO {

    private int id;
    private String name;
    private String studentid;
    private String favouriteColour;
    private String favouriteAnimal;
    private String eyeColor;
    private int height;
    private int shoeSize;

    public GroupMemberDTO(GroupMember gm) {
        this.id = gm.getId();
        this.name = gm.getName();
        this.studentid = gm.getStudentid();
        this.favouriteColour = gm.getFavouriteColour();
        this.favouriteAnimal = gm.getFavouriteAnimal();
        this.eyeColor = gm.getEyeColor();
        this.height = gm.getHeight();
        this.shoeSize = gm.getShoeSize();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStudentid() {
        return studentid;
    }

    public String getFavouriteColour() {
        return favouriteColour;
    }

    public String getFavouriteAnimal() {
        return favouriteAnimal;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public int getHeight() {
        return height;
    }

    public int getShoeSize() {
        return shoeSize;
    }

    @Override
    public String toString() {
        return "GroupMemberDTO{" + "id=" + id + ", name=" + name + ", studentid=" + studentid + ", favouriteColour=" + favouriteColour + ", favouriteAnimal=" + favouriteAnimal + ", eyeColor=" + eyeColor + ", height=" + height + ", shoeSize=" + shoeSize + '}';
    }
    
    
    
    
}
