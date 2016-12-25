// This class is use for view staff records in database
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance.Bus;

/**
 *
 * @author Lim Zhen Kai
 */
import Da.TablesModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

public class View_Bus extends JFrame {

    private String host = "jdbc:derby://localhost:1527/FYP database";
    private String user = "nbuser";
    private String password = "nbuser";
    static final String STAFF_QUERY = "SELECT * FROM BUS";
    private TablesModel tableModel;
    private TableRowSorter<TablesModel> sorter;
    private JTable resultTable;

    public View_Bus() {
        super("Bus Record");

        try {
            tableModel = new TablesModel(host, user, password, STAFF_QUERY);

            resultTable = new JTable(tableModel);

            Box boxNorth = Box.createHorizontalBox();

            add(new JScrollPane(resultTable), BorderLayout.CENTER);
            add(boxNorth, BorderLayout.NORTH);

            sorter = new TableRowSorter<TablesModel>(tableModel);
            resultTable.setRowSorter(sorter);
            setTitle("View Bus Record");
            setSize(700, 300);
            setLocation(400, 400);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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
            System.exit(1);

        }
    }

}
