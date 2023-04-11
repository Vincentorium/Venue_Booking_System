/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ict.bean;
import java.io.Serializable;

/**
 *
 * @author Vincent
 */
public class Phone implements Serializable {
    private String name;
    private String img;
    private double price;
   
    public Phone() {
    }

    public Phone(String name, String img, double price) {
        this.name = name;
        this.img = img;
        this.price = price;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
 
    

}
