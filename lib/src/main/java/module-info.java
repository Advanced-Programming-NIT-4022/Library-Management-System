module com.example.lib {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lib to javafx.fxml;
    opens controler to javafx.fxml;
    exports controler;
    exports com.example.lib;
}