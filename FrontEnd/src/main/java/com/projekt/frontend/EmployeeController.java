package com.projekt.frontend;

import backend.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

class EmployeeDataHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void saveEmployeesToFile(List<Employee> employees, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), employees);
    }
    public static List<Employee> loadEmployeesFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
    }
}

public class EmployeeController {
    private ValidateController mainController;
    public void setMainController(ValidateController mainController_) {
        this.mainController = mainController_;
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
    private TableColumn<Employee, String> tablePosition;
    @FXML
    private TableColumn<Employee, Void> tableEDIT;
    @FXML
    private TableColumn<Employee, Void> tableFIRE;

    private ArrayList<Employee> employees = new ArrayList<>();
    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();

    public Boss boss = new Boss();
    Employee emp = new Employee(12, "dekiel", "wątły", "1293939393", "Masrjanin", "nie ma", "marsandstars@gmail.gay", "samsung galaksi 2", "wczoraj", (float)99222, 365, "walkman");

    private String name;
    private String surname;
    private String pesel;
    private String nationality;
    private String address;
    private String email;
    private String phone;
    private String birth;
    private Float salary;
    private Integer daysoff;
    private String position;
    public void initialize() throws IOException {
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
        tablePosition.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPosition()));

        tableEDIT.setCellFactory(column -> new TableCell<>() {
            private final Button editButton = new Button("Edytuj");
            {
                editButton.setOnAction(event -> {
                    Employee employee = getTableView().getItems().get(getIndex());
                    //HR.employeeUpdate(employee, "WYPlATA"); // Call your edit logic
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
                    employees.remove(employee);
                    try{
                        EmployeeDataHandler.saveEmployeesToFile(employeeList, "D:/Pro(JAVA)ects/ProjektPO2024/FrontEnd/src/main/resources/employees.json");
                        System.out.println("Employees saved to file.");
                    } catch(IOException en){
                        en.printStackTrace();
                    }
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

        /*tableID.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        tableName.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        tableSurname.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tablePESEL.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tableNationality.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        tableAddress.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tableEmail.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tablePhone.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tableBirth.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tableSalary.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.1));
        tableDaysoff.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        tableEDIT.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        tableFIRE.prefWidthProperty().bind(employeeTable.widthProperty().multiply(0.05));
        */
        employeeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Load employees from JSON
        InputStream inputStream = Employee.class.getClassLoader().getResourceAsStream("employees.json");
        if (inputStream == null) {
            throw new FileNotFoundException("File not found: employees.json");
        }

        if (inputStream.available() != 0) {
            try {
                employees = (ArrayList<Employee>) EmployeeDataHandler.loadEmployeesFromFile("D:/Pro(JAVA)ects/ProjektPO2024/FrontEnd/src/main/resources/employees.json");
                employeeList.addAll(employees);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println("Employees loaded from file");
        //employeeList.add(emp);
        employeeTable.setItems(employeeList);
        boss.setEmployees(employees);
    }
    Stage tempStage = new Stage();
    public void onAddEmployeeButton(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("new-employee-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        AddEmployeeCotroller controller = fxmlLoader.getController();
        controller.setMainController(this);
        tempStage.setTitle("Add your Employee!");
        tempStage.setScene(scene);
        tempStage.show();
    }
    public void getNewEmployee(String newName, String newSurname, String newPESEL, String newNationality, String newAddress, String newEmail, String newPhone, String newBirthDate, Float newSalary, Integer newDaysoff, String newPosition){
        tempStage.close();
        Random rand = new Random();
        Employee e = new Employee(rand.nextInt(10000),newName, newSurname, newPESEL, newNationality, newAddress, newEmail, newPhone, newBirthDate, newSalary, newDaysoff, newPosition);
        name=null;
        surname=null;
        pesel=null;
        nationality=null;
        address=null;
        email=null;
        phone=null;
        birth=null;
        salary=null;
        daysoff=null;
        position=null;
        employeeList.add(e);
        employeeTable.setItems(employeeList);
        // Save employees to JSON
        try{
            EmployeeDataHandler.saveEmployeesToFile(employeeList, "D:/Pro(JAVA)ects/ProjektPO2024/FrontEnd/src/main/resources/employees.json");
            System.out.println("Employees saved to file.");
        } catch(IOException en){
            en.printStackTrace();
        }
    }
    public Boss getBoss(){
        return boss;
    }
    Stage tempStage2 = new Stage();
    @FXML
    public void onSearchByFilter(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("filter-search-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        FilterSearchController controller = fxmlLoader.getController();
        controller.setMainController(this);
        tempStage2.setTitle("Search your Employee!");
        tempStage2.setScene(scene);
        tempStage2.show();
    }
    public void doneFiltering(ArrayList<Employee> searches){
        tempStage2.close();
        ObservableList<Employee> search=FXCollections.observableArrayList();
        search.addAll(searches);
        employeeTable.setItems(search);
    }
    public void onExitButton(ActionEvent actionEvent){
        mainController.closeApp();
    }
}