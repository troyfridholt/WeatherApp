package com.example.javafxprojekt;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GUIController {

    @FXML
    private Label temperatureLabel;
    @FXML
    private Label humidityLabel;
    @FXML
    private TextField cityTextField;
    @FXML
    private ComboBox<String> temperatureUnitComboBox;

    @FXML
    private void initialize() {
        temperatureUnitComboBox.getItems().addAll("Kelvin", "Fahrenheit", "Celsius");
        temperatureUnitComboBox.setValue("Kelvin");
    }

    @FXML
    private void getWeather() {
        String city = cityTextField.getText();
        WeatherAPI weatherAPI = new WeatherAPI();
        WeatherData weatherData = weatherAPI.getWeather(city);
        String selectedUnit = temperatureUnitComboBox.getValue();
        double temperature = weatherData.getTemperature();
        if (selectedUnit.equals("Fahrenheit")) {
            temperature = (temperature - 273.15) * 9 / 5 + 32;
        } else if (selectedUnit.equals("Celsius")) {
            temperature = temperature - 273.15;
        }
        temperatureLabel.setText(String.valueOf(temperature));
        humidityLabel.setText(String.valueOf(weatherData.getHumidity()));
    }
}
