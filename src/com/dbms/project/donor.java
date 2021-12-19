package com.dbms.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class donor extends JFrame implements ActionListener
{
    JButton b1,b2;
    private JLabel l;

    public donor()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l = new JLabel("DONOR PAGE");
        b1 = new JButton("SIGN UP");
        b2 = new JButton("LOG IN");

        l.setBounds(200, 10, 100, 100);
        b1.setBounds(130, 100, 200, 40);
        b2.setBounds(130, 200, 200, 40);



        add(l);
        add(b1);
        add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);

        setSize(400,300);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {

            setVisible(false);
            new donorsignup().setVisible(true);


        }
        if (e.getSource() ==b2) {
            setVisible(false);
            new donorlogin().setVisible(true);


        }


    }



}
