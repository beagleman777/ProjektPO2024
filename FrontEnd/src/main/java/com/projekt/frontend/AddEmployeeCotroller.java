package com.projekt.frontend;

import backend.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class AddEmployeeCotroller {
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField peselField;
    @FXML
    private TextField nationalityField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField birthField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField daysoffField;
    @FXML
    private TextField positionField;

    private String name;
    private String surname;
    private String pesel;
    private String nationality;
    private String address;
    private String email;
    private String phone;
    private String birth;
    private String salary;
    private String daysOff;
    private String position;

    private EmployeeController mainController;
    private Stage primaryStage;
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    public void setMainController(EmployeeController mainController) {this.mainController=mainController;}
    public void initialize() {
        nameField.textProperty().addListener((observable, oldValue, newValue) -> {name=newValue;});
        surnameField.textProperty().addListener((observable, oldValue, newValue) -> {surname=newValue;});
        peselField.textProperty().addListener((observable, oldValue, newValue) -> {pesel=newValue;});
        nationalityField.textProperty().addListener((observable, oldValue, newValue) -> {nationality=newValue;});
        addressField.textProperty().addListener((observable, oldValue, newValue) -> {address=newValue;});
        emailField.textProperty().addListener((observable, oldValue, newValue) -> {email=newValue;});
        phoneField.textProperty().addListener((observable, oldValue, newValue) -> {phone=newValue;});
        birthField.textProperty().addListener((observable, oldValue, newValue) -> {birth=newValue;});
        salaryField.textProperty().addListener((observable, oldValue, newValue) -> {salary=newValue;});
        daysoffField.textProperty().addListener((observable, oldValue, newValue) -> {daysOff=newValue;});
        positionField.textProperty().addListener((observable, oldValue, newValue) -> {position=newValue;});
    }

    @FXML
    public void onNameField(ActionEvent event) {

    }
    @FXML
    public void onSurnameField(ActionEvent event) {

    }
    @FXML
    public void onPeselField(ActionEvent event) {

    }
    @FXML
    public void onNationalityField(ActionEvent event) {

    }
    @FXML
    public void onAddressField(ActionEvent event) {

    }
    @FXML
    public void onEmailField(ActionEvent event) {

    }
    @FXML
    public void onPhoneField(ActionEvent event) {

    }
    @FXML
    public void onBirthField(ActionEvent event) {

    }
    @FXML
    public void onSalaryField(ActionEvent event) {

    }
    @FXML
    public void onDaysoffField(ActionEvent event) {

    }
    @FXML
    public void onPositionField(ActionEvent actionEvent){

    }
    private boolean validBirthDate(String day){
        boolean result=true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(day, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }
    @FXML
    public void onAddTheEmployee(ActionEvent event) {
        Float SALARY=null;
        Integer DAYSOFF=null;
        try {
            try {
                SALARY = Float.parseFloat(salary);
                SALARY = Math.round(SALARY * 100) / 100.0f;
                DAYSOFF = Integer.parseInt(daysOff);
                if(Long.parseLong(pesel)<0){
                    throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
                }
                if(Long.parseLong(phone)<0){
                    throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
                }
                if(pesel.length()!=11){
                    throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
                }
                if(SALARY<0){
                    throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
                }
                if(DAYSOFF<0){
                    throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
                }
            } catch (NumberFormatException e) {
                throw new ValidatingErrorException("Wprowadzono błędne dane do pól liczbowch!");
            }
        } catch (ValidatingErrorException | IOException ex){return;}
        try{
            if(!validBirthDate(birth)){
                throw new ValidatingErrorException("Datę należy podać w formacie DD.MM.YYY");
            }
        } catch (ValidatingErrorException exc){return;} catch (IOException e) {return;}
        mainController.getNewEmployee(name, surname, pesel, nationality, address, email, phone, birth, SALARY, DAYSOFF, position);
    }
}
