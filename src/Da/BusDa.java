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
import Domain.Bus;
import java.sql.*;
import javax.swing.*;
import Domain.Package;

public class BusDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "BUS";
    private Connection conn;
    private PreparedStatement stmt;
    private BusDa busDa;
    private PackageDa packageDa;

    public BusDa() {
        createConnection();
    }

    public Bus getBusRecordWithId(String BUS_ID) {
        Bus bus = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE BUS_ID = ?");
            stmt.setString(1, BUS_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                bus = new Bus(BUS_ID, rs.getString("BUS_NO"), rs.getInt("SEAT"),
                        rs.getString("BUS_MODEL"), rs.getString("STAFF_ID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return bus;
    }

    public String RetrieveBusStaffID() {
        String staffbus_id = "";
        try {
            String sql = "SELECT * FROM BUS";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                staffbus_id = rs.getString(5);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return staffbus_id;
    }

    public void addOnNewBusRecord(Bus bus) {

        try {

            stmt = conn.prepareStatement("INSERT INTO BUS VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, bus.getBUS_ID());
            stmt.setString(2, bus.getBUS_NO());
            stmt.setString(3, String.valueOf(bus.getSEAT()));
            stmt.setString(4, bus.getBUS_MODEL());
            stmt.setString(5, bus.getSTAFF_ID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateBusRecord(Bus bus) {

        try {

            stmt = conn.prepareStatement("UPDATE BUS SET BUS_NO = ?, SEAT = ?,"
                    + " BUS_MODEL = ?, STAFF_ID = ? WHERE BUS_ID = ?");

            stmt.setString(1, bus.getBUS_NO());
            stmt.setString(2, String.valueOf(bus.getSEAT()));
            stmt.setString(3, bus.getBUS_MODEL());
            stmt.setString(4, bus.getSTAFF_ID());
            stmt.setString(5, bus.getBUS_ID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteBusRecordWithId(Bus bus) {

        try {
            stmt = conn.prepareStatement("DELETE FROM BUS WHERE BUS_ID = ?");
            stmt.setString(1, bus.getBUS_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String RetrieveBusNo(String PACKAGE_ID) {
        Bus bus = null;
        String busno = "";
        try {
            stmt = conn.prepareStatement("SELECT * FROM\n"
                    + "     \"NBUSER\".\"PACKAGE\" PACKAGE INNER JOIN \"NBUSER\".\"BUS\" BUS ON PACKAGE.\"BUS_ID\" = BUS.\"BUS_ID\"\n"
                    + "WHERE\n"
                    + "     PACKAGE.PACKAGE_ID = ?");
            stmt.setString(1, PACKAGE_ID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {

                busno = rs.getString("BUS_NO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return busno;
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
