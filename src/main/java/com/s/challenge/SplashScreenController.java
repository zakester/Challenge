package com.s.challenge;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashScreenController {
    @FXML
    ImageView img;
    public void goToMain () {
        Stage stage =(Stage) img.getScene().getWindow();
        FXMLLoader viewLoader = new FXMLLoader(getClass().getResource("view.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(viewLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Challenge");
        stage.setScene(scene);
        MainController mainController = viewLoader.getController();
        stage.setFullScreen(true);
        stage.show();

    }
}
