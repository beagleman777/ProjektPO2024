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

class DataHandler {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static void saveEmployeesToFile(List<Employee> employees, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), employees);
    }
    public static List<Employee> loadEmployeesFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Employee.class));
    }
    public static void saveFiltersToFile(List<Filter> filters, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), filters);
    }
    public static List<Filter> loadFiltersFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Filter.class));
    }
    public static void saveEditsToFile(ArrayList<Edit> edits, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), edits);
    }
    public static List<Edit> loadEditsFromFile(String filePath) throws IOException {
        return objectMapper.readValue(new File(filePath), objectMapper.getTypeFactory().constructCollectionType(List.class, Edit.class));
    }
}

public class EmployeeController {
    String filePath = "src/main/resources/employees.json";
    String filtersPath = "src/main/resources/filters.json";
    String editsPath = "src/main/resources/edits.json";
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
    private ArrayList<Filter> filters = new ArrayList<>();
    private ArrayList<Edit> edits = new ArrayList<>();
    private ObservableList<Employee> employeeList = FXCollections.observableArrayList();
    private ArrayList<String> filtersReadable = new ArrayList<>();
    private ArrayList<String> editsReadable = new ArrayList<>();
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
                    try {
                        editingEmployee(employee);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
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
                    employeeList.remove(employee);
                    boss.getEmployees().remove(employee);
                    try{
                        DataHandler.saveEmployeesToFile(employeeList, filePath);
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
        InputStream inputStreamEdit = Edit.class.getClassLoader().getResourceAsStream("edits.json");
        if (inputStreamEdit == null) {
            throw new FileNotFoundException("File not found: edits.json");
        }

        if (inputStreamEdit.available() != 0) {
            try {
                edits = (ArrayList<Edit>) DataHandler.loadEditsFromFile(editsPath);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        for(Filter f : filters){
            filtersReadable.add(f.printFilter());
            System.out.println(f.printFilter());
        }
        for(Edit e : edits){
            editsReadable.add(e.printEdit());
            System.out.println(e.printEdit());
        }
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
        Employee e = new Employee(rand.nextInt(1000000),newName, newSurname, newPESEL, newNationality, newAddress, newEmail, newPhone, newBirthDate, newSalary, newDaysoff, newPosition);
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
        boss.getEmployees().add(e);
        employeeTable.setItems(employeeList);
        employeeTable.refresh();

        try{
            DataHandler.saveEmployeesToFile(employeeList, filePath);
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
    Stage tempStage3 = new Stage();
    Employee currentEditedEmployee = null;
    public void editingEmployee(Employee employee) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("edit-employee-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        currentEditedEmployee = employee;
        EditEmployeeController controller = fxmlLoader.getController();
        controller.setMainController(this);
        controller.forwardEmployee(employee);
        controller.initialize();
        tempStage3.setTitle("Edit your Employee!");
        tempStage3.setScene(scene);
        tempStage3.show();
    }
    public void doneEditing(Employee editedEmp, Edit[] newEdit, String[] editWhat){
        tempStage3.close();
        employeeTable.refresh();
        int index = employeeList.indexOf(currentEditedEmployee);
        employeeList.set(index, editedEmp);
        for(int i=0; i<3; i++){
            newEdit[i].setName(currentEditedEmployee.getName());
            newEdit[i].setSurname(currentEditedEmployee.getSurname());
            newEdit[i].setPesel(currentEditedEmployee.getPesel());
            newEdit[i].setNationality(currentEditedEmployee.getNationality());
            newEdit[i].setAddress(currentEditedEmployee.getAddress());
            newEdit[i].setEmail(currentEditedEmployee.getEmail());
            newEdit[i].setPhone(currentEditedEmployee.getPhone());
            newEdit[i].setBirth_date(currentEditedEmployee.getBirth_date());
            newEdit[i].setSalary(currentEditedEmployee.getSalary());
            newEdit[i].setDaysOff(currentEditedEmployee.getDaysOff());
            newEdit[i].setPosition(currentEditedEmployee.getPosition());
        }

        if(editWhat[0]!=null){
            newEdit[0].setSalary(Float.parseFloat(editWhat[0]));
        }
        if(editWhat[1]!=null){
            newEdit[1].setDaysOff(Integer.parseInt(editWhat[1]));
        }
        if(editWhat[2]!=null){
            newEdit[2].setPosition(editWhat[2]);
        }
        currentEditedEmployee=null;
        edits.add(newEdit[0]);
        edits.add(newEdit[1]);
        edits.add(newEdit[2]);
        editsReadable.add(newEdit[0].printEdit());
        editsReadable.add(newEdit[1].printEdit());
        editsReadable.add(newEdit[2].printEdit());
        try{
            DataHandler.saveEditsToFile(edits, editsPath);
            System.out.println("Edits saved to file.");
        } catch(IOException en){
            en.printStackTrace();
        }
        try{
            DataHandler.saveEmployeesToFile(employeeList, filePath);
            System.out.println("Employees saved to file.");
        } catch(IOException en){
            en.printStackTrace();
        }
    }
    Stage tempStage4 = new Stage();
    @FXML
    public void onPrintFilters(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("search-string-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        ListingController controller = fxmlLoader.getController();
        controller.getStrings(filtersReadable);
        controller.setMainController(this);
        controller.initialize();
        tempStage4.setTitle("Search filters history!");
        tempStage4.setScene(scene);
        tempStage4.show();
    }
    Stage tempStage5 = new Stage();
    @FXML
    public void onPrintEdits(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(EmployeeApplication.class.getResource("search-string-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        ListingController controller = fxmlLoader.getController();
        controller.getStrings(editsReadable);
        controller.setMainController(this);
        controller.initialize();
        tempStage5.setTitle("Search filters history!");
        tempStage5.setScene(scene);
        tempStage5.show();
    }
    @FXML
    public void onExitButton(ActionEvent actionEvent){
        mainController.closeApp();
    }
}