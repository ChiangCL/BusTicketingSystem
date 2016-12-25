/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule.Package;

/**
 *
 * @author Guanhaochan
 */
import Ui.ChangePassword;
import Ui.Maintenance.MaintenanceMenu;
import Ui.Schedule.ScheduleMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PackageMenu extends JFrame {

    private JButton create = new JButton("New");
    private JButton read = new JButton("View");
    private JButton update = new JButton("Update");
    private JButton delete = new JButton("Delete");
    private JButton search = new JButton("Search");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private ImageIcon back = new ImageIcon(getClass().getResource("/images/1.gif"));
    private JButton backbutton = new JButton(back);
    private String user;
    private String position;

    public PackageMenu() {
        new PackageMenu(user, position);
    }

    public PackageMenu(String user) {
        new PackageMenu(user, position);
    }

    public PackageMenu(String user, String position) {

        JPanel p1 = new JPanel(null);
        p1.setOpaque(false);
        search.setOpaque(false);
        search.setContentAreaFilled(false);
        search.setBorderPainted(false);
        search.setMnemonic(KeyEvent.VK_H);
        search.setFont(new Font("Times New Roman", Font.BOLD, 30));
        search.setFocusPainted(false);
        search.setForeground(Color.WHITE);
        search.setBounds(65, 75, 220, 220);

        read.setOpaque(false);
        read.setContentAreaFilled(false);
        read.setBorderPainted(false);
        read.setMnemonic(KeyEvent.VK_R);
        read.setFont(new Font("Times New Roman", Font.BOLD, 30));
        read.setFocusPainted(false);
        read.setForeground(Color.WHITE);
        read.setBounds(560, 2, 220, 220);

        create.setOpaque(false);
        create.setContentAreaFilled(false);
        create.setBorderPainted(false);
        create.setMnemonic(KeyEvent.VK_C);
        create.setFont(new Font("Times New Roman", Font.BOLD, 45));
        create.setFocusPainted(false);
        create.setForeground(Color.WHITE);
        create.setBounds(737, 381, 300, 290);

        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);
        delete.setMnemonic(KeyEvent.VK_D);
        delete.setFont(new Font("Times New Roman", Font.BOLD, 30));
        delete.setFocusPainted(false);
        delete.setForeground(Color.WHITE);
        delete.setBounds(973, 135, 240, 240);

        update.setOpaque(false);
        update.setContentAreaFilled(false);
        update.setBorderPainted(false);
        update.setMnemonic(KeyEvent.VK_U);
        update.setFont(new Font("Times New Roman", Font.BOLD, 35));
        update.setFocusPainted(false);
        update.setForeground(Color.WHITE);
        update.setBounds(280, 290, 260, 250);

        backbutton.setOpaque(false);
        backbutton.setMnemonic(KeyEvent.VK_B);
        backbutton.setContentAreaFilled(false);
        backbutton.setFocusPainted(false);
        backbutton.setBorderPainted(false);
        backbutton.setBounds(0, 550, 250, 150);
        p1.add(search);
        p1.add(read);
        p1.add(create);
        p1.add(delete);
        p1.add(update);
        p1.add(backbutton);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);

        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Add_Package().setVisible(true);
            }
        });
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Package().setVisible(true);
            }
        });
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Delete_Package().setVisible(true);
            }
        });
        read.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Package();
            }
        });
        search.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Search_Package().setVisible(true);
            }
        });
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ScheduleMenu(user, position);
                dispose();
            }
        });
        createMenuBar(user, position);
        setTitle("Package Menu");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    private void createMenuBar(String user, String position) {

        JMenuBar menubar = new JMenuBar();

        JMenu setting = new JMenu("Setting");
        setting.setMnemonic(KeyEvent.VK_S);

        JMenuItem eMenuItem = new JMenuItem("Exit");
        eMenuItem.setMnemonic(KeyEvent.VK_E);
        eMenuItem.setToolTipText("Exit application");
        eMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        JMenuItem c_pass = new JMenuItem("Change Password");
        c_pass.setMnemonic(KeyEvent.VK_C);
        c_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ChangePassword(user, position).setVisible(true);
            }
        });

        setting.add(c_pass);
        setting.add(eMenuItem);
        menubar.add(setting);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {
        new PackageMenu();
    }
}
