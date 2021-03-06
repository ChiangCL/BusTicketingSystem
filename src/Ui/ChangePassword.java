/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Control.*;
import Da.*;
import Domain.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class ChangePassword extends javax.swing.JFrame {

    private MaintainStaffControl staffControl;
    private StaffDa staffDa;
    Staff staff;

    public ChangePassword(String user, String position) {

        staffControl = new MaintainStaffControl();

        staff = staffControl.selectRecord(user);
        initComponents();
        jTextField1.setText(user);
        jTextField2.setText(staff.getSTAFF_NAME());
        setResizable(false);
        setSize(420, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
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
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField4 = new javax.swing.JPasswordField();
        jPasswordField5 = new javax.swing.JPasswordField();
        jPasswordField6 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Staff ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 50, 110, 28);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Staff Name      ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 90, 110, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("New Password    ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 170, 110, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Old Password   ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(100, 130, 110, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 210, 110, 30);

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(210, 50, 110, 30);

        jTextField2.setEditable(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(210, 90, 110, 28);

        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(107, 276, 80, 36);

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(207, 276, 82, 36);
        getContentPane().add(jPasswordField4);
        jPasswordField4.setBounds(210, 130, 110, 30);
        getContentPane().add(jPasswordField5);
        jPasswordField5.setBounds(210, 170, 110, 30);
        getContentPane().add(jPasswordField6);
        jPasswordField6.setBounds(210, 210, 110, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 420, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        staffDa = new StaffDa();
        String pass = jPasswordField4.getText().trim();
        String id = jTextField1.getText();
        String name = jTextField2.getText();
        if (validation() == true) {
            int i = staffDa.verifyPassword(id, name, pass);

            if (i == 1) {
                staff.setPASSWORD(jPasswordField6.getText().trim());
                staffControl.UpdatePassword(staff);

                JOptionPane.showMessageDialog(null, "New Password change successfully.",
                        "Password Changed", JOptionPane.INFORMATION_MESSAGE);

                jPasswordField4.setText(null);
                jPasswordField5.setText(null);
                jPasswordField6.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "Old password Incorrect",
                        "Password incorrect", JOptionPane.ERROR_MESSAGE);
                jPasswordField4.grabFocus();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private boolean validation() {
        if (jPasswordField4.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your old password",
                    "Invalid old password", JOptionPane.ERROR_MESSAGE);
            jPasswordField4.grabFocus();
            return false;
        } else if (jPasswordField5.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your new password",
                    "Invalid new password", JOptionPane.ERROR_MESSAGE);
            jPasswordField5.grabFocus();
            return false;
        } else if (jPasswordField5.getText().trim().length() < 5) {
            JOptionPane.showMessageDialog(null, "Please enter atleast 6 alphanumeric password",
                    "Invalid Format", JOptionPane.ERROR_MESSAGE);
            jPasswordField5.grabFocus();
            return false;
        }else if (jPasswordField6.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your confirm password",
                    "Invalid confirm password", JOptionPane.ERROR_MESSAGE);
            jPasswordField6.grabFocus();
            return false;
        } else if (jPasswordField6.getText().trim().length() < 5) {
            JOptionPane.showMessageDialog(null, "Please enter atleast 6 alphanumeric password",
                    "Invalid Format", JOptionPane.ERROR_MESSAGE);
            jPasswordField6.grabFocus();
            return false;
        }else if (!jPasswordField5.getText().trim().equals(jPasswordField6.getText().trim())) {

            JOptionPane.showMessageDialog(null, "New password Not matches.",
                    "Password Not matches", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jPasswordField4.setText(null);
        jPasswordField5.setText(null);
        jPasswordField6.setText(null);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JPasswordField jPasswordField5;
    private javax.swing.JPasswordField jPasswordField6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
