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
public class Employee {
    private int id;
    private String name;
    private int yearOB;
    private String address;
    private String phone;
    private String email;
    private String username;

    public Employee(int id, String name, int yearOB, String address, String phone, String email, String username) {
        this.id = id;
        this.name = name;
        this.yearOB = yearOB;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearOB() {
        return yearOB;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    
}
