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
public class BillInfo {
    private int id;
    private Date date;
    private int employeeID;
    private int customerID;

    public BillInfo(int id, Date date, int employeeID, int customerID) {
        this.id = id;
        this.date = date;
        this.employeeID = employeeID;
        this.customerID = customerID;
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

    
}
