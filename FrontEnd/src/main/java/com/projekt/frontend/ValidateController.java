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
    //true - Boss, false - HR
    private boolean bossOrHR=true;
    private List<Boss> bosses = new ArrayList<>();
    private List<HR> hrs = new ArrayList<>();
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
            getStaffFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for(Boss i : bosses){
            System.out.println(i.getLogin() + " " + i.getPassword());
        }
        for(HR i : hrs){
            System.out.println(i.getLogin() + " " + i.getPassword());
        }
    }
    public boolean currentStaff() {
        return bossOrHR;
    }
    public void getStaffFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/bosses.txt"))) {
            String line;
            int i = 0;

            while ((line = reader.readLine()) != null) {
                if(i%2==0){
                    bosses.add(new Boss());
                    bosses.get(i/2).setLogin(line);
                }
                if(i%2==1) {
                    bosses.get(i/2).setPassword(line);
                }
                i++;
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/hrs.txt"))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                if(i%2==0){
                    hrs.add(new HR());
                    hrs.get(i/2).setLogin(line);
                }
                if(i%2==1){
                    hrs.get(i/2).setPassword(line);
                }
                i++;
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
        secondController.setMainController(this);
        secondController.whoIsStaff(bossOrHR);
        primaryStage.setTitle("Dodaj Boss");
        primaryStage.setScene(newScene);
        primaryStage.show();
        secondController.setTheBossStage();
    }
    @FXML
    public void onAddHR(ActionEvent actionEvent) throws IOException {
        this.bossOrHR=false;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("new-view.fxml"));
        Parent second = loader.load();
        Scene newScene = new Scene(second);
        NewStaffTempController secondController = loader.getController();
        secondController.setPrimaryStage2(primaryStage);
        secondController.setMainController(this);
        secondController.whoIsStaff(bossOrHR);
        primaryStage.setTitle("Dodaj HR");
        primaryStage.setScene(newScene);
        primaryStage.show();
        secondController.setTheHRStage();
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
    public void acquirePassesBoss(String log, String pass) {
        this.newLogin=log;
        this.newPassword=pass;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/bosses.txt" ,true))){
            writer.write(this.newLogin);
            writer.newLine();
            writer.write(this.newPassword);
            writer.newLine();
        } catch (IOException e){
            System.err.println("Nie ma pliku");
        }
    }
    public void acquirePassesHR(String log, String pass) {
        this.newLogin=log;
        this.newPassword=pass;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/hrs.txt" ,true))){
            writer.write(this.newLogin);
            writer.newLine();
            writer.write(this.newPassword);
            writer.newLine();
        } catch (IOException e){
            System.err.println("Nie ma pliku");
        }
    }
}
