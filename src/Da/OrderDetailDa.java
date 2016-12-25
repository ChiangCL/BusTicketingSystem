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
import Domain.Order_Detail;
import java.sql.*;
import javax.swing.*;

public class OrderDetailDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDER_DETAIL";
    private Connection conn;
    private PreparedStatement stmt;
    private OrderDetailDa orderdetailDa;

    public OrderDetailDa() {
        createConnection();
    }

    public Order_Detail getOrderDetailRecordWithId(String ORDER_ID) {
        Order_Detail orderdetail = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE ORDER_ID = ?");
            stmt.setString(1, ORDER_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                orderdetail = new Order_Detail(ORDER_ID, rs.getString("PACKAGE_ID"), rs.getString("DEPARTURE_DATE"),
                        rs.getString("DEPARTURE_TIME"), rs.getDouble("SUBTOTAL"), rs.getString("SEAT_ID"), rs.getInt("TICKET_NO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderdetail;
    }

    public void addOnNewOrderDetailRecord(Order_Detail orderdetail) {

        try {

            stmt = conn.prepareStatement("INSERT INTO ORDER_DETAIL VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, orderdetail.getORDER_ID());
            stmt.setString(2, orderdetail.getPACKAGE_ID());
            stmt.setString(3, orderdetail.getDEPARTURE_DATE());
            stmt.setString(4, orderdetail.getDEPARTURE_TIME());
            stmt.setString(5, String.valueOf(orderdetail.getSUBTOTAL()));
            stmt.setString(6, orderdetail.getSEAT_ID());
            stmt.setString(7, String.valueOf(orderdetail.getTICKET_NO()));
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateOrderDetailRecord(Order_Detail orderdetail) {

        try {

            stmt = conn.prepareStatement("UPDATE ORDER_DETAIL SET PACKAGE_ID = ?,"
                    + " DEPARTURE_DATE = ?, DEPARTURE_TIME = ?, SUBTOTAL = ?, SEAT_ID = ?, TICKET_NO = ? WHERE ORDER_ID = ?");

            
            stmt.setString(1, orderdetail.getPACKAGE_ID());
            stmt.setString(2, orderdetail.getDEPARTURE_DATE());
            stmt.setString(3, orderdetail.getDEPARTURE_TIME());
            stmt.setString(4, String.valueOf(orderdetail.getSUBTOTAL()));
            stmt.setString(5, orderdetail.getSEAT_ID());
            stmt.setString(6, String.valueOf(orderdetail.getTICKET_NO()));
            stmt.setString(7, orderdetail.getORDER_ID());
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
    public Order_Detail checkingseatavail(String PACKAGE_ID, String DEPARTURE_DATE, String DAPERTURE_TIME) {
        Order_Detail orderdetail = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE PACKAGE_ID = ? "
                    + "AND DEPARTURE_DATE = ? AND DEPARTURE_TIME = ? ");
            stmt.setString(1, PACKAGE_ID);
            stmt.setString(2, DEPARTURE_DATE);
            stmt.setString(3, DAPERTURE_TIME);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                orderdetail = new Order_Detail(rs.getString("ORDER_ID"), rs.getString("PACKAGE_ID"), rs.getString("DEPARTURE_DATE"),
                        rs.getString("DEPARTURE_TIME"), rs.getDouble("SUBTOTAL"), rs.getString("SEAT_ID"), rs.getInt("TICKET_NO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return orderdetail;

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

}
