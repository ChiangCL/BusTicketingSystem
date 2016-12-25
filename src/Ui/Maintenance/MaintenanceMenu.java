/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Maintenance;

/**
 *
 * @author Chan Guan Hao
 */
import Ui.ChangePassword;
import Ui.LogIn;
import Ui.MainMenu;
import Ui.Maintenance.Bus.BusMenu;
import Ui.Maintenance.Member.MemberMenu;
import Ui.Maintenance.Staff.StaffMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MaintenanceMenu extends JFrame {

    private JButton staff = new JButton("Staff");
    private JButton member = new JButton("Member");
    private JButton bus = new JButton("Bus");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private ImageIcon back = new ImageIcon(getClass().getResource("/images/1.gif"));
    private JButton backbutton = new JButton(back);
    private String user;
    private String position;

    public MaintenanceMenu() {
        new MaintenanceMenu(user, position);
    }

    public MaintenanceMenu(String user) {
        new MaintenanceMenu(user, position);
    }

    public MaintenanceMenu(String user, String position) {

        JPanel p1 = new JPanel(null);
        p1.setOpaque(false);

        staff.setMnemonic(KeyEvent.VK_F);
        staff.setOpaque(false);
        staff.setContentAreaFilled(false);
        staff.setBorderPainted(false);
        staff.setFont(new Font("Times New Roman", Font.BOLD, 45));
        staff.setFocusPainted(false);
        staff.setForeground(Color.WHITE);
        staff.setBounds(737, 381, 300, 290);

        bus.setMnemonic(KeyEvent.VK_U);
        bus.setOpaque(false);
        bus.setContentAreaFilled(false);
        bus.setBorderPainted(false);
        bus.setFont(new Font("Times New Roman", Font.BOLD, 30));
        bus.setFocusPainted(false);
        bus.setForeground(Color.WHITE);
        bus.setBounds(973, 135, 240, 240);

        member.setMnemonic(KeyEvent.VK_E);
        member.setOpaque(false);
        member.setContentAreaFilled(false);
        member.setBorderPainted(false);
        member.setFont(new Font("Times New Roman", Font.BOLD, 35));
        member.setFocusPainted(false);
        member.setForeground(Color.WHITE);
        member.setBounds(280, 290, 260, 250);

        backbutton.setMnemonic(KeyEvent.VK_B);
        backbutton.setOpaque(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setFocusPainted(false);
        backbutton.setBorderPainted(false);
        backbutton.setBounds(0, 550, 250, 150);
        p1.add(staff);
        p1.add(bus);
        p1.add(member);
        p1.add(backbutton);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);

        staff.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StaffMenu(user, position);
            }
        });
        member.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MemberMenu(user, position);
            }
        });
        bus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new BusMenu(user, position);
            }
        });
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new MainMenu(user, position);
                dispose();
            }
        });
        createMenuBar(user, position);
        setTitle("MaintenanceMenu");
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
                new ChangePassword(user, position).setVisible(true);;
            }
        });

        setting.add(c_pass);
        setting.add(eMenuItem);
        menubar.add(setting);

        setJMenuBar(menubar);
    }
}
