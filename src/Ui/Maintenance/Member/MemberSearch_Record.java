/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Member;

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
public class MemberSearch_Record extends JFrame {

    private String id;
    private int i = 0;
    private String name;
    private String ic;
    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    private TablesModel tableModel;
    private TableRowSorter<TableModel> sorter;
    private JTable resultTable;
    private JTextField search = new JTextField();

    public MemberSearch_Record() {
        new MemberSearch_Record(i, id, name, ic);
    }

    public MemberSearch_Record(int i, String id, String name, String ic) {
        if (i == 1) {
            try {
                String Staffid = "Select * FROM MEMBER Where MEMBER_ID ='" + id + "'";
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
                String Staffname = "Select * FROM MEMBER Where MEMBER_NAME ='" + name + "'";
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
                String StaffPosition = "Select * FROM MEMBER Where MEMBER_IC ='" + ic + "'";
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

        setTitle("Member Record");
        setSize(670, 300);
        setLocation(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
}
