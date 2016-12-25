/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Member;

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
public class Delete_Member extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private MemberDa memberDa;
    private Member member;
    private MaintainMemberControl memberControl;

    public Delete_Member() {
        memberControl = new MaintainMemberControl();
        createConnection();
        initComponents();
        RetrieveValueToComboBox();
        confirm.setEnabled(false);
        setSize(688, 526);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        setTitle("Delete Member");
    }

    private void RetrieveValueToComboBox() {
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                memberid.addItem(id);

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

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        membername = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberaddress = new javax.swing.JTextArea();
        confirm = new javax.swing.JButton();
        search = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        memberid = new javax.swing.JComboBox();
        contactno = new javax.swing.JFormattedTextField();
        memberic = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Member ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 70, 180, 42);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 120, 180, 42);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I.C Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 170, 180, 38);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(140, 220, 180, 42);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(140, 340, 180, 40);

        membername.setEditable(false);
        getContentPane().add(membername);
        membername.setBounds(320, 120, 230, 40);

        memberaddress.setEditable(false);
        memberaddress.setColumns(20);
        memberaddress.setRows(5);
        jScrollPane1.setViewportView(memberaddress);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 220, 230, 108);

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(200, 430, 90, 30);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(570, 80, 80, 30);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(350, 430, 90, 30);

        memberid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        memberid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberidActionPerformed(evt);
            }
        });
        getContentPane().add(memberid);
        memberid.setBounds(320, 70, 230, 40);

        contactno.setEditable(false);
        try {
            contactno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        contactno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactnoActionPerformed(evt);
            }
        });
        getContentPane().add(contactno);
        contactno.setBounds(320, 340, 230, 40);

        memberic.setEditable(false);
        try {
            memberic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(memberic);
        memberic.setBounds(320, 170, 230, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 690, 520);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed

        int n = JOptionPane.showConfirmDialog(null, "Are you sure want to delete it?",
                "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.OK_OPTION) {
            memberControl.DeleteRecord(member);
            memberid.removeAllItems();
            memberid.addItem("-");
        }
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                memberid.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        memberaddress.setText(null);
        membername.setText(null);
        contactno.setText(null);
        memberic.setText(null);
        confirm.setEnabled(false);
        memberic.setValue(null);
        contactno.setValue(null);
        memberid.setSelectedItem("-");
    }//GEN-LAST:event_confirmActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if ((memberid.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the member id",
                    "Invalid selection", JOptionPane.ERROR_MESSAGE);
        } else {
            confirm.setEnabled(true);

            String id = String.valueOf(memberid.getSelectedItem());
            member = memberControl.selectRecord(id);

            membername.setText(member.getMEMBER_NAME());
            memberic.setText(member.getMEMBER_IC());
            memberaddress.setText(member.getADDRESS());
            contactno.setText(member.getCONTACT_NO());
        }

    }//GEN-LAST:event_searchActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        memberaddress.setText(null);
        membername.setText(null);
        contactno.setText(null);
        memberic.setText(null);
        confirm.setEnabled(false);
        memberic.setValue(null);
        contactno.setValue(null);
        memberid.setSelectedItem("-");

    }//GEN-LAST:event_resetActionPerformed

    private void memberidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberidActionPerformed

    }//GEN-LAST:event_memberidActionPerformed

    private void contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnoActionPerformed

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
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirm;
    private javax.swing.JFormattedTextField contactno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea memberaddress;
    private javax.swing.JFormattedTextField memberic;
    private javax.swing.JComboBox memberid;
    private javax.swing.JTextField membername;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
