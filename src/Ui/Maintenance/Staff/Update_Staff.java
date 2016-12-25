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
public class Update_Staff extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;

    public Update_Staff() {
        staffControl = new MaintainStaffControl();
        createConnection();
        initComponents();
        RetrieveValueToComboBox();
        staffaddress.setEditable(false);
        staffname.setEditable(false);
        contactno.setEditable(false);
        staffic.setEditable(false);
        password1.setEditable(false);
        password2.setEditable(false);
        position1.setEnabled(false);
        confirm.setEnabled(false);
        setSize(700, 630);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Update Staff");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        position1 = new javax.swing.JComboBox();
        contactno = new javax.swing.JFormattedTextField();
        staffic = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Staff ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 40, 108, 42);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Staff Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 90, 108, 42);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("I.C Number");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 140, 108, 38);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Address");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 190, 108, 42);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contact Number");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 310, 160, 40);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Position");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 360, 160, 41);
        getContentPane().add(staffname);
        staffname.setBounds(310, 90, 230, 40);

        staffaddress.setColumns(20);
        staffaddress.setRows(5);
        jScrollPane1.setViewportView(staffaddress);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 190, 230, 108);

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
        search.setBounds(560, 50, 90, 30);

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

        password2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password2ActionPerformed(evt);
            }
        });
        getContentPane().add(password2);
        password2.setBounds(310, 460, 230, 40);

        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        getContentPane().add(password1);
        password1.setBounds(310, 410, 230, 40);

        position1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Manager", "Clerk", "Receptionist", "Bus Driver" }));
        position1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                position1ActionPerformed(evt);
            }
        });
        getContentPane().add(position1);
        position1.setBounds(310, 360, 230, 40);

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

        try {
            staffic.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        staffic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stafficActionPerformed(evt);
            }
        });
        getContentPane().add(staffic);
        staffic.setBounds(310, 140, 230, 40);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Password");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(130, 410, 160, 41);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Confirm Password");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 460, 160, 41);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 690, 630);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed

        if (validation() == true) {
            String id = String.valueOf(staffid.getSelectedItem());
            String adrs = staffaddress.getText();
            String position = String.valueOf(position1.getSelectedItem());
            String name = staffname.getText();
            String c_no = contactno.getText();
            String ic = staffic.getText();
            String pass1 = password1.getText();
            String pass2 = password2.getText();
            staff = new Staff(id, name, ic, adrs, c_no, position, pass1);
            staffControl.UpdateRecord(staff);
            JOptionPane.showMessageDialog(null, "Staff record updated successfully.",
                    "Staff Updated", JOptionPane.INFORMATION_MESSAGE);

            staffaddress.setText(null);
            staffname.setText(null);
            contactno.setText(null);
            staffic.setText(null);
            password1.setText(null);
            password2.setText(null);
            staffaddress.setEditable(false);
            staffname.setEditable(false);
            contactno.setEditable(false);
            staffic.setEditable(false);
            password1.setEditable(false);
            password2.setEditable(false);
            position1.setEnabled(false);
            staffic.setValue(null);
            contactno.setValue(null);
            staffid.setSelectedItem("-");
            position1.setSelectedItem("-");
            confirm.setEnabled(false);
        }


    }//GEN-LAST:event_confirmActionPerformed
    public boolean validation() {
        if (staffname.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the staff name",
                    "Invalid Name", JOptionPane.ERROR_MESSAGE);
            staffname.grabFocus();
            return false;
        } else if ((staffic.getText().trim().length() == 0)
                || (staffic.getText().trim().length() < 14)) {
            JOptionPane.showMessageDialog(null, "Please enter the IC number. eg.160322-08-1234",
                    "Invalid IC", JOptionPane.ERROR_MESSAGE);
            staffic.grabFocus();
            return false;
        } else if ((staffaddress.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "Please enter the staff address",
                    "Invalid Staff Address", JOptionPane.ERROR_MESSAGE);
            staffaddress.grabFocus();
            return false;
        } else if ((contactno.getText().trim().length() == 0)
                || (contactno.getText().trim().length() < 11)) {
            JOptionPane.showMessageDialog(null, "Please enter the Contact No. eg.012-3456789",
                    "Invalid Contact Number", JOptionPane.ERROR_MESSAGE);
            contactno.grabFocus();
            return false;
        } else if ((password1.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please enter the password",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);
            password1.grabFocus();
            return false;
        } else if ((password1.getText().trim().length() < 5)) {
            JOptionPane.showMessageDialog(null, "Please enter atleast 6 alphanumeric password",
                    "Invalid Format", JOptionPane.ERROR_MESSAGE);
            password1.grabFocus();
            return false;
        } else if ((password2.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Please enter the confirm password",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);
            password2.grabFocus();
            return false;
        } else if ((password2.getText().trim().length() < 5)) {
            JOptionPane.showMessageDialog(null, "Please enter atleast 6 alphanumeric password",
                    "Invalid Format", JOptionPane.ERROR_MESSAGE);
            password2.grabFocus();
            return false;
        } else if ((!password1.getText().equals(password2.getText()))) {
            JOptionPane.showMessageDialog(null, "Password not matches",
                    "Password Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((position1.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please selection the staff position",
                    "Invalid selection", JOptionPane.ERROR_MESSAGE);
            contactno.grabFocus();

            return false;
        }

        return true;
    }
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        staffaddress.setEditable(false);
        staffname.setEditable(false);
        contactno.setEditable(false);
        staffic.setEditable(false);
        password1.setEditable(false);
        password2.setEditable(false);
        position1.setEnabled(false);
        staffaddress.setText(null);
        staffname.setText(null);
        contactno.setText(null);
        staffic.setText(null);
        password1.setText(null);
        password2.setText(null);
        staffic.setValue(null);
        contactno.setValue(null);
        confirm.setEnabled(false);
        staffid.setSelectedItem("-");
        position1.setSelectedItem("-");
    }//GEN-LAST:event_resetActionPerformed

    private void position1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_position1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_position1ActionPerformed

    private void contactnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactnoActionPerformed

    private void staffidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffidActionPerformed

    }//GEN-LAST:event_staffidActionPerformed

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
            position1.setSelectedItem(staff.getPOSITION());
            password1.setText(staff.getPASSWORD());
            password2.setText(staff.getPASSWORD());
            staffaddress.setEditable(true);
            staffname.setEditable(true);
            contactno.setEditable(true);
            staffic.setEditable(true);
            password1.setEditable(true);
            password2.setEditable(true);
            position1.setEnabled(true);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

    private void password2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password2ActionPerformed

    private void stafficActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stafficActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stafficActionPerformed

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
            java.util.logging.Logger.getLogger(Update_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update_Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update_Staff().setVisible(true);
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
    private javax.swing.JComboBox position1;
    private javax.swing.JButton reset;
    private javax.swing.JButton search;
    private javax.swing.JTextArea staffaddress;
    private javax.swing.JFormattedTextField staffic;
    private javax.swing.JComboBox staffid;
    private javax.swing.JTextField staffname;
    // End of variables declaration//GEN-END:variables
}