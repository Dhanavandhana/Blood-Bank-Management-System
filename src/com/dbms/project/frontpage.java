package com.dbms.project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frontpage extends JFrame implements ActionListener{
    JLabel l1;
    JButton b0,b1,b2;
    public frontpage()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("BLOOD BANK MANAGEMENT SYSTEM");
        b0 = new JButton("ADMIN");
        b1 = new JButton("DONOR");
        b2 = new JButton("RECIPIENT");

        l1.setBounds(65,50,500,100);
        b0.setBounds(130,200,100, 40);
        b1.setBounds(130,300,100,40);
        b2.setBounds(130,400,100,40);


        add(b0);
        add(b1);
        add(b2);
        add(l1);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b0) {

            setVisible(false);
            new admin().setVisible(true);
        }
        if (e.getSource() ==b1) {
            setVisible(false);
            new donor().setVisible(true);
        }
        if (e.getSource() ==b2) {
            setVisible(false);
            new recipient().setVisible(true);
        }


    }
    public static void main(String args[])
    {
        new frontpage();
    }
}
