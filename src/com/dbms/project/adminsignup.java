package com.dbms.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class adminsignup extends JFrame implements ActionListener {

    JLabel l,l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b;


    public adminsignup()
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        l = new JLabel("ADMIN SIGN UP PAGE");

        l1 = new JLabel(" Admin Name :");
        l2 = new JLabel(" Username:");
        l5 = new JLabel("Password: ");
        l6 = new JLabel("Confirm Password:");
        l3 = new JLabel(" Phone :");
        l4 = new JLabel(" Address :");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();




        l.setBounds(100,100,200,50);
        l1.setBounds(50,200,100,30);
        l2.setBounds(50,250,100,30);
        l5.setBounds(50,300,100,30);
        l6.setBounds(50,350,100,30);
        l3.setBounds(50,400,100,30);
        l4.setBounds(50,450,100,30);

        tf1.setBounds(150,200,100,30);
        tf2.setBounds(150,250,100,30);
        tf5.setBounds(150,300,100,30);
        tf6.setBounds(150,350,100,30);
        tf3.setBounds(150,400,100,30);
        tf4.setBounds(150,450,200,80);


        b = new JButton("SIGN UP");
        b.setBounds(100,600,100,40);
        add(b);
        b.addActionListener(this);

        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);

        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);

        setSize(400,300);
        setLayout(null);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
            try {

                PreparedStatement Pstatement=Myconnection.getConnection().prepareStatement("insert into admin values(?,?,?,?,?)");
                Pstatement.setString(1,tf1.getText());
                Pstatement.setString(2,tf2.getText());
                Pstatement.setString(3,tf5.getText());
                Pstatement.setString(4,tf3.getText());
                Pstatement.setString(5,tf4.getText());

                if(tf5.getText().equals(tf6.getText()))
                {
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                    setVisible(false);
                    new adminlogin().setVisible(true);


                }
                else
                {
                    JOptionPane.showMessageDialog(null,"password did not match");
                }

            }
            catch(SQLIntegrityConstraintViolationException e2){
                System.out.println(e2);
                JOptionPane.showMessageDialog(null,"Username not unique");
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }


        }

    }
}

