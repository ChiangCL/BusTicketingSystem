/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Guanhaochan
 */
public class SummaryReport extends javax.swing.JFrame {

    /**
     * Creates new form SummaryReport1
     */
    public SummaryReport() {
        initComponents();
        setSize(567, 355);
        radiogroup.add(dateradio);
        radiogroup.add(positionradio);
        dateradio.setSelected(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        setTitle("Summary Report");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radiogroup = new javax.swing.ButtonGroup();
        positionradio = new javax.swing.JRadioButton();
        position = new javax.swing.JLabel();
        positioncombo = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        smonth = new com.toedter.calendar.JDateChooser();
        emonth = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dateradio = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        positionradio.setOpaque(false);
        positionradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                positionradioActionPerformed(evt);
            }
        });
        getContentPane().add(positionradio);
        positionradio.setBounds(130, 180, 20, 30);

        position.setForeground(new java.awt.Color(255, 255, 255));
        position.setText("Position");
        getContentPane().add(position);
        position.setBounds(170, 180, 90, 30);

        positioncombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Manager", "Clerk", "Receptionist", "Bus Driver" }));
        getContentPane().add(positioncombo);
        positioncombo.setBounds(260, 180, 140, 30);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Start Month:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 70, 80, 30);
        getContentPane().add(smonth);
        smonth.setBounds(260, 70, 140, 30);
        getContentPane().add(emonth);
        emonth.setBounds(260, 120, 139, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("End Month:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 120, 80, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(200, 230, 90, 40);

        dateradio.setOpaque(false);
        getContentPane().add(dateradio);
        dateradio.setBounds(130, 90, 30, 40);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 160, 560, 10);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Search by");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(240, 20, 90, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 550, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void positionradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_positionradioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_positionradioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int i = 0;
        i = radioselection();
        if (i == 0) {

        } else if (i == 1) {
            if (validation() == true) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String startdate = dateFormat.format(smonth.getDate());
                String enddate = dateFormat.format(emonth.getDate());
                String host = "jdbc:derby://localhost:1527/FYP database";
                String user = "nbuser";
                String password = "nbuser";
                Connection conn = null;
                String reportSource = "C://Users//user//Desktop//Final Year Project//FYP//src//Ui//Report//SummaryReport.jrxml";

                Map<String, Object> params = new HashMap<String, Object>();
                params.put("from", smonth.getDate());
                params.put("to", emonth.getDate());
                params.put("StartMonth", startdate);
                params.put("EndMonth", enddate);
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    conn = DriverManager.getConnection(host, user, password);

                    JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                    JasperViewer.viewReport(jasperPrint, false);

                } catch (JRException jrex) {
                    JOptionPane.showMessageDialog(null, "error in generating report");
                    jrex.printStackTrace();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                    ex.printStackTrace();
                }
            }
        } else {
            String host = "jdbc:derby://localhost:1527/FYP database";
            String user = "nbuser";
            String password = "nbuser";
            Connection conn = null;
            String reportSource = "C://Users//user//Desktop//Final Year Project//FYP//src//Ui//Report//StaffSummaryReport.jrxml";

            String position = String.valueOf(positioncombo.getSelectedItem());
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("position", position);

            try {
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                conn = DriverManager.getConnection(host, user, password);

                JasperReport jasperReport = JasperCompileManager.compileReport(reportSource);
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, conn);
                JasperViewer.viewReport(jasperPrint, false);

            } catch (JRException jrex) {
                JOptionPane.showMessageDialog(null, "error in generating report");
                jrex.printStackTrace();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Unble to generate report~!");
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private int radioselection() {
        int i = 0;
        if (dateradio.isSelected()) {
            i = 1;
        } else {
            i = 2;
        }
        return i;
    }

    private boolean validation() {
        if (smonth.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please choose the start month ",
                    "Invalid Start Month", JOptionPane.ERROR_MESSAGE);
            smonth.grabFocus();
            return false;
        } else if (emonth.getDate() == null) {
            JOptionPane.showMessageDialog(null, "Please choose the end month ",
                    "Invalid End Month", JOptionPane.ERROR_MESSAGE);
            emonth.grabFocus();
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
            java.util.logging.Logger.getLogger(SummaryReport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SummaryReport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SummaryReport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SummaryReport.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SummaryReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dateradio;
    private com.toedter.calendar.JDateChooser emonth;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel position;
    private javax.swing.JComboBox positioncombo;
    private javax.swing.JRadioButton positionradio;
    private javax.swing.ButtonGroup radiogroup;
    private com.toedter.calendar.JDateChooser smonth;
    // End of variables declaration//GEN-END:variables
}
