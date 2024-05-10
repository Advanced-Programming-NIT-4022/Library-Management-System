module com.example.lib {
    requires javafx.controls;
    requires javafx.fxml;
    requires mysql.connector.j;
    requires java.sql;
    opens com.example.lib to mysql.connector.j, javafx.fxml;
    opens controler to javafx.fxml;

    exports controler;
    exports com.example.lib;

}