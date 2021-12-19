package com.dbms.project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionListener;

public class request extends JFrame implements ActionListener {
    JLabel l, l1, l2, l3, l4;
    JTextField tf1, tf2, tf3, tf4;
    JButton b;

    public request() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l = new JLabel("Create Request");

        l2 = new JLabel("Blood Group:");
        l3= new JLabel("Quantity:");
        l4 = new JLabel("Hospital:");

        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();


        l.setBounds(100, 100, 200, 50);
        l2.setBounds(50, 250, 100, 30);
        l3.setBounds(50, 300, 200, 30);
        l4.setBounds(50, 350, 200, 30);


        tf2.setBounds(150, 250, 100, 30);
        tf3.setBounds(200, 300, 100, 30);
        tf4.setBounds(200, 350, 100, 30);



        b = new JButton("SUBMIT");
        b.setBounds(100, 500, 100, 40);
        add(b);
        b.addActionListener(this);

        add(l);
        //add(l1);
        add(l2);
        add(l3);
        add(l4);

        //add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);


        setSize(400, 300);
        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            try {
                String blood=tf2.getText();
                String quan=tf3.getText();

                String query = "delete from stock where blood_grp=? and quantity=?";
                PreparedStatement st = Myconnection.getConnection().prepareStatement(query);
                st.setString(1,blood );
                st.setString(2,quan);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(b, "Stock available.Request Accepted");

                } else {
                    JOptionPane.showMessageDialog(b, "Stock not available");
                }
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }

        }


    }

}


