package com.example.addressboock.windowcontrollers;

import com.example.addressboock.dao.UserDao;
import com.example.addressboock.models.Users;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class AddController {

    @FXML
    private Button AddUsers;
    @FXML
    private TextField Address;

    @FXML
    private TextField LastName;

    @FXML
    private TextField Mail;

    @FXML
    private TextField Name;

    @FXML
    private TextField Phone;

    @FXML
    void initialize() {
        AddUsers.setOnAction(event ->
        {
            System.out.println("Добавить");
            Users user = new Users(
                    Name.getText(),
                    LastName.getText(),
                    Phone.getText(),
                    Mail.getText(),
                    Address.getText()
            );
            System.out.println(user);
            try {
                UserDao userDao = new UserDao();
                userDao.saveUser(user);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        });
    }

}





