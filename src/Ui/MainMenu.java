/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

/**
 *
 * @author Chan Guan Hao
 */
import Ui.Maintenance.MaintenanceMenu;
import Ui.Report.ReportMenu;
import Ui.Schedule.ScheduleMenu;
import Ui.Tickets.Change_Ticket;
import Ui.Tickets.Purchase_Ticket;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu extends JFrame {

    private JButton M_Menu = new JButton("Maintenance");
    private JButton Report = new JButton("Report");
    private JButton schedule = new JButton("Schedule");
    private JButton ticket = new JButton("Ticket");
    private JButton c_ticket = new JButton("Changes Ticket");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private ImageIcon back = new ImageIcon(getClass().getResource("/images/1.gif"));
    private JButton backbutton = new JButton(back);
    private String user;
    private String position;

    public MainMenu() {
        new MainMenu(user, position);
    }

    public MainMenu(String user) {
        new MainMenu(user, position);
    }

    public MainMenu(String user, String position) {

        JPanel p1 = new JPanel(null);
        p1.setOpaque(false);
        M_Menu.setOpaque(false);
        M_Menu.setContentAreaFilled(false);
        M_Menu.setBorderPainted(false);
        M_Menu.setFont(new Font("Times New Roman", Font.BOLD, 30));
        M_Menu.setForeground(Color.WHITE);
        M_Menu.setFocusPainted(false);
        M_Menu.setBounds(65, 75, 220, 220);
        M_Menu.setMnemonic(KeyEvent.VK_M);
        M_Menu.setEnabled(false);

        Report.setOpaque(false);
        Report.setContentAreaFilled(false);
        Report.setBorderPainted(false);
        Report.setFont(new Font("Times New Roman", Font.BOLD, 30));
        Report.setForeground(Color.WHITE);
        Report.setFocusPainted(false);
        Report.setMnemonic(KeyEvent.VK_R);
        Report.setBounds(560, 2, 220, 220);
        Report.setEnabled(false);

        ticket.setOpaque(false);
        ticket.setContentAreaFilled(false);
        ticket.setBorderPainted(false);
        ticket.setFont(new Font("Times New Roman", Font.BOLD, 45));
        ticket.setForeground(Color.WHITE);
        ticket.setFocusPainted(false);
        ticket.setMnemonic(KeyEvent.VK_T);
        ticket.setBounds(737, 381, 300, 290);
        ticket.setEnabled(false);

        c_ticket.setOpaque(false);
        c_ticket.setContentAreaFilled(false);
        c_ticket.setBorderPainted(false);
        c_ticket.setFont(new Font("Times New Roman", Font.BOLD, 30));
        c_ticket.setForeground(Color.WHITE);
        c_ticket.setFocusPainted(false);
        c_ticket.setMnemonic(KeyEvent.VK_G);
        c_ticket.setBounds(973, 135, 240, 240);
        c_ticket.setEnabled(false);

        schedule.setOpaque(false);
        schedule.setContentAreaFilled(false);
        schedule.setBorderPainted(false);
        schedule.setFont(new Font("Times New Roman", Font.BOLD, 35));
        schedule.setForeground(Color.WHITE);
        schedule.setFocusPainted(false);
        schedule.setMnemonic(KeyEvent.VK_P);
        schedule.setBounds(280, 290, 260, 250);
        schedule.setEnabled(false);

        backbutton.setOpaque(false);
        backbutton.setFocusPainted(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setMnemonic(KeyEvent.VK_B);
        backbutton.setBorderPainted(false);
        backbutton.setBounds(0, 550, 250, 150);

        if (position.equals("Clerk")) {
            M_Menu.setEnabled(true);
            schedule.setEnabled(true);
        } else if (position.equals("Bus Driver")) {
            schedule.setEnabled(true);
        } else if (position.equals("Manager")) {
            Report.setEnabled(true);
            schedule.setEnabled(true);
            M_Menu.setEnabled(true);
            c_ticket.setEnabled(true);
            ticket.setEnabled(true);
        } else {
            c_ticket.setEnabled(true);
            ticket.setEnabled(true);
        }
        p1.add(M_Menu);
        p1.add(Report);
        p1.add(schedule);
        p1.add(ticket);
        p1.add(c_ticket);
        p1.add(backbutton);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);

        M_Menu.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MaintenanceMenu(user, position);
            }
        });
        schedule.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ScheduleMenu(user, position);
            }
        });

        Report.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ReportMenu(user, position);
            }
        });

        ticket.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Purchase_Ticket(user, position).setVisible(true);
            }
        });
        c_ticket.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Change_Ticket(user, position).setVisible(true);
            }
        });
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new LogIn();
                dispose();
            }
        });
        createMenuBar(user);
        setTitle("MainMenu");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    private void createMenuBar(String user) {

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
        new MainMenu();
    }
}
