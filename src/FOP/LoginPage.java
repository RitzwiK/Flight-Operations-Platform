package FOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JButton bt1, bt2;  
    JTextField tf;  
    JPasswordField pf;  
    JFrame f;

    LoginPage() {
        f = new JFrame("LOGIN ACCOUNT");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("FOP/icons/1.jpg")); 
        Image i1 = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);  

        f.add(l1);  

        l2 = new JLabel("USERNAME");
        l2.setBounds(120, 120, 150, 30);
        l2.setForeground(Color.BLACK);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l2);

        l3 = new JLabel("Login Account");
        l3.setBounds(190, 30, 500, 50);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Arial", Font.BOLD, 33));
        l1.add(l3);

        l4 = new JLabel("PASSWORD");
        l4.setBounds(120, 170, 150, 30);
        l4.setForeground(Color.BLACK);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l1.add(l4);

        tf = new JTextField();
        tf.setBounds(320, 120, 150, 30); 
        l1.add(tf);

        pf = new JPasswordField();
        pf.setBounds(320, 170, 150, 30);  
        l1.add(pf);

        bt1 = new JButton("Login");
        bt1.setForeground(Color.WHITE);
        bt1.setBackground(Color.BLACK);  
        bt1.setBounds(120, 220, 150, 40);
        l1.add(bt1);
        
        bt1.addActionListener(this); 
        bt2 = new JButton("Sign Up");
        bt2.setForeground(Color.WHITE);
        bt2.setBackground(Color.BLACK); 
        bt2.setBounds(320, 220, 150, 40);  
        l1.add(bt2);
        bt2.addActionListener(this); 

        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            String username = tf.getText();  
            String pass = pf.getText();  
            try {
                ConnectionClass obj = new ConnectionClass();
                String g = "Select * from signup where username='" + username + "' and password='" + pass + "'";
                ResultSet rs = obj.stm.executeQuery(g);
                if (rs.next()) {
                    new HomePage().setVisible(true);  
                    f.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password!");
                    f.setVisible(false);
                    f.setVisible(true);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == bt2) {
            this.setVisible(false); // Hide the current login page
            new SignupMessage(); // Show the signup message
        }
    }

    public static void main(String[] args) {
        new LoginPage();
    }
}
