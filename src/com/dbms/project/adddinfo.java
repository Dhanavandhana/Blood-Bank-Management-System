package com.dbms.project;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adddinfo extends JFrame implements ActionListener {
    JLabel l, l1, l2, l3, l4, l5,l6,l7;
    JTextField f1, f2, f3, f4, f5,f6,f7;
    JButton btn;
    public adddinfo() {
        super("Add Donor Information");

        l1 = new JLabel("Enter Donor Name:");
        l1.setBounds(20, 120, 200, 20);
        f1 = new JTextField(50);
        f1.setBounds(130, 120, 200, 20);
        l2 = new JLabel("Enter User Name:");
        l2.setBounds(20, 150, 200, 20);
        f2 = new JTextField(100);
        f2.setBounds(130, 150, 200, 20);
        l3 = new JLabel("Blood group:");
        l3.setBounds(20, 210, 200, 20);
        f3 = new JTextField(50);
        f3.setBounds(130, 210, 50, 20);
        l4 = new JLabel("Age:");
        l4.setBounds(20, 240, 200, 20);
        f4 = new JTextField(50);
        f4.setBounds(130, 240, 200, 20);
        l5 = new JLabel("Phone");
        l5.setBounds(20, 270, 200, 20);
        f5 = new JTextField(20);
        f5.setBounds(130, 270, 200, 20);
        l6 = new JLabel("Address");
        l6.setBounds(20, 300, 200, 20);
        f6 = new JTextField(20);
        f6.setBounds(130, 300, 200, 20);
        l7 = new JLabel("Password");
        l7.setBounds(20, 180, 200, 20);
        f7 = new JTextField(20);
        f7.setBounds(130, 180, 200, 20);
        btn = new JButton("Submit");
        btn.setBounds(20, 330, 100, 20);
        btn.addActionListener(this);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btn);
        add(l1);
        add(f1);
        add(l2);
        add(f2);
        add(l3);
        add(f3);
        add(l4);
        add(f4);
        add(l5);
        add(f5);
        add(l6);
        add(f6);
        add(l7);
        add(f7);

    }
    public void actionPerformed(ActionEvent e) {
        String name=f1.getText();
        String uname=f2.getText();
        String password=f7.getText();
        String blood=f3.getText();
        String age=f4.getText();
        String phone=f5.getText();
        String address=f6.getText();
        update obj=new update();
        obj.add(name,uname,blood,age,phone,address,password);
        if (e.getSource() == btn) {
                JOptionPane.showMessageDialog(this, "Donor info added");
                setVisible(false);
                new viewdonortable();

        }
    }
    public class update {

        void add(String str1, String str2, String str3, String str4, String str5,String str6,String str7) {
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "dhanavandhana", "password");
                String query="insert into donor values(?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, str1);
                ps.setString(2,str2);
                ps.setString(3,str7);
                ps.setString(4,str3);
                ps.setString(5,str4);
                ps.setString (6,str5);
                ps.setString (7,str6);


                ps.executeUpdate();
                ps.close();
                con.close();

            }
            catch(SQLIntegrityConstraintViolationException e2){
                System.out.println(e2);
                JOptionPane.showMessageDialog(null,"Username not unique");
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}