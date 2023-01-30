package com.example.javafxprojekt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class WeatherAPI {

    private static final String API_KEY = "67acd4e8f0cfb70fa1d19299bb3f796c";

    public WeatherData getWeather(String city) {
        WeatherData weatherData = new WeatherData();
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
            reader.close();
            JSONObject weatherJSON = new JSONObject(stringBuilder.toString());
            JSONObject mainJSON = weatherJSON.getJSONObject("main");
            weatherData.setTemperature(mainJSON.getDouble("temp"));
            weatherData.setHumidity(mainJSON.getDouble("humidity"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherData;
    }
}
