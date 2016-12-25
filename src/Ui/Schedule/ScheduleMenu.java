/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Schedule;

/**
 *
 * @author Chan Guan Hao
 */
import Ui.Schedule.Package.PackageMenu;
import Ui.ChangePassword;
import Ui.LogIn;
import Ui.MainMenu;
import Ui.Maintenance.Bus.BusMenu;
import Ui.Maintenance.Member.MemberMenu;
import Ui.Maintenance.Staff.StaffMenu;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ScheduleMenu extends JFrame {

    private JButton pack = new JButton("Package");
    private JButton DS = new JButton("Driver Schedule");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private ImageIcon back = new ImageIcon(getClass().getResource("/images/1.gif"));
    private JButton backbutton = new JButton(back);
    private String user;
    private String position;

    public ScheduleMenu() {
        new ScheduleMenu(user, position);
    }

    public ScheduleMenu(String user) {
        new ScheduleMenu(user, position);
    }

    public ScheduleMenu(String user, String position) {

        JPanel p1 = new JPanel(null);
        p1.setOpaque(false);

        pack.setOpaque(false);
        pack.setContentAreaFilled(false);
        pack.setBorderPainted(false);
        pack.setMnemonic(KeyEvent.VK_P);
        pack.setFont(new Font("Times New Roman", Font.BOLD, 45));
        pack.setFocusPainted(false);
        pack.setForeground(Color.WHITE);
        pack.setBounds(737, 381, 300, 290);

        DS.setOpaque(false);
        DS.setContentAreaFilled(false);
        DS.setBorderPainted(false);
        DS.setMnemonic(KeyEvent.VK_D);
        DS.setFont(new Font("Times New Roman", Font.BOLD, 32));
        DS.setFocusPainted(false);
        DS.setForeground(Color.WHITE);
        DS.setBounds(280, 290, 260, 250);

        backbutton.setOpaque(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setMnemonic(KeyEvent.VK_B);
        backbutton.setBorderPainted(false);
        backbutton.setBounds(0, 550, 250, 150);
        p1.add(DS);
        p1.add(pack);
        p1.add(backbutton);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);

        DS.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                new Driver_Schedule().setVisible(true);
            }
        });
        pack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new PackageMenu(user, position);
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
        setTitle("ScheduleMenu");
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
        new ScheduleMenu();
    }
}
