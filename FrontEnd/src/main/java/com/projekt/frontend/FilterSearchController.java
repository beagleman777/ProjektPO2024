package com.projekt.frontend;

import backend.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.util.ArrayList;

public class FilterSearchController {
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

    private String name=null;
    private String surname=null;
    private String pesel=null;
    private String nationality=null;
    private String address=null;
    private String email=null;
    private String phone=null;
    private String birth=null;
    private String salary=null;
    private String daysOff=null;
    private String position=null;

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
    public void onPositionField(ActionEvent event) {

    }
    @FXML
    public void onPrintOutEmployees(ActionEvent event) {
        Filter f = new Filter();
        f.setName(name);
        f.setSurname(surname);
        f.setPesel(pesel);
        f.setNationality(nationality);
        f.setAddress(address);
        f.setEmail(email);
        f.setPhone(phone);
        f.setBirth_date(birth);
        if(salary!=null){
            f.setSalary(Float.parseFloat(salary));
        }
        if(daysOff!=null){
            f.setDaysOff(Integer.parseInt(daysOff));
        }
        f.setPosition(position);
        if(salary==null){
            f.setSalary(-1f);
        } else {
            f.setSalary(Float.parseFloat(salary));
        }
        if(daysOff==null){
            f.setDaysOff(-1);
        } else {
            f.setDaysOff(Integer.parseInt(daysOff));
        }
        f.setPosition(position);
        ArrayList<Employee> searches = new ArrayList<Employee>();
        //mainController.getBoss().getEmployees();
        ArrayList<Employee> temp = new ArrayList<Employee>();
        ArrayList<Filter> filters = new ArrayList<>();
        Filter tempFilter = new Filter();
        Pair<ArrayList<Employee>, Filter> result = new Pair<>(temp, tempFilter);
        result=mainController.getBoss().listSome("IMIE", f.getName());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("NAZWISKO", f.getSurname());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("PESEL", f.getPesel());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("NARODOWOŚĆ", f.getNationality());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("ADRES ZAMIESZKANIA", f.getAddress());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("EMAIL", f.getEmail());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("TELEFON", f.getPhone());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("DATA URODZENIA", f.getBirth_date());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("WYPLATA", String.valueOf(f.getSalary()));
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("DNI WOLNE", String.valueOf(f.getDaysOff()));
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        result=mainController.getBoss().listSome("STANOWISKO", f.getPosition());
        if(result.getKey().size()>0){
            filters.add(result.getValue());
            temp.addAll(result.getKey());
        }
        if(temp.size()==0){
            mainController.doneFiltering(searches, filters);
            return;
        } else {
            searches.add(temp.get(0));
            for(int i=1; i<temp.size(); i++) {
                int counter=0;
                for(int j=0; j<searches.size(); j++) {
                    if(searches.get(j).getIdNum()!=temp.get(i).getIdNum()) {
                        counter++;
                    }
                }
                if(counter==searches.size()) {
                    searches.add(temp.get(i));
                }
            }
        }
        for(Filter filt : filters){
            System.out.println(filt.getSearch_id());
            System.out.println(filt.getSearch_name());
            System.out.println(filt.getSearch_date());
        }
        mainController.doneFiltering(searches, filters);
    }
}