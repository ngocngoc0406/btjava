/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Login;

import java.awt.Color;
import static java.awt.Color.blue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pf_password = new javax.swing.JPasswordField();
        pf_confirmpassword = new javax.swing.JPasswordField();
        tf_username = new javax.swing.JTextField();
        tf_address = new javax.swing.JTextField();
        tf_fullname = new javax.swing.JTextField();
        btn_register = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_loginnow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(620, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/11261451131679836828-128-removebg-preview.png"))); // NOI18N
        jLabel1.setText("Register");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/19306016551679893896-64-removebg-preview.png"))); // NOI18N
        jLabel2.setText("Full name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/19306016551679893896-64-removebg-preview.png"))); // NOI18N
        jLabel3.setText("Username");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/7205445111595501398-64.png"))); // NOI18N
        jLabel4.setText("Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 70));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/7205445111595501398-64.png"))); // NOI18N
        jLabel5.setText("Confirm password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Login/11197983181642744712-64-removebg-preview.png"))); // NOI18N
        jLabel6.setText("Address");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        pf_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pf_password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pf_passwordMouseClicked(evt);
            }
        });
        getContentPane().add(pf_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 260, 40));

        pf_confirmpassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pf_confirmpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pf_confirmpasswordMouseClicked(evt);
            }
        });
        getContentPane().add(pf_confirmpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 260, 40));

        tf_username.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tf_username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_usernameMouseClicked(evt);
            }
        });
        getContentPane().add(tf_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 260, 40));

        tf_address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tf_address.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_addressMouseClicked(evt);
            }
        });
        getContentPane().add(tf_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 500, 260, 40));

        tf_fullname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tf_fullname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_fullnameMouseClicked(evt);
            }
        });
        getContentPane().add(tf_fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 260, 40));

        btn_register.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_register.setText("Register");
        btn_register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_register, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 560, 110, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Do you already have an account ?");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, -1, 30));

        btn_loginnow.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_loginnow.setText("Login now");
        btn_loginnow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginnowActionPerformed(evt);
            }
        });
        getContentPane().add(btn_loginnow, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 620, 140, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registerActionPerformed
        String pass = pf_password.getText();
        String confirmpass=pf_confirmpassword.getText();
        if(pass.equals(confirmpass)){
            Connection connection = null;
        try {
                // checkpassword();
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); 
            String url = "jdbc:mySQL://127.0.0.1:3306/javadatabase";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO `account`(`Full name`, `Username`, `Password`, `Address`) VALUES (?,?,?,?)";
            PreparedStatement pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, tf_fullname.getText());
            pstatement.setString(2, tf_username.getText());
            pstatement.setString(3, pf_password.getText());
            pstatement.setString(4, tf_address.getText());
            
            int row = pstatement.executeUpdate();
       
          //  JOptionPane.showMessageDialog(null, "Register successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Register successfully");
//        pf_password.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
//        pf_confirmpassword.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
//        
    }
        else if(!(pass.equals(confirmpass))){
            pf_password.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            pf_confirmpassword.setBorder(BorderFactory.createLineBorder(Color.red, 2));
            JOptionPane.showMessageDialog(null, "Password and confirm password don't match");
        }
        
    }//GEN-LAST:event_btn_registerActionPerformed

    private void tf_fullnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_fullnameMouseClicked
        // TODO add your handling code here:
        tf_fullname.setBorder(BorderFactory.createLineBorder(Color.blue));
    }//GEN-LAST:event_tf_fullnameMouseClicked

    private void tf_usernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_usernameMouseClicked
        // TODO add your handling code here:
        tf_username.setBorder(BorderFactory.createLineBorder(Color.blue));
    }//GEN-LAST:event_tf_usernameMouseClicked

    private void pf_passwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_passwordMouseClicked
        // TODO add your handling code here:
        pf_password.setBorder(BorderFactory.createLineBorder(Color.blue));
    }//GEN-LAST:event_pf_passwordMouseClicked

    private void pf_confirmpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pf_confirmpasswordMouseClicked
        // TODO add your handling code here:
        pf_confirmpassword.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }//GEN-LAST:event_pf_confirmpasswordMouseClicked

    private void tf_addressMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_addressMouseClicked
        // TODO add your handling code here:
        tf_address.setBorder(BorderFactory.createLineBorder(Color.BLUE));
    }//GEN-LAST:event_tf_addressMouseClicked

    private void btn_loginnowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginnowActionPerformed
        // TODO add your handling code here:
        Login lg = new Login();
        lg.setLocationRelativeTo(null);
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_loginnowActionPerformed

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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_loginnow;
    private javax.swing.JButton btn_register;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField pf_confirmpassword;
    private javax.swing.JPasswordField pf_password;
    private javax.swing.JTextField tf_address;
    private javax.swing.JTextField tf_fullname;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}
