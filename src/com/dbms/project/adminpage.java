package com.dbms.project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminpage extends JFrame implements ActionListener {
    JButton b,b1,b2;
    public adminpage()
    {
            super("Admin Page");
            b=new JButton("View Donorinfo");
            b.setBounds(50,80,180,30);
            add(b);
            b.addActionListener(this);
            b1=new JButton("Add Donorinfo");
            b1.setBounds(50,130,180,30);
            add(b1);
            b1.addActionListener(this);
            b2=new JButton("Delete Donorinfo");
            b2.setBounds(50,180,180,30);
            add(b2);
            b2.addActionListener(this);
            setSize(400,400);
            setLayout(null);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {

            setVisible(false);
            new viewdonortable().setVisible(true);


        }
        if (e.getSource() ==b1) {
            setVisible(false);
            new adddinfo().setVisible(true);


        }
        if (e.getSource() ==b2) {
            setVisible(false);
            new deleteinfo().setVisible(true);


        }


    }
}
