package com.dbms.project;

import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class deleteinfo extends JFrame implements ActionListener {
    JLabel l1;
    JTextField tf1;
    JButton b;
    public deleteinfo(){
        super("Delete Donor Information");

        l1 = new JLabel("Enter Donor User Name:");
        l1.setBounds(20, 120, 200, 20);
        tf1 = new JTextField(50);
        tf1.setBounds(180, 120, 200, 20);
        b = new JButton("Delete");
        b.setBounds(20, 330, 100, 20);
        b.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(b);
        add(l1);
        add(tf1);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            String str = tf1.getText();
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dhanavandhana", "password");
            PreparedStatement st = con.prepareStatement("delete from donor where username=?");
            st.setString(1, str);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(b, "Donor details has been deleted");
                setVisible(false);
                new viewdonortable();
            } else {
                JOptionPane.showMessageDialog(b, "Wrong Username");
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
