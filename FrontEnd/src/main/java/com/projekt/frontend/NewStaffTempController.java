package com.projekt.frontend;

import backend.Boss;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewStaffTempController {
    private Stage primaryStage;
    public void setPrimaryStage2(Stage stage) {
        this.primaryStage = stage;
    }

    //tworzenie nowego członka personelu
    @FXML
    private TextField newLoginField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField repeatNewPasswordField;
    @FXML
    private Label addStaffLabel;
    @FXML
    private Button addStaffButton;

    private String newLogin;
    private String newPassword;
    private String repeatNewPassword;
    //true - Boss, false - backend.HR
    private boolean bossOrHR=true;
    private List<Boss> bosses = new ArrayList<>();

    ValidateController mainController = new ValidateController();

    public void setMainController(ValidateController mainController) {
        this.mainController = mainController;
    }
    public void initialize() {
        newLoginField.textProperty().addListener((observable, oldValue, newValue) -> {newLogin=newValue;});
        newPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {newPassword=newValue;});
        repeatNewPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {repeatNewPassword=newValue;});
        if(bossOrHR){
            addStaffLabel.setText("Dodaj nowego Boss");
            addStaffButton.setText("Utwórz Boss");
        } else {
            addStaffLabel.setText("Dodaj nowego HR");
            addStaffButton.setText("Utwórz HR");
        }
    }
    //tworzenie nowego członka personelu
    @FXML
    public void onNewLogIn(ActionEvent actionEvent) {
        newLogin=newLoginField.getText();
    }
    @FXML
    public void onNewPassword(ActionEvent actionEvent) {
        newPassword=newPasswordField.getText();
    }
    @FXML
    public void onRepeatNewPassword(ActionEvent actionEvent) {
        repeatNewPassword=repeatNewPasswordField.getText();
    }
    public void whoIsStaff(boolean who) {
        bossOrHR=who;
    }
    @FXML
    public void onAddStaff(ActionEvent actionEvent) throws IOException {

        if(newLoginField.getText() == null || newPasswordField.getText() == null || repeatNewPasswordField.getText() == null || newLogin == null || newPassword == null || repeatNewPassword == null) {
            try{
                throw new CreatingStaffException("Nie wprowadzono loginu lub haseł!");
            } catch (CreatingStaffException e) {}
        } else if (!(newPassword.equals(repeatNewPassword))) {
            try{
                throw new CreatingStaffException("Podane hasła nie zgadzają się!");
            } catch (CreatingStaffException e) {}
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("validate-view.fxml"));
            Parent newRoot = fxmlLoader.load();
            Scene newScene = new Scene(newRoot);
            ValidateController controller = fxmlLoader.getController();
            primaryStage.setScene(newScene);
            controller.setPrimaryStage(primaryStage);
            if(bossOrHR){
                controller.acquirePassesBoss(newLogin,newPassword);
            } else {
                controller.acquirePassesHR(newLogin,newPassword);
            }

        }
    }
    @FXML
    public void onComeback(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("validate-view.fxml"));
        Parent newRoot = fxmlLoader.load();
        Scene newScene = new Scene(newRoot);
        ValidateController controller = fxmlLoader.getController();
        primaryStage.setScene(newScene);
        controller.setPrimaryStage(primaryStage);
    }
}
