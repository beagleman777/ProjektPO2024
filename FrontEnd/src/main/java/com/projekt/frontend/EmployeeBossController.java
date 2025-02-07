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
import java.io.InputStream;
import java.util.ArrayList;

public class EmployeeBossController {
    String filePath = "src/main/resources/employees.json";
    String filtersPath = "src/main/resources/filters.json";
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

    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Filter> filters = new ArrayList<>();
    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private ArrayList<String> filtersReadable = new ArrayList<>();
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

        employeeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        InputStream inputStreamEmployee = Employee.class.getClassLoader().getResourceAsStream("employees.json");
        if (inputStreamEmployee == null) {
            throw new FileNotFoundException("File not found: employees.json");
        }

        if (inputStreamEmployee.available() != 0) {
            try {
                employees = (ArrayList<Employee>) DataHandler.loadEmployeesFromFile(filePath);
                employeeList.addAll(employees);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println("Employees loaded from file");
        //employeeList.add(emp);
        employeeTable.setItems(employeeList);
        boss.setEmployees(employees);
        employees = null;

        InputStream inputStreamFilter = Filter.class.getClassLoader().getResourceAsStream("filters.json");
        if (inputStreamFilter == null) {
            throw new FileNotFoundException("File not found: filters.json");
        }

        if (inputStreamFilter.available() != 0) {
            try {
                filters = (ArrayList<Filter>) DataHandler.loadFiltersFromFile(filtersPath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        for(Filter f : filters){
            filtersReadable.add(f.printFilter());
            //System.out.println(f.printFilter());
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
    public void doneFiltering(ArrayList<Employee> searches, ArrayList<Filter> filters){
        tempStage2.close();
        //ObservableList<Employee> search=FXCollections.observableArrayList();
        employeeList.setAll(searches);
        employeeTable.setItems(employeeList);
        this.filters.addAll(filters);
        for(Filter f : filters){
            filtersReadable.add(f.printFilter());
        }
        try{
            DataHandler.saveFiltersToFile(this.filters, filtersPath);
            System.out.println("Filters saved to file.");
        } catch(IOException en){
            en.printStackTrace();
        }
    }
    @FXML
    public void onPrintAllEmployees(ActionEvent actionEvent){
        //employeeList.clear();
        //ObservableList<Employee> all=FXCollections.observableArrayList();
        employeeList.setAll(boss.getEmployees());
        employeeTable.setItems(employeeList);
    }
    Stage tempStage4 = new Stage();
    @FXML
    public void onPrintFilters(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("search-string-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        ListingController controller = fxmlLoader.getController();
        controller.getStrings(filtersReadable);
        controller.initialize();
        tempStage4.setTitle("Search filters history!");
        tempStage4.setScene(scene);
        tempStage4.show();
    }
    @FXML
    public void onExitButton(ActionEvent actionEvent){
        mainController.closeApp();
    }
}