/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule.Package;

import Control.MaintainStaffControl;
import Da.StaffDa;
import Domain.Staff;
import Ui.Maintenance.Staff.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class Search_Package extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;
    
    public Search_Package() {

        createConnection();
        initComponents();
        RetrieveIDToComboBox();
        RetrieveTimeToComboBox();
        RetrieveDestinationToComboBox();
        setSize(567, 404);
        buttonradio.add(packageradio);
        buttonradio.add(destradio);
        buttonradio.add(timeradio);
        buttonradio.add(dayradio);
        packageradio.setSelected(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Package");
    }

    private void RetrieveTimeToComboBox() {
        try {
            String sql = "select distinct TIME from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("TIME");
                timecombo.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveIDToComboBox() {
        try {
            String sql = "select * from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                String name = rs.getString(1);
                packagecombo.addItem(name);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveDestinationToComboBox() {
        try {
            String sql = "select distinct DESTINATION from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString("DESTINATION");
                
                    destcombo.addItem(name);
                
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

        buttonradio = new javax.swing.ButtonGroup();
        staffid = new javax.swing.JLabel();
        staffname = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        packagecombo = new javax.swing.JComboBox();
        destcombo = new javax.swing.JComboBox();
        daycombo = new javax.swing.JComboBox();
        packageradio = new javax.swing.JRadioButton();
        destradio = new javax.swing.JRadioButton();
        timeradio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        dayradio = new javax.swing.JRadioButton();
        label1 = new javax.swing.JLabel();
        timecombo = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        staffid.setForeground(new java.awt.Color(255, 255, 255));
        staffid.setText("Package ID");
        getContentPane().add(staffid);
        staffid.setBounds(160, 80, 80, 30);

        staffname.setForeground(new java.awt.Color(255, 255, 255));
        staffname.setText("Destination");
        getContentPane().add(staffname);
        staffname.setBounds(160, 140, 80, 30);

        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setText("Day");
        getContentPane().add(position);
        position.setBounds(160, 200, 90, 30);
        getContentPane().add(packagecombo);
        packagecombo.setBounds(270, 80, 140, 30);
        getContentPane().add(destcombo);
        destcombo.setBounds(270, 140, 140, 30);

        daycombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        getContentPane().add(daycombo);
        daycombo.setBounds(270, 200, 140, 30);

        packageradio.setOpaque(false);
        getContentPane().add(packageradio);
        packageradio.setBounds(130, 80, 20, 30);

        destradio.setOpaque(false);
        getContentPane().add(destradio);
        destradio.setBounds(130, 140, 20, 30);

        timeradio.setOpaque(false);
        getContentPane().add(timeradio);
        timeradio.setBounds(130, 250, 20, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(240, 300, 90, 40);

        dayradio.setOpaque(false);
        getContentPane().add(dayradio);
        dayradio.setBounds(130, 200, 20, 30);

        label1.setForeground(new java.awt.Color(255, 255, 255));
        label1.setText("Time");
        getContentPane().add(label1);
        label1.setBounds(160, 250, 90, 30);
        getContentPane().add(timecombo);
        timecombo.setBounds(270, 250, 140, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = 0;
        String packageid;
        String destination;
        String day;
        String time;
        i = radioselection();
        packageid = String.valueOf(packagecombo.getSelectedItem());
        destination = String.valueOf(destcombo.getSelectedItem());
        day = String.valueOf(daycombo.getSelectedItem());
        time = String.valueOf(timecombo.getSelectedItem());
        new PackageSearch_Record(i, packageid, destination, day, time);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int radioselection() {
        int i = 0;
        if (packageradio.isSelected()) {
            i = 1;
        } else if (destradio.isSelected()) {
            i = 2;
        } else if (dayradio.isSelected()) {
            i = 3;
        } else if (timeradio.isSelected()) {
            i = 4;
        }

        return i;
    }
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
            java.util.logging.Logger.getLogger(Search_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_Package().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonradio;
    private javax.swing.JComboBox daycombo;
    private javax.swing.JRadioButton dayradio;
    private javax.swing.JComboBox destcombo;
    private javax.swing.JRadioButton destradio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label1;
    private javax.swing.JComboBox packagecombo;
    private javax.swing.JRadioButton packageradio;
    private javax.swing.JLabel position;
    private javax.swing.JLabel staffid;
    private javax.swing.JLabel staffname;
    private javax.swing.JComboBox timecombo;
    private javax.swing.JRadioButton timeradio;
    // End of variables declaration//GEN-END:variables
}
