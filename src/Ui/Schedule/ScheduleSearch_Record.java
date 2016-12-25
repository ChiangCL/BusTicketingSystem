/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule;

import Ui.Maintenance.Member.*;
import Ui.Maintenance.Staff.*;
import Da.TablesModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Guanhaochan
 */
public class ScheduleSearch_Record extends JFrame {

    private String _package;
    private int i = 0;
    private String driver;
    private String no;
    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private TablesModel tableModel;
    private TableRowSorter<TableModel> sorter;
    private JTable resultTable;
    private JTextField search = new JTextField();

    public ScheduleSearch_Record() {
        new ScheduleSearch_Record(i, driver, no, _package);
    }

    public ScheduleSearch_Record(int i, String driver, String no, String _package) {
        if (i == 1) {
            try {
                String Staffid = "SELECT\n"
                        + "     PACKAGE.\"PACKAGE_ID\" AS PACKAGE_ID,\n"
                        + "     PACKAGE.\"DESTINATION\" AS DESTINATION,\n"
                        + "     PACKAGE.\"DAY\" AS DAY,\n"
                        + "     PACKAGE.\"TIME\" AS TIME,\n"
                        + "     BUS.\"BUS_NO\" AS BUS_NO,\n"
                        + "     BUS.\"SEAT\" AS BUS_SEAT,\n"
                        + "     BUS.\"BUS_MODEL\" AS BUS_MODEL,\n"
                        + "     BUS.\"BUS_ID\" AS BUS_ID\n"
                        + "FROM\n"
                        + "     \"NBUSER\".\"BUS\" BUS INNER JOIN \"NBUSER\".\"STAFF\" STAFF ON BUS.\"STAFF_ID\" = STAFF.\"STAFF_ID\"\n"
                        + "     INNER JOIN \"NBUSER\".\"PACKAGE\" PACKAGE ON BUS.\"BUS_ID\" = PACKAGE.\"BUS_ID\"\n"
                        + "WHERE\n"
                        + "     STAFF_NAME ='" + driver + "'";
                tableModel = new TablesModel(host, user, password, Staffid);

                resultTable = new JTable(tableModel);

                Box boxNorth = Box.createHorizontalBox();

                add(new JScrollPane(resultTable), BorderLayout.CENTER);
                add(boxNorth, BorderLayout.NORTH);

                sorter = new TableRowSorter<>(tableModel);
                resultTable.setRowSorter(sorter);
                // ensure database connection is closed when user quits application
                addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent event) {
                        tableModel.disconnectFromDatabase();
                    }
                });

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                tableModel.disconnectFromDatabase();

            }
        } else if (i == 2) {
            try {
                String Staffname = "SELECT\n"
                        + "     STAFF.\"STAFF_ID\" AS STAFF_STAFF_ID,\n"
                        + "     STAFF.\"STAFF_NAME\" AS STAFF_STAFF_NAME,\n"
                        + "     PACKAGE.\"PACKAGE_ID\" AS PACKAGE_PACKAGE_ID,\n"
                        + "     PACKAGE.\"DESTINATION\" AS PACKAGE_DESTINATION,\n"
                        + "     PACKAGE.\"DAY\" AS PACKAGE_DAY,\n"
                        + "     PACKAGE.\"TIME\" AS PACKAGE_TIME\n"
                        + "FROM\n"
                        + "     \"NBUSER\".\"STAFF\" STAFF INNER JOIN \"NBUSER\".\"BUS\" BUS ON STAFF.\"STAFF_ID\" = BUS.\"STAFF_ID\"\n"
                        + "     INNER JOIN \"NBUSER\".\"PACKAGE\" PACKAGE ON BUS.\"BUS_ID\" = PACKAGE.\"BUS_ID\"\n"
                        + "WHERE\n"
                        + "     BUS_NO ='" + no + "'";
                tableModel = new TablesModel(host, user, password, Staffname);

                resultTable = new JTable(tableModel);

                Box boxNorth = Box.createHorizontalBox();

                add(new JScrollPane(resultTable), BorderLayout.CENTER);
                add(boxNorth, BorderLayout.NORTH);

                sorter = new TableRowSorter<>(tableModel);
                resultTable.setRowSorter(sorter);
                // ensure database connection is closed when user quits application
                addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent event) {
                        tableModel.disconnectFromDatabase();
                    }
                });

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                tableModel.disconnectFromDatabase();

            }
        } else {
            try {
                String StaffPosition = "SELECT\n"
                        + "     PACKAGE.\"DESTINATION\" AS PACKAGE_DESTINATION,\n"
                        + "     PACKAGE.\"DAY\" AS PACKAGE_DAY,\n"
                        + "     PACKAGE.\"TIME\" AS PACKAGE_TIME,\n"
                        + "     BUS.\"BUS_NO\" AS BUS_BUS_NO,\n"
                        + "     STAFF.\"STAFF_NAME\" AS STAFF_STAFF_NAME\n"
                        + "FROM\n"
                        + "     \"NBUSER\".\"BUS\" BUS INNER JOIN \"NBUSER\".\"PACKAGE\" PACKAGE ON BUS.\"BUS_ID\" = PACKAGE.\"BUS_ID\"\n"
                        + "     INNER JOIN \"NBUSER\".\"STAFF\" STAFF ON BUS.\"STAFF_ID\" = STAFF.\"STAFF_ID\"\n"
                        + "WHERE\n"
                        + "     PACKAGE_ID ='" + _package + "'";
                tableModel = new TablesModel(host, user, password, StaffPosition);

                resultTable = new JTable(tableModel);

                Box boxNorth = Box.createHorizontalBox();

                add(new JScrollPane(resultTable), BorderLayout.CENTER);
                add(boxNorth, BorderLayout.NORTH);

                sorter = new TableRowSorter<>(tableModel);
                resultTable.setRowSorter(sorter);
                // ensure database connection is closed when user quits application
                addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent event) {
                        tableModel.disconnectFromDatabase();
                    }
                });

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
                tableModel.disconnectFromDatabase();

            }
        }

        setTitle("View Schedule Record");
        setSize(900, 300);
        setLocation(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
