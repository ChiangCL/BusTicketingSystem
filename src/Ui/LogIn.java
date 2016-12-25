/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

/**
 *
 * @author Chan Guan Hao & Lim Zhen Kai
 */
import Da.StaffDa;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class LogIn extends JFrame {

    private JTextField jtfUser = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JLabel input1 = new JLabel("Username:", FlowLayout.LEFT);
    private JLabel input2 = new JLabel("Password:", FlowLayout.LEFT);
    private JLabel title = new JLabel("ILikeBus", FlowLayout.LEFT);
    private JButton Login = new JButton("Login");
    private JLabel background = new JLabel(new ImageIcon(getClass().getResource("/images/w1.jpg")));
    private StaffDa staffDa;

    public LogIn() {
        Container c = getContentPane();
        input1.setFont(new Font("Times New Roman", Font.BOLD, 33));
        input2.setFont(new Font("Times New Roman", Font.BOLD, 33));
        Login.setFont(new Font("Times New Roman", Font.BOLD, 35));
        title.setFont(new Font("Times New Roman", Font.BOLD + Font.ITALIC, 100));
        jtfUser.setOpaque(false);
        jtfUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
        jtfUser.setForeground(Color.WHITE);
        jtfUser.setToolTipText("Username are required");
        passwordField.setFont(new Font("Times New Roman", Font.BOLD, 35));
        passwordField.setOpaque(false);
        passwordField.setForeground(Color.WHITE);
        passwordField.setToolTipText("Password are required");
        setLayout(new BorderLayout(5, 10));
        title.setForeground(Color.WHITE);
        input1.setForeground(Color.WHITE);
        input2.setForeground(Color.WHITE);
        Login.setForeground(Color.WHITE);
        Login.setOpaque(false);
        Login.setFocusPainted(false);
        Login.setContentAreaFilled(false);
        Login.setBorderPainted(false);

        c.setLayout(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(0, 3));
        JPanel p4 = new JPanel(new GridLayout(1, 2));
        p4.add(new JLabel(""));
        p4.add(new JLabel(""));

        p4.setOpaque(false);
        p1.add(p4);
        p1.setOpaque(false);
        JPanel p2 = new JPanel(new GridLayout(3, 1));
        p2.add(title);
        p2.setOpaque(false);
        p1.add(p2);
        JPanel p3 = new JPanel(new GridLayout(4, 2, 10, 18));
        p3.add(new JLabel(""));
        p3.add(new JLabel(""));
        p3.add(new JLabel(""));
        p3.add(new JLabel(""));
        p3.add(input1);
        p3.add(jtfUser);
        p3.add(input2);
        p3.add(passwordField);
        p3.setOpaque(false);
        p2.add(p3, BorderLayout.SOUTH);
        JPanel p5 = new JPanel(new GridLayout(3, 1, 10, 0));
        p5.add(Login);
        p5.setOpaque(false);
        p2.add(p5);

        background.setLayout(new GridLayout());
        background.add(p1);
        add(background);
        Login.addActionListener(new verify());

        createMenuBar();
        setTitle("Login");
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);
    }
//Login function

    private class verify implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            staffDa = new StaffDa();
            String user = jtfUser.getText().toUpperCase();
            String pass = passwordField.getText();
            if (validation() == true) {
                int i = staffDa.verifyUser(user, pass);
                String position = staffDa.RetrievePosition(user, pass);
                if (i == 1) {
                    new MainMenu(user, position);
                    dispose();
                } else {
                    jtfUser.setText(null);
                    passwordField.setText(null);
                    jtfUser.grabFocus();
                    JOptionPane.showMessageDialog(null, "Username or Password Incorrect", "Invalid Account",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private boolean validation() {
        if (jtfUser.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the Username",
                    "Invalid Username", JOptionPane.ERROR_MESSAGE);

            jtfUser.grabFocus();
            return false;
        } else if (passwordField.getText().trim().length() == 0) {
            JOptionPane.showMessageDialog(null, "Please enter the Password",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);

            passwordField.grabFocus();
            return false;
        }
        return true;
    }

    private void createMenuBar() {

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
        JMenuItem r_pass = new JMenuItem("Recover Password");
        r_pass.setMnemonic(KeyEvent.VK_R);
        r_pass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new RecoveryPassword().setVisible(true);

            }
        });

        setting.add(r_pass);
        setting.add(eMenuItem);
        menubar.add(setting);

        setJMenuBar(menubar);
    }

    public static void main(String[] args) {
        new LogIn();
    }
}
