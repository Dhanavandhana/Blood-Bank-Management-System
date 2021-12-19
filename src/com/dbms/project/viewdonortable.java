package com.dbms.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewdonortable extends JFrame{


    DefaultTableModel defaultTableModel;
    JTable table;
    Statement statement;

    public viewdonortable() {
        super("Donor Database");
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        defaultTableModel = new DefaultTableModel();
        table = new JTable(defaultTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
        defaultTableModel.addColumn("Donor Name");
        defaultTableModel.addColumn("Username");
        defaultTableModel.addColumn("Blood Group");
        defaultTableModel.addColumn("Age");
        defaultTableModel.addColumn("Phone");
        defaultTableModel.addColumn("Address");

        try {

            statement = Myconnection.getConnection().createStatement();
            String query = "select * from donor";
            ResultSet resultSet = statement.executeQuery(query);


            while (resultSet.next()) {
                String dname = resultSet.getString("donor_name");
                String uname = resultSet.getString("username");
                String blood = resultSet.getString("blood");
                String age = resultSet.getString("age");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");

                defaultTableModel.addRow(new Object[]{dname,uname,blood,age,phone,address});
                setVisible(true);
                validate();


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}