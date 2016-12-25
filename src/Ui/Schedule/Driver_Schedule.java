/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule;

import Ui.Maintenance.*;
import Control.*;
import Da.*;
import Domain.*;
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
public class Driver_Schedule extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;

    public Driver_Schedule() {
        createConnection();
        initComponents();
        RetrieveIDToComboBox();
        RetrieveNameToComboBox();
        RetrieveICToComboBox();
        setSize(567, 355);
        buttonradio.add(driverradio);
        buttonradio.add(noradio);
        buttonradio.add(packageradio);
        driverradio.setSelected(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Driver Schedule");
    }

    private void RetrieveIDToComboBox() {
        try {
            String sql = "select * from STAFF WHERE POSITION = 'Bus Driver'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(2);
                drivername.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveNameToComboBox() {
        try {
            String sql = "select * from BUS";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(2);
                busnoradio.addItem(name);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveICToComboBox() {
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
        jLabel2 = new javax.swing.JLabel();
        position = new javax.swing.JLabel();
        drivername = new javax.swing.JComboBox();
        busnoradio = new javax.swing.JComboBox();
        packagecombo = new javax.swing.JComboBox();
        driverradio = new javax.swing.JRadioButton();
        noradio = new javax.swing.JRadioButton();
        packageradio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        staffid.setForeground(new java.awt.Color(255, 255, 255));
        staffid.setText("Driver Name");
        getContentPane().add(staffid);
        staffid.setBounds(160, 80, 110, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Bus No");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 140, 110, 30);

        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setText("Package ID");
        getContentPane().add(position);
        position.setBounds(160, 200, 110, 30);
        getContentPane().add(drivername);
        drivername.setBounds(270, 80, 140, 30);
        getContentPane().add(busnoradio);
        busnoradio.setBounds(270, 140, 140, 30);
        getContentPane().add(packagecombo);
        packagecombo.setBounds(270, 200, 140, 30);

        driverradio.setOpaque(false);
        getContentPane().add(driverradio);
        driverradio.setBounds(130, 80, 20, 30);

        noradio.setOpaque(false);
        getContentPane().add(noradio);
        noradio.setBounds(130, 140, 20, 30);

        packageradio.setOpaque(false);
        getContentPane().add(packageradio);
        packageradio.setBounds(130, 200, 20, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(230, 260, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = 0;
        String name;
        String driver;
        String _package;
        i = radioselection();
        driver = String.valueOf(drivername.getSelectedItem());
        name = String.valueOf(busnoradio.getSelectedItem());
        _package = String.valueOf(packagecombo.getSelectedItem());
        new ScheduleSearch_Record(i, driver, name, _package);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int radioselection() {
        int i = 0;
        if (driverradio.isSelected()) {
            i = 1;
        } else if (noradio.isSelected()) {
            i = 2;
        } else if (packageradio.isSelected()) {
            i = 3;
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
            java.util.logging.Logger.getLogger(Driver_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Driver_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Driver_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Driver_Schedule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Driver_Schedule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox busnoradio;
    private javax.swing.ButtonGroup buttonradio;
    private javax.swing.JComboBox drivername;
    private javax.swing.JRadioButton driverradio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton noradio;
    private javax.swing.JComboBox packagecombo;
    private javax.swing.JRadioButton packageradio;
    private javax.swing.JLabel position;
    private javax.swing.JLabel staffid;
    // End of variables declaration//GEN-END:variables
}
