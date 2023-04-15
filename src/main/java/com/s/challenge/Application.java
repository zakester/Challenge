package com.s.challenge;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        loadFonts();
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setMinWidth(1280.0);
        stage.setMinHeight(720.0);
        stage.setMaxWidth(1280.0);
        stage.setMaxHeight(720.0);
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Challenge");
        stage.setScene(scene);
        stage.show();
    }

    private void loadFonts() {
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-Light.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-Regular.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-Medium.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-Bold.ttf"), 10);
        Font.loadFont(getClass().getResourceAsStream("font/Tajawal-ExtraBold.ttf"), 10);
    }

    public static void main(String[] args) {
        launch();
    }
}