module com.projekt.frontend {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    opens com.projekt.frontend to javafx.fxml;
    exports com.projekt.frontend;
}