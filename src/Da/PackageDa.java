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
import Domain.Package;
import java.sql.*;
import javax.swing.*;

public class PackageDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "PACKAGE";
    private Connection conn;
    private PreparedStatement stmt;
    private PackageDa packageDa;

    public PackageDa() {
        createConnection();
    }

    public Package getPackageRecordWithId(String PACKAGE_ID) {
        Package _package = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE PACKAGE_ID = ?");
            stmt.setString(1, PACKAGE_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                _package = new Package(PACKAGE_ID, rs.getString("DESTINATION"), rs.getDouble("PRICE"),
                        rs.getString("DAY"), rs.getString("TIME"), rs.getString("BUS_ID"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return _package;
    }

    public void addOnNewPackageRecord(Package _package) {

        try {

            stmt = conn.prepareStatement("INSERT INTO PACKAGE VALUES(?, ?, ?, ?, ?, ?)");
            stmt.setString(1, _package.getPACKAGE_ID());
            stmt.setString(2, _package.getDESTINATION());
            stmt.setString(3, String.valueOf(_package.getPRICE()));
            stmt.setString(4, _package.getDAY());
            stmt.setString(5, _package.getTIME());
            stmt.setString(6, _package.getBUS_ID());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updatePackageRecord(Package _package) {

        try {

            stmt = conn.prepareStatement("UPDATE PACKAGE SET DESTINATION = ?, PRICE = ?,"
                    + " DAY = ?, TIME = ?, BUS_ID = ? WHERE PACKAGE_ID = ?");

            stmt.setString(1, _package.getDESTINATION());
            stmt.setString(2, String.valueOf(_package.getPRICE()));
            stmt.setString(3, _package.getDAY());
            stmt.setString(4, _package.getTIME());
            stmt.setString(5, _package.getBUS_ID());
            stmt.setString(6, _package.getPACKAGE_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deletePackageRecordWithId(Package _package) {

        try {
            stmt = conn.prepareStatement("DELETE FROM PACKAGE WHERE PACKAGE_ID = ?");
            stmt.setString(1, _package.getPACKAGE_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
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
