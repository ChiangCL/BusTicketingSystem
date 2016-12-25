/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Member;

import Ui.Maintenance.Member.*;
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
public class Update_Member extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private MemberDa memberDa;
    private Member member;
    private MaintainMemberControl memberControl;

    public Update_Member() {
        memberControl = new MaintainMemberControl();
        createConnection();
        initComponents();
        RetrieveValueToComboBox();
        memberaddress.setEditable(false);
        membername.setEditable(false);
        contactno.setEditable(false);
        memberic.setEditable(false);
        confirm.setEnabled(false);
        setSize(700, 520);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Update Member");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Member ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 70, 180, 42);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Member Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 120, 180, 42);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I.C Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(110, 170, 180, 38);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 220, 180, 42);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 340, 180, 40);
        getContentPane().add(membername);
        membername.setBounds(290, 120, 230, 40);

        memberaddress.setColumns(20);
        memberaddress.setRows(5);
        jScrollPane1.setViewportView(memberaddress);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(290, 220, 230, 108);

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(170, 430, 90, 30);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(540, 80, 80, 30);

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
        memberid.setBounds(290, 70, 230, 40);

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
        contactno.setBounds(290, 340, 230, 40);

        try {
            memberic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(memberic);
        memberic.setBounds(290, 170, 230, 40);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 690, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed

        String id = String.valueOf(memberid.getSelectedItem());
        String adrs = memberaddress.getText();
        String name = membername.getText().toUpperCase();
        String c_no = contactno.getText();
        String ic = memberic.getText();

        if (validation() == true) {
            member = new Member(id, name, ic, adrs, c_no);
            memberControl.UpdateRecord(member);
            JOptionPane.showMessageDialog(null, "Member record updated successfully.",
                    "Member Updated", JOptionPane.INFORMATION_MESSAGE);
        }
        memberaddress.setText(null);
        membername.setText(null);
        contactno.setText(null);
        memberic.setText(null);
        memberaddress.setEditable(false);
        membername.setEditable(false);
        contactno.setEditable(false);
        memberic.setEditable(false);
        memberic.setValue(null);
        contactno.setValue(null);
        confirm.setEnabled(false);
    }//GEN-LAST:event_confirmActionPerformed
    public boolean validation() {
        if (membername.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the member name.",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
            membername.grabFocus();
            return false;
        } else if ((memberic.getText().trim().length() == 0)
                || (memberic.getText().trim().length() < 14)) {
            JOptionPane.showMessageDialog(null, "IC must have 12 Digit. egeg.160322-08-1234",
                    "Invalid IC", JOptionPane.ERROR_MESSAGE);
            memberic.grabFocus();
            return false;
        } else if ((memberaddress.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "Please key in address.",
                    "Invalid Staff Address", JOptionPane.ERROR_MESSAGE);
            memberaddress.grabFocus();
            return false;
        } else if ((contactno.getText().trim().length() == 0)
                || (contactno.getText().trim().length() < 11)) {
            JOptionPane.showMessageDialog(null, "Contact Number must be 10 Digit. 012-3456789",
                    "Invalid Contact Number", JOptionPane.ERROR_MESSAGE);
            contactno.grabFocus();
            return false;
        }

        return true;
    }
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        memberaddress.setEditable(false);
        membername.setEditable(false);
        contactno.setEditable(false);
        memberic.setEditable(false);
        confirm.setEnabled(false);
        memberaddress.setText(null);
        membername.setText(null);
        contactno.setText(null);
        memberic.setText(null);
        memberic.setValue(null);
        contactno.setValue(null);
        memberid.setSelectedItem("-");

    }//GEN-LAST:event_resetActionPerformed

    private void contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnoActionPerformed

    private void memberidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberidActionPerformed

    }//GEN-LAST:event_memberidActionPerformed

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
            memberaddress.setEditable(true);
            membername.setEditable(true);
            contactno.setEditable(true);
            memberic.setEditable(true);
        }
    }//GEN-LAST:event_searchActionPerformed

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
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Member().setVisible(true);
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