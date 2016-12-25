/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui.Report;

/**
 *
 * @author Chan Guan Hao
 */
import Ui.ChangePassword;
import Ui.MainMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReportMenu extends JFrame {

    private JButton transaction = new JButton("Transaction");
    private JButton summary = new JButton("Summary");
    private JButton exception = new JButton("Exception");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private ImageIcon back = new ImageIcon(getClass().getResource("/images/1.gif"));
    private JButton backbutton = new JButton(back);
    private String user;
    private String position;

    public ReportMenu() {
        new ReportMenu(user, position);
    }

    public ReportMenu(String user) {
        new ReportMenu(user, position);
    }

    public ReportMenu(String user, String position) {

        JPanel p1 = new JPanel(null);
        p1.setOpaque(false);

        transaction.setOpaque(false);
        transaction.setContentAreaFilled(false);
        transaction.setBorderPainted(false);
        transaction.setFont(new Font("Times New Roman", Font.BOLD, 45));
        transaction.setFocusPainted(false);
        transaction.setForeground(Color.WHITE);
        transaction.setMnemonic(KeyEvent.VK_R);
        transaction.setBounds(737, 381, 300, 290);

        summary.setOpaque(false);
        summary.setContentAreaFilled(false);
        summary.setBorderPainted(false);
        summary.setFont(new Font("Times New Roman", Font.BOLD, 35));
        summary.setFocusPainted(false);
        summary.setForeground(Color.WHITE);
        summary.setMnemonic(KeyEvent.VK_M);
        summary.setBounds(280, 290, 260, 250);

        exception.setOpaque(false);
        exception.setContentAreaFilled(false);
        exception.setBorderPainted(false);
        exception.setFont(new Font("Times New Roman", Font.BOLD, 30));
        exception.setFocusPainted(false);
        exception.setMnemonic(KeyEvent.VK_C);
        exception.setForeground(Color.WHITE);
        exception.setBounds(973, 135, 240, 240);

        backbutton.setOpaque(false);
        backbutton.setContentAreaFilled(false);
        backbutton.setFocusPainted(false);
        backbutton.setBorderPainted(false);
        backbutton.setMnemonic(KeyEvent.VK_B);
        backbutton.setBounds(0, 550, 250, 150);
        p1.add(transaction);
        p1.add(summary);
        p1.add(backbutton);
        p1.add(exception);
        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);

        transaction.addActionListener(new Transaction_Report());
        summary.addActionListener(new Summary_Report());
        exception.addActionListener(new Exception_Report());
        backbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new MainMenu(user, position);
                dispose();
            }
        });

        createMenuBar(user, position);
        setTitle("Report Menu");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }

    private class Transaction_Report implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new TransactionReport().setVisible(true);

        }
    }

    private class Summary_Report implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new SummaryReport().setVisible(true);
        }
    }

    private class Exception_Report implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new ExceptionReport().setVisible(true);
        }
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
        new ReportMenu();
    }
}
