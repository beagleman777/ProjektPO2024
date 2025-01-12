module com.projekt.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    opens com.projekt.frontend to javafx.fxml;
    exports com.projekt.frontend;

    exports backend; // Allow access to backend classes
    opens backend to com.fasterxml.jackson.databind; // Allow reflection by Jackson
}