package com.projekt.frontend;

import backend.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.ArrayList;

public class ListingController {
    private ArrayList<String> strings = new ArrayList<>();
    @FXML
    private ListView<String> listView;
    public void initialize() {
        ObservableList<String> tempList = FXCollections.observableArrayList(strings);
        tempList.setAll(strings);
        listView.setItems(tempList);
    }
    public void getStrings(ArrayList<String> strings) {
        this.strings = strings;
        System.out.println(this.strings);
    }
}
