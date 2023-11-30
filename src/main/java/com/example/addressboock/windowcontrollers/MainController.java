package com.example.addressboock.windowcontrollers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class MainController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button Add;

    @FXML
    private Button Search;

    @FXML
    private Button Delete;

    @FXML
    private Button Table;


    @FXML
    void initialize() {
        Add.setOnAction(actionEvent -> {
            System.out.println("Добавить Участника");
            openNewScene("Add.fxml");

        });

        Search.setOnAction(actionEvent -> {
            System.out.println("Добавить Участника");
            openNewScene("Search.fxml");

        });

        Delete.setOnAction(actionEvent -> {
            System.out.println("Добавить Участника");
            openNewScene("Delete.fxml");

        });

        Table.setOnAction(actionEvent -> {
            System.out.println("Добавить Участника");
            openNewScene("Table.fxml");

        });
    }

    public  void  openNewScene(String window)
    {

        Add.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}

