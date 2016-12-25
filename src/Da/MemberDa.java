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
import Domain.Member;
import java.sql.*;
import javax.swing.*;

public class MemberDa {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private String tableName = "MEMBER";
    private Connection conn;
    private PreparedStatement stmt;
    private MemberDa memberDa;

    public MemberDa() {
        createConnection();
    }

    public Member getMemberRecordWithId(String MEMBER_ID) {
        Member member = null;
        try {
            stmt = conn.prepareStatement("SELECT * FROM " + tableName + " WHERE MEMBER_ID = ?");
            stmt.setString(1, MEMBER_ID);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                member = new Member(MEMBER_ID, rs.getString("MEMBER_NAME"), rs.getString("MEMBER_IC"),
                        rs.getString("ADDRESS"), rs.getString("CONTACT_NO"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return member;
    }

    /* public int verifyMember(String MemberId){
     int i=0;
     try{
     String sqlQueryStr = "SELECT * FROM Member WHERE mem_id ='" + MemberId + "'" ;
     stmt = conn.prepareStatement(sqlQueryStr);
     ResultSet rs = stmt.executeQuery();
     if(rs.next() == true){           
     i = 1;
     }
     }catch (SQLException ex) {
     JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
     }
     return i;
     }*/
    public void addOnNewMemberRecord(Member member) {

        try {

            stmt = conn.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?)");
            stmt.setString(1, member.getMEMBER_ID());
            stmt.setString(2, member.getMEMBER_NAME());
            stmt.setString(3, member.getMEMBER_IC());
            stmt.setString(4, member.getADDRESS());
            stmt.setString(5, member.getCONTACT_NO());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void updateMemberRecord(Member member) {

        try {

            stmt = conn.prepareStatement("UPDATE MEMBER SET MEMBER_NAME = ?, MEMBER_IC = ?,"
                    + " ADDRESS = ?, CONTACT_NO = ? WHERE MEMBER_ID = ?");

            stmt.setString(1, member.getMEMBER_NAME());
            stmt.setString(2, member.getMEMBER_IC());
            stmt.setString(3, member.getADDRESS());
            stmt.setString(4, member.getCONTACT_NO());
            stmt.setString(5, member.getMEMBER_ID());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void deleteMemberRecordWithId(Member member) {

        try {
            stmt = conn.prepareStatement("DELETE FROM MEMBER WHERE MEMBER_ID = ?");
            stmt.setString(1, member.getMEMBER_ID());

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
