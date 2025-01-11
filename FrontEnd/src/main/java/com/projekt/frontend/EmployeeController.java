package com.projekt.frontend;

import backend.Employee;
import backend.HR;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.*;
import javafx.fxml.*;
import java.io.IOException;
import java.io.File;
public class EmployeeController {
    private Stage primaryStage;
    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    @FXML
    private TableView<Employee> employeeTable;
    @FXML
    private TableColumn<Employee, Integer> tableID;
    @FXML
    private TableColumn<Employee, String> tableName;
    @FXML
    private TableColumn<Employee, String> tableSurname;
    @FXML
    private TableColumn<Employee, String> tablePESEL;
    @FXML
    private TableColumn<Employee, String> tableNationality;
    @FXML
    private TableColumn<Employee, String> tableAddress;
    @FXML
    private TableColumn<Employee, String> tableEmail;
    @FXML
    private TableColumn<Employee, String> tablePhone;
    @FXML
    private TableColumn<Employee, String> tableBirth;
    @FXML
    private TableColumn<Employee, Float> tableSalary;
    @FXML
    private TableColumn<Employee, Integer> tableDaysoff;
    @FXML
    private TableColumn<Employee, Void> tableEDIT;
    @FXML
    private TableColumn<Employee, Void> tableFIRE;

    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    Employee emp = new Employee(12, "dekiel", "wątły", "1293939393", "Masrjanin", "nie ma", "marsandstars@gmail.gay", "samsung galaksi 2", "wczoraj", (float)99222, 365);
    public void initialize(){
        //załadowanie danych tabeli
        tableID.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getIdNum()));
        tableName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getName()));
        tableSurname.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getSurname()));
        tablePESEL.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPesel()));
        tableNationality.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNationality()));
        tableAddress.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAddress()));
        tableEmail.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEmail()));
        tablePhone.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPhone()));
        tableBirth.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getBirth_date()));
        tableSalary.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getSalary()));
        tableDaysoff.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDaysOff()));


        tableEDIT.setCellFactory(column -> new TableCell<>() {
            private final Button editButton = new Button("Edytuj");
            {
                editButton.setOnAction(event -> {
                    Employee employee = getTableView().getItems().get(getIndex());
                    HR.employeeUpdate(employee, "WYPlATA"); // Call your edit logic
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(editButton);
                }
            }
        });
        tableFIRE.setCellFactory(column -> new TableCell<>() {
            private final Button removeButton = new Button("Zwolnij");
            {
                removeButton.setOnAction(event -> {
                    Employee employee = getTableView().getItems().get(getIndex());
                    employeeList.remove(employee); // Remove employee from the list
                });
            }
            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(removeButton);
                }
            }
        });
        employeeList.add(emp);
        employeeTable.setItems(employeeList);
    }

}