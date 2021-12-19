package com.dbms.project;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class Donorpage extends JFrame {
    private JFrame f;
    private JLabel l;
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;

    public Donorpage() {
        f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l = new JLabel("DONOR PAGE");
        b0 = new JButton("DONATE BLOOD");
        b1 = new JButton("EDIT PROFILE");
        b2 = new JButton("VIEW PROFILE");
        b3 = new JButton("LOG OUT");




        l.setBounds(200, 10, 100, 100);
        b0.setBounds(130, 100, 200, 40);
        b1.setBounds(130, 200, 200, 40);
        b2.setBounds(130, 300, 200, 40);
        b3.setBounds(130, 400, 200, 40);


        f.add(b0);
        f.add(b1);
        f.add(b2);
        f.add(b3);

        f.add(l);
        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);

        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                donateblood db = new donateblood();
            }
        });

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                editprofile ep = new editprofile();

            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                frontpage ep = new frontpage();

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new donorinfo();

            }
        });

    }

}
