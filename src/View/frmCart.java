/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ManagementProcess;
import Model.Customer;
import Model.DBConnection;
import Model.Order;
import Model.Product;
import java.awt.Image;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieum
 */
public class frmCart extends javax.swing.JFrame {
    Customer customer;
    ArrayList<Order> listOrder;
    ManagementProcess manager;
    ArrayList<Product> listProduct;
    /**
     * Creates new form frmCart
     */
    public frmCart() {
        initComponents();
        try {
            Image imgOrder=ImageIO.read(getClass().getResourceAsStream("/Icon/order.png")).getScaledInstance(lbViewOrder.getWidth(), lbViewOrder.getHeight(), Image.SCALE_SMOOTH);
            lbViewOrder.setIcon(new ImageIcon(imgOrder));
        } catch (IOException ex) {
            Logger.getLogger(frmCart.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public frmCart(Customer customer,ArrayList<Order> listOrder) {
        initComponents();
        try {
            Image imgOrder=ImageIO.read(getClass().getResourceAsStream("/Icon/order.png")).getScaledInstance(lbViewOrder.getWidth(), lbViewOrder.getHeight(), Image.SCALE_SMOOTH);
            lbViewOrder.setIcon(new ImageIcon(imgOrder));
        } catch (IOException ex) {
            Logger.getLogger(frmCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.customer=customer;
        this.listOrder=listOrder;
        initConnection();
        listProduct=manager.getProduct();
        if (listOrder != null) {
            initTable();
            tbCart.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (tbCart.getSelectedRow() != -1) {
                        fillData(listOrder.get(tbCart.getSelectedRow()));
                    }
                }
            });
            tbCart.setRowSelectionInterval(0, 0);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbCart = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbSetup = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        btOrder = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbViewOrder = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        tbCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Product Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbCart);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Your Cart");

        txtQuantity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQuantityActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Quantity:");

        cbSetup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbSetup.setText("Is set up?");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Set");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btOrder.setBackground(new java.awt.Color(153, 255, 153));
        btOrder.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        btOrder.setForeground(new java.awt.Color(255, 51, 51));
        btOrder.setText("Send Order");
        btOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrderActionPerformed(evt);
            }
        });

        jButton2.setText("Return Shop");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbViewOrder.setPreferredSize(new java.awt.Dimension(40, 40));
        lbViewOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbViewOrderMouseClicked(evt);
            }
        });

        jLabel4.setText("Your Order");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btOrder)
                                .addGap(30, 30, 30))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbSetup)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1)
                                        .addGap(30, 30, 30))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(lbViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel4)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSetup)
                            .addComponent(jButton1))
                        .addGap(109, 109, 109)
                        .addComponent(btOrder)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQuantityActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        for (Order order : listOrder) {
            if (order.getProductID()==Integer.parseInt(tbCart.getValueAt(tbCart.getSelectedRow(),0).toString())) {
                Order order2=order;
                order2.setQuantity(Integer.parseInt(txtQuantity.getText().trim()));
                order2.setIsSetup(cbSetup.isSelected());
                listOrder.set(listOrder.indexOf(order), order2);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrderActionPerformed
        // TODO add your handling code here:
        for (Order order : listOrder) {
            if (manager.insertOrder(order)) {
                JOptionPane.showMessageDialog(this, "Send Order Complete! Check detail in Order!");
                listOrder.clear();
                initTable();
            }else
                JOptionPane.showMessageDialog(this, "Error!Can't send this Order!");
        }
    }//GEN-LAST:event_btOrderActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new frmForCustomer(customer,listOrder).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lbViewOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbViewOrderMouseClicked
        // TODO add your handling code here:
        new frmOrderForCustomer(customer).setVisible(true);
    }//GEN-LAST:event_lbViewOrderMouseClicked

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
            java.util.logging.Logger.getLogger(frmCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCart().setVisible(true);
            }
        });
    }
    private void initTable(){
        tbCart.removeAll();
        DefaultTableModel model=new javax.swing.table.DefaultTableModel(new Object [][]{},
    new String [] {"Product ID", "Product Name", "Quantity"});
        for (Order order : listOrder) {
            String name = "";
            for (Product product: listProduct) {
                if (order.getProductID()==product.getId()) {
                    name=product.getName();
                }
            }
            model.addRow(new Object[]{order.getProductID(),name,order.getQuantity()});
        }
        tbCart.setModel(model);
    }
    private void initConnection(){
        Connection conn=new DBConnection().getConnection();
        manager=new ManagementProcess(conn);
    }
    private void fillData(Order order){
        txtQuantity.setText(String.valueOf(order.getQuantity()));
        cbSetup.setSelected(order.isIsSetup());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btOrder;
    private javax.swing.JCheckBox cbSetup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbViewOrder;
    private javax.swing.JTable tbCart;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
