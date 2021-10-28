/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author kieum
 */
public class ImportProduct {
    private int id;
    private Date date;
    private int employeeID;
    private int customerID;
    private int productID;
    private int quantity;
    private float totalPrice;

    public ImportProduct(int id, Date date, int employeeID, int customerID, int productID, int quantity, float totalPrice) {
        this.id = id;
        this.date = date;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
    

    
    
    
}
