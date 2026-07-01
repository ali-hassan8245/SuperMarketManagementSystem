package supermarket;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

public class Login extends javax.swing.JFrame {
    public static String adminName;
    public static String sellerName;
    public Login() {
        initComponents();
        
    }

    String[] IDs = new String[10];
    String[] Passwords = new String[10];
    static int a = 0;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        UID = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Login = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Password = new javax.swing.JPasswordField();
        showPassword = new javax.swing.JRadioButton();
        Close = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(12, 19, 16));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(12, 19, 16));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login imageeee 2.1.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 470, 610));

        jLabel12.setText("jLabel12");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 90, 70));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(23, 179, 139));
        jLabel13.setText("Family Point");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, -1, 33));

        jPanel2.setBackground(new java.awt.Color(59, 52, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 25, -1));

        UID.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        UID.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(UID, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 176, 36));

        jComboBox1.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Seller" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 176, 31));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 150, 100, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setText("Password");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel5.setText("Select Role");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        Login.setBackground(new java.awt.Color(242, 242, 242));
        Login.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Login.setText("Login");
        Login.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        Login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Login.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                LoginAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginActionPerformed(evt);
            }
        });
        jPanel2.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 460, 80, 31));

        Clear.setBackground(new java.awt.Color(242, 242, 242));
        Clear.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Clear.setText("Clear");
        Clear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel2.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 90, 31));

        Password.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        Password.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PasswordKeyReleased(evt);
            }
        });
        jPanel2.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 176, 38));

        showPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        showPassword.setText("Show Password");
        showPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordActionPerformed(evt);
            }
        });
        jPanel2.add(showPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));

        Close.setBackground(new java.awt.Color(251, 37, 37));
        Close.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        Close.setForeground(new java.awt.Color(255, 255, 255));
        Close.setText("X");
        Close.setBorder(null);
        Close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jPanel2.add(Close, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 0, 39, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Untitled-2.o.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 90, 60));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login imageeee.1.jpg"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 1050, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed

         String Uid = UID.getText(), Pass = new String(Password.getPassword());
        switch (jComboBox1.getSelectedItem().toString()) {
            case "Admin":
                if (Uid.equals("taha@123") && Pass.equals("864") || Uid.equals("ali@345") && Pass.equals("123") || Uid.equals("umair@567") && Pass.equals("456")) {
                    adminName = Uid;
                    new Admin().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Admin UID or Password");
                }
                break;
            case "Seller":
                boolean notFound = true;
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_user_database", "root", "");

                    String query = "SELECT Name FROM user WHERE UID = ? AND Pass = ?";
                    PreparedStatement pstmt = connection.prepareStatement(query);
                    pstmt.setString(1, Uid);
                    pstmt.setString(2, Pass);
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        notFound = false;
                        sellerName = rs.getString("Name");
                    }
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error connecting to the database");
                }
                if (!notFound) {
                    new Selling().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Wrong Seller UID or Password");
                }

                break;
        }
    }//GEN-LAST:event_LoginActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        UID.setText(null);
        Password.setText(null);
    }//GEN-LAST:event_ClearActionPerformed

    private void showPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordActionPerformed
        if (showPassword.isSelected()) {
            Password.setEchoChar((char) 0);
        } else {
            Password.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    private void PasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PasswordKeyReleased

    }//GEN-LAST:event_PasswordKeyReleased

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void LoginAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_LoginAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginAncestorAdded

    protected void ConvertArray() {
        try {
            FileReader fRead = new FileReader("Seller.txt");
            BufferedReader buffFileRead = new BufferedReader(fRead);
            String currentString;
            while ((currentString = buffFileRead.readLine()) != null) {
                separator(currentString);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Can not convert into array");
        }
    }
    protected void separator(String cString) {
        int location1 = 0;
        int location2 = 0;
        boolean first = false;
        for (int i = 0; i < cString.length(); i++) {
            if (cString.charAt(i) == '/' && !first) {
                location1 = i;
                first = true;
            } else if (cString.charAt(i) == '/' && first) {
                location2 = i;
                break;
            }
        }
        IDs[a] = cString.substring(0, location1);
        Passwords[a] = cString.substring(location1 + 1, location2);
        a++;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Clear;
    private javax.swing.JButton Close;
    private javax.swing.JButton Login;
    private javax.swing.JPasswordField Password;
    private javax.swing.JTextField UID;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton showPassword;
    // End of variables declaration//GEN-END:variables
}
