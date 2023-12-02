package com.example.addressboock.dao;

import com.example.addressboock.models.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
    private DataBase dataBase;

    public UserDao() throws SQLException, ClassNotFoundException {
        this.dataBase = new DataBase();
    }

    public boolean saveUser(Users users) {

        String insert = "INSERT INTO   users(Name, LastName, Telephone, Mail, Address) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement prSt;
            prSt = this.dataBase.getDbConnection().prepareStatement(insert);
            prSt.setString(1, users.getName());
            prSt.setString(2, users.getLastname());
            prSt.setString(3, users.getTelephone());
            prSt.setString(4, users.getMail());
            prSt.setString(5, users.getAddress());
            prSt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
