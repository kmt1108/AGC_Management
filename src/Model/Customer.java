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
public class Customer {
    private int id;
    private String name;
    private String companyName;
    private String companyAddress;
    private String contactPhone;
    private String contactEmail;
    private String username;

    public Customer(int id, String name, String companyName, String companyAddress, String contactPhone, String contactEmail, String username) {
        this.id = id;
        this.name = name;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.contactPhone = contactPhone;
        this.contactEmail = contactEmail;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getUsername() {
        return username;
    }
    

}