package com.projekt.frontend;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class ValidateController implements Serializable {
    //Back
    private Stage primaryStage;
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    Boss boss = new Boss();
    //FRONT//

    //Atrybuty
    private String login;
    private String password;
    private String newLogin;
    private String newPassword;
    private String repeatNewPassword;
    //true - Boss, false - backend.HR
    private boolean bossOrHR=true;
    private List<Boss> bosses = new ArrayList<>();

    //logowanie
    @FXML
    private Label loggingAs;
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private ToggleButton logAs;

    //tworzenie nowego członka personelu
    @FXML
    TextField newLoginField;
    @FXML
    PasswordField newPasswordField;
    @FXML
    PasswordField repeatNewPasswordField;
    @FXML
    private Label addStaffLabel;
    @FXML
    private Button addStaffButton;

    //Metody
    public void initialize() {
        try{
            getBossesFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getBossesFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/bosses.txt"))) {
            String line;
            int i = 0;
            Boss tempboss=new Boss();
            while ((line = reader.readLine()) != null) {
                if(i%2==0){
                    tempboss.setLogin(line);
                }
                if(i%2==1){
                    tempboss.setPassword(line);
                }
                bosses.add(tempboss);
            }
        }
    }
    //logowanie
    @FXML
    public void onLoginField(ActionEvent actionEvent) {
        loginField.textProperty().addListener((observable, oldValue, newValue) -> {login=newValue;});
    }
    @FXML
    public void onPasswordField(ActionEvent actionEvent) {
        passwordField.textProperty().addListener((observable, oldValue, newValue) -> {password=newValue;});
    }
    @FXML
    public void onLogIn(ActionEvent actionEvent) {
        //if()
    }
    @FXML
    public void onAddBoss(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-view.fxml"));
        Parent second = loader.load();
        Scene newScene = new Scene(second);
        NewStaffTempController secondController = loader.getController();
        secondController.setPrimaryStage2(primaryStage);
        primaryStage.setTitle("Dodaj Boss");
        primaryStage.setScene(newScene);
        primaryStage.show();
        secondController.setMainController(this);
    }
    @FXML
    public void onAddHR(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("new-view.fxml"));
        Parent newRoot = fxmlLoader.load();
        Scene newScene = new Scene(newRoot);
        ValidateController controller = fxmlLoader.getController();
        primaryStage.setScene(newScene);
        controller.setPrimaryStage(primaryStage);
        controller.addStaffLabel.setText("Dodaj nowego HR");
        controller.addStaffButton.setText("Utwórz HR");
        controller.newLoginField.textProperty().addListener((observable, oldValue, newValue) -> {newLogin=newValue;});
        controller.newPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {newPassword=newValue;});
        controller.repeatNewPasswordField.textProperty().addListener((observable, oldValue, newValue) -> {repeatNewPassword=newValue;});
    }
    @FXML
    public void onLogAs(ActionEvent actionEvent) {
        bossOrHR=!bossOrHR;
        if(bossOrHR) {
            logAs.setText("Zaloguj się jako HR");
            loggingAs.setText("Boss");
        } else {
            logAs.setText("Zaloguj się jako Boss");
            loggingAs.setText("HR");
        }
    }
    public void acquirePasses(String log, String pass) {
        this.newLogin=log;
        this.newPassword=pass;
    }
}
