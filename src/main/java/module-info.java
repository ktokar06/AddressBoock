module com.example.addressboock {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.addressboock to javafx.fxml;
    exports com.example.addressboock;
    exports com.example.addressboock.windowcontrollers;
    opens com.example.addressboock.windowcontrollers to javafx.fxml;
}