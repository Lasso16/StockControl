package com.tokioschool.controlstock.controlstock;

import com.tokioschool.controlstock.controlstock.model.DataBase;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private AppController controller;
    @Override
    public void start(Stage stage)  {
        AppView view = new AppView(stage);
        DataBase model = new DataBase();
        AppController controller = new AppController(view, model);
    }

    public static void main(String[] args) {
        launch();
    }
}