/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule.Package;

/**
 *
 * @author limzh
 */
import Control.*;
import Da.*;
import Domain.Package;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Add_Package extends javax.swing.JFrame {

    private MaintainPackageControl packageControl;
    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private Connection conn;
    private PreparedStatement stmt;
    private StaffDa staffDa;
    private Package _package;

    public Add_Package() {
        packageControl = new MaintainPackageControl();
        String id = packageControl.GetNewPackageCode();
        createConnection();
        initComponents();
        RetrieveBusToComboBox();
        todest.setEnabled(false);

        setSize(641, 611);
        packageid.setText(id);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Add Package");
    }

    private void RetrieveBusToComboBox() {
        try {
            String sql = "select * from BUS";
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                busid.addItem(id);

            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        packageid = new javax.swing.JTextField();
        destination = new javax.swing.JTextField();
        confirm = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        dayid = new javax.swing.JComboBox();
        timeid = new javax.swing.JComboBox();
        timeid1 = new javax.swing.JComboBox();
        price = new javax.swing.JFormattedTextField();
        fromdest = new javax.swing.JComboBox();
        todest = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        timeid2 = new javax.swing.JComboBox();
        busid = new javax.swing.JComboBox();
        timeid3 = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        Time = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Package ID");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 60, 90, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Destination");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 160, 90, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(150, 210, 90, 30);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("From");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(150, 110, 90, 30);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Day ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(150, 260, 90, 30);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Departure Time");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 310, 90, 30);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Bus ID");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(150, 460, 90, 30);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("To");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(380, 110, 30, 30);

        packageid.setEditable(false);
        getContentPane().add(packageid);
        packageid.setBounds(240, 60, 110, 30);

        destination.setEditable(false);
        destination.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationActionPerformed(evt);
            }
        });
        getContentPane().add(destination);
        destination.setBounds(240, 160, 230, 30);

        confirm.setText("Confirm");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });
        getContentPane().add(confirm);
        confirm.setBounds(160, 520, 90, 30);

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        getContentPane().add(reset);
        reset.setBounds(350, 520, 90, 30);

        dayid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        getContentPane().add(dayid);
        dayid.setBounds(240, 260, 100, 30);

        timeid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        timeid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeidActionPerformed(evt);
            }
        });
        getContentPane().add(timeid);
        timeid.setBounds(240, 310, 50, 30);

        timeid1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        timeid1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeid1ActionPerformed(evt);
            }
        });
        getContentPane().add(timeid1);
        timeid1.setBounds(340, 310, 50, 30);

        price.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        getContentPane().add(price);
        price.setBounds(240, 210, 100, 30);

        fromdest.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "IPOH", "KUALA LUMPUR", "JOHOR", "PENANG", "TERENGGANU", "KELANTAN", "PERLIS", "SINGAPORE", "MELAKA", "KEDAH", "PAHANG", " " }));
        fromdest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromdestActionPerformed(evt);
            }
        });
        getContentPane().add(fromdest);
        fromdest.setBounds(240, 110, 110, 30);

        todest.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-", "IPOH", "KUALA LUMPUR", "JOHOR", "PENANG", "TERENGGANU", "KELANTAN", "PERLIS", "SINGAPORE", "MELAKA", "KEDAH", "PAHANG" }));
        todest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todestActionPerformed(evt);
            }
        });
        getContentPane().add(todest);
        todest.setBounds(410, 110, 110, 30);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Duration");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(150, 360, 90, 30);

        timeid2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13" }));
        timeid2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeid2ActionPerformed(evt);
            }
        });
        getContentPane().add(timeid2);
        timeid2.setBounds(240, 360, 50, 30);

        busid.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-" }));
        getContentPane().add(busid);
        busid.setBounds(240, 460, 120, 30);

        timeid3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        timeid3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeid3ActionPerformed(evt);
            }
        });
        getContentPane().add(timeid3);
        timeid3.setBounds(340, 360, 50, 30);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Time");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(150, 410, 90, 30);

        Time.setEditable(false);
        getContentPane().add(Time);
        Time.setBounds(240, 410, 150, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 0, 640, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void timeidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeidActionPerformed

        if (timeid3.getSelectedItem() != "-") {
            int t1 = Integer.parseInt(timeid.getSelectedItem().toString());
            int t2 = Integer.parseInt(timeid1.getSelectedItem().toString());
            int t3 = Integer.parseInt(timeid2.getSelectedItem().toString());
            int t4 = Integer.parseInt(timeid3.getSelectedItem().toString());
            int arriveh = t1 + t3;
            int arrivem = t2 + t4;
            if (arriveh > 23) {
                arriveh = arriveh - 24;

            }
            if (arrivem > 59) {
                arrivem -= 60;
                arriveh++;
            }

            String time = String.format("%s:%s - %02d:%02d",
                    timeid.getSelectedItem().toString(),
                    timeid1.getSelectedItem().toString(),
                    arriveh, arrivem);
            Time.setText(time);

        }

    }//GEN-LAST:event_timeidActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed

        destination.setText(null);
        price.setText(null);
        todest.setEnabled(false);
        price.setValue(null);
        fromdest.setSelectedItem("-");
        dayid.setSelectedItem("-");
        busid.setSelectedIndex(0);
        Time.setText(null);
        Time.setText("");
        try {
            timeid.setSelectedIndex(0);
            timeid1.setSelectedIndex(0);
            timeid2.setSelectedIndex(0);
            timeid3.setSelectedIndex(0);
        } catch (Exception ex) {

        }
    }//GEN-LAST:event_resetActionPerformed

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed

        if (validation() == true) {
            try {
                String id = packageid.getText();
                String dest = destination.getText();
                double price1 = Double.parseDouble(price.getText());
                String day = String.valueOf(dayid.getSelectedItem());
                String time = String.valueOf(Time.getText());
                String bus_id = String.valueOf(busid.getSelectedItem());
                _package = new Package(id, dest, price1, day, time, bus_id);
                packageControl.addRecord(_package);
                JOptionPane.showMessageDialog(null, "New package added successfully.",
                        "Package Added", JOptionPane.INFORMATION_MESSAGE);
                packageid.setText(packageControl.GetNewPackageCode());
                destination.setText(null);
                Time.setText(null);
                price.setText(null);
                price.setValue(null);
                dayid.setSelectedItem("-");
                busid.setSelectedItem("-");

            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_confirmActionPerformed

    private void fromdestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromdestActionPerformed
        todest.setEnabled(true);
        String l1 = fromdest.getSelectedItem().toString();
        String l2 = todest.getSelectedItem().toString();
        if (l1.equals(l2)) {
            JOptionPane.showMessageDialog(null, "Two destination are same please select again.",
                    "Destination Error", JOptionPane.ERROR_MESSAGE);
            todest.setSelectedItem("-");

        } else {
            String test = l1 + " - " + l2;
            destination.setText(test);
        }

    }//GEN-LAST:event_fromdestActionPerformed

    private void todestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_todestActionPerformed

        String l1 = fromdest.getSelectedItem().toString();
        String l2 = todest.getSelectedItem().toString();
        if (l1.equals(l2)) {
            JOptionPane.showMessageDialog(null, "Two destination are same please select again.",
                    "Destination Error", JOptionPane.ERROR_MESSAGE);
            todest.setSelectedItem("-");

        } else {
            String test = l1 + " - " + l2;
            destination.setText(test);
        }
    }//GEN-LAST:event_todestActionPerformed

    private void timeid1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeid1ActionPerformed

        if (timeid3.getSelectedItem() != "-") {
            int t1 = Integer.parseInt(timeid.getSelectedItem().toString());
            int t2 = Integer.parseInt(timeid1.getSelectedItem().toString());
            int t3 = Integer.parseInt(timeid2.getSelectedItem().toString());
            int t4 = Integer.parseInt(timeid3.getSelectedItem().toString());
            int arriveh = t1 + t3;
            int arrivem = t2 + t4;
            if (arriveh > 23) {
                arriveh = arriveh - 24;

            }
            if (arrivem > 59) {
                arrivem -= 60;
                arriveh++;
            }

            String time = String.format("%s:%s - %02d:%02d",
                    timeid.getSelectedItem().toString(),
                    timeid1.getSelectedItem().toString(),
                    arriveh, arrivem);
            Time.setText(time);

        }

    }//GEN-LAST:event_timeid1ActionPerformed

    private void timeid2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeid2ActionPerformed

        if (timeid3.getSelectedItem() != "-") {
            int t1 = Integer.parseInt(timeid.getSelectedItem().toString());
            int t2 = Integer.parseInt(timeid1.getSelectedItem().toString());
            int t3 = Integer.parseInt(timeid2.getSelectedItem().toString());
            int t4 = Integer.parseInt(timeid3.getSelectedItem().toString());
            int arriveh = t1 + t3;
            int arrivem = t2 + t4;
            if (arriveh > 23) {
                arriveh = arriveh - 24;

            }
            if (arrivem > 59) {
                arrivem -= 60;
                arriveh++;
            }

            String time = String.format("%s:%s - %02d:%02d",
                    timeid.getSelectedItem().toString(),
                    timeid1.getSelectedItem().toString(),
                    arriveh, arrivem);
            Time.setText(time);

        }


    }//GEN-LAST:event_timeid2ActionPerformed

    private void timeid3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeid3ActionPerformed
        if (timeid3.getSelectedItem() != "-") {
            int t1 = Integer.parseInt(timeid.getSelectedItem().toString());
            int t2 = Integer.parseInt(timeid1.getSelectedItem().toString());
            int t3 = Integer.parseInt(timeid2.getSelectedItem().toString());
            int t4 = Integer.parseInt(timeid3.getSelectedItem().toString());

            int arriveh = t1 + t3;
            int arrivem = t2 + t4;
            if (arriveh > 23) {
                arriveh = arriveh - 24;

            }
            if (arrivem > 59) {
                arrivem -= 60;
                arriveh++;
            }
            String time = String.format("%s:%s - %02d:%02d",
                    timeid.getSelectedItem().toString(),
                    timeid1.getSelectedItem().toString(),
                    arriveh, arrivem);
            Time.setText(time);

        }


    }//GEN-LAST:event_timeid3ActionPerformed

    private void destinationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationActionPerformed

    }//GEN-LAST:event_destinationActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    public boolean validation() {
        if ((fromdest.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the From destination ",
                    "Invalid from destination", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((todest.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the To destination ",
                    "Invalid To destination", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (destination.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please select the destination",
                    "Invalid Destination", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((price.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "Please enter the price",
                    "Invalid price", JOptionPane.ERROR_MESSAGE);
            price.grabFocus();
            return false;
        } else if ((Double.parseDouble(price.getText()) <= 0)) {
            JOptionPane.showMessageDialog(null, "Please enter a valid price. eg.123.50",
                    "Invalid price", JOptionPane.ERROR_MESSAGE);
            price.grabFocus();
            return false;
        } else if ((dayid.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the day ",
                    "Invalid day", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (timeid2.getSelectedItem() == "00" && timeid3.getSelectedItem() == "00") {
            JOptionPane.showMessageDialog(null, "Time cannot be all same. Please select again. ",
                    "Invalid time", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((Time.getText().trim().length() == 0)) {
            JOptionPane.showMessageDialog(null, "Please select the time ",
                    "Invalid time", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if ((busid.getSelectedItem() == "-")) {
            JOptionPane.showMessageDialog(null, "Please select the bus id. ",
                    "Invalid bus id", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

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
            java.util.logging.Logger.getLogger(Add_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Package.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Package().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Time;
    private javax.swing.JComboBox busid;
    private javax.swing.JButton confirm;
    private javax.swing.JComboBox dayid;
    private javax.swing.JTextField destination;
    private javax.swing.JComboBox fromdest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField packageid;
    private javax.swing.JFormattedTextField price;
    private javax.swing.JButton reset;
    private javax.swing.JComboBox timeid;
    private javax.swing.JComboBox timeid1;
    private javax.swing.JComboBox timeid2;
    private javax.swing.JComboBox timeid3;
    private javax.swing.JComboBox todest;
    // End of variables declaration//GEN-END:variables
}
