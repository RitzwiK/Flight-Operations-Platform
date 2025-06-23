package FOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdatePassenger extends JFrame implements ActionListener {
    Font f, f1,f2;
    Choice ch;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton bt1, bt2;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    JPanel p1, p2, p3;

    UpdatePassenger() {
        super("Update Passenger");
        setLocation(450, 10);
        setSize(740, 600);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);
        f2 =new Font("Arial",Font.BOLD, 14);

        // Choice for username
        ch = new Choice();

        // Fetching usernames from the database
        try {
            ConnectionClass obj = new ConnectionClass();
            String q = "select username from passenger";
            ResultSet rest = obj.stm.executeQuery(q);
            while (rest.next()) {
                ch.add(rest.getString("username"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Initializing labels and text fields
        l1 = new JLabel("Update Passenger Details");
        l2 = new JLabel("Username", SwingConstants.RIGHT);
        l3 = new JLabel("Name", SwingConstants.RIGHT);
        l4 = new JLabel("Age", SwingConstants.RIGHT);
        l5 = new JLabel("Date of Birth", SwingConstants.RIGHT);
        l6 = new JLabel("Address", SwingConstants.RIGHT);
        l7 = new JLabel("Phone No.", SwingConstants.RIGHT);
        l8 = new JLabel("Email ID", SwingConstants.RIGHT);
        l9 = new JLabel("Nationality", SwingConstants.RIGHT);
        l10 = new JLabel("Gender", SwingConstants.RIGHT);
        l11 = new JLabel("Passport No.", SwingConstants.RIGHT);

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();

        bt1 = new JButton("UPDATE PASSENGER");
        bt2 = new JButton("BACK");

        l1.setHorizontalAlignment(JLabel.CENTER);

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        // Setting fonts
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);

        tf1.setFont(f1);
        tf2.setFont(f1);
        tf3.setFont(f1);
        tf4.setFont(f1);
        tf5.setFont(f1);
        tf6.setFont(f1);
        tf7.setFont(f1);
        tf8.setFont(f1);
        tf9.setFont(f1);

        bt1.setFont(f2);
        bt2.setFont(f1);

        bt1.setBackground(Color.BLUE);
        bt2.setBackground(Color.RED);

        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);

        // Panel 1 for heading
        p1 = new JPanel();
        p1.setLayout(new BorderLayout());
        p1.add(l1, BorderLayout.CENTER);

        // Panel 2 for form fields
        p2 = new JPanel();
        p2.setLayout(new GridLayout(11, 2, 10, 10));
        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(l9);
        p2.add(tf7);
        p2.add(l10);
        p2.add(tf8);
        p2.add(l11);
        p2.add(tf9);

        // Adding buttons
        p2.add(bt1);
        p2.add(bt2);

        // Panel 3 for image on the left
        p3 = new JPanel();
        p3.setLayout(new BorderLayout());
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("FOP/icons/6.jpg")); // Add your image path
        Image img1 = img.getImage().getScaledInstance(300, 500, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(img1);
        l12 = new JLabel(ic1);
        p3.add(l12, BorderLayout.CENTER);

        // Set the layout of the frame
        setLayout(new BorderLayout());
        add(p1, BorderLayout.NORTH);
        add(p3, BorderLayout.WEST); // Image on the left
        add(p2, BorderLayout.CENTER); // Form in the center

        // Add functionality to load passenger details when username is selected
        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                try {
                    ConnectionClass obj = new ConnectionClass();
                    String username = ch.getSelectedItem();
                    String q1 = "select * from passenger where username='" + username + "'";
                    ResultSet rest1 = obj.stm.executeQuery(q1);
                    while (rest1.next()) {
                        tf1.setText(rest1.getString("name"));
                        tf2.setText(rest1.getString("age"));
                        tf3.setText(rest1.getString("dob"));
                        tf4.setText(rest1.getString("address"));
                        tf5.setText(rest1.getString("phone"));
                        tf6.setText(rest1.getString("email"));
                        tf7.setText(rest1.getString("nationality"));
                        tf8.setText(rest1.getString("gender"));
                        tf9.setText(rest1.getString("passport"));
                    }
                } catch (Exception exx) {
                    exx.printStackTrace();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            String username = ch.getSelectedItem();
            String name = tf1.getText();
            String age = tf2.getText();
            String dob = tf3.getText();
            String address = tf4.getText();
            String phone = tf5.getText();
            String email = tf6.getText();
            String nationality = tf7.getText();
            String gender = tf8.getText();
            String passport = tf9.getText();

            try {
                ConnectionClass obj = new ConnectionClass();
                String q1 = "update passenger set name='" + name + "', age='" + age + "', dob='" + dob + "', address='" + address + "', phone='" + phone + "', email='" + email + "', nationality='" + nationality + "', gender='" + gender + "', passport='" + passport + "' where username='" + username + "'";
                int aa = obj.stm.executeUpdate(q1);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Passenger details updated successfully!");
                    this.setVisible(false);
                    new ViewPassengers().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error in updating passenger details.");
                }
            } catch (Exception exx) {
                exx.printStackTrace();
            }
        }

        if (e.getSource() == bt2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdatePassenger().setVisible(true);
    }
}
