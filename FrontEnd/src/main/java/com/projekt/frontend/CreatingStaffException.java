package com.projekt.frontend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class CreatingStaffException extends Exception {
    CreatingStaffException(String message) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("error.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Label errorLabel = (Label) root.lookup("#errorMessageLabel");
        Stage stage = new Stage();
        stage.setTitle("Błąd!");
        stage.setScene(new Scene(root));
        stage.show();
        errorLabel.setText(message);
    }
}