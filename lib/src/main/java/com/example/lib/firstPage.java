package com.example.lib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class firstPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(firstPage.class.getResource("v.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
