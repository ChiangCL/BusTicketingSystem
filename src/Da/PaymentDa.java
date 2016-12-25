/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Da;

/**
 *
 * @author Guanhaochan
 */
import Domain.Payment;
import java.sql.*;

import javax.swing.*;

public class PaymentDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PAYMENT";
    private Connection conn;
    private PreparedStatement stmt;
    private PaymentDa paymentDa;

    public PaymentDa() {
        createConnection();
    }

    public Payment getPaymentRecordWithId(String PAYMENT_ID) {
        Payment payment = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE PAYMENT_ID = ?");
            stmt.setString(1, PAYMENT_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                payment = new Payment(PAYMENT_ID, rs.getString("PAYMENT_METHOD"), rs.getDouble("DISCOUNT"),
                        rs.getDouble("TOTAL_AMOUNT"), rs.getString("PAYMENT_DATE"), rs.getString("STAFF_ID"),
                        rs.getString("MEMBER_ID"), rs.getString("ORDER_ID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return payment;
    }

    public void addOnNewPaymentRecord(Payment payment) {

        try {

            stmt = conn.prepareStatement("INSERT INTO PAYMENT VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, payment.getPAYMENT_ID());
            stmt.setString(2, payment.getPAYMENT_METHOD());
            stmt.setDouble(3, payment.getDISCOUNT());
            stmt.setDouble(4, payment.getTOTAL_AMOUNT());
            stmt.setString(5, payment.getPAYMENT_DATE());
            stmt.setString(6, payment.getSTAFF_ID());
            stmt.setString(7, payment.getMEMBER_ID());
            stmt.setString(8, payment.getORDER_ID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePaymentRecord(Payment payment) {

        try {

            stmt = conn.prepareStatement("UPDATE PAYMENT SET PAYMENT_METHOD = ?, DISCOUNT = ?,"
                    + " TOTAL_AMOUNT = ?, PAYMENT_DATE = ?, STAFF_ID = ?, MEMBER_ID = ?, ORDER_ID = ? "
                    + "WHERE PAYMENT_ID = ?");

            stmt.setString(1, payment.getPAYMENT_METHOD());
            stmt.setDouble(2, payment.getDISCOUNT());
            stmt.setDouble(3, payment.getTOTAL_AMOUNT());
            stmt.setString(4, payment.getPAYMENT_DATE());
            stmt.setString(5, payment.getSTAFF_ID());
            stmt.setString(6, payment.getMEMBER_ID());
            stmt.setString(7, payment.getORDER_ID());
            stmt.setString(8, payment.getPAYMENT_ID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*public void deleteBusRecordWithId(Bus bus) {

     try {
     stmt = conn.prepareStatement("DELETE FROM BUS WHERE BUS_ID = ?");
     stmt.setString(1, bus.getBUS_ID());

     stmt.executeUpdate();
     } catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
     }
     }*/
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

}
