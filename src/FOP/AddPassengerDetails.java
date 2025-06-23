package FOP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class AddPassengerDetails extends JFrame implements ActionListener {
    JButton bt1, bt2;
    JLabel l1; // Background label
    JLabel l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;

    AddPassengerDetails() {
        super("Add Passenger Details");
        setLayout(null);

        // Load the image as a background
        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        
        // Load the image using class loader
        ImageIcon img = new ImageIcon(getClass().getResource("/FOP/icons/3.jpg"));
        if (img.getIconWidth() == -1) {
            System.out.println("Image not found!");
        } else {
            Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
            ImageIcon img2 = new ImageIcon(i1);
            l1.setIcon(img2);
        }

        // Create labels with white text
        l2 = new JLabel("Username:");
        l2.setBounds(50, 150, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.WHITE); // Set text color to white
        l1.add(l2);

        l3 = new JLabel("WELCOME TO THE AIRLINES OF INDIA!");
        l3.setBounds(140, 40, 600, 40);
        l3.setFont(new Font("Arial", Font.BOLD, 30));
        l3.setForeground(Color.WHITE); // Set text color to white
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(200, 150, 150, 30);
        l1.add(tf1);

        l4 = new JLabel("Name:");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.WHITE); // Set text color to white
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(600, 150, 150, 30);
        l1.add(tf2);

        l5 = new JLabel("Age:");
        l5.setBounds(50, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.WHITE); // Set text color to white
        l1.add(l5);

        tf3 = new JTextField();
        tf3.setBounds(200, 200, 150, 30);
        l1.add(tf3);

        l6 = new JLabel("Date of Birth:");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.WHITE); // Set text color to white
        l1.add(l6);

        tf4 = new JTextField();
        tf4.setBounds(600, 200, 150, 30);
        l1.add(tf4);

        l7 = new JLabel("Address:");
        l7.setBounds(50, 250, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.WHITE); // Set text color to white
        l1.add(l7);

        tf5 = new JTextField();
        tf5.setBounds(200, 250, 150, 30);
        l1.add(tf5);

        l8 = new JLabel("Phone:");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.WHITE); // Set text color to white
        l1.add(l8);

        tf6 = new JTextField();
        tf6.setBounds(600, 250, 150, 30);
        l1.add(tf6);

        l9 = new JLabel("Email ID:");
        l9.setBounds(50, 300, 100, 30);
        l9.setFont(new Font("Arial", Font.BOLD, 20));
        l9.setForeground(Color.WHITE); // Set text color to white
        l1.add(l9);

        tf7 = new JTextField();
        tf7.setBounds(200, 300, 150, 30);
        l1.add(tf7);

        l10 = new JLabel("Nationality:");
        l10.setBounds(450, 300, 120, 30);
        l10.setFont(new Font("Arial", Font.BOLD, 20));
        l10.setForeground(Color.WHITE); // Set text color to white
        l1.add(l10);

        tf8 = new JTextField();
        tf8.setBounds(600, 300, 150, 30);
        l1.add(tf8);

        l11 = new JLabel("Gender:");
        l11.setBounds(50, 350, 100, 30);
        l11.setFont(new Font("Arial", Font.BOLD, 20));
        l11.setForeground(Color.WHITE); // Set text color to white
        l1.add(l11);

        tf9 = new JTextField();
        tf9.setBounds(200, 350, 150, 30);
        l1.add(tf9);

        l12 = new JLabel("Passport No.:");
        l12.setBounds(450, 350, 250, 30);
        l12.setFont(new Font("Arial", Font.BOLD, 20));
        l12.setForeground(Color.WHITE); // Set text color to white
        l1.add(l12);

        tf10 = new JTextField();
        tf10.setBounds(600, 350, 150, 30);
        l1.add(tf10);

        bt1 = new JButton("SAVE");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 40);
        l1.add(bt1);

        bt2 = new JButton("CLOSE");
        bt2.setBackground(Color.BLACK);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 500, 150, 40);
        l1.add(bt2);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        add(l1);
        setVisible(true);
        setSize(900, 600);
        setLocation(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on exit
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1) {
            String username = tf1.getText();
            String name = tf2.getText();
            String age = tf3.getText();
            String dob = tf4.getText();
            String address = tf5.getText();
            String phone = tf6.getText();
            String email = tf7.getText();
            String nationality = tf8.getText();
            String gender = tf9.getText();
            String passport = tf10.getText();
            
            try {
                ConnectionClass obj = new ConnectionClass();
                String g = "INSERT INTO passenger VALUES('"+username+"','"+name+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+nationality+"','"+gender+"','"+passport+"')";
                obj.stm.executeUpdate(g);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                // f.setVisible(false);
                // new HomePage(); // Uncomment if you want to navigate to HomePage
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource() == bt2) {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure that you want to close this page?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.setVisible(false);
            }
        }
    }

    public static void main(String[] args) {
        new AddPassengerDetails();
    }
}
