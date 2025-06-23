package FOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;  
import java.sql.*;
public class HomePage extends JFrame implements ActionListener
{
    JLabel l1, l2;
    Font f, f1, f2;
    
    HomePage()
    {
        super("Indian Airlines Home Page");
        setLocation(0, 0);
        
        f = new Font("Lucida Fax", Font.BOLD, 20);
        f1 = new Font("Gadugi", Font.BOLD, 35);
        f2 = new Font("MS UI Gothic", Font.BOLD, 18);
        
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("FOP/icons/5.jpg")); 
        Image i1 = ic.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon ic1 = new ImageIcon(i1);
        l1 = new JLabel(ic1);
        
        JMenuBar m1 = new JMenuBar();
        
        JMenu men1 = new JMenu("Passenger Profile");
        JMenuItem men1Item1 = new JMenuItem("Add Passenger Profile");
        JMenuItem men1Item2 = new JMenuItem("View Passenger Profile");
        men1.add(men1Item1);
        men1.add(men1Item2);
        m1.add(men1);
        
        JMenu men2 = new JMenu("Manage Passenger");
        JMenuItem men2Item1 = new JMenuItem("Update Passenger Profile");
        men2.add(men2Item1);
        m1.add(men2);
        
        JMenu men3 = new JMenu("Your Flight");
        JMenuItem men3Item1 = new JMenuItem("Book Flight");
        JMenuItem men3Item2 = new JMenuItem("View Booked Flight");
        men3.add(men3Item1);
        men3.add(men3Item2);
        m1.add(men3);
        
        JMenu men4 = new JMenu("Flight Details");
        JMenuItem men4Item1 = new JMenuItem("Journey Details");
        JMenuItem men4Item2 = new JMenuItem("Flight Time");
        men4.add(men4Item1);
        men4.add(men4Item2);
        m1.add(men4);
        
        JMenu men5 = new JMenu("Cancellation");
        JMenuItem men5Item1 = new JMenuItem("Cancel Ticket");
        JMenuItem men5Item2 = new JMenuItem("View Canceled Ticket");
        men5.add(men5Item1);
        men5.add(men5Item2);
        m1.add(men5);
        
        JMenu men6 = new JMenu("Bill");
        JMenuItem men6Item1 = new JMenuItem("Check Payment");
        men6.add(men6Item1);
        m1.add(men6);
        
        JMenu men8 = new JMenu("Logout");
        JMenuItem men8Item1 = new JMenuItem("Exit");
        men8.add(men8Item1);
        m1.add(men8);
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men8.setFont(f);
        
        men1Item1.setFont(f1);
        men1Item2.setFont(f1);
        men2Item1.setFont(f1);
        men3Item1.setFont(f1);
        men3Item2.setFont(f1);
        men4Item1.setFont(f1);
        men4Item2.setFont(f1);
        men5Item1.setFont(f1);
        men5Item2.setFont(f1);
        men6Item1.setFont(f1);
        men8Item1.setFont(f1);
        
        m1.setBackground(new java.awt.Color(4, 1, 54));
        
        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);
        men6.setForeground(Color.GRAY);
        men8.setForeground(Color.RED);
        
        men1Item1.setBackground(Color.BLACK);
        men1Item2.setBackground(Color.BLACK);
        men2Item1.setBackground(Color.BLACK);
        men3Item1.setBackground(Color.BLACK);
        men3Item2.setBackground(Color.BLACK);
        men4Item1.setBackground(Color.BLACK);
        men4Item2.setBackground(Color.BLACK);
        men5Item1.setBackground(Color.BLACK);
        men5Item2.setBackground(Color.BLACK);
        men6Item1.setBackground(Color.BLACK);
        men8Item1.setBackground(Color.BLACK);
        
        men1Item1.setForeground(Color.YELLOW);
        men1Item2.setForeground(Color.YELLOW);
        men2Item1.setForeground(Color.YELLOW);
        men3Item1.setForeground(Color.YELLOW);
        men3Item2.setForeground(Color.YELLOW);
        men4Item1.setForeground(Color.YELLOW);
        men4Item2.setForeground(Color.YELLOW);
        men5Item1.setForeground(Color.YELLOW);
        men5Item2.setForeground(Color.YELLOW);
        men6Item1.setForeground(Color.YELLOW);
        men8Item1.setForeground(Color.RED);
        
        men1Item1.addActionListener(this);
        men1Item2.addActionListener(this);
        men2Item1.addActionListener(this);
        men3Item1.addActionListener(this);
        men3Item2.addActionListener(this);
        men4Item1.addActionListener(this);
        men4Item2.addActionListener(this);
        men5Item1.addActionListener(this);
        men5Item2.addActionListener(this);
        men6Item1.addActionListener(this);
        men8Item1.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
    }

    public void actionPerformed(ActionEvent e)
    {
        String cmd = e.getActionCommand();
        if (cmd.equals("Add Passenger Profile"))
        {
            new AddPassengerDetails();
        }
        else if (cmd.equals("View Passenger Profile"))
        {
            new ViewPassengers().setVisible(true);
        }
        else if (cmd.equals("Update Passenger Profile"))
        {
            new UpdatePassenger().setVisible(true);
        }
        else if (cmd.equals("Book Flight"))
        {
            new bookFlight().setVisible(true);
        }
        else if (cmd.equals("View Booked Flight"))
        {
            new ViewBookedFlight().setVisible(true);
        }
        else if (cmd.equals("Journey Details"))
        {
            new FlightJourney();
        }
        else if (cmd.equals("Flight Time"))
        {
            new FlightZone().setVisible(true);
        }
        else if (cmd.equals("Cancel Ticket"))
        {
            new CancelFlight().setVisible(true);
        }
        else if (cmd.equals("View Canceled Ticket"))
        {
            new ViewCanceledTicket().setVisible(true);
        }
        else if (cmd.equals("Check Payment"))
        {
            new CheckPaymentDetails().setVisible(true);
        }
        else if (cmd.equals("Exit"))
        {
            System.exit(0);
        }
    }

    public static void main(String[] args)
    {
        new HomePage().setVisible(true);
    }
}
