module com.example.cryptoanalizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cryptoanalizer.cryptoanalizer to javafx.fxml;
    exports com.example.cryptoanalizer.cryptoanalizer;
    exports com.example.cryptoanalizer.cryptoanalizer.controller;
    opens com.example.cryptoanalizer.cryptoanalizer.controller to javafx.fxml;
}