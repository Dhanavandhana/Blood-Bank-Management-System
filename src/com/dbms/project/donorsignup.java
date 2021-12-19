package com.dbms.project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;




public class donorsignup extends JFrame implements ActionListener {

    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8;
    JButton b;
    public donorsignup()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel l = new JLabel("DONOR SIGN UP PAGE");

        l1 = new JLabel(" Donor Name :");
        l2 = new JLabel("Username:");
        l3 = new JLabel("Password:");
        l4 = new JLabel("Confirm Password:");
        l5 = new JLabel(" Blood Group :");
        l6 = new JLabel(" Age :");
        l7 = new JLabel(" Phone :");
        l8 = new JLabel(" Address :");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();


        l.setBounds(100,100,200,50);
        l1.setBounds(50,200,100,30);
        l2.setBounds(50,250,100,30);
        l3.setBounds(50,300,200,30);
        l4.setBounds(50,350,200,30);
        l5.setBounds(50,400,100,30);
        l6.setBounds(50,450,100,30);
        l7.setBounds(50,500,100,30);
        l8.setBounds(50,550,100,30);

        tf1.setBounds(150,200,100,30);
        tf2.setBounds(150,250,100,30);
        tf3.setBounds(200,300,100,30);
        tf4.setBounds(200,350,100,30);
        tf5.setBounds(150,400,100,30);
        tf6.setBounds(150,450,100,30);
        tf7.setBounds(150,500,100,30);
        tf8.setBounds(150,550,100,30);



        b = new JButton("SUBMIT");
        b.setBounds(100,700,100,40);
        add(b);
        b.addActionListener(this);

        add(l);
        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(l6);
        add(l7);
        add(l8);

        add(tf1);
        add(tf2);
        add(tf3);
        add(tf4);
        add(tf5);
        add(tf6);
        add(tf7);
        add(tf8);

        setSize(400,300);
        setLayout(null);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b)
        {
            try {

                PreparedStatement Pstatement=Myconnection.getConnection().prepareStatement("insert into donor values(?,?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,tf1.getText());
                Pstatement.setString(2,tf2.getText());
                Pstatement.setString(3,tf3.getText());
                Pstatement.setString(4,tf5.getText());
                Pstatement.setString(5,tf6.getText());
                Pstatement.setString(6,tf7.getText());
                Pstatement.setString(7,tf8.getText());
                //Checking for the Password match
                if(tf3.getText().equals(tf4.getText()))
                {
                    //Executing query
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                    setVisible(false);
                    new donorlogin().setVisible(true);


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



