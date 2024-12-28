package com.projekt.frontend;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.fxml.*;
public class EmployeeController {
    private Stage primaryStage;
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}