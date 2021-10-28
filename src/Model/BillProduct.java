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
public class BillProduct {
    private int billID;
    private int productID;
    private int quantity;
    private boolean isSetup;

    public BillProduct(int billID, int productID, int quantity, boolean isSetup) {
        this.billID = billID;
        this.productID = productID;
        this.quantity = quantity;
        this.isSetup = isSetup;
    }

    public int getBillID() {
        return billID;
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
    
    
}
