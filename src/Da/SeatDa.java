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
import Domain.Seat;
import java.sql.*;
import javax.swing.*;

public class SeatDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "SEAT";
    private Connection conn;
    private PreparedStatement stmt;
    private SeatDa seatDa;

    public SeatDa() {
        createConnection();
    }

    public Seat getSeatRecordWithId(String SEAT_ID) {
        Seat seat = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE SEAT_ID = ?");
            stmt.setString(1, SEAT_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                seat = new Seat(SEAT_ID, rs.getString("SEAT_NO"));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }

    public String[] getSeatRecordSeatNo(String SEAT_ID) {
        String[] seat = new String[100];
        int i = 0;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE SEAT_ID = ?");
            stmt.setString(1, SEAT_ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                seat[i] = rs.getString("SEAT_NO");
                i++;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }
    
    public String getSeatRecord(String SEAT_ID) {
        String seat = "";
        try {
            stmt = conn.prepareStatement("SELECT SEAT_NO FROM " + tableName + " WHERE SEAT_ID = ?");
            stmt.setString(1, SEAT_ID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                
                seat += rs.getString("SEAT_NO")+"\n";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
    }
    
    public void addOnNewSeatRecord(Seat seat) {

        try {

            stmt = conn.prepareStatement("INSERT INTO SEAT VALUES(?, ?)");
            stmt.setString(1, seat.getSEAT_ID());
            stmt.setString(2, seat.getSEAT_NO());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateSeatRecord(Seat seat, String seatno) {

        try {

            stmt = conn.prepareStatement("UPDATE SEAT SET SEAT_NO = ? WHERE SEAT_ID = ? AND SEAT_NO = ?");

            
            stmt.setString(1, seat.getSEAT_NO());
            stmt.setString(2, seat.getSEAT_ID());
            stmt.setString(3, seatno);
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
    public Seat getSeatRecordWithSeatNo(String SEAT_NO) {
        Seat seat = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE SEAT_NO = ?");
            stmt.setString(1, SEAT_NO);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                seat = new Seat(rs.getString("SEAT_ID"), rs.getString("SEAT_NO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return seat;
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
