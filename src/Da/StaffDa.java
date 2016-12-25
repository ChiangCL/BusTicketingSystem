/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Da;

import Domain.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guanhaochan
 */
public class StaffDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "STAFF";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;

    public StaffDa() {
        createConnection();
    }

    public Staff getStaffRecordWithId(String STAFF_ID) {
        Staff staff = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE STAFF_ID = ?");
            stmt.setString(1, STAFF_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                staff = new Staff(STAFF_ID, rs.getString("STAFF_NAME"), rs.getString("STAFF_IC"),
                        rs.getString("ADDRESS"), rs.getString("CONTACT_NO"), rs.getString("POSITION"), rs.getString("PASSWORD"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staff;
    }

    public String getDriverID() {
        Staff staff = null;
        String id = "";
        try {
            stmt = conn.prepareStatement("SELECT * FROM STAFF WHERE POSITION = 'Bus Driver'");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return id;
    }

    public void addOnNewStaffRecord(Staff staff) {

        try {

            stmt = conn.prepareStatement("INSERT INTO STAFF VALUES(?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, staff.getSTAFF_ID());
            stmt.setString(2, staff.getSTAFF_NAME());
            stmt.setString(3, staff.getSTAFF_IC());
            stmt.setString(4, staff.getADDRESS());
            stmt.setString(5, staff.getCONTACT_NO());
            stmt.setString(6, staff.getPOSITION());
            stmt.setString(7, staff.getPASSWORD());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateStaffRecord(Staff staff) {

        try {

            stmt = conn.prepareStatement("UPDATE STAFF SET STAFF_NAME = ?, STAFF_IC = ?,"
                    + " ADDRESS = ?, CONTACT_NO = ?, POSITION = ?, PASSWORD = ? WHERE STAFF_ID = ?");

            stmt.setString(1, staff.getSTAFF_NAME());
            stmt.setString(2, staff.getSTAFF_IC());
            stmt.setString(3, staff.getADDRESS());
            stmt.setString(4, staff.getCONTACT_NO());
            stmt.setString(5, staff.getPOSITION());
            stmt.setString(6, staff.getPASSWORD());
            stmt.setString(7, staff.getSTAFF_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteStaffRecordWithId(Staff staff) {

        try {
            stmt = conn.prepareStatement("DELETE FROM STAFF WHERE STAFF_ID = ?");
            stmt.setString(1, staff.getSTAFF_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String RetrieveDriverName(String BUS_NO) {
        Staff staff = null;
        String staffname = "";
        try {
            stmt = conn.prepareStatement("SELECT * FROM\n"
                    + "     \"NBUSER\".\"BUS\" BUS INNER JOIN \"NBUSER\".\"STAFF\" STAFF ON BUS.\"STAFF_ID\" = STAFF.\"STAFF_ID\"\n"
                    + "WHERE\n"
                    + "     BUS.\"BUS_NO\" = '" + BUS_NO + "'");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                staffname = rs.getString("STAFF_NAME");

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return staffname;
    }

    public int verifyUser(String STAFF_ID, String PASSWORD) {
        int i = 0;
        try {
            String sqlQueryStr = "SELECT * FROM STAFF WHERE STAFF_ID ='" + STAFF_ID + "' AND PASSWORD ='" + PASSWORD + "'";
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                i = 1;

                JOptionPane.showMessageDialog(null, "Welcome, " + rs.getString(2));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }

    public String RetrievePosition(String STAFF_ID, String PASSWORD) {
        String position = null;
        try {
            String sqlQueryStr = "SELECT * FROM STAFF WHERE STAFF_ID ='" + STAFF_ID + "' AND PASSWORD ='" + PASSWORD + "'";
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                position = rs.getString(6);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return position;
    }

    public int verifyPassword(String STAFF_ID, String STAFF_NAME, String PASSWORD) {
        int i = 0;
        try {
            String sqlQueryStr = "SELECT * FROM STAFF WHERE STAFF_ID ='" + STAFF_ID + "' AND STAFF_NAME='" + STAFF_NAME
                    + "' AND PASSWORD ='" + PASSWORD + "'";
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                i = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }

    public int verifyRecoverPassword(String STAFF_ID, String STAFF_NAME, String STAFF_IC) {
        int i = 0;
        try {
            String sqlQueryStr = "SELECT * FROM STAFF WHERE STAFF_ID ='" + STAFF_ID + "' AND STAFF_NAME='" + STAFF_NAME
                    + "' AND STAFF_IC='" + STAFF_IC + "'";
            stmt = conn.prepareStatement(sqlQueryStr);
            ResultSet rs = stmt.executeQuery();
            if (rs.next() == true) {
                JOptionPane.showMessageDialog(null, "Your Password is " + rs.getString(7),
                        "Password Recovered", JOptionPane.INFORMATION_MESSAGE);
                i = 1;
            } else {
                JOptionPane.showMessageDialog(null, "This Staff Records is doesn't exist.",
                        "ID not found", JOptionPane.ERROR_MESSAGE);
                i = 2;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return i;
    }

    public void updateNewPassword(Staff staff) {

        try {

            stmt = conn.prepareStatement("UPDATE STAFF SET PASSWORD = ? WHERE STAFF_ID = ?");

            stmt.setString(1, staff.getPASSWORD());
            stmt.setString(2, staff.getSTAFF_ID());

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
