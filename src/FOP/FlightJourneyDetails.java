package FOP;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FlightJourneyDetails extends JFrame
{
    JTable t;
    String x[] = {"Username", "Name", "Age", "Date of Birth", "Address", "Phone", "Email ID", "Nationality", "Gender", "Passport"};
    String y[][] = new String[50][10];
    int i = 0, j = 0;
    Font f;
    FlightJourneyDetails(String src,String dst)
    {
        super("Flight Status Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
        
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="select* from bookedflight where source='"+src"' and destination='"+dst+"'";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next())
            {
                y[i][j++] = rest.getString("username"); 
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("age");
                y[i][j++] = rest.getString("dob");
                y[i][j++] = rest.getString("address");
                y[i][j++] = rest.getString("phone");
                y[i][j++] = rest.getString("email");
                y[i][j++] = rest.getString("nationality");
                y[i][j++] = rest.getString("gender");
                y[i][j++] = rest.getString("passport");
                i++;
                j = 0;
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLUE);
        t.setForeground(Color.BLACK);
        
        JScrollPane js=new JScrollPane(t);
        add(t);
    }   
}