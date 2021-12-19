package com.dbms.project;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
public class editprofile extends JFrame implements ActionListener {
    JLabel lb, lb1, lb2, lb3, lb4, lb5, lb6, lb7;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    JButton btn;

    public editprofile() {
        super("Edit Profile Info");
        lb = new JLabel("EDIT PROFILE INFO");
        lb.setBounds(100, 50, 200, 50);
        lb1 = new JLabel("Username:");
        lb1.setBounds(20, 120, 100, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(130, 120, 200, 20);
        lb2 = new JLabel("Donor Name:");
        lb2.setBounds(20, 150, 100, 20);
        tf2 = new JTextField(100);
        tf2.setBounds(130, 150, 200, 20);
        lb3 = new JLabel("Blood group:");
        lb3.setBounds(20, 180, 100, 20);
        tf3 = new JTextField(50);
        tf3.setBounds(130, 180, 200, 20);
        lb4 = new JLabel("Age:");
        lb4.setBounds(20, 210, 100, 20);
        tf4 = new JTextField(50);
        tf4.setBounds(130, 210, 100, 20);
        lb6 = new JLabel("Phone:");
        lb6.setBounds(20, 240, 100, 20);
        tf6 = new JTextField(50);
        tf6.setBounds(130, 240, 100, 20);
        lb7 = new JLabel("Address:");
        lb7.setBounds(20, 270, 100, 20);
        tf7 = new JTextField(50);
        tf7.setBounds(130, 270, 100, 20);
        btn = new JButton("Submit");
        btn.setBounds(50, 300, 100, 20);
        btn.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        add(btn);
        add(lb);
        add(lb1);
        add(tf1);
        add(lb2);
        add(tf2);
        add(lb3);
        add(tf3);
        add(lb4);
        add(tf4);
        add(lb6);
        add(tf6);
        add(lb7);
        add(tf7);

    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            try {
                Statement stmt = Myconnection.getConnection().createStatement();
                stmt.execute("UPDATE donor SET donor_name='" + tf2.getText() + "',blood='" + tf3.getText() + "',age='" + tf4.getText() + "',phone='" + tf6.getText() + "',address='" + tf7.getText() + "' WHERE username='" + tf1.getText() + "'");
                JOptionPane.showMessageDialog(null, "Record is updated...");
                //stmt.close();

            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}