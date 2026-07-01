package supermarket;

import javax.swing.*;
import javax.swing.table.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends javax.swing.JFrame {

    private Connection connection;
    private final String databaseURL = "jdbc:mysql://localhost:3306/java_user_database";
    private final String username = "root";
    private final String password = "";

    public Admin() {
        initComponents();
        connectToDatabase();
        loadDataFromDatabase();
        Admin_name.setText(Login.adminName);
    }

    private void connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(databaseURL, username, password);
            System.out.println("Connected to the database");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database: " + e.getMessage());
        }
    }

    private void loadDataFromDatabase() {
        loadProductData();
        loadSellerData();
    }

    private void loadProductData() {
    DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
    model.setRowCount(0);

    String query = "SELECT ID, Name, Price, Quantity, Category FROM products";
    try (Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            String id = rs.getString("ID");
            String name = rs.getString("Name");
            String price = rs.getString("Price");
            String quantity = rs.getString("Quantity");
            String category = rs.getString("Category");
            model.addRow(new Object[]{id, name, price, quantity, category});
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Failed to load product data from database: " + e.getMessage());
    }
}

    private void loadSellerData() {
        DefaultTableModel model = (DefaultTableModel) SellerTable.getModel();
        model.setRowCount(0);

        String query = "SELECT UID, Name, Pass, Gender FROM user";
        try (Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                String uid = rs.getString("UID");
                String name = rs.getString("Name");
                String pass = rs.getString("Pass");
                String gender = rs.getString("Gender");
                model.addRow(new Object[]{uid, name, pass, gender});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to load seller data from database: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        SID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        SName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        SPassword = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        SGender = new javax.swing.JComboBox<>();
        SellerAdd = new javax.swing.JButton();
        SellerUpdate = new javax.swing.JButton();
        SellerDelete = new javax.swing.JButton();
        SellerClear = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        SellerTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        Log = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        Admin_name = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Product = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        DELETE = new javax.swing.JButton();
        CLEAR = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        EDIT = new javax.swing.JButton();
        ADD = new javax.swing.JButton();
        Qty = new javax.swing.JTextField();
        Price = new javax.swing.JTextField();
        Cat = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Log1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N

        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel9.setText("MANAGE SELLERS CENTRAL");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("SELLER ID");

        SID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel11.setText("NAME");

        SName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SNameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel12.setText("PASSWORD");

        SPassword.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SPasswordActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("GENDER");

        SGender.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        SGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"", "Male", "Female" }));
        SGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SGenderActionPerformed(evt);
            }
        });

        SellerAdd.setBackground(new java.awt.Color(242, 242, 242));
        SellerAdd.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        SellerAdd.setText("Add");
        SellerAdd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        SellerAdd.setBorderPainted(false);
        SellerAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SellerAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerAddActionPerformed(evt);
            }
        });

        SellerUpdate.setBackground(new java.awt.Color(242, 242, 242));
        SellerUpdate.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        SellerUpdate.setText("Update");
        SellerUpdate.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        SellerUpdate.setBorderPainted(false);
        SellerUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SellerUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerUpdateActionPerformed(evt);
            }
        });

        SellerDelete.setBackground(new java.awt.Color(242, 242, 242));
        SellerDelete.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        SellerDelete.setText("Delete");
        SellerDelete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        SellerDelete.setBorderPainted(false);
        SellerDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SellerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerDeleteActionPerformed(evt);
            }
        });

        SellerClear.setBackground(new java.awt.Color(242, 242, 242));
        SellerClear.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        SellerClear.setText("Clear");
        SellerClear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        SellerClear.setBorderPainted(false);
        SellerClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        SellerClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerClearActionPerformed(evt);
            }
        });

        SellerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seller ID", "NAME", "PASSWORD", "GENDER"
            }
        ));
        SellerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SellerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(SellerTable);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel14.setText("SELLERS LIST");

        Log.setBackground(new java.awt.Color(242, 242, 242));
        Log.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        Log.setText("Logout");
        Log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogActionPerformed(evt);
            }
        });

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Untitled-2.o.png"))); // NOI18N

        Admin_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("FLIPKART GROCERY STORE ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 89, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(385, 385, 385))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addGap(18, 18, 18))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                        .addComponent(jLabel11)
                                                        .addGap(61, 61, 61)))
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(SID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addComponent(SellerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(87, 87, 87)
                                                .addComponent(SellerUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(64, 64, 64)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jLabel12)
                                                .addGap(37, 37, 37))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(SellerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13))
                                                .addGap(14, 14, 14))))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(14, 14, 14)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(SPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SGender, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(86, 86, 86)
                                        .addComponent(SellerClear, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(jLabel9)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Log)
                        .addGap(33, 33, 33))))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {SGender, SID, SName, SPassword});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(Log))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Admin_name, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(44, 44, 44)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(SID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(SName, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(SGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(49, 49, 49)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SellerAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SellerUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SellerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SellerClear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {SGender, SID, SName, SPassword});

        jTabbedPane1.addTab("Manage Sellers", jPanel3);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel3.setText("MANAGE PRODUCTS CENTRAL");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setText("PRODUCT ID");

        Product.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Product.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("NAME");

        Name.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("QUANTITY");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel6.setText("PRICE");

        DELETE.setBackground(new java.awt.Color(242, 242, 242));
        DELETE.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        DELETE.setText("Delete");
        DELETE.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        DELETE.setBorderPainted(false);
        DELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DELETEActionPerformed(evt);
            }
        });

        CLEAR.setBackground(new java.awt.Color(242, 242, 242));
        CLEAR.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        CLEAR.setText("Clear");
        CLEAR.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        CLEAR.setBorderPainted(false);
        CLEAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CLEARActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(12, 19, 16));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Price", "Quantity", "Category"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel8.setText("PRODUCTS LIST");

        EDIT.setBackground(new java.awt.Color(242, 242, 242));
        EDIT.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        EDIT.setText("Update");
        EDIT.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        EDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EDITActionPerformed(evt);
            }
        });

        ADD.setBackground(new java.awt.Color(242, 242, 242));
        ADD.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        ADD.setText("Add");
        ADD.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        ADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ADDActionPerformed(evt);
            }
        });

        Qty.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Qty.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                QtyKeyTyped(evt);
            }
        });

        Price.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Price.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PriceKeyTyped(evt);
            }
        });

        Cat.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Cat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatActionPerformed(evt);
            }
        });
        Cat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CatKeyTyped(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setText("CATEGORY");

        Log1.setBackground(new java.awt.Color(242, 242, 242));
        Log1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        Log1.setText("Logout");
        Log1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Log1ActionPerformed(evt);
            }
        });
        Log1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Log1KeyPressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Untitled-2.o.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel15.setText("FLIPKART GROCERY STORE ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Product, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(89, 89, 89)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel19)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6)))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Cat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Qty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(355, 355, 355))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 72, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Log1)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Log1)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Qty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Price, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Cat, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Product, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ADD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DELETE, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CLEAR, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Manage Products", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1062, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceKeyTyped

    }//GEN-LAST:event_PriceKeyTyped

    private void QtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyKeyTyped

    }//GEN-LAST:event_QtyKeyTyped


    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        ProductManager s1 = new ProductManager();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (Product.getText().equals("") || Name.getText().equals("") || Price.getText().equals("") || Qty.getText().toString().equals("") || Cat.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the required fields");
            return;
        }
        try {
            int Quantity = Integer.parseInt(Qty.getText());
            int Pr = Integer.parseInt(Price.getText());
            if (Quantity <= 0 || Pr <= 0) {
                JOptionPane.showMessageDialog(this, "Enter only positive integer value");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter Only integer value");
            return;
        }
        String Id;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Id = model.getValueAt(i, 0).toString().trim();
            if (Product.getText().equals(Id)) {
                JOptionPane.showMessageDialog(null, "Product ID should be Unique");
                return;
            }
        }
        s1.setId(Product.getText().trim());
        s1.setName(Name.getText().trim());
        s1.setPrice(Price.getText().trim());
        s1.setQty(Qty.getText().trim());
        s1.setCat(Cat.getText().trim());
        ProductAddMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat());
        model.addRow(new Object[]{s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat()});
        JOptionPane.showMessageDialog(this, "Data Successfully Added.");
        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");

    }//GEN-LAST:event_ADDActionPerformed

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
        ProductManager s1 = new ProductManager();

        s1.setId(Product.getText().trim());
        s1.setName(Name.getText().trim());
        s1.setPrice(Price.getText().trim());
        s1.setQty(Qty.getText().trim());
        s1.setCat(Cat.getText().trim());
        try {
            int Quantity = Integer.parseInt(Qty.getText());
            int Pr = Integer.parseInt(Price.getText());
            if (Quantity <= 0 || Pr <= 0) {
                JOptionPane.showMessageDialog(this, "Enter only positive integer value");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter Only integer value");
            return;
        }

        ProductDeleteMethod(s1.getId());
        
        ProductAddMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat());

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRowCount() == 1) {

            while (Product.getText().equals("") || Name.getText().equals("") || Price.getText().equals("") || Qty.getText().toString().equals("") || Cat.getText().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the required fields");
                return;
            }

            String prod = Product.getText();
            String nam = Name.getText();
            String price = Price.getText();
            String qty = Qty.getText();
            String cat = Cat.getText();
            model.setValueAt(prod, jTable1.getSelectedRow(), 0);
            model.setValueAt(nam, jTable1.getSelectedRow(), 1);
            model.setValueAt(price, jTable1.getSelectedRow(), 2);
            model.setValueAt(qty, jTable1.getSelectedRow(), 3);
            model.setValueAt(cat, jTable1.getSelectedRow(), 4);
            JOptionPane.showMessageDialog(this, "Update Successfully..");
        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty..");
            } else {
                JOptionPane.showMessageDialog(this, "Please Select Single Row to Update..");
            }

        }
        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");
        Product.setEditable(true);
    }//GEN-LAST:event_EDITActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        String product = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String name = model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String price = model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String qty = model.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String cat = model.getValueAt(jTable1.getSelectedRow(), 4).toString();

        Product.setText(product);
        Name.setText(name);
        Price.setText(price);
        Qty.setText(qty);
        Cat.setText(cat);

        Product.setEditable(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");
        Product.setEditable(true);

    }//GEN-LAST:event_CLEARActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ProductManager s1 = new ProductManager();
        s1.setId(Product.getText().trim());
        s1.setName(Name.getText().trim());
        s1.setPrice(Price.getText().trim());
        s1.setQty(Qty.getText().trim());
        s1.setCat(Cat.getText().trim());
        ProductDeleteMethod(s1.getId());
        if (jTable1.getSelectedRowCount() == 1) {
            model.removeRow(jTable1.getSelectedRow());
        } else if (jTable1.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Table is Empty..");
        } else {
            JOptionPane.showMessageDialog(this, "Table is Empty or Muliple Rows are selected");

        }
        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");
        Product.setEditable(true);
    }//GEN-LAST:event_DELETEActionPerformed

    private void CatKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CatKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CatKeyTyped

    private void Log1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Log1ActionPerformed
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_Log1ActionPerformed

    private void Log1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Log1KeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_Log1KeyPressed

    private void ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductActionPerformed

    private void LogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogActionPerformed
        Login log = new Login();
        log.setVisible(true);
        dispose();
    }//GEN-LAST:event_LogActionPerformed

    private void SellerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SellerTableMouseClicked
        SellerManager seller = new SellerManager();
        DefaultTableModel model = (DefaultTableModel) SellerTable.getModel();

        seller.setId(model.getValueAt(SellerTable.getSelectedRow(), 0).toString());
        seller.setSPassword(model.getValueAt(SellerTable.getSelectedRow(), 1).toString());
        seller.setName(model.getValueAt(SellerTable.getSelectedRow(), 2).toString());
        seller.setSGender(model.getValueAt(SellerTable.getSelectedRow(), 3).toString());

        SID.setText(seller.getId());
        SPassword.setText(seller.getSPassword());
        SName.setText(seller.getName());
        SGender.setSelectedItem(seller.getSGender());

        SID.setEditable(false);
    }//GEN-LAST:event_SellerTableMouseClicked

    private void SellerClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerClearActionPerformed
        SID.setText("");
        SName.setText("");
        SPassword.setText("");
        SGender.setSelectedItem("");
        SID.setEditable(true);
    }//GEN-LAST:event_SellerClearActionPerformed

    private void SellerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerDeleteActionPerformed
        SellerManager seller = new SellerManager();
        DefaultTableModel DeleteModel = (DefaultTableModel) SellerTable.getModel();

        seller.setId(SID.getText());
        seller.setSPassword(SPassword.getText());
        seller.setName(SName.getText());
        seller.setSGender(SGender.getSelectedItem().toString());

        if (SellerTable.getSelectedRowCount() == 1) {
            DeleteModel.removeRow(SellerTable.getSelectedRow());
            SellingDeleteMethod(seller.getId(), seller.getSPassword(), seller.getName(), seller.getSGender());
            JOptionPane.showMessageDialog(this, "Record Successfully Deleted");
        } else if (SellerTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Table is Empty");
        } else if (SellerTable.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No Row is Selected");
        } else {
            JOptionPane.showMessageDialog(null, "Please Select a Single Row to Update");
        }

        SID.setText("");
        SPassword.setText("");
        SName.setText("");
        SGender.setSelectedItem("");
        SID.setEditable(true);
    }//GEN-LAST:event_SellerDeleteActionPerformed


    private void SellerUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerUpdateActionPerformed
        SellerManager seller = new SellerManager();
        DefaultTableModel EditModel = (DefaultTableModel) SellerTable.getModel();

        seller.setId(SID.getText());
        seller.setSPassword(SPassword.getText());
        seller.setName(SName.getText());
        seller.setSGender(SGender.getSelectedItem().toString());

        if (SellerTable.getSelectedRowCount() == 1) {
            while (SID.getText().equals("")  || SPassword.getText().equals("") || SName.getText().equals("") || SGender.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the required fields");
                return;
            }

            EditModel.setValueAt(seller.getId(), SellerTable.getSelectedRow(), 0);
            EditModel.setValueAt(seller.getSPassword().toString(), SellerTable.getSelectedRow(), 1);
            EditModel.setValueAt(seller.getName(), SellerTable.getSelectedRow(), 2);
            EditModel.setValueAt(seller.getSGender(), SellerTable.getSelectedRow(), 3);

            SellingDeleteMethod(seller.getId(),  seller.getName(), seller.getSPassword(), seller.getSGender());
            SellingAddMethod(seller.getId(), seller.getSPassword(), seller.getName(), seller.getSGender());

            JOptionPane.showMessageDialog(this, "Record Updated Successfully");
        } else {
            if (SellerTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is Empty");
            } else if (SellerTable.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "No Row is Selected");
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a Single Row to Update");
            }
        }

        SID.setText("");
        SPassword.setText("");
        SName.setText("");
        SGender.setSelectedItem("");
        SID.setEditable(true);
    }//GEN-LAST:event_SellerUpdateActionPerformed

    private void SellerAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerAddActionPerformed
        SellerManager seller = new SellerManager();
        DefaultTableModel AddModel = (DefaultTableModel) SellerTable.getModel();

        while (SID.getText().equals("")  || SName.getText().equals("") || SPassword.getText().equals("") || SGender.getSelectedItem().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the required fields");
            return;
        }

        seller.setId(SID.getText());
        seller.setName(SName.getText());
        seller.setSPassword(SPassword.getText());
        seller.setSGender(SGender.getSelectedItem().toString());

        
        SellingAddMethod(seller.getId(), seller.getName(), seller.getSPassword(), seller.getSGender());

        Object[] row = {seller.getId(), seller.getName(), seller.getSPassword(), seller.getSGender()};
        AddModel.addRow(row);

        JOptionPane.showMessageDialog(this, "Data Successfully Added");

        SID.setText("");
        SPassword.setText("");
        SName.setText("");
        SGender.setSelectedItem("");

    }//GEN-LAST:event_SellerAddActionPerformed

    private void SNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SNameActionPerformed

    private void CatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CatActionPerformed

    private void NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameActionPerformed

    private void SPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SPasswordActionPerformed

    private void SGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SGenderActionPerformed

    private void ProductAddMethod(String id, String name, String price, String qty, String cat) {
        try {
            String query = "INSERT INTO Products (ID, Name, Price, Quantity, Category) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, price);
            pstmt.setString(4, qty);
            pstmt.setString(5, cat);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Adding Data to Database");
        }
    }
    


    private void ProductDeleteMethod(String id) {
        try {
            String query = "DELETE FROM Products WHERE ID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            System.out.println("Product with ID " + id + " deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Deleting Data from Database: " + e.getMessage());
        }
    }

    private void SellingAddMethod(String ID, String Password, String Name, String Gender) {
        try {
            String query = "INSERT INTO user (UID, Name, Pass, Gender) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, ID);
            pstmt.setString(3, Name);
            pstmt.setString(2, Password);
            pstmt.setString(4, Gender);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Adding Data to Database");
        }
    }

    private void SellingDeleteMethod(String Id, String Password, String Name, String Gender) {
        try {
            String query = "DELETE FROM user WHERE UID = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, Id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Deleting Data from Database");
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JLabel Admin_name;
    private javax.swing.JButton CLEAR;
    private javax.swing.JTextField Cat;
    private javax.swing.JButton DELETE;
    private javax.swing.JButton EDIT;
    private javax.swing.JButton Log;
    private javax.swing.JButton Log1;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Price;
    private javax.swing.JTextField Product;
    private javax.swing.JTextField Qty;
    private javax.swing.JComboBox<String> SGender;
    private javax.swing.JTextField SID;
    private javax.swing.JTextField SName;
    private javax.swing.JTextField SPassword;
    private javax.swing.JButton SellerAdd;
    private javax.swing.JButton SellerClear;
    private javax.swing.JButton SellerDelete;
    private javax.swing.JTable SellerTable;
    private javax.swing.JButton SellerUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
