/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Member;

import Ui.Maintenance.Staff.*;
import Control.MaintainStaffControl;
import Da.StaffDa;
import Domain.Staff;
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
public class Search_Member extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;

    public Search_Member() {
        createConnection();
        initComponents();
        RetrieveIDToComboBox();
        RetrieveNameToComboBox();
        RetrieveICToComboBox();
        setSize(567, 355);
        buttonradio.add(idradio);
        buttonradio.add(nameradio);
        buttonradio.add(icradio);
        idradio.setSelected(true);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Search Member");
    }

    private void RetrieveIDToComboBox() {
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                idcombo.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveNameToComboBox() {
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(2);
                namecombo.addItem(name);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveICToComboBox() {
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String name = rs.getString(3);
                iccombo.addItem(name);

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
        idcombo = new javax.swing.JComboBox();
        namecombo = new javax.swing.JComboBox();
        iccombo = new javax.swing.JComboBox();
        idradio = new javax.swing.JRadioButton();
        nameradio = new javax.swing.JRadioButton();
        icradio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        staffid.setForeground(new java.awt.Color(255, 255, 255));
        staffid.setText("Member ID");
        getContentPane().add(staffid);
        staffid.setBounds(160, 80, 110, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 140, 110, 30);

        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setText("Member IC");
        getContentPane().add(position);
        position.setBounds(160, 200, 110, 30);
        getContentPane().add(idcombo);
        idcombo.setBounds(270, 80, 140, 30);
        getContentPane().add(namecombo);
        namecombo.setBounds(270, 140, 140, 30);
        getContentPane().add(iccombo);
        iccombo.setBounds(270, 200, 140, 30);

        idradio.setOpaque(false);
        idradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idradioActionPerformed(evt);
            }
        });
        getContentPane().add(idradio);
        idradio.setBounds(130, 80, 20, 30);

        nameradio.setOpaque(false);
        nameradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameradioActionPerformed(evt);
            }
        });
        getContentPane().add(nameradio);
        nameradio.setBounds(130, 140, 20, 30);

        icradio.setOpaque(false);
        icradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                icradioActionPerformed(evt);
            }
        });
        getContentPane().add(icradio);
        icradio.setBounds(130, 200, 20, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 270, 90, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 570, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = 0;
        String name;
        String id;
        String ic;
        i = radioselection();
        id = String.valueOf(idcombo.getSelectedItem());
        name = String.valueOf(namecombo.getSelectedItem());
        ic = String.valueOf(iccombo.getSelectedItem());
        if (i == 0) {
            JOptionPane.showMessageDialog(null, "Please select the radio button.",
                    "Radio Button Error", JOptionPane.ERROR_MESSAGE);
        } else {
            new MemberSearch_Record(i, id, name, ic);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private int radioselection() {
        int i = 0;
        if (idradio.isSelected()) {
            i = 1;
        } else if (nameradio.isSelected()) {
            i = 2;
        } else if (icradio.isSelected()) {
            i = 3;
        }
        return i;
    }
    private void idradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idradioActionPerformed

    }//GEN-LAST:event_idradioActionPerformed

    private void icradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_icradioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_icradioActionPerformed

    private void nameradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameradioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameradioActionPerformed

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
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonradio;
    private javax.swing.JComboBox iccombo;
    private javax.swing.JRadioButton icradio;
    private javax.swing.JComboBox idcombo;
    private javax.swing.JRadioButton idradio;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox namecombo;
    private javax.swing.JRadioButton nameradio;
    private javax.swing.JLabel position;
    private javax.swing.JLabel staffid;
    // End of variables declaration//GEN-END:variables
}
