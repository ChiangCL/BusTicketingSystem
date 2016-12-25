/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule.Package;

import Control.*;
import Da.*;
import Domain.Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class Delete_Package extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private PackageDa packageDa;
    private Package _package;
    private MaintainPackageControl packageControl;

    public Delete_Package() {
        packageControl = new MaintainPackageControl();
        createConnection();
        initComponents();
        RetrieveValueToComboBox();
        setSize(547, 468);
        setResizable(false);
        confirm.setEnabled(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Delete Package");
    }

    private void RetrieveValueToComboBox() {
        try {
            String sql = "select * from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                packageid.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, user, password);
            System.out.println("***TRACE: Connection established.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void shutDown() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        packageid = new javax.swing.JComboBox();
        search = new javax.swing.JButton();
        busid = new javax.swing.JTextField();
        day_ = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Package ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 60, 90, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Destination");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 110, 90, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 160, 90, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Day ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 210, 90, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bus ID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 310, 90, 30);

        destination.setEditable(false);
        getContentPane().add(destination);
        destination.setBounds(220, 110, 230, 30);

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(130, 380, 90, 30);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(290, 380, 90, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Time");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(130, 260, 90, 30);

        Time.setEditable(false);
        getContentPane().add(Time);
        Time.setBounds(220, 260, 150, 30);

        packageid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        getContentPane().add(packageid);
        packageid.setBounds(220, 60, 120, 30);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(370, 63, 90, 30);

        busid.setEditable(false);
        busid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busidActionPerformed(evt);
            }
        });
        getContentPane().add(busid);
        busid.setBounds(220, 310, 100, 30);

        day_.setEditable(false);
        getContentPane().add(day_);
        day_.setBounds(220, 210, 100, 30);

        price.setEditable(false);
        getContentPane().add(price);
        price.setBounds(220, 160, 100, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 550, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        int n = JOptionPane.showConfirmDialog(null, "Are you sure want to delete it?",
                "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.OK_OPTION) {
            packageControl.DeleteRecord(_package);
            packageid.removeAllItems();
            packageid.addItem("-");
        }

        try {
            String sql = "select * from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                packageid.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        destination.setText(null);
        day_.setText(null);
        Time.setText(null);
        price.setText(null);
        busid.setText(null);
        confirm.setEnabled(false);

    }//GEN-LAST:event_confirmActionPerformed

    public boolean validation() {
        if (destination.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please select the destination",
                    "Invalid Destination", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((price.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "Please key in the price",
                    "Invalid price", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        destination.setText(null);
        day_.setText(null);
        Time.setText(null);
        price.setText(null);
        busid.setText(null);
        confirm.setEnabled(false);
        packageid.setSelectedItem("-");
    }//GEN-LAST:event_resetActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if ((packageid.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the package id",
                    "Invalid selection", JOptionPane.ERROR_MESSAGE);
        } else {

            confirm.setEnabled(true);
            String id = String.valueOf(packageid.getSelectedItem());
            _package = packageControl.selectRecord(id);

            destination.setText(_package.getDESTINATION());
            price.setText(String.valueOf(_package.getPRICE()));
            day_.setText(_package.getDAY());
            Time.setText(_package.getTIME());
            busid.setText(_package.getBUS_ID());
        }
    }//GEN-LAST:event_searchActionPerformed

    private void busidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busidActionPerformed

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
            java.util.logging.Logger.getLogger(Delete_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Package().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Time;
    private javax.swing.JTextField busid;
    private javax.swing.JButton confirm;
    private javax.swing.JTextField day_;
    private javax.swing.JTextField destination;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox packageid;
    private javax.swing.JTextField price;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
