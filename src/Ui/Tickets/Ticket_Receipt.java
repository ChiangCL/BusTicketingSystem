/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Tickets;

import Control.MaintainPackageControl;
import Da.PackageDa;
import Domain.Package;
import Domain.*;
import Da.*;
import Control.*;

/**
 *
 * @author Guanhaochan
 */
public class Ticket_Receipt extends javax.swing.JFrame {

    private PackageDa packageDa;
    private Domain.Package _package;
    private MaintainPackageControl packageControl;
    private MemberDa memberDa;
    private Domain.Member member;
    private MaintainMemberControl memberControl;
    private BusDa busDa;
    private Bus bus;
    private MaintainBusControl busControl;
    private StaffDa staffDa;
    private Staff staff;
    private MaintainStaffControl staffControl;
    private Seat seatDa;
    private Seat seat;
    private MaintainSeatControl seatControl;
    private String Order_ID;
    private String Order_Date;
    private String Package_ID;
    private String depart_Date;
    private String depart_Time;
    private double Subtotal;
    private int Ticket_No;
    private int ticket_;
    private String seatid;
    private String user;
    private String position;
    private double total;
    private String id;
    private String memberid1;
    public int seat1;

    public Ticket_Receipt() {
        new Ticket_Receipt(Order_ID, Order_Date, Package_ID, depart_Date, depart_Time, Subtotal, ticket_, Ticket_No, seatid, user, position,
                total, memberid1, seat1);
    }

    public Ticket_Receipt(String Order_ID, String Order_Date, String Package_ID, String depart_Date, String depart_Time,
            double Subtotal, int ticket_, int Ticket_No, String seatid, String user, String position, int seat1) {
        memberControl = new MaintainMemberControl();
        busControl = new MaintainBusControl();
        staffControl = new MaintainStaffControl();
        seatControl = new MaintainSeatControl();
        packageControl = new MaintainPackageControl();
        member = memberControl.selectRecord(memberid1);
        _package = packageControl.selectRecord(Package_ID);
        String bus_no1 = busControl.RetrieveBus(Package_ID);
        String staffname = staffControl.RetrieveDriver(bus_no1);
        initComponents();
        if (memberid1.equals("null")) {
            memberid.setText("null");
            customer.setText("null");
            telephone.setText("null");
        } else {

            memberid.setText(memberid1);
            customer.setText(member.getMEMBER_NAME());
            telephone.setText(member.getCONTACT_NO());
        }

        busno.setText(bus_no1);
        driver.setText(staffname);
        destination.setText(_package.getDESTINATION());
        date_.setText(Order_Date);
        time.setText(_package.getTIME());
        depart_time.setText(depart_Time);
        totalamount.setText(String.format("%.2f", total));
        String SeAt = "";
        String seatAT;
        for (int i = 0; Ticket_No > i; i++) {
            seatAT = Package_ID + "0" + (i + 1);

            SeAt += Package_ID + "0" + (seat1 + i + 1) + ",";

        }
        seatss.setText(SeAt.toString());
        setSize(694, 507);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Ticket Generated");
    }

    public Ticket_Receipt(String Order_ID, String Order_Date, String Package_ID, String depart_Date, String depart_Time,
            double Subtotal, int ticket_, int Ticket_No, String seatid, String user, String position, double total,
            String memberid1, int seat1) {
        memberControl = new MaintainMemberControl();
        busControl = new MaintainBusControl();
        staffControl = new MaintainStaffControl();
        seatControl = new MaintainSeatControl();
        packageControl = new MaintainPackageControl();
        member = memberControl.selectRecord(memberid1);
        _package = packageControl.selectRecord(Package_ID);
        String bus_no1 = busControl.RetrieveBus(Package_ID);
        String staffname = staffControl.RetrieveDriver(bus_no1);
        initComponents();
        if (memberid1.equals("null")) {
            memberid.setText("null");
            customer.setText("null");
            telephone.setText("null");
        } else {

            memberid.setText(memberid1);
            customer.setText(member.getMEMBER_NAME());
            telephone.setText(member.getCONTACT_NO());
        }

        busno.setText(bus_no1);
        driver.setText(staffname);
        destination.setText(_package.getDESTINATION());
        date_.setText(Order_Date);
        time.setText(_package.getTIME());
        depart_time.setText(depart_Time);
        totalamount.setText(String.format("%.2f", total));
        String SeAt = "";
        String seatAT;
        for (int i = 0; Ticket_No > i; i++) {
            seatAT = Package_ID + "0" + (i + 1);

            SeAt += Package_ID + "0" + (seat1 + i + 1) + ",";

        }
        seatss.setText(SeAt.toString());
        setSize(694, 507);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setTitle("Ticket Generated");
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        date_ = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        memberid = new javax.swing.JTextField();
        customer = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        telephone = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        busno = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        driver = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        destination = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        depart_time = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        totalamount = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        seatss = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("iLikeBus");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(290, 10, 110, 50);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Peter Lin 74 Green St Jordan,  Ipoh, 31800, Perak.");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel2.setName(""); // NOI18N
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 50, 300, 20);

        jLabel3.setText(" Contact No :012-5304975");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(290, 70, 150, 20);

        date_.setEditable(false);
        getContentPane().add(date_);
        date_.setBounds(80, 210, 100, 30);

        jLabel7.setText("Date ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 210, 50, 30);

        jLabel8.setText("To :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 100, 30, 30);

        memberid.setEditable(false);
        memberid.setBorder(null);
        getContentPane().add(memberid);
        memberid.setBounds(60, 100, 40, 30);

        customer.setEditable(false);
        customer.setBorder(null);
        getContentPane().add(customer);
        customer.setBounds(120, 100, 130, 30);

        jLabel9.setText("Tel :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(280, 100, 30, 30);

        telephone.setEditable(false);
        telephone.setBorder(null);
        getContentPane().add(telephone);
        telephone.setBounds(320, 100, 190, 30);

        jLabel12.setText("Bus No.");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 170, 50, 30);

        busno.setEditable(false);
        getContentPane().add(busno);
        busno.setBounds(80, 170, 100, 30);

        jLabel13.setText("Driver");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(200, 170, 40, 30);

        driver.setEditable(false);
        getContentPane().add(driver);
        driver.setBounds(240, 170, 110, 30);

        jLabel14.setText("Time ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(200, 210, 40, 30);

        time.setEditable(false);
        getContentPane().add(time);
        time.setBounds(240, 210, 110, 30);

        jLabel10.setText("Destination");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(370, 170, 70, 30);

        destination.setEditable(false);
        getContentPane().add(destination);
        destination.setBounds(470, 170, 190, 30);

        jLabel11.setText("Departure Time");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(370, 210, 100, 30);

        depart_time.setEditable(false);
        getContentPane().add(depart_time);
        depart_time.setBounds(470, 210, 190, 30);

        jLabel15.setText("Seat No.");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(80, 260, 60, 30);

        jLabel16.setText("Amount Paid(RM)");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(440, 330, 110, 30);

        totalamount.setEditable(false);
        totalamount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(totalamount);
        totalamount.setBounds(550, 320, 110, 50);

        seatss.setEditable(false);
        seatss.setColumns(20);
        seatss.setLineWrap(true);
        seatss.setRows(5);
        jScrollPane1.setViewportView(seatss);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 250, 240, 110);

        jButton1.setText("Print");
        getContentPane().add(jButton1);
        jButton1.setBounds(290, 400, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ticket_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_Receipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_Receipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField busno;
    private javax.swing.JTextField customer;
    private javax.swing.JTextField date_;
    private javax.swing.JTextField depart_time;
    private javax.swing.JTextField destination;
    private javax.swing.JTextField driver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField memberid;
    private javax.swing.JTextArea seatss;
    private javax.swing.JTextField telephone;
    private javax.swing.JTextField time;
    private javax.swing.JTextField totalamount;
    // End of variables declaration//GEN-END:variables
}
