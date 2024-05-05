module com.example.cryptoanalizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cryptoanalizer to javafx.fxml;
    exports com.example.cryptoanalizer;
}