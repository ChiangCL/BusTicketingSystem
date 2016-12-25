/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Tickets;

import Control.*;
import Da.*;
import Domain.Bus;
import Domain.Order_Detail;
import Domain.Order_Table;
import Domain.Package;
import Domain.Payment;
import Domain.Seat;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class Change_Ticket extends javax.swing.JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String username = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private PreparedStatement stmt1;
    private String orderid;
    private String destination;
    private String day;
    private MaintainPackageControl packageControl;
    private MaintainSeatControl seatControl;
    private MaintainOrderControl orderControl;
    private MaintainOrderDetailControl orderdetailControl;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    Date date1 = new Date();
    public int seat1;
    public String[] od = new String[100];
    private Package package_;
    private Order_Table order_table;
    private Seat seat;
    private Order_Detail orderdetail;
    private String user;
    private String position;
    private String seatid;
    Calendar c = Calendar.getInstance();

    public Change_Ticket() {
        new Change_Ticket(user, position).setVisible(true);
    }

    public Change_Ticket(String user, String position) {
        packageControl = new MaintainPackageControl();
        seatControl = new MaintainSeatControl();
        orderControl = new MaintainOrderControl();
        orderdetailControl = new MaintainOrderDetailControl();
        initComponents();
        departdate.setEditable(false);
        dest.setEditable(false);
        day_.setEditable(false);
        ticketcombo.setEditable(false);
        package_id.setEditable(false);
        c.setTime(date1);
        c.add(Calendar.DATE, 2);
        date1 = c.getTime();
        Changes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String id = order_id.getText().toUpperCase();
                    orderdetail = orderdetailControl.selectRecord(id);
                    if (orderdetail != null) {

                        order_table = orderControl.selectRecord(id);
                        order_date.setText(order_table.getORDER_DATE());
                        String package_id1 = orderdetail.getPACKAGE_ID();
                        package_ = packageControl.selectRecord(package_id1);
                        package_id.setText(package_.getPACKAGE_ID());
                        dest.setText(package_.getDESTINATION());
                        day_.setText(package_.getDAY());
                        price_.setText(String.valueOf(package_.getPRICE()));
                        Time.setText(package_.getTIME());
                        Time1.setText(Time.getText().substring(0, 5));
                        departdate.setText(orderdetail.getDEPARTURE_DATE());
                        ticketcombo.setText(String.valueOf(orderdetail.getTICKET_NO()));
                        Time1.setText(orderdetail.getDEPARTURE_TIME());
                        sub_total.setText(String.valueOf(orderdetail.getSUBTOTAL()));
                        seatid = orderdetail.getSEAT_ID();
                        double tickets = orderdetail.getTICKET_NO();
                        String SeAt = "";
                        String seatAT = "";
                        String SeatID = orderdetail.getSEAT_ID();
                        String seatid_ = seatControl.selectSeatRecord(SeatID);
                        for (int i = 0; tickets > i; i++) {
                            seatAT = package_id1 + "0" + (i + 1);

                            SeAt = seatid_;

                        }
                        seatno_.setText(SeAt.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "This Order Record Not Found.",
                                "Order Record NOT FOUND", JOptionPane.ERROR_MESSAGE);
                    }
                    String Order_ID = order_id.getText();
                    //String Order_Date = order_date.getText();
                    String destination = (dest.getText());

                    String Package_ID = String.valueOf(package_id.getText());
                    //String depart_Date = dateFormat.format(departdate.getText());
                    String departtime = Time.getText();
                    String depart_Time = Time1.getText();
                    double Subtotal = Double.valueOf(sub_total.getText());
                    int Ticket_No = Integer.parseInt(ticketcombo.getText().toString());
                    int ticket_ = 0;
                    /* for (int y = 0; y < ticketcombo.getSelectedIndex(); y++) {
                     ticket_ = y + 1;
                     }*/
                    String zxc = "172800000";
                    Date da1 = dateFormat.parse(orderdetail.getDEPARTURE_DATE());
                    String date1 = dateFormat.format(da1.getTime() - Long.parseLong(zxc));
                    
                    if (dateFormat.parse(orderdetail.getDEPARTURE_DATE()).before(date)) {
                        JOptionPane.showMessageDialog(null, "This ticket already expires",
                                "Ticket Expires", JOptionPane.ERROR_MESSAGE);

                    } else if (dateFormat.parse(date1).compareTo(date)<0) {
                        
                        JOptionPane.showMessageDialog(null, "Less than 2 days cannot change ticket.",
                                "Ticket Can't Changes", JOptionPane.ERROR_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Please OK to proceed the TicketChanges",
                                "TicketChanges", JOptionPane.INFORMATION_MESSAGE);

                        new Update_Ticket(Order_ID, destination, Ticket_No, Subtotal, seatid, user, position).setVisible(true);
                        dispose();
                    }
                } catch (Exception ex) {

                }

            }
        });
        setSize(801, 606);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Tickets");

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
        order_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        order_date = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        price_ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Time1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Changes = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        sub_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seatno_ = new javax.swing.JTextArea();
        dest = new javax.swing.JTextField();
        day_ = new javax.swing.JTextField();
        package_id = new javax.swing.JTextField();
        ticketcombo = new javax.swing.JTextField();
        departdate = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 80, 80, 30);

        order_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                order_idActionPerformed(evt);
            }
        });
        getContentPane().add(order_id);
        order_id.setBounds(240, 80, 90, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 80, 70, 30);

        order_date.setEditable(false);
        getContentPane().add(order_date);
        order_date.setBounds(500, 80, 110, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Package ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 180, 80, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Destination");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 130, 80, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(420, 180, 80, 30);

        price_.setEditable(false);
        getContentPane().add(price_);
        price_.setBounds(500, 180, 110, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Day");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 130, 80, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Time");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(160, 230, 80, 30);

        Time.setEditable(false);
        getContentPane().add(Time);
        Time.setBounds(240, 230, 140, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Departure Time");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(150, 330, 90, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Departure Date");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 280, 90, 30);

        Time1.setEditable(false);
        getContentPane().add(Time1);
        Time1.setBounds(240, 330, 140, 30);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Ticket No");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(420, 230, 80, 30);

        Changes.setText("Confirm");
        Changes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChangesActionPerformed(evt);
            }
        });
        getContentPane().add(Changes);
        Changes.setBounds(230, 490, 100, 30);

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(380, 490, 100, 30);

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Sub Total");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(160, 380, 80, 30);

        sub_total.setEditable(false);
        getContentPane().add(sub_total);
        sub_total.setBounds(240, 380, 100, 30);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Seat No");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(420, 280, 80, 30);

        seatno_.setEditable(false);
        seatno_.setColumns(20);
        seatno_.setRows(5);
        jScrollPane2.setViewportView(seatno_);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(500, 280, 146, 106);

        dest.setEditable(false);
        getContentPane().add(dest);
        dest.setBounds(240, 130, 160, 30);

        day_.setEditable(false);
        getContentPane().add(day_);
        day_.setBounds(500, 130, 110, 30);

        package_id.setEditable(false);
        getContentPane().add(package_id);
        package_id.setBounds(240, 180, 110, 30);
        getContentPane().add(ticketcombo);
        ticketcombo.setBounds(500, 230, 110, 30);

        departdate.setEditable(false);
        getContentPane().add(departdate);
        departdate.setBounds(240, 280, 140, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChangesActionPerformed
        try {
            String Order_ID = order_id.getText();
            String Order_Date = order_date.getText();
            String Package_ID = String.valueOf(package_id.getText());
            String depart_Date = dateFormat.format(departdate.getText());
            String depart_Time = Time1.getText();
            double Subtotal = Double.valueOf(sub_total.getText());
            int Ticket_No = Integer.parseInt(ticketcombo.getText());
            String seatid = seatControl.GetNewSeatCode();
        } catch (Exception ex) {

        }

    }//GEN-LAST:event_ChangesActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void order_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_order_idActionPerformed
        dest.setEnabled(true);
        departdate.setEnabled(true);
        String id = order_id.getText().toUpperCase();
        orderdetail = orderdetailControl.selectRecord(id);
        if (orderdetail != null) {

            order_table = orderControl.selectRecord(id);
            order_date.setText(order_table.getORDER_DATE());
            String package_id1 = orderdetail.getPACKAGE_ID();
            package_ = packageControl.selectRecord(package_id1);
            package_id.setText(package_.getPACKAGE_ID());
            dest.setText(package_.getDESTINATION());
            day_.setText(package_.getDAY());
            price_.setText(String.valueOf(package_.getPRICE()));
            Time.setText(package_.getTIME());
            Time1.setText(Time.getText().substring(0, 5));
            departdate.setText(orderdetail.getDEPARTURE_DATE());
            ticketcombo.setText(String.valueOf(orderdetail.getTICKET_NO()));
            Time1.setText(orderdetail.getDEPARTURE_TIME());
            sub_total.setText(String.valueOf(orderdetail.getSUBTOTAL()));
            double tickets = orderdetail.getTICKET_NO();
            String SeAt = "";
            String seatAT = "";
            String SeatID = orderdetail.getSEAT_ID();
            String seatid_ = seatControl.selectSeatRecord(SeatID);
            for (int i = 0; tickets > i; i++) {
                seatAT = package_id1 + "0" + (i + 1);

                SeAt = seatid_;
            }
            seatno_.setText(SeAt.toString());
        } else {
            JOptionPane.showMessageDialog(null, "This Order Record Not Found.",
                    "Order Record NOT FOUND", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_order_idActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Change_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Changes;
    private javax.swing.JTextField Time;
    private javax.swing.JTextField Time1;
    private javax.swing.JTextField day_;
    private javax.swing.JTextField departdate;
    private javax.swing.JTextField dest;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField order_date;
    private javax.swing.JTextField order_id;
    private javax.swing.JTextField package_id;
    private javax.swing.JTextField price_;
    private javax.swing.JTextArea seatno_;
    private javax.swing.JTextField sub_total;
    private javax.swing.JTextField ticketcombo;
    // End of variables declaration//GEN-END:variables
}
