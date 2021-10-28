/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Control.ManagementProcess;
import Model.Account;
import Model.Categories;
import Model.ComboItem;
import Model.Customer;
import Model.DBConnection;
import Model.Order;
import Model.Product;
import com.sun.xml.internal.ws.handler.HandlerException;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kieum
 */
public class frmForCustomer extends javax.swing.JFrame {
    private Customer defaultCustomer;
    private ArrayList<Categories> listCategories;
    private ArrayList<Product> listProduct;
    private ArrayList<Product> currentListProduct;
    private ManagementProcess manager;
    private ArrayList<Order> listOrder;
    boolean showOptionAccount=false;

    /**
     * Creates new form frmForCustomer
     */
    public frmForCustomer() {
        initComponents();
        
    }
    public frmForCustomer(Customer cus){
        initComponents();
        initConnection();
        btAddcard.setEnabled(false);
        defaultCustomer=cus;
        simpleInit(defaultCustomer);
        listCategories=manager.getCategories();
        listProduct=manager.getProduct();
        initCategories(listCategories);
        tbProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx = tbProduct.getSelectedRow();
                if (idx != -1) {
                    Product pro = currentListProduct.get(idx);
                    fillDate(pro);
                    btAddcard.setEnabled(true);
                }else
                    btAddcard.setEnabled(false);
            }
        });
        cbbCategories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentListProduct = new ArrayList<>();//To change body of generated methods, choose Tools | Templates.
                String sl = cbbCategories.getSelectedItem().toString();
                int key = Integer.parseInt(sl.split(":")[0]);
                for (Product product : listProduct) {
                    if (product.getCategoriesID() == (key)) {
                        currentListProduct.add(product);
                    }
                }
                initTable();
                if (currentListProduct.size() > 0) {
                    tbProduct.setRowSelectionInterval(0, 0);

                }
            }
        });
        cbbCategories.setSelectedIndex(0);

    }

    public frmForCustomer(Customer cus, ArrayList<Order> listOrder) {
        initComponents();
        btAddcard.setEnabled(false);
        defaultCustomer=cus;
        this.listOrder=listOrder;
        if (listOrder!=null) {
            lbNumCart.setText("("+listOrder.size()+")");
        }
        simpleInit(defaultCustomer);
        initConnection();
        listCategories=manager.getCategories();
        listProduct=manager.getProduct();
        initCategories(listCategories);
        tbProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx = tbProduct.getSelectedRow();
                if (idx != -1) {
                    Product pro = currentListProduct.get(idx);
                    fillDate(pro);
                    btAddcard.setEnabled(true);
                }else
                    btAddcard.setEnabled(false);
            }
        });
        cbbCategories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentListProduct = new ArrayList<>();//To change body of generated methods, choose Tools | Templates.
                String sl = cbbCategories.getSelectedItem().toString();
                int key = Integer.parseInt(sl.split(":")[0]);
                for (Product product : listProduct) {
                    if (product.getCategoriesID() == (key)) {
                        currentListProduct.add(product);
                    }
                }
                initTable();
                if (currentListProduct.size() > 0) {
                    tbProduct.setRowSelectionInterval(0, 0);

                }
            }
        });
        cbbCategories.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionAccount = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        editInfoDialog = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        txtEditID = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEditCPN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEditCPA = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtEditSDT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEditEmail = new javax.swing.JTextField();
        btEdit = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        changePassDialog = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cbbCategories = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btSort = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btX = new javax.swing.JButton();
        lbPicture = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        btAddcard = new javax.swing.JButton();
        lbAccountName = new javax.swing.JLabel();
        lbAccount = new javax.swing.JLabel();
        lbCart = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbNumCart = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbBill = new javax.swing.JLabel();

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem1.setText("Edit Infomation");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        optionAccount.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuItem2.setText("Change password?");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        optionAccount.add(jMenuItem2);

        jMenuItem3.setText("Log out");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        optionAccount.add(jMenuItem3);

        editInfoDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editInfoDialog.setTitle("Edit Infomation");
        editInfoDialog.setMinimumSize(new java.awt.Dimension(400, 420));
        editInfoDialog.setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Your ID:");

        txtEditID.setEditable(false);
        txtEditID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Your Name:");

        txtEditName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Company Name:");

        txtEditCPN.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Company Address:");

        txtEditCPA.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Phone Contact:");

        txtEditSDT.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Email Contact:");

        txtEditEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        btEdit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btEdit.setText("Edit");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btCancel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editInfoDialogLayout = new javax.swing.GroupLayout(editInfoDialog.getContentPane());
        editInfoDialog.getContentPane().setLayout(editInfoDialogLayout);
        editInfoDialogLayout.setHorizontalGroup(
            editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editInfoDialogLayout.createSequentialGroup()
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editInfoDialogLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(editInfoDialogLayout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtEditCPA, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEditID, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEditCPN, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(editInfoDialogLayout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(btCancel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editInfoDialogLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtEditEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editInfoDialogLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtEditSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(editInfoDialogLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(btEdit)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        editInfoDialogLayout.setVerticalGroup(
            editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editInfoDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditCPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditCPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEditEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(editInfoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEdit)
                    .addComponent(btCancel))
                .addContainerGap())
        );

        changePassDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        changePassDialog.setTitle("Change Password");
        changePassDialog.setMinimumSize(new java.awt.Dimension(431, 225));
        changePassDialog.setResizable(false);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("New Password:");

        txtPass1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Retype:");

        txtPass2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changePassDialogLayout = new javax.swing.GroupLayout(changePassDialog.getContentPane());
        changePassDialog.getContentPane().setLayout(changePassDialogLayout);
        changePassDialogLayout.setHorizontalGroup(
            changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePassDialogLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changePassDialogLayout.createSequentialGroup()
                        .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPass1)
                            .addComponent(txtPass2))
                        .addGap(37, 37, 37))
                    .addGroup(changePassDialogLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(52, 52, 52))))
        );
        changePassDialogLayout.setVerticalGroup(
            changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePassDialogLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(changePassDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(34, 34, 34))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Customer App");

        cbbCategories.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbbCategories.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Categories:");

        btSort.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSort.setText("Sort");
        btSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSortActionPerformed(evt);
            }
        });

        btSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSearch.setText("Search");

        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product ID", "Product Name", "Brand", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProduct.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tbProduct);
        tbProduct.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        txtSearch.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        btX.setText("X");

        lbPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lbPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(51, 51, 255));
        lbPrice.setText("Price:?");

        btAddcard.setBackground(new java.awt.Color(153, 255, 153));
        btAddcard.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btAddcard.setForeground(new java.awt.Color(204, 0, 0));
        btAddcard.setText("Add Cart");
        btAddcard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddcardActionPerformed(evt);
            }
        });

        lbAccountName.setText("Customer Account");

        lbAccount.setPreferredSize(new java.awt.Dimension(40, 40));
        lbAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAccountMouseClicked(evt);
            }
        });

        lbCart.setPreferredSize(new java.awt.Dimension(40, 40));
        lbCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCartMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Your Cart");

        lbNumCart.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbNumCart.setForeground(new java.awt.Color(255, 51, 51));
        lbNumCart.setText("(0)");
        lbNumCart.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lbNumCart.setPreferredSize(new java.awt.Dimension(40, 40));
        lbNumCart.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Your Bill");

        lbBill.setPreferredSize(new java.awt.Dimension(40, 40));
        lbBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBillMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbPrice)
                    .addComponent(btAddcard, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(212, 212, 212)
                        .addComponent(lbAccountName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(380, 380, 380)
                        .addComponent(btSort))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btX)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearch))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(lbBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbNumCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lbAccountName)
                    .addComponent(lbCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(lbNumCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(cbbCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSort)
                    .addComponent(btSearch)
                    .addComponent(btX)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbPrice)
                        .addGap(18, 18, 18)
                        .addComponent(btAddcard, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSortActionPerformed
        // TODO add your handling code here:
        Collections.sort(listProduct, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getUnitPrice() > o2.getUnitPrice() ? 1 : -1; //To change body of generated methods, choose Tools | Templates.
            }
        });
        initTable();
    }//GEN-LAST:event_btSortActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void btAddcardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddcardActionPerformed
        // TODO add your handling code here:
        try {
            String st = JOptionPane.showInputDialog(this, "Input quantity!");
            int num=0;
            if (st!=null) {
                num = Integer.parseInt(st.trim());
            }
            if (num > 0) {
                if (JOptionPane.showConfirmDialog(this, "Do you want setup?", "Choose Setup", JOptionPane.YES_NO_OPTION) == 0) {
                    Order order=new Order(defaultCustomer.getId(), Integer.parseInt(tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString()), num, true);
                    addCart(order);

                } else {
                    Order order=new Order(defaultCustomer.getId(), Integer.parseInt(tbProduct.getValueAt(tbProduct.getSelectedRow(), 0).toString()), num, false);
                    addCart(order);
                }
            } else {
                JOptionPane.showMessageDialog(this, "quantity must > 0!");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "please input number!");
        }
        

    }//GEN-LAST:event_btAddcardActionPerformed

    private void lbCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCartMouseClicked
        // TODO add your handling code here:
        new frmCart(defaultCustomer, listOrder).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbCartMouseClicked

    private void lbBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBillMouseClicked
        // TODO add your handling code here:
        new frmBillMgr(defaultCustomer).setVisible(true);
    }//GEN-LAST:event_lbBillMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        changePassDialog.setVisible(true);
        setLocation(this.getX()+150, this.getY()+150);
        optionAccount.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void lbAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAccountMouseClicked
        // TODO add your handling code here:
        showOptionAccount=!showOptionAccount;
        optionAccount.setVisible(showOptionAccount);
        optionAccount.setLocation(lbAccount.getX()-60, lbAccount.getY()+80);
    }//GEN-LAST:event_lbAccountMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        editInfoDialog.setVisible(true);
        editInfoDialog.setLocation(this.getX()+150, this.getY()+150);
        txtEditID.setText(String.valueOf(defaultCustomer.getId()));
        txtEditName.setText(defaultCustomer.getName());
        txtEditCPN.setText(defaultCustomer.getCompanyName());
        txtEditCPA.setText(defaultCustomer.getCompanyAddress());
        txtEditSDT.setText(defaultCustomer.getContactPhone());
        txtEditEmail.setText(defaultCustomer.getContactEmail());
        optionAccount.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        // TODO add your handling code here:
        Customer customer=new Customer(defaultCustomer.getId(),txtEditName.getText(), txtEditCPN.getText(), txtEditCPA.getText(), txtEditSDT.getText(), txtEditEmail.getText(), defaultCustomer.getUsername());
        if (manager.updateCustomer(defaultCustomer.getId(), customer)) {
            JOptionPane.showMessageDialog(this, "Update Infomation Completed!");
            defaultCustomer=customer;
            editInfoDialog.dispose();
        }else
            JOptionPane.showMessageDialog(this, "Update Error!","Error",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btEditActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        editInfoDialog.dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String passc=txtPass1.getText();
        if (!txtPass1.getText().equals(txtPass2.getText())) {
            JOptionPane.showMessageDialog(this, "Retype the same password!","error",JOptionPane.ERROR_MESSAGE);
        }else{
            try {
                String pass=manager.getPass(defaultCustomer.getUsername());
                if (pass.equals(passc)) {
                    JOptionPane.showMessageDialog(this, "Please type other password!","error",JOptionPane.ERROR_MESSAGE);
                }else{
                    if (manager.updateAccount(defaultCustomer.getUsername(),new Account(defaultCustomer.getUsername(), passc,"CU"))) {
                        if (JOptionPane.showConfirmDialog(changePassDialog,"Password Changed! Do you want Login agian?","Login again",JOptionPane.OK_CANCEL_OPTION)==0) {
                            new frmLogin(new Account(defaultCustomer.getUsername(), passc, "CU")).setVisible(true);
                            changePassDialog.dispose();
                            this.dispose();
                        }else
                            changePassDialog.dispose();

                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(frmForCustomer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        changePassDialog.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new frmLogin().setVisible(true);
        optionAccount.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(frmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmForCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmForCustomer().setVisible(true);
            }
        });
    }
    public void simpleInit(Customer cus){
        try {
            Image cart=ImageIO.read(getClass().getResourceAsStream("/Icon/cart.jpg")).getScaledInstance(lbCart.getWidth()-1, lbCart.getHeight()-1, Image.SCALE_SMOOTH);
            Image ac=ImageIO.read(getClass().getResourceAsStream("/Icon/account.png")).getScaledInstance(lbCart.getWidth()-1, lbCart.getHeight()-1, Image.SCALE_SMOOTH);
            Image bill=ImageIO.read(getClass().getResourceAsStream("/Icon/bill.png")).getScaledInstance(lbCart.getWidth()-1, lbCart.getHeight()-1, Image.SCALE_SMOOTH);
            lbCart.setIcon(new ImageIcon(cart));
            lbAccount.setIcon(new ImageIcon(ac));
            lbAccountName.setText(cus.getName());
            lbBill.setIcon(new ImageIcon(bill));
        } catch (IOException ex) {
            Logger.getLogger(frmForCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    private void fillDate(Product pro){
        Image img=pro.getPicture().getScaledInstance(lbPicture.getWidth(), lbPicture.getHeight(), Image.SCALE_SMOOTH);
        lbPicture.setIcon(new ImageIcon(img));
        lbPrice.setText("Price: "+pro.getUnitPrice());
        
    }
    private void initConnection(){
        Connection con=new DBConnection().getConnection();
        manager=new ManagementProcess(con);
    }
    public void initTable(){
        tbProduct.removeAll();
        DefaultTableModel model = new DefaultTableModel(new Object[][]{}, new String[]{
            "Product ID", "Product Name", "Brand", "Unit Price"});
        for (Product product : currentListProduct) {
            model.addRow(new Object[]{product.getId(), product.getName(), product.getBrand(), product.getUnitPrice()});
        }
        tbProduct.setModel(model);
    }
    public void initCategories(ArrayList<Categories> lst){
        cbbCategories.removeAllItems();
        for (Categories categories : lst) {
            cbbCategories.addItem(categories.getId()+":"+categories.getName());
        }
    }
    private int checkInCart(Order order){
        for (Order or: listOrder) {
            if (or.getProductID()==order.getProductID()&&or.isIsSetup()==order.isIsSetup()) {
                return listOrder.indexOf(or);
            }
                
        }
        return -1;
    }
    private void addCart(Order order) {
        if (listOrder == null) {
            listOrder = new ArrayList<>();
            if (listOrder.add(order)) {
                JOptionPane.showMessageDialog(this, "Add Complete! Please check detail in cart!");
                lbNumCart.setText("(" + listOrder.size() + ")");
            }

        } else {
            int idx = checkInCart(order);
            if (idx != -1) {
                Order order1 = listOrder.get(idx);
                order1.setQuantity(order1.getQuantity() + order.getQuantity());
                JOptionPane.showMessageDialog(this, "Update cart Complete! Please check detail in cart!");
            } else {
                listOrder.add(order);
                JOptionPane.showMessageDialog(this, "Add Complete! Please check detail in cart!");
                lbNumCart.setText("(" + listOrder.size() + ")");
            }

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddcard;
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btSort;
    private javax.swing.JButton btX;
    private javax.swing.JComboBox<String> cbbCategories;
    private javax.swing.JDialog changePassDialog;
    private javax.swing.JDialog editInfoDialog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbAccountName;
    private javax.swing.JLabel lbBill;
    private javax.swing.JLabel lbCart;
    private javax.swing.JLabel lbNumCart;
    private javax.swing.JLabel lbPicture;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JPopupMenu optionAccount;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtEditCPA;
    private javax.swing.JTextField txtEditCPN;
    private javax.swing.JTextField txtEditEmail;
    private javax.swing.JTextField txtEditID;
    private javax.swing.JTextField txtEditName;
    private javax.swing.JTextField txtEditSDT;
    private javax.swing.JTextField txtPass1;
    private javax.swing.JTextField txtPass2;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
