/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;

/**
 *
 * @author kieum
 */
public class Product {
    private int id;
    private int categoriesID;
    private String Name;
    private String brand;
    private int yearProduce;
    private float unitPrice;
    private int quantity;
    private Image picture;

    public Product(int id, int categoriesID, String Name, String brand, int yearProduce, float unitPrice, int quantity, Image picture) {
        this.id = id;
        this.categoriesID = categoriesID;
        this.Name = Name;
        this.brand = brand;
        this.yearProduce = yearProduce;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public int getCategoriesID() {
        return categoriesID;
    }

    public String getName() {
        return Name;
    }

    public String getBrand() {
        return brand;
    }

    public int getYearProduce() {
        return yearProduce;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public Image getPicture() {
        return picture;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
