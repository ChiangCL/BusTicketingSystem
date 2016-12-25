/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Staff;

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
public class Delete_Staff extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;

    public Delete_Staff() {
        staffControl = new MaintainStaffControl();
        createConnection();
        initComponents();
        RetrieveValueToComboBox();
        confirm.setEnabled(false);
        setResizable(false);
        setSize(700, 630);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Delete Staff");
    }

    private void RetrieveValueToComboBox() {
        try {
            String sql = "select * from STAFF";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                staffid.addItem(id);

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
        jLabel6 = new javax.swing.JLabel();
        staffname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        staffaddress = new javax.swing.JTextArea();
        confirm = new javax.swing.JButton();
        search = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        staffid = new javax.swing.JComboBox();
        password2 = new javax.swing.JPasswordField();
        password1 = new javax.swing.JPasswordField();
        contactno = new javax.swing.JFormattedTextField();
        staffic = new javax.swing.JFormattedTextField();
        position1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Staff ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 40, 180, 42);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Staff Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 90, 180, 42);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I.C Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 140, 180, 38);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 190, 180, 42);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 310, 180, 40);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Position");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 360, 180, 41);

        staffname.setEditable(false);
        getContentPane().add(staffname);
        staffname.setBounds(310, 90, 230, 40);

        staffaddress.setEditable(false);
        staffaddress.setColumns(20);
        staffaddress.setRows(5);
        jScrollPane1.setViewportView(staffaddress);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 190, 230, 110);

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(200, 540, 90, 30);

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        getContentPane().add(search);
        search.setBounds(560, 50, 80, 30);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(350, 540, 90, 30);

        staffid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        staffid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffidActionPerformed(evt);
            }
        });
        getContentPane().add(staffid);
        staffid.setBounds(310, 40, 230, 40);

        password2.setEditable(false);
        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });
        getContentPane().add(password2);
        password2.setBounds(310, 460, 230, 40);

        password1.setEditable(false);
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        getContentPane().add(password1);
        password1.setBounds(310, 410, 230, 40);

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
        contactno.setBounds(310, 310, 230, 40);

        staffic.setEditable(false);
        try {
            staffic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(staffic);
        staffic.setBounds(310, 140, 230, 40);

        position1.setEditable(false);
        getContentPane().add(position1);
        position1.setBounds(310, 360, 230, 40);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 410, 180, 41);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 460, 180, 41);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 690, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed

        int n = JOptionPane.showConfirmDialog(null, "Are you sure want to delete it?",
                "RECORD DELETED", JOptionPane.OK_CANCEL_OPTION);
        if (n == JOptionPane.OK_OPTION) {
            staffControl.DeleteRecord(staff);
        }

        staffid.removeAllItems();
        staffid.addItem("-");
        try {
            String sql = "select * from STAFF";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                staffid.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        staffaddress.setText(null);
        staffname.setText(null);
        contactno.setText(null);
        position1.setText(null);
        staffic.setText(null);
        password1.setText(null);
        password2.setText(null);
        staffic.setValue(null);
        contactno.setValue(null);
        confirm.setEnabled(false);
        staffid.setSelectedItem("-");
    }//GEN-LAST:event_confirmActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        if ((staffid.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the staff id",
                    "Invalid selection", JOptionPane.ERROR_MESSAGE);
        } else {
            confirm.setEnabled(true);
            String id = String.valueOf(staffid.getSelectedItem());
            staff = staffControl.selectRecord(id);

            staffname.setText(staff.getSTAFF_NAME());
            staffic.setText(staff.getSTAFF_IC());
            staffaddress.setText(staff.getADDRESS());
            contactno.setText(staff.getCONTACT_NO());
            position1.setText(staff.getPOSITION());
            password1.setText(staff.getPASSWORD());
            password2.setText(staff.getPASSWORD());
        }
    }//GEN-LAST:event_searchActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        staffaddress.setText(null);
        staffname.setText(null);
        contactno.setText(null);
        staffic.setText(null);
        position1.setText(null);
        password1.setText(null);
        password2.setText(null);
        staffic.setValue(null);
        contactno.setValue(null);
        confirm.setEnabled(false);
        staffid.setSelectedItem("-");
    }//GEN-LAST:event_resetActionPerformed

    private void staffidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffidActionPerformed

    }//GEN-LAST:event_staffidActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

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
            java.util.logging.Logger.getLogger(Delete_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Delete_Staff().setVisible(true);
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPasswordField password1;
    private javax.swing.JPasswordField password2;
    private javax.swing.JTextField position1;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JTextArea staffaddress;
    private javax.swing.JFormattedTextField staffic;
    private javax.swing.JComboBox staffid;
    private javax.swing.JTextField staffname;
    // End of variables declaration//GEN-END:variables
}
