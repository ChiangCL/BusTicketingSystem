/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Tickets;

/**
 *
 * @author Guanhaochan
 */
import Domain.Package;
import Domain.*;
import Da.*;
import Control.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Receipt extends javax.swing.JFrame {

    private PackageDa packageDa;
    private Package _package;
    private MaintainPackageControl packageControl;
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
    private double dist;
    public double total;
    private String id;
    private String memberid;
    private double gst1;
    public int seat1;
    public double amount;
    public double cash_ = 0;

    public Receipt() {
        new Receipt(Order_ID, Order_Date, Package_ID, depart_Date, depart_Time,
                Subtotal, ticket_, Ticket_No, seatid, user, position,
                dist, total, id, memberid, gst1, seat1);
    }

    public Receipt(String Order_ID, String Order_Date, String Package_ID,
            String depart_Date, String depart_Time,
            double Subtotal, int ticket_, int Ticket_No, String seatid,
            String user, String position, double dist, double total,
            String id, String memberid, double gst1, int seat1) {
        packageControl = new MaintainPackageControl();
        initComponents();

        while (cash_ < total) {
            try {
                cash_ = (double) Double.parseDouble(JOptionPane.showInputDialog(null,
                        "Please enter the amount",
                        "Payment",
                        JOptionPane.QUESTION_MESSAGE
                ));

            } catch (Exception ex) {
                cash_ = 0;
            }
        }

        paymentid.setText(id);
        order_id.setText(Order_ID);
        paymentdate.setText(Order_Date);
        packageid.setText(Package_ID);

        _package = packageControl.selectRecord(Package_ID);
        destination.setText(_package.getDESTINATION());
        packageprice.setText(String.valueOf(_package.getPRICE()));
        ticketno.setText(String.valueOf(ticket_));
        subtotal.setText(String.format("%.2f", Subtotal));
        discount.setText(String.format("%.2f", dist));
        gst_.setText(String.format("%.2f", gst1));
        total1.setText(String.format("%.2f", total));
        double round = total;
        roundingup.setText(String.format("%.2f", round - total));
        totaldue.setText(String.format("%.2f", round));
        cash.setText(String.format("%.2f", cash_));
        double changes1 = cash_ - round;
        changes.setText(String.format("%.2f", changes1));

        setSize(537, 703);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Receipt Generated");
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        order_id = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        paymentdate = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        packageprice = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        paymentid = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        packageid = new javax.swing.JTextField();
        destination = new javax.swing.JTextField();
        ticketno = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        subtotal = new javax.swing.JTextField();
        discount = new javax.swing.JTextField();
        gst_ = new javax.swing.JTextField();
        total1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        roundingup = new javax.swing.JTextField();
        totaldue = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cash = new javax.swing.JTextField();
        changes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("iLikeBus");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 30, 110, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Peter Lin 74 Green St Jordan,  Ipoh, 31800, Perak.");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setName(""); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 70, 280, 20);

        jLabel3.setText(" Contact No :012-5304975");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 90, 150, 20);

        jLabel4.setText("GST No: 001101189120");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 110, 170, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Tax Invoice");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(390, 110, 80, 30);

        jLabel16.setText("Order ID ");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 200, 60, 30);

        order_id.setEditable(false);
        order_id.setBorder(null);
        order_id.setOpaque(false);
        order_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_idActionPerformed(evt);
            }
        });
        getContentPane().add(order_id);
        order_id.setBounds(110, 200, 90, 30);

        jLabel17.setText("Payment Date ");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(280, 200, 90, 30);

        paymentdate.setEditable(false);
        paymentdate.setBorder(null);
        paymentdate.setOpaque(false);
        getContentPane().add(paymentdate);
        paymentdate.setBounds(370, 200, 120, 30);

        jLabel18.setText("SUBTOTAL");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(110, 360, 80, 30);

        packageprice.setEditable(false);
        packageprice.setBorder(null);
        packageprice.setOpaque(false);
        getContentPane().add(packageprice);
        packageprice.setBounds(370, 290, 110, 30);

        jLabel19.setText("Payment ID");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(160, 140, 70, 30);

        paymentid.setEditable(false);
        paymentid.setBorder(null);
        paymentid.setOpaque(false);
        getContentPane().add(paymentid);
        paymentid.setBounds(230, 140, 90, 30);

        jLabel20.setText("DISCOUNT");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(110, 390, 80, 30);

        jLabel21.setText("6% GST");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(110, 420, 80, 30);

        jLabel22.setText("TOTAL DUE");
        getContentPane().add(jLabel22);
        jLabel22.setBounds(110, 510, 80, 30);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(0, 260, 530, 10);

        packageid.setEditable(false);
        packageid.setBorder(null);
        packageid.setOpaque(false);
        getContentPane().add(packageid);
        packageid.setBounds(110, 290, 40, 30);

        destination.setEditable(false);
        destination.setBorder(null);
        destination.setOpaque(false);
        getContentPane().add(destination);
        destination.setBounds(160, 290, 200, 30);

        ticketno.setEditable(false);
        ticketno.setBorder(null);
        ticketno.setOpaque(false);
        getContentPane().add(ticketno);
        ticketno.setBounds(190, 330, 30, 30);

        jLabel7.setText("Tickets");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(220, 330, 50, 30);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(220, 620, 70, 30);

        subtotal.setEditable(false);
        subtotal.setBorder(null);
        subtotal.setOpaque(false);
        getContentPane().add(subtotal);
        subtotal.setBounds(370, 360, 110, 30);

        discount.setEditable(false);
        discount.setBorder(null);
        discount.setOpaque(false);
        getContentPane().add(discount);
        discount.setBounds(370, 390, 110, 30);

        gst_.setEditable(false);
        gst_.setBorder(null);
        gst_.setOpaque(false);
        getContentPane().add(gst_);
        gst_.setBounds(370, 420, 110, 30);

        total1.setEditable(false);
        total1.setBorder(null);
        total1.setOpaque(false);
        total1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                total1ActionPerformed(evt);
            }
        });
        getContentPane().add(total1);
        total1.setBounds(370, 450, 110, 30);

        jLabel8.setText("ROUNDING");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(110, 480, 80, 30);

        jLabel9.setText("CASH");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(110, 540, 80, 30);

        roundingup.setEditable(false);
        roundingup.setBorder(null);
        roundingup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roundingupActionPerformed(evt);
            }
        });
        getContentPane().add(roundingup);
        roundingup.setBounds(370, 480, 110, 30);

        totaldue.setEditable(false);
        totaldue.setBorder(null);
        getContentPane().add(totaldue);
        totaldue.setBounds(370, 510, 110, 30);

        jLabel10.setText("TOTAL");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(110, 450, 80, 30);

        jLabel11.setText("CHANGES");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(110, 570, 80, 30);

        cash.setEditable(false);
        cash.setBorder(null);
        getContentPane().add(cash);
        cash.setBounds(370, 540, 110, 30);

        changes.setEditable(false);
        changes.setBorder(null);
        getContentPane().add(changes);
        changes.setBounds(370, 570, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void roundingupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roundingupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roundingupActionPerformed

    private void total1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_total1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_total1ActionPerformed

    private void order_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_order_idActionPerformed

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
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cash;
    private javax.swing.JTextField changes;
    private javax.swing.JTextField destination;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField gst_;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField order_id;
    private javax.swing.JTextField packageid;
    private javax.swing.JTextField packageprice;
    private javax.swing.JTextField paymentdate;
    private javax.swing.JTextField paymentid;
    private javax.swing.JTextField roundingup;
    private javax.swing.JTextField subtotal;
    private javax.swing.JTextField ticketno;
    private javax.swing.JTextField total1;
    private javax.swing.JTextField totaldue;
    // End of variables declaration//GEN-END:variables
}
