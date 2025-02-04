package com.projekt.frontend;

import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class EditEmployeeController {
    Employee editEmp = new Employee();
    Edit[] newEdit = new Edit[3];
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

    private String salary=null;
    private String daysOff=null;
    private String position=null;

    private EmployeeController mainController;
    public void setMainController(EmployeeController mainController) {this.mainController=mainController;}
    public void initialize() {
        nameField.setText(editEmp.getName());
        surnameField.setText(editEmp.getSurname());
        peselField.setText(editEmp.getPesel());
        nationalityField.setText(editEmp.getNationality());
        addressField.setText(editEmp.getAddress());
        emailField.setText(editEmp.getEmail());
        phoneField.setText(editEmp.getPhone());
        birthField.setText(editEmp.getBirth_date());
        salaryField.textProperty().addListener((observable, oldValue, newValue) -> {salary=newValue;});
        daysoffField.textProperty().addListener((observable, oldValue, newValue) -> {daysOff=newValue;});
        positionField.textProperty().addListener((observable, oldValue, newValue) -> {position=newValue;});
    }
    public void forwardEmployee(Employee employee) {
        this.editEmp=employee;
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
    public void onPositionField(ActionEvent event) {

    }
    @FXML
    public void onEditEmployee(ActionEvent event) {
        String editWhat[] = new String[3];
        editWhat[0]=null;
        editWhat[1]=null;
        editWhat[2]=null;
        if(salary!=null) {
            newEdit[0]=HR.employeeUpdate(editEmp, "WYPLATA", salary);
            editWhat[0]=salary;
            salary=null;
        }
        if(daysOff!=null) {
            newEdit[1]=HR.employeeUpdate(editEmp, "DNI WOLNE", daysOff);
            editWhat[1]=daysOff;
            daysOff=null;
        }
        if(position!=null) {
            newEdit[2]=HR.employeeUpdate(editEmp,"STANOWISKO", position);
            editWhat[2]=position;
            position=null;
        }
        mainController.doneEditing(editEmp, newEdit, editWhat);
    }
}