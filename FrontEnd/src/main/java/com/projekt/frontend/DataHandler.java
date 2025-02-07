package com.projekt.frontend;

import backend.Edit;
import backend.Employee;
import backend.Filter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
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
