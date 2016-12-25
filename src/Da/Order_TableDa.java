//This class is use to connect database
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
import Domain.Order_Table;
import java.sql.*;
import javax.swing.*;

public class Order_TableDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "ORDER_TABLE";
    private Connection conn;
    private PreparedStatement stmt;
    private Order_TableDa order_tableda;

    public Order_TableDa() {
        createConnection();
    }

    public Order_Table getOrderRecordWithId(String ORDER_ID) {
        Order_Table order_table = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE ORDER_ID = ?");
            stmt.setString(1, ORDER_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                order_table = new Order_Table(ORDER_ID, rs.getString("ORDER_DATE"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return order_table;
    }

    public void addOnNewOrderRecord(Order_Table order_table) {

        try {

            stmt = conn.prepareStatement("INSERT INTO ORDER_TABLE VALUES(?, ?)");
            stmt.setString(1, order_table.getORDER_ID());
            stmt.setString(2, order_table.getORDER_DATE());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateOrderRecord(Order_Table order_table) {

        try {

            stmt = conn.prepareStatement("UPDATE ORDER_TABLE SET ORDER_DATE = ? WHERE ORDER_ID = ?");

            stmt.setString(1, order_table.getORDER_DATE());
            stmt.setString(2, order_table.getORDER_ID());
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
