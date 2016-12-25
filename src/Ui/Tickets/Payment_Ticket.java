/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Tickets;

import Control.*;
import Domain.*;
import Domain.Package;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class Payment_Ticket extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String username = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private String Order_ID;
    private String Order_Date;
    private String Package_ID;
    private String depart_Date;
    private String depart_Time;
    private double Subtotal;
    private int Ticket_No;
    private int ticket_;
    private String seatid;
    private String user;
    private String position;
    public int seat1;
    private MaintainPaymentControl paymentControl;
    private MaintainPackageControl packageControl;
    private MaintainSeatControl seatControl;
    private MaintainOrderControl orderControl;
    private MaintainOrderDetailControl orderdetailControl;
    private Package package_;
    private Order_Table order_table;
    private Seat seat;
    private Order_Detail orderdetail;
    private Payment payment;

    public Payment_Ticket() {
        new Payment_Ticket(Order_ID, Order_Date, Package_ID, depart_Date, depart_Time, Subtotal, ticket_,
                Ticket_No, seatid, user, position, seat1);
    }

    public Payment_Ticket(String Order_ID, String Order_Date, String Package_ID, String depart_Date, String depart_Time,
            double Subtotal, int ticket_, int Ticket_No, String seatid, String user, String position, int seat1) {

        packageControl = new MaintainPackageControl();
        seatControl = new MaintainSeatControl();
        orderControl = new MaintainOrderControl();
        orderdetailControl = new MaintainOrderDetailControl();
        paymentControl = new MaintainPaymentControl();
        createConnection();
        initComponents();
        String id = paymentControl.GetNewPaymentCode();
        paymentid.setText(id);
        paymethod.add(creditcard);
        paymethod.add(cash);
        membery_n.add(nno);
        membery_n.add(yyes);
        cash.setSelected(true);
        memberidcombo.setEnabled(false);
        discount.setEnabled(false);
        RetrieveMemberIDToComboBox();
        nno.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int i = radioselection();
                if (i == 2) {
                    double discountvalue = Subtotal;
                    double gst = Subtotal * 0.06;
                    double totalvalue = Subtotal + gst;
                    discount.setText(String.valueOf(0));
                    gstcharge.setText(String.format("%.2f", gst));
                    totalamount.setText(String.format("%.2f", totalvalue));
                }
            }
        });
        yyes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                memberidcombo.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int i = radioselection();
                        if (i == 1) {
                            double discountvalue = Subtotal * 0.1;
                            double gst = Subtotal * 0.06;
                            double totalvalue = Subtotal - discountvalue + gst;
                            discount.setText(String.format("%.2f", discountvalue));
                            gstcharge.setText(String.format("%.2f", gst));
                            totalamount.setText(String.format("%.2f", totalvalue));
                        } else if (i == 2) {
                            double discountvalue = Subtotal;
                            double gst = Subtotal * 0.06;
                            double totalvalue = Subtotal + gst;
                            discount.setText(String.valueOf(0));
                            gstcharge.setText(String.format("%.2f", gst));
                            totalamount.setText(String.format("%.2f", totalvalue));
                        }
                    }
                });
            }
        });

        paybutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (validation() == true) {
                int x = paymentradioselection();
                String method = "";
                String memberid = "null";
                if (x == 1) {
                    method = "CREDIT CARD";
                } else if (x == 2) {
                    method = "CASH";
                }
                int a = radioselection();
                if (a == 1) {
                    memberid = String.valueOf(memberidcombo.getSelectedItem());

                } else if (a == 2) {
                    memberid = String.valueOf("null");
                }
                String id = paymentid.getText();

                double dist = Double.valueOf(discount.getText());
                double total = Double.valueOf(totalamount.getText());
                double gst = Double.valueOf(gstcharge.getText());

                order_table = new Order_Table(Order_ID, Order_Date);
                orderControl.addRecord(order_table);

                orderdetail = new Order_Detail(Order_ID, Package_ID, depart_Date, depart_Time, Subtotal, seatid, ticket_);
                orderdetailControl.addRecord(orderdetail);
                String SeAt = "";
                String seatAT = "";
                for (int i = 0; Ticket_No > i; i++) {
                    seatAT = Package_ID + "0" + (i + 1);

                    SeAt = Package_ID + "0" + (seat1 + i + 1);
                    seat = new Seat(seatid, SeAt);
                    seatControl.addRecord(seat);

                }

                payment = new Payment(id, method, dist, total, Order_Date, user, memberid, Order_ID);
                paymentControl.addRecord(payment);
                dispose();
                new Receipt(Order_ID, Order_Date, Package_ID, depart_Date, depart_Time, Subtotal, ticket_,
                        Ticket_No, seatid, user, position, dist, total, id, memberid, gst, seat1).setVisible(true);
                new Ticket_Receipt(Order_ID, Order_Date, Package_ID, depart_Date, depart_Time, Subtotal, ticket_,
                        Ticket_No, seatid, user, position, total, memberid, seat1).setVisible(true);
            }
            }
        });
        cancelbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Purchase_Ticket(user, position).setVisible(true);
            }
        });
        setSize(552, 470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Payment");
    }

    private void RetrieveMemberIDToComboBox() {
        try {
            String sql = "select * from MEMBER";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                memberidcombo.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void createConnection() {
        try {
            conn = DriverManager.getConnection(host, username, password);
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

    /*private boolean validation(){
     if ((.getSelectedItem() == "-")) {
     JOptionPane.showMessageDialog(null, "Please select the From destination ",
     "Invalid from destination", JOptionPane.ERROR_MESSAGE);
     return false;
     }
     return true;
     }*/
    private int radioselection() {
        int i = 0;
        if (yyes.isSelected()) {
            i = 1;

        } else if (nno.isSelected()) {
            i = 2;
        }
        return i;
    }

    private int paymentradioselection() {
        int i = 0;
        if (creditcard.isSelected()) {
            i = 1;

        } else if (cash.isSelected()) {
            i = 2;
        }
        return i;
    }
    private boolean validation(){
        if ((nno.getSelectedObjects()== null && yyes.getSelectedObjects() == null)) {
            JOptionPane.showMessageDialog(null, "Please choose either one.",
                    "Invalid member selection", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymethod = new javax.swing.ButtonGroup();
        membery_n = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        paymentid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        creditcard = new javax.swing.JRadioButton();
        cash = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        yyes = new javax.swing.JRadioButton();
        nno = new javax.swing.JRadioButton();
        memberidcombo = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        discount = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        gstcharge = new javax.swing.JTextField();
        totalamount = new javax.swing.JTextField();
        paybutton = new javax.swing.JButton();
        cancelbutton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Payment ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 100, 90, 30);

        paymentid.setEditable(false);
        getContentPane().add(paymentid);
        paymentid.setBounds(220, 100, 110, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Payment Method");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(130, 150, 90, 30);

        creditcard.setForeground(new java.awt.Color(255, 255, 255));
        creditcard.setText("CREDIT CARD");
        creditcard.setOpaque(false);
        getContentPane().add(creditcard);
        creditcard.setBounds(240, 150, 110, 30);

        cash.setForeground(new java.awt.Color(255, 255, 255));
        cash.setText("CASH");
        cash.setOpaque(false);
        getContentPane().add(cash);
        cash.setBounds(360, 150, 93, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Member");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 200, 90, 30);

        yyes.setForeground(new java.awt.Color(255, 255, 255));
        yyes.setText("Yes");
        yyes.setOpaque(false);
        yyes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yyesActionPerformed(evt);
            }
        });
        getContentPane().add(yyes);
        yyes.setBounds(240, 200, 60, 30);

        nno.setForeground(new java.awt.Color(255, 255, 255));
        nno.setText("No");
        nno.setOpaque(false);
        nno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nnoActionPerformed(evt);
            }
        });
        getContentPane().add(nno);
        nno.setBounds(320, 200, 60, 30);

        memberidcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberidcomboActionPerformed(evt);
            }
        });
        getContentPane().add(memberidcombo);
        memberidcombo.setBounds(390, 200, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total Amount");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(130, 320, 90, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("10%Discount");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(130, 240, 90, 30);

        discount.setEditable(false);
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });
        getContentPane().add(discount);
        discount.setBounds(220, 240, 100, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("6%GST Charge");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(130, 280, 90, 30);

        gstcharge.setEditable(false);
        getContentPane().add(gstcharge);
        gstcharge.setBounds(220, 280, 100, 30);

        totalamount.setEditable(false);
        getContentPane().add(totalamount);
        totalamount.setBounds(220, 320, 100, 30);

        paybutton.setText("Pay");
        paybutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paybuttonActionPerformed(evt);
            }
        });
        getContentPane().add(paybutton);
        paybutton.setBounds(150, 380, 90, 30);

        cancelbutton.setText("Cancel");
        cancelbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelbutton);
        cancelbutton.setBounds(300, 380, 90, 30);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 550, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nnoActionPerformed
        memberidcombo.setEnabled(false);
        discount.setEnabled(false);
    }//GEN-LAST:event_nnoActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void paybuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paybuttonActionPerformed


    }//GEN-LAST:event_paybuttonActionPerformed

    private void memberidcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberidcomboActionPerformed

    }//GEN-LAST:event_memberidcomboActionPerformed

    private void yyesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yyesActionPerformed
        memberidcombo.setEnabled(true);
        discount.setEnabled(true);
    }//GEN-LAST:event_yyesActionPerformed

    private void cancelbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbuttonActionPerformed

    }//GEN-LAST:event_cancelbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(Payment_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment_Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbutton;
    private javax.swing.JRadioButton cash;
    private javax.swing.JRadioButton creditcard;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField gstcharge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JComboBox memberidcombo;
    private javax.swing.ButtonGroup membery_n;
    private javax.swing.JRadioButton nno;
    private javax.swing.JButton paybutton;
    private javax.swing.JTextField paymentid;
    private javax.swing.ButtonGroup paymethod;
    private javax.swing.JTextField totalamount;
    private javax.swing.JRadioButton yyes;
    // End of variables declaration//GEN-END:variables
}
