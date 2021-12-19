package com.dbms.project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class donorlogin extends JFrame implements ActionListener {

    JLabel l, l1, l2;
    JTextField tf1, tf2;
    JButton b;


    public donorlogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        l = new JLabel("DONOR LOG IN PAGE");

        l1 = new JLabel(" Donor Username :");
        l2 = new JLabel(" Password :");

        tf1 = new JTextField();
        tf2 = new JTextField();


        l.setBounds(100, 50, 300, 100);
        l1.setBounds(50, 200, 100, 30);
        l2.setBounds(50, 250, 100, 30);


        tf1.setBounds(150, 200, 100, 30);
        tf2.setBounds(150, 250, 100, 30);


        JButton b = new JButton("Login");
        b.setBounds(100, 350, 100, 40);
        add(b);
        b.addActionListener(this);

        add(l);
        add(l1);
        add(l2);


        add(tf1);
        add(tf2);


        setSize(400, 300);
        setLayout(null);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent e) {

        String uname = tf1.getText();
        String pass = tf2.getText();
        try {
            String query = "SELECT * FROM donor WHERE username =? AND password=?";

            PreparedStatement st = Myconnection.getConnection().prepareStatement(query);


            st.setString(1, uname);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                setVisible(false);
                new Donorpage();
                JOptionPane.showMessageDialog(b, "You have successfully logged in");
            } else {
                JOptionPane.showMessageDialog(b, "Wrong Username & Password");
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

