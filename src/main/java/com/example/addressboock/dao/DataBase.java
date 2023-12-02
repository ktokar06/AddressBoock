package com.example.addressboock.dao;

import com.example.addressboock.models.Users;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

public class DataBase extends Configs {
    Connection dbConnection;

    public DataBase() throws ClassNotFoundException, SQLException{

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        this.dbConnection = getConnection(connectionString,
                dbUser, dbPass);
    }

    public Connection getDbConnection() {
        return this.dbConnection;
    }
}
