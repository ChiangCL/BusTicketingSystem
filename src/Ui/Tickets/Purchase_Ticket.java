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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class Purchase_Ticket extends javax.swing.JFrame {

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
    public int seat1;
    public String[] od = new String[100];
    private Package package_;
    private Order_Table order_table;
    private Seat seat;
    private Order_Detail orderdetail;
    private String user;
    private String position;
    public int seatno;
    public int totalseat;

    public Purchase_Ticket() {
        new Purchase_Ticket(user, position).setVisible(true);
    }

    public Purchase_Ticket(String user, String position) {
        packageControl = new MaintainPackageControl();
        seatControl = new MaintainSeatControl();
        orderControl = new MaintainOrderControl();
        orderdetailControl = new MaintainOrderDetailControl();
        createConnection();
        String id = orderControl.GetNewOrderCode();
        initComponents();
        RetrieveValueToComboBox();
        order_id.setText(id);
        submit.setEnabled(false);
        departdate.setEnabled(false);
        package_id.setEnabled(false);
        RetrieveBusIDToComboBox(destination, day);

        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (validation1() == true) {
                    try {
                        
                        ticketcombo.setEnabled(true);
                        String bus_id = RetrievePackage(String.valueOf(package_id.getSelectedItem()));
                        totalseat = RetrieveBusSeat(bus_id);
                        seat1 = RetrieveTicketToComboBox(String.valueOf(package_id.getSelectedItem()),
                                departdate.getDate(),
                                Time1.getText());

                        seatno = totalseat - seat1;
                        String seatAT = "";
                        ticketcombo.removeAllItems();
                        for (int i = 0; i < seatno; i++) {
                            seatAT = String.valueOf(package_id.getSelectedItem()) + "0" + (i + 1);
                            ticketcombo.addItem(i + 1);
                        }
                        ok.setEnabled(false);
                        departdate.setEnabled(false);
                    } catch (Exception ex) {

                    }
                    submit.setEnabled(true);

                }
            }
        }
        );

        departdate.getJCalendar()
                .setMinSelectableDate(date);
        /*if(day.equals("Monday")){
         departdate.getJCalendar().getCalendar().setFirstDayOfWeek(Calendar.MONDAY);
         }else if(day.equals("Tuesday")){
         departdate.getCalendar().setFirstDayOfWeek(Calendar.TUESDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }else if(day.equals("Wednesday")){
         departdate.getCalendar().setFirstDayOfWeek(Calendar.WEDNESDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }else if(day.equals("Thursday")){
         departdate.getCalendar().setFirstDayOfWeek(Calendar.THURSDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }else if(day.equals("Friday")){
         departdate.getCalendar().setFirstDayOfWeek(Calendar.FRIDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }else if(day.equals("Saturday")){
         departdate.getCalendar().setFirstDayOfWeek(Calendar.SATURDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }else{
         departdate.getCalendar().setFirstDayOfWeek(Calendar.SUNDAY);
         departdate.getJCalendar().setMinSelectableDate(date);
         }*/
        order_date.setText(dateFormat.format(date));
        ticketcombo.setEnabled(false);

        submit.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e
                    ) {
                        if (validation() == true) {
                            if (validation1() == true) {

                                String Order_ID = order_id.getText();
                                String Order_Date = order_date.getText();
                                String Package_ID = String.valueOf(package_id.getSelectedItem());
                                String depart_Date = dateFormat.format(departdate.getDate());
                                String depart_Time = Time1.getText();
                                double Subtotal = Double.valueOf(sub_total.getText());
                                int Ticket_No = Integer.parseInt(ticketcombo.getSelectedItem().toString());
                                int ticket_ = 0;
                                for (int y = 0; y < ticketcombo.getSelectedIndex(); y++) {
                                    ticket_ = y + 1;
                                }

                                String seatid = seatControl.GetNewSeatCode();

                                JOptionPane.showMessageDialog(null,
                                        "Please OK to proceed the payment",
                                        "Payment details",
                                        JOptionPane.INFORMATION_MESSAGE);
                                
                                new Payment_Ticket(Order_ID, Order_Date,
                                        Package_ID, depart_Date, depart_Time,
                                        Subtotal, ticket_ + 1, Ticket_No,
                                        seatid, user,
                                        position, seat1).setVisible(true);
                                dispose();
                            }
                        }
                    }
                }
        );
        setSize(678, 592);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Tickets");

    }

    private void RetrieveValueToComboBox() {
        try {
            String sql = "select distinct DESTINATION from PACKAGE";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String destination = rs.getString("DESTINATION");
                destination_.addItem(destination);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveDayComboBox(String dest) {
        try {
            String sql = "select * from PACKAGE WHERE DESTINATION = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dest);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String day1 = rs.getString("DAY");
                day_.addItem(day1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private void RetrieveBusIDToComboBox(String destination, String day) {
        try {
            String sql = "SELECT\n"
                    + "     PACKAGE.\"PACKAGE_ID\" AS PACKAGE_PACKAGE_ID,\n"
                    + "     PACKAGE.\"DESTINATION\" AS PACKAGE_DESTINATION,\n"
                    + "     PACKAGE.\"PRICE\" AS PACKAGE_PRICE,\n"
                    + "     PACKAGE.\"DAY\" AS PACKAGE_DAY,\n"
                    + "     PACKAGE.\"TIME\" AS PACKAGE_TIME,\n"
                    + "     PACKAGE.\"BUS_ID\" AS PACKAGE_BUS_ID\n"
                    + "FROM\n"
                    + "     \"NBUSER\".\"PACKAGE\" PACKAGE\n"
                    + "WHERE DESTINATION ='" + destination + "' "
                    + "AND DAY ='" + day + "'";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                String id = rs.getString(1);
                package_id.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private int RetrieveTicketToComboBox(String Package_ID,
            Date depart_Date, String depart_Time) {

        int seat1 = 0;
        String ddate = dateFormat.format(depart_Date);

        try {
            String sql = "SELECT * FROM ORDER_DETAIL WHERE DEPARTURE_DATE = ? "
                    + "AND DEPARTURE_TIME = ? AND PACKAGE_ID = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ddate);
            stmt.setString(2, depart_Time);
            stmt.setString(3, Package_ID);
            ResultSet rs = stmt.executeQuery();
            int i = 0;
            while (rs.next()) {
                od[i] = rs.getString("TICKET_NO");
                i++;
                String ticket1 = rs.getString(7);
                seat1 += Integer.parseInt(ticket1);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return seat1;
    }

    private String RetrievePackage(String Package_ID) {
        String bus_id = "";
        try {
            String sql = "SELECT * FROM PACKAGE WHERE PACKAGE_ID "
                    + "='" + Package_ID + "'";

            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                bus_id = rs.getString(6);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return bus_id;
    }

    private int RetrieveBusSeat(String bus_id) {
        int seat1 = 0;
        try {
            String sql = "SELECT * FROM BUS WHERE BUS_ID ='" + bus_id + "'";

            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String ticket = rs.getString(3);
                seat1 = Integer.parseInt(ticket);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return seat1;
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
        package_id = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        price_ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        check = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        departdate = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Time1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ticketcombo = new javax.swing.JComboBox();
        submit = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        sub_total = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        seatno_ = new javax.swing.JTextArea();
        ok = new javax.swing.JButton();
        day_ = new javax.swing.JComboBox();
        destination_ = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Order ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 80, 80, 30);

        order_id.setEditable(false);
        getContentPane().add(order_id);
        order_id.setBounds(240, 80, 90, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Order Date");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(420, 80, 70, 30);

        order_date.setEditable(false);
        getContentPane().add(order_date);
        order_date.setBounds(490, 80, 110, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Package ID");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 180, 80, 30);

        package_id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        getContentPane().add(package_id);
        package_id.setBounds(240, 180, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Destination");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(160, 130, 80, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 230, 80, 30);

        price_.setEditable(false);
        getContentPane().add(price_);
        price_.setBounds(240, 230, 90, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Day");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(420, 130, 70, 30);

        check.setText("Check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check);
        check.setBounds(360, 180, 80, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Time");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(410, 230, 50, 30);

        Time.setEditable(false);
        getContentPane().add(Time);
        Time.setBounds(460, 230, 120, 30);
        getContentPane().add(departdate);
        departdate.setBounds(240, 280, 140, 30);

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
        jLabel10.setBounds(460, 280, 70, 30);

        ticketcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketcomboActionPerformed(evt);
            }
        });
        getContentPane().add(ticketcombo);
        ticketcombo.setBounds(530, 280, 70, 30);

        submit.setText("Confirm");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });
        getContentPane().add(submit);
        submit.setBounds(230, 470, 100, 30);

        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(380, 470, 100, 30);

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
        jLabel14.setBounds(400, 330, 60, 30);

        seatno_.setEditable(false);
        seatno_.setColumns(20);
        seatno_.setRows(5);
        jScrollPane2.setViewportView(seatno_);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(460, 330, 146, 106);

        ok.setText("Ok");
        getContentPane().add(ok);
        ok.setBounds(390, 280, 50, 30);

        day_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        day_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                day_ActionPerformed(evt);
            }
        });
        getContentPane().add(day_);
        day_.setBounds(490, 130, 110, 30);

        destination_.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        destination_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destination_ActionPerformed(evt);
            }
        });
        getContentPane().add(destination_);
        destination_.setBounds(240, 130, 160, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(0, 0, 680, 590);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed

        if (validation() == true) {
            departdate.setEnabled(true);
            String id = String.valueOf(package_id.getSelectedItem());
            //String depart = dateFormat.format(departdate.getDate());
            package_ = packageControl.selectRecord(id);

            price_.setText(String.valueOf(package_.getPRICE()));
            Time.setText(package_.getTIME());
            Time1.setText(Time.getText().substring(0, 5));

        }
    }//GEN-LAST:event_checkActionPerformed

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed

        String Order_ID = order_id.getText();
        String Order_Date = order_date.getText();
        String Package_ID = String.valueOf(package_id.getSelectedItem());
        String depart_Date = dateFormat.format(departdate.getDate());
        String depart_Time = Time1.getText();
        double Subtotal = Double.valueOf(sub_total.getText());
        int Ticket_No = ticketcombo.getSelectedIndex();
        String seatid = seatControl.GetNewSeatCode();


    }//GEN-LAST:event_submitActionPerformed

    private boolean validation() {
        if (destination_.getSelectedItem() == "-") {
            JOptionPane.showMessageDialog(null, "Please select the destination.",
                    "Invalid Destination", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (day_.getSelectedItem() == "-") {
            JOptionPane.showMessageDialog(null, "Please select the day.",
                    "Invalid Day", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (package_id.getSelectedItem() == "-") {
            JOptionPane.showMessageDialog(null, "Please select the package id.",
                    "Invalid Package ID", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean validation1() {
        if (departdate.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please select the departure date.",
                    "Invalid departure date", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    private void ticketcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketcomboActionPerformed

        int i;
        int y;
        int z = 0;
        int Ticket_No = Integer.valueOf(ticketcombo.getSelectedItem().toString());
        String Package_ID = String.valueOf(package_id.getSelectedItem());
        double ticket = Double.valueOf(Ticket_No);
        double Price = Double.parseDouble(price_.getText());
        String SeAt = "";
        String seatAT = "";
        for (i = 0; Ticket_No > i; i++) {
            seatAT = Package_ID + "0" + (i + 1);

            SeAt += Package_ID + "0" + (seat1 + i + 1) + "\n";

        }
        seatno_.setText(SeAt.toString());
        for (y = 0; y < ticketcombo.getSelectedIndex(); y++) {
            z = y + 1;
        }
        double total = (z + 1) * Price;
        sub_total.setText(String.valueOf(total));


    }//GEN-LAST:event_ticketcomboActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed

        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void day_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_day_ActionPerformed
        if (day_.isShowing()) {
            package_id.removeAllItems();
            package_id.addItem("-");
        }
        package_id.setEnabled(true);
        destination = String.valueOf(destination_.getSelectedItem());
        day = String.valueOf(day_.getSelectedItem());
        RetrieveBusIDToComboBox(destination, day);
    }//GEN-LAST:event_day_ActionPerformed

    private void destination_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destination_ActionPerformed
        if (destination_.isShowing()) {
            day_.removeAllItems();
            day_.addItem("-");

        }
        RetrieveDayComboBox(String.valueOf(destination_.getSelectedItem()));
    }//GEN-LAST:event_destination_ActionPerformed

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
                new Purchase_Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Time;
    private javax.swing.JTextField Time1;
    private javax.swing.JButton cancel;
    private javax.swing.JButton check;
    private javax.swing.JComboBox day_;
    private com.toedter.calendar.JDateChooser departdate;
    private javax.swing.JComboBox destination_;
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
    private javax.swing.JButton ok;
    private javax.swing.JTextField order_date;
    private javax.swing.JTextField order_id;
    private javax.swing.JComboBox package_id;
    private javax.swing.JTextField price_;
    private javax.swing.JTextArea seatno_;
    private javax.swing.JTextField sub_total;
    private javax.swing.JButton submit;
    private javax.swing.JComboBox ticketcombo;
    // End of variables declaration//GEN-END:variables
}
