package FOP;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.net.URL; // Add this import for URL class

public class CheckPaymentDetails extends JFrame {
    
    // Declare UI components
    JTextField textField;
    JTable table;
    JLabel Sector, FlightCode, Capacity, Classcode, Classname, label;
    
    public static void main(String[] args) {
        new CheckPaymentDetails();
    }
    
    CheckPaymentDetails() {
        initialise();  // Initialize the frame
    }
    
    // Method to initialize the components
    private void initialise() {
        // Set up the frame
        setTitle("Payment Details");
        getContentPane().setBackground(Color.WHITE);
        setSize(860, 486);
        setLayout(null);
        
        // Add Username label
        JLabel Fcode = new JLabel("Username");
        Fcode.setFont(new Font("Arial", Font.BOLD, 16));
        Fcode.setBounds(190, 160, 150, 26);
        add(Fcode);
        
        // Add table to display payment details
        table = new JTable();
        table.setBounds(93, 297, 766, 87);
        add(table);
        
        // Input field for username
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.BOLD, 14));
        textField.setBounds(300, 160, 150, 26);
        add(textField);
        
        // Button to show payment details
        JButton Show = new JButton("Show");
        Show.setFont(new Font("Arial", Font.BOLD, 14));
        Show.setBackground(Color.BLACK);
        Show.setForeground(Color.WHITE);
        Show.setBounds(500, 160, 150, 26);
        add(Show);
        
        // Title label
        Sector = new JLabel("Check Payment Details");
        Sector.setForeground(Color.BLUE);
        Sector.setFont(new Font("Arial", Font.BOLD, 33));
        Sector.setBounds(291, 17, 800, 39);
        add(Sector);
        
        // Labels for table headers
        FlightCode = new JLabel("Ticket ID");
        FlightCode.setFont(new Font("Arial", Font.BOLD, 14));
        FlightCode.setBounds(117, 262, 108, 26);
        add(FlightCode);
        
        Capacity = new JLabel("Price");
        Capacity.setFont(new Font("Arial", Font.BOLD, 14));
        Capacity.setBounds(237, 268, 38, 14);
        add(Capacity);
        
        Classcode = new JLabel("Journey Date");
        Classcode.setFont(new Font("Arial", Font.BOLD, 14));
        Classcode.setBounds(362, 264, 101, 24);
        add(Classcode);
        
        Classname = new JLabel("Journey Time");
        Classname.setFont(new Font("Arial", Font.BOLD, 14));
        Classname.setBounds(485, 268, 114, 14);
        add(Classname);
        
        JLabel Cardno = new JLabel("Username");
        Cardno.setFont(new Font("Arial", Font.BOLD, 14));
        Cardno.setBounds(620, 269, 101, 19);
        add(Cardno);
        
        JLabel Phoneno = new JLabel("Status");
        Phoneno.setFont(new Font("Arial", Font.BOLD, 14));
        Phoneno.setBounds(752, 264, 86, 24);
        add(Phoneno);
        
        // Load image using ClassLoader
        URL imgURL = getClass().getClassLoader().getResource("FOP/icons/1.jpg"); // Adjust if necessary for your resource path
        if (imgURL != null) {
            ImageIcon ic = new ImageIcon(imgURL);
            Image img = ic.getImage().getScaledInstance(1540, 800, Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            label = new JLabel(ic1);
            label.setBounds(0, 0, 960, 590);
            add(label);
        } else {
            System.err.println("Image not found!");
        }
        
        // Set default frame properties
        setSize(960, 590);
        setLocation(40, 20);
        setVisible(true);
        
        // ActionListener for the Show button
        Show.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                try {
                    String usn = textField.getText();  // Get username from text field
                    ConnectionClass obj = new ConnectionClass();  // Create database connection
                    String str = "select tid, price, journey_date, journey_time, username, status from bookedFlight where username ='" + usn + "' and status='Scheduled'";
                    ResultSet rs = obj.stm.executeQuery(str);  // Execute query
                    table.setModel(DbUtils.resultSetToTableModel(rs));  // Populate table with result set
                    table.setFont(new Font("Arial", Font.BOLD, 14));
                } catch (SQLException e) {
                    e.printStackTrace();  // Print SQL exception
                }
            }
        });
    }
}
