/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ManagementProcess;
import Model.Account;
import Model.Employee;
import Model.DBConnection;
import Model.Employee;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieum
 */
public class frmEmployeeMgr extends javax.swing.JFrame {
    ManagementProcess manager;
    ArrayList<Employee> listEmployee;
    ArrayList<Employee> currentlistEmployee;

    /**
     * Creates new form frmEmployeeMgr
     */
    public frmEmployeeMgr() {
        initComponents();
        initConnection();
        listEmployee=manager.getEmployee();
        currentlistEmployee=(ArrayList<Employee>) listEmployee.clone();
        try {
            initTable();
        } catch (SQLException ex) {
            Logger.getLogger(frmEmployeeMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
        tbEmployee.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tbEmployee.getSelectedRow()!=-1) {
                    Employee cus=currentlistEmployee.get(tbEmployee.getSelectedRow());
                    try {
                        fillData(cus);
                    } catch (SQLException ex) {
                        Logger.getLogger(frmEmployeeMgr.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        });
        if (currentlistEmployee.size()>0) {
            tbEmployee.setRowSelectionInterval(0, 0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        btEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPass = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmployee = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btAdd = new javax.swing.JButton();
        chooseYear = new com.toedter.calendar.JYearChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Employee Name:");

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Address:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Email:");

        txtUser.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Username:");

        txtPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Password:");

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        tbEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Customer ID", "Customer Name", "Company Name", "Company Address", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmployee.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbEmployee);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Manager");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Employee ID:");

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Year of Birth:");

        txtSdt.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSearch.setText("Search");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Phone Number:");

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chooseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(123, 123, 123)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btSearch)
                                .addGap(0, 91, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                            .addComponent(txtUser)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btAdd)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                        .addComponent(btEdit)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                        .addComponent(btDelete)
                                        .addGap(24, 24, 24))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chooseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btAdd)
                            .addComponent(btDelete)
                            .addComponent(btEdit)
                            .addComponent(jLabel9)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            Employee em=currentlistEmployee.get(tbEmployee.getSelectedRow());
            if (checkUser(txtUser.getText().trim(),em,"EDIT")) {
                if (manager.updateAccount(em.getUsername(), new Account(txtUser.getText().trim(), txtPass.getText(), tbEmployee.getValueAt(tbEmployee.getSelectedRow(),5).toString()))) {
                    if (manager.updateEmployee(em.getId(), new Employee(Integer.parseInt(txtID.getText().trim()), txtName.getText().trim(), chooseYear.getYear(), txtAddress.getText(), txtSdt.getText().trim(), txtEmail.getText().trim(), txtUser.getText().trim()))) {
                        JOptionPane.showMessageDialog(this, "Update employee successful!");
                        new frmEmployeeMgr().setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Can't upadate info employee!\n User/password updated!");
                        new frmEmployeeMgr().setVisible(true);
                        this.dispose();
                    }
                }else
                JOptionPane.showMessageDialog(this, "Can't use this account!!");

            }else
            JOptionPane.showMessageDialog(this, "This username exist!");
        } catch (SQLException ex) {
            Logger.getLogger(frmEmployeeMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btEditActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        // TODO add your handling code here:
        if (manager.deleteData(Integer.parseInt(txtID.getText().trim()), "DELETE_Employee")) {
            JOptionPane.showMessageDialog(this, "Delete Employee successful!");
            new frmEmployeeMgr().setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Can't delete Employee!");
        }

    }//GEN-LAST:event_btDeleteActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        Object[] ob= new Object[]{"ADMIN","SELLER"};
        int type=JOptionPane.showOptionDialog(this,"Choose type of Employee!","Type employee",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null, ob,ob[0]);
        if (type==0) {
            addProcess("AD");
        }else if(type==1)
            addProcess("SE");
    }//GEN-LAST:event_btAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmEmployeeMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmployeeMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmployeeMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmployeeMgr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmployeeMgr().setVisible(true);
            }
        });
    }
    private void initTable() throws SQLException{
        tbEmployee.removeAll();
        DefaultTableModel model= new DefaultTableModel(new Object [][]{},new String [] {"Employee ID", "Employee Name", "Year of Birth", "Address", "Phone","Account Type"});
        for (Employee em: currentlistEmployee) {
            String type=manager.getAccountType(em.getUsername());
            model.addRow(new Object[]{String.valueOf(em.getId()),em.getName(),em.getYearOB(),em.getAddress(),em.getPhone(),type});
        }
        tbEmployee.setModel(model);
    }
    private void initConnection(){
        Connection conn=new DBConnection().getConnection();
        manager=new ManagementProcess(conn);
    }
    private void fillData(Employee em) throws SQLException{
        txtID.setText(String.valueOf(em.getId()));
        txtName.setText(em.getName());
        chooseYear.setYear(em.getYearOB());
        txtAddress.setText(em.getAddress());
        txtSdt.setText(em.getPhone());
        txtEmail.setText(em.getEmail());
        txtUser.setText(em.getUsername());
        txtPass.setText(manager.getPass(em.getUsername()));
    }
    private boolean checkUser(String user,Employee oEm,String type) throws SQLException{
        if (type.equals("EDIT")) {
            if (user.equals(oEm.getUsername())) {
                return true;
            } else {
                ArrayList<String> lstUser = manager.getAllUser();
                for (String str : lstUser) {
                    if (str.equals(user)) {
                        return false;
                    }
                }
                return true;
            }
        }else if (type.equals("ADD")) {
                ArrayList<String> lstUser = manager.getAllUser();
                for (String str : lstUser) {
                    if (str.equals(user)) {
                        return false;
                    }
                }
                return true;
        }else
            return false;
        
    }
    private void addProcess(String type){
        String user=txtUser.getText().trim();
        String pass=txtPass.getText().trim();  
        try {
            if (checkUser(txtUser.getText().trim(),currentlistEmployee.get(tbEmployee.getSelectedRow()),"ADD")) {
                if (manager.insertAccount(new Account(user,pass,type))) {
                    if (manager.insertEmployee(new Employee(Integer.parseInt(txtID.getText().trim()), txtName.getText().trim(), chooseYear.getYear(), txtAddress.getText(), txtSdt.getText().trim(), txtEmail.getText().trim(), txtUser.getText().trim()))) {
                        JOptionPane.showMessageDialog(this, "Add Employee successful!");
                        new frmEmployeeMgr().setVisible(true);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Can't add new Employee!");
                    }
                } else {
                    if (manager.updateAccount(user, new Account(user, pass, type))) {
                        if (manager.insertEmployee(new Employee(Integer.parseInt(txtID.getText().trim()), txtName.getText().trim(), chooseYear.getYear(), txtAddress.getText(), txtSdt.getText().trim(), txtEmail.getText().trim(), txtUser.getText().trim()))) {
                            JOptionPane.showMessageDialog(this, "Add Employee successful!");
                            new frmEmployeeMgr().setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Can't add new Employee!");
                        }
                    }else
                        JOptionPane.showMessageDialog(this, "Can't add new Employee!");
                    
                }

            }else
                JOptionPane.showMessageDialog(this, "This username exist!");
        } catch (SQLException ex) {
            Logger.getLogger(frmEmployeeMgr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSearch;
    private com.toedter.calendar.JYearChooser chooseYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbEmployee;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
