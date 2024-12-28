module com.projekt.frontend {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projekt.frontend to javafx.fxml;
    exports com.projekt.frontend;
}