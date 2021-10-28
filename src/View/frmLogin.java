/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ManagementProcess;
import Model.Account;
import Model.Customer;
import Model.DBConnection;
import Model.Employee;
import java.awt.event.WindowListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author kieum
 */
public class frmLogin extends javax.swing.JFrame {

    private Connection conn;
    private ManagementProcess manager;

    /**
     * Creates new form frmLogin
     */
    public frmLogin() {
        initComponents();
        conn = new DBConnection().getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Unable connect to server!", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            manager = new ManagementProcess(conn);
        }
    }

    public frmLogin(Account account) {
        initComponents();
        conn = new DBConnection().getConnection();
        if (conn == null) {
            JOptionPane.showMessageDialog(this, "Unable connect to server!", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            manager = new ManagementProcess(conn);
        }
        cbIsEmployee.setSelected(!account.getAccountType().equals("CU"));
        txtUsername.setText(account.getUsername());
//To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        cbIsEmployee = new javax.swing.JCheckBox();
        btSignin = new javax.swing.JButton();
        btClear = new javax.swing.JButton();
        btSignup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Login to AGC Management");

        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Username:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Password:");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        cbIsEmployee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbIsEmployee.setText("You are employee of AGC?");

        btSignin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSignin.setText("Sign in");
        btSignin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSigninActionPerformed(evt);
            }
        });

        btClear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btClear.setText("Clear");
        btClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClearActionPerformed(evt);
            }
        });

        btSignup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSignup.setText("Sign up?");
        btSignup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSignupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbIsEmployee)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btSignin)
                            .addGap(18, 18, 18)
                            .addComponent(btClear)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSignup))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addGap(35, 35, 35)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbIsEmployee)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSignin)
                    .addComponent(btClear)
                    .addComponent(btSignup))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSigninActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSigninActionPerformed
        // TODO add your handling code here:
        String user = txtUsername.getText().trim();
        String pass = txtPassword.getText().trim();
        if (conn != null) {
            if (cbIsEmployee.isSelected()) {
                String rs = manager.loginProcess(txtUsername.getText(), txtPassword.getText());
                if (rs != null) {
                    Employee em = manager.getSingleEmployee(user);
                    if (rs.equals("AD") && em != null) {
                        JOptionPane.showMessageDialog(this, "Login admin successful! Name: " + em.getName());
                        new frmForEmoloyee(true, em).setVisible(true);
                        this.dispose();
                    }
                    if (rs.equals("SE") && em != null) {
                        JOptionPane.showMessageDialog(this, "Login seller successful! Name: " + em.getName());
                        new frmForEmoloyee(false, em).setVisible(true);
                        this.dispose();
                    }
                    if (rs.equals("CU")) {
                        JOptionPane.showMessageDialog(this, "Please check username/password and try agian!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Please check username/password and try agian!", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                String rs = manager.loginProcess(user, pass);
                if (rs != null) {
                    if (rs.equals("CU")) {
                        Customer cus = manager.getSingleCustomer(user);
                        if (cus != null) {
                            JOptionPane.showMessageDialog(this, "Login customer successful! Name: " + cus.getName());
                            new frmForCustomer(cus).setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(this, "Can't reacht infomation of Customer!", "Error!", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Please check your username/password!", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please check username/password and try agian!", "Error!", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

    }//GEN-LAST:event_btSigninActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
        btSignin.doClick();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
        txtPassword.requestFocus();
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClearActionPerformed
        // TODO add your handling code here:
        txtUsername.setText("");
        txtPassword.setText("");
        cbIsEmployee.setSelected(false);
    }//GEN-LAST:event_btClearActionPerformed

    private void btSignupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignupActionPerformed
        // TODO add your handling code here:
        JOptionPane.showOptionDialog(this, "You are?", "Sign up", JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null, new Object[]{"Employee","Customer"},"Employee");
    }//GEN-LAST:event_btSignupActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClear;
    private javax.swing.JButton btSignin;
    private javax.swing.JButton btSignup;
    private javax.swing.JCheckBox cbIsEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}