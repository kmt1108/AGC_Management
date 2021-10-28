/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kieum
 */
public class Order {
    private int customerID;
    private int productID;
    private int quantity;
    private boolean isSetup;

    public Order(int customerID, int productID, int quantity, boolean isSetup) {
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
        this.isSetup = isSetup;
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

    public boolean isIsSetup() {
        return isSetup;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIsSetup(boolean isSetup) {
        this.isSetup = isSetup;
    }
    
}
