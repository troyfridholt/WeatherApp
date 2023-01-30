package com.example.javafxprojekt;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUI {
    private Stage primaryStage;
    private Scene scene;
    private VBox root;
    private Label label;
    private TextField textField;
    private Button button;

    public GUI(Stage primaryStage) {
        this.primaryStage = primaryStage;
        initUI();
    }

    private void initUI() {
        root = new VBox();
        scene = new Scene(root, 300, 250);
        label = new Label("Enter city name:");
        textField = new TextField();
        button = new Button("Get Weather");
        button.setOnAction(e -> {
            String city = textField.getText();
            WeatherAPI api = new WeatherAPI();
            WeatherData weatherData = api.getWeather(city);
            label.setText(String.valueOf(weatherData.getTemperature()));

        });
        root.getChildren().addAll(label, textField, button);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
