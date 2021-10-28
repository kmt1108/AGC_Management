/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Account;
import Model.BillInfo;
import Model.BillProduct;
import Model.Categories;
import Model.Customer;
import Model.Employee;
import Model.ImportProduct;
import Model.Order;
import Model.Product;
import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author kieum
 */
public class ManagementProcess {
    Connection conn;
    CallableStatement stmt;
    public ManagementProcess(Connection conn) {
        this.conn = conn;
    }
    public ArrayList<Employee> getEmployee(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Employee> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Employee}");
            rs=stmt.executeQuery();
            list =new ArrayList<>();
            while (rs.next()) {
                Employee em=new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                list.add(em);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Employee getSingleEmployee(String username){
        
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from AGC_Employee where username='"+username+"'");
            while (rs.next()) {
                Employee em=new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                return em;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Product getSingleProduct(int id){
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from AGC_Product where productID="+id);
            while (rs.next()) {
                Image img=ImageIO.read(rs.getBinaryStream(8));
                Product pro=new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getInt(7), img);
                return pro;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Categories> getCategories(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Categories> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Categories}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                Categories cate=new Categories(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Customer> getCustomer(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Customer> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Customer}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                Customer cus=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).trim(), rs.getString(6), rs.getString(7));
                list.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public Customer getSingleCustomer(String username){
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from AGC_Customer where username='"+username+"'");
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).trim(), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Customer getSingleCustomerFromID(int id){
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery("select * from AGC_Customer where customerID="+id);
            while (rs.next()) {
                return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5).trim(), rs.getString(6), rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Product> getProduct(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Product> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Product}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                Image img=ImageIO.read(rs.getBinaryStream(8));
                Product pr=new Product(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getFloat(6), rs.getInt(7), img);
                list.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<ImportProduct> getImport(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<ImportProduct> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Import}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                ImportProduct imp =new ImportProduct(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getFloat(7));
                list.add(imp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Order> getOrder1(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Order> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Order}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                Order o=new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Integer> getOrder(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Integer> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Order}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Order> getOrderForCustomer(int cusID){
        stmt=null;
        ResultSet rs=null;
        ArrayList<Order> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_OrderForCustomer(?)}");
            stmt.setInt(1, cusID);
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                Order o=new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
                list.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<BillInfo> getBill(){
        stmt=null;
        ResultSet rs=null;
        ArrayList<BillInfo> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Bill}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                BillInfo bill=new BillInfo(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4));
                list.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<BillInfo> getBillForCustomer(int cusID){
        stmt=null;
        ResultSet rs=null;
        ArrayList<BillInfo> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_Bill}");
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                if (rs.getInt(4)==cusID) {
                    BillInfo bill=new BillInfo(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getInt(4));
                    list.add(bill);
                }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<BillProduct> getBillProduct(int bilID){
        stmt=null;
        ResultSet rs=null;
        ArrayList<BillProduct> list=null;
        try {
            stmt=conn.prepareCall("{CALL GET_BillProduct(?)}");
            stmt.setInt(1, bilID);
            rs=stmt.executeQuery();
            list=new ArrayList<>();
            while (rs.next()) {
                BillProduct product=new BillProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getBoolean(4));
                list.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> getAllUser() throws SQLException{
        ArrayList<String> lst=new ArrayList<>();
        Statement stm=conn.createStatement();
        ResultSet rs=stm.executeQuery("Select username from AGC_Account");
        while (rs.next()) {
            lst.add(rs.getString(1));
        }
        return lst;
    }
    public String getPass(String user) throws SQLException{
        ArrayList<String> lst=new ArrayList<>();
        Statement stm=conn.createStatement();
        ResultSet rs=stm.executeQuery("Select password from AGC_Account where username='"+user+"'");
        while (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
    public String getAccountType(String user) throws SQLException{
        ArrayList<String> lst=new ArrayList<>();
        Statement stm=conn.createStatement();
        ResultSet rs=stm.executeQuery("Select accountType from AGC_Account where username='"+user+"'");
        while (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
    public boolean insertAccount(Account acc){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Account(?,?,?)}");
            stmt.setString(1,acc.getUsername());
            stmt.setString(2,acc.getPassword());
            stmt.setString(3, acc.getAccountType());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertCategories(Categories cate){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Categories(?,?,?)}");
            stmt.setInt(1,cate.getId());
            stmt.setString(2,cate.getName());
            stmt.setString(3, cate.getDescription());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertEmployee(Employee em){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Employee(?,?,?,?,?,?,?)}");
            stmt.setInt(1,em.getId());
            stmt.setString(2,em.getName());
            stmt.setInt(3, em.getYearOB());
            stmt.setString(4, em.getAddress());
            stmt.setString(5, em.getPhone());
            stmt.setString(6, em.getEmail());
            stmt.setString(7, em.getUsername());  
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertCustomer(Customer cus){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Customer(?,?,?,?,?,?,?)}");
            stmt.setInt(1,cus.getId());
            stmt.setString(2,cus.getName());
            stmt.setString(3, cus.getCompanyName());
            stmt.setString(4, cus.getCompanyAddress());
            stmt.setString(5, cus.getContactPhone());
            stmt.setString(6, cus.getContactEmail());
            stmt.setString(7, cus.getUsername());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertProduct(Product pro){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Product(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1,pro.getId());
            stmt.setInt(2, pro.getCategoriesID());
            stmt.setString(3,pro.getName());
            stmt.setString(4, pro.getBrand());
            stmt.setInt(5, pro.getYearProduce());
            stmt.setFloat(6, pro.getUnitPrice());
            stmt.setInt(7, pro.getQuantity());
            stmt.setBinaryStream(8, ISfromPicture(pro.getPicture()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertImportProduct(ImportProduct im){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Import(?,?,?,?,?,?,?)}");
            stmt.setInt(1,im.getId());
            Date date=im.getDate();
            java.sql.Date d=new java.sql.Date(date.getTime());
            stmt.setDate(2,d);
            stmt.setInt(3, im.getEmployeeID());
            stmt.setInt(4, im.getCustomerID());
            stmt.setInt(5, im.getProductID());
            stmt.setInt(6, im.getQuantity());
            stmt.setFloat(7,im.getTotalPrice());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertBill(BillInfo bill){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_Bill(?,?,?,?)}");
            stmt.setInt(1,bill.getId());
            Date date=bill.getDate();
            java.sql.Date d=new java.sql.Date(date.getTime());
            stmt.setDate(2,d);
            stmt.setInt(3, bill.getEmployeeID());
            stmt.setInt(4, bill.getCustomerID());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean insertBillProduct(BillProduct product){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL INSERT_BillProduct(?,?,?,?)}");
            stmt.setInt(1,product.getBillID());
            stmt.setInt(2,product.getProductID());
            stmt.setInt(3,product.getQuantity());
            stmt.setBoolean(4, product.isIsSetup());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean updateAccount(String oUser,Account acc){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_Account(?,?,?,?)}");
            stmt.setString(1,oUser);
            stmt.setString(2,acc.getUsername());
            stmt.setString(3,acc.getPassword());
            stmt.setString(4, acc.getAccountType());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateCategories(int oid,Categories cate){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_Categories(?,?,?,?)}");
            stmt.setInt(1,oid);
            stmt.setInt(2,cate.getId());
            stmt.setString(3,cate.getName());
            stmt.setString(4, cate.getDescription());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateEmployee(int oid,Employee em){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_Employee(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1, oid);
            stmt.setInt(2,em.getId());
            stmt.setString(3,em.getName());
            stmt.setInt(4, em.getYearOB());
            stmt.setString(5, em.getAddress());
            stmt.setString(6, em.getPhone());
            stmt.setString(7, em.getEmail());
            stmt.setString(8, em.getUsername());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    } 
    public boolean updateCustomer(int oid,Customer cus){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_Customer(?,?,?,?,?,?,?,?)}");
            stmt.setInt(1,oid);
            stmt.setInt(2,cus.getId());
            stmt.setString(3,cus.getName());
            stmt.setString(4, cus.getCompanyName());
            stmt.setString(5, cus.getCompanyAddress());
            stmt.setString(6, cus.getContactPhone());
            stmt.setString(7, cus.getContactEmail());
            stmt.setString(8, cus.getUsername());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateProduct(int oid,Product pro){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_Product(?,?,?,?,?,?,?,?,?)}");
            stmt.setInt(1,oid);
            stmt.setInt(2,pro.getId());
            stmt.setInt(3, pro.getCategoriesID());
            stmt.setString(4,pro.getName());
            stmt.setString(5, pro.getBrand());
            stmt.setInt(6, pro.getYearProduce());
            stmt.setFloat(7, pro.getUnitPrice());
            stmt.setInt(8, pro.getQuantity());
            stmt.setBinaryStream(9, ISfromPicture(pro.getPicture()));
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateOrder(Order oOrder,int quantity,boolean setup){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL UPDATE_OrderForCustomer(?,?,?,?,?)}");
            stmt.setInt(1,oOrder.getCustomerID());
            stmt.setInt(2,oOrder.getProductID());
            stmt.setBoolean(3, oOrder.isIsSetup());
            stmt.setInt(4,quantity);
            stmt.setBoolean(5, setup);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean deleteData(int id,String procName){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL "+procName+"(?)}");
            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public boolean deleteOrderForCustomer(Order order){
        stmt=null;
        try {
            stmt=conn.prepareCall("{CALL DELETE_OrderForCustomer(?,?,?)}");
            stmt.setInt(1, order.getCustomerID());
            stmt.setInt(2, order.getProductID());
            stmt.setBoolean(3, order.isIsSetup());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     public boolean deleteOrderForEmployee(int customerID){
         stmt=null;
        try {
            stmt=conn.prepareCall("{CALL DELETE_OrderForEmployee(?)}");
            stmt.setInt(1, customerID);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
     }
    
    public String loginProcess(String user,String pass){
        try {
            PreparedStatement stm=conn.prepareStatement("select * from AGC_Account where username=? and password=?");
            stm.setString(1,user);
            stm.setString(2, pass);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                return rs.getString(3);
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insertOrder( Order order){
        try {
            PreparedStatement stmt=conn.prepareCall("Insert into AGC_Order values(?,?,?,?)");
            stmt.setInt(1, order.getCustomerID());
            stmt.setInt(2, order.getProductID());
            stmt.setInt(3, order.getQuantity());
            stmt.setBoolean(4, order.isIsSetup());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    private InputStream ISfromPicture(Image img){
        InputStream fis=null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write((RenderedImage) img, "png", os);
            fis = new ByteArrayInputStream(os.toByteArray());
        } catch (IOException ex) {
            Logger.getLogger(ManagementProcess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fis;
    }
    
    
    
    
    
}
