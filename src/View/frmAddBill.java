/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ManagementProcess;
import Model.BillInfo;
import Model.BillProduct;
import Model.DBConnection;
import Model.Employee;
import Model.Product;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieum
 */
public class frmAddBill extends javax.swing.JFrame {
    private ManagementProcess manager;
    private ArrayList<BillProduct> listBillProduct=new ArrayList<>();
    private Employee defaultEmployee;

    /**
     * Creates new form frmAddBill
     */
    public frmAddBill() {
        initComponents();
        initConnection();
    }
    public frmAddBill(Employee employee) {
        initComponents();
        initConnection();
        this.defaultEmployee=employee;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addProductDialog = new javax.swing.JDialog();
        txtAddProID = new javax.swing.JTextField();
        txtAddQuantity = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbAddSetup = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btAdd = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBillProduct = new javax.swing.JTable();
        btRemove = new javax.swing.JButton();
        btAdd2 = new javax.swing.JButton();

        addProductDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addProductDialog.setTitle("Add Bill Product");
        addProductDialog.setAlwaysOnTop(true);
        addProductDialog.setMaximumSize(new java.awt.Dimension(400, 300));
        addProductDialog.setMinimumSize(new java.awt.Dimension(400, 300));
        addProductDialog.setResizable(false);

        txtAddProID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtAddQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Input Product ID:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Input Quantity:");

        cbAddSetup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbAddSetup.setText("Set up?");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Cancel");

        javax.swing.GroupLayout addProductDialogLayout = new javax.swing.GroupLayout(addProductDialog.getContentPane());
        addProductDialog.getContentPane().setLayout(addProductDialogLayout);
        addProductDialogLayout.setHorizontalGroup(
            addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addProductDialogLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAddSetup)
                    .addGroup(addProductDialogLayout.createSequentialGroup()
                        .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(26, 26, 26)
                        .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddProID, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(addProductDialogLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(77, 77, 77))
        );
        addProductDialogLayout.setVerticalGroup(
            addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addProductDialogLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAddProID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbAddSetup)
                .addGap(18, 18, 18)
                .addGroup(addProductDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(32, 32, 32))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        btAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Customer ID:");

        btDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btDelete.setText("Delete");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Bill ID:");

        txtCustomerID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setText("Add Bill");

        tbBillProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity", "Set up"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbBillProduct);

        btRemove.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btRemove.setText("Remove");
        btRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRemoveActionPerformed(evt);
            }
        });

        btAdd2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btAdd2.setText("Add Product");
        btAdd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdd2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(244, 244, 244))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btAdd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRemove))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btDelete))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                            .addComponent(txtID))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btRemove)
                    .addComponent(btAdd2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDelete)
                    .addComponent(btAdd))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRemoveActionPerformed
        // TODO add your handling code here:
        int idx=tbBillProduct.getSelectedRow();
        if (idx!=-1) {
            listBillProduct.remove(idx);
            initBillProductTB();
        }
    }//GEN-LAST:event_btRemoveActionPerformed

    private void btAdd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdd2ActionPerformed
        // TODO add your handling code here:
        if (txtID.getText().trim() == null) {
            JOptionPane.showMessageDialog(this, "Input bill ID before!");
        } else {
            try {
                int billID = Integer.parseInt(txtID.getText());
                txtID.setEditable(false);
                addProductDialog.setVisible(true);
                txtAddProID.setText("");
                txtAddQuantity.setText("");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "bill ID is Integer!");
            }
        }
        
    }//GEN-LAST:event_btAdd2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                int billID = Integer.parseInt(txtID.getText());
                if (checkproID(Integer.parseInt(txtAddProID.getText()))) {
                    listBillProduct.add(new BillProduct(billID, Integer.parseInt(txtAddProID.getText().trim()), Integer.parseInt(txtAddQuantity.getText().trim()), cbAddSetup.isSelected()));
                    initBillProductTB();
                    addProductDialog.dispose();
                }
        
        


    }//GEN-LAST:event_jButton1ActionPerformed

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        if (listBillProduct.size()==0||listBillProduct==null) {
            JOptionPane.showMessageDialog(this, "Add least a Product before!");
        }else{
            BillInfo billInfo=new BillInfo(Integer.parseInt(txtID.getText().trim()),new Date(),defaultEmployee.getId(),Integer.parseInt(txtCustomerID.getText().trim()));
            if (manager.insertBill(billInfo)) {
                for (BillProduct billProduct : listBillProduct) {
                    manager.insertBillProduct(billProduct);
                }
                JOptionPane.showMessageDialog(this,"Add bill Conplete!");
            }else
                JOptionPane.showMessageDialog(this,"Add bill error!");  
        }
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
            java.util.logging.Logger.getLogger(frmAddBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAddBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAddBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAddBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAddBill().setVisible(true);
            }
        });
    }
    private void initBillProductTB(){
        tbBillProduct.removeAll();
        DefaultTableModel model=new DefaultTableModel(new Object [][] {},new String [] { "Product ID", "Product Name", "Quantity", "Set up"});
        for (BillProduct pro : listBillProduct) {
            String name=manager.getSingleProduct(pro.getProductID()).getName();
            model.addRow(new Object[]{pro.getProductID(),name,pro.getQuantity(),pro.isIsSetup()});
        }
        tbBillProduct.setModel(model);
    }
    private void initConnection(){
        Connection conn=new DBConnection().getConnection();
        manager=new ManagementProcess(conn);
    }
    private boolean checkproID(int ID){
        if (manager.getSingleProduct(ID)!=null) {
            return true;
        }else
            return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog addProductDialog;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAdd2;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btRemove;
    private javax.swing.JCheckBox cbAddSetup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbBillProduct;
    private javax.swing.JTextField txtAddProID;
    private javax.swing.JTextField txtAddQuantity;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}