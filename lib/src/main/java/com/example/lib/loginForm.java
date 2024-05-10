package com.example.lib;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class loginForm extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlloader = new FXMLLoader(loginForm.class.getResource("loginForm.fxml"));
        Scene scene = new Scene(fxmlloader.load(), 1080, 820);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
