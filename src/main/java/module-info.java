module com.example.cafesystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;


    opens com.example.cafesystem to javafx.fxml;
    exports com.example.cafesystem;
}