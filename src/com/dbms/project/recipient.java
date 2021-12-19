package com.dbms.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class recipient extends JFrame implements ActionListener
{
    JButton b1;
    JLabel l;

    public recipient()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l = new JLabel("RECIPIENT PAGE");
        b1 = new JButton("MAKE REQUEST");


        l.setBounds(100,50,200,60);
        add(l);
        b1.setBounds(50,150,200, 60);
        add(b1);
        b1.addActionListener(this);



        add(l);

        setSize(400,300);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==b1) {
            setVisible(false);
            new request();


        }
    }
}

