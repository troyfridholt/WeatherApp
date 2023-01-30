module com.example.javafxprojekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.google.gson;
    requires org.json;


    opens com.example.javafxprojekt to javafx.fxml;
    exports com.example.javafxprojekt;
}