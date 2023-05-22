package com.s.challenge;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {
    @FXML
    ImageView img;
    private Timeline timeline;
    public Label timer;
    String musicFile1 = "sound/clock.mp3";     // For example
    String musicFile2 = "sound/time up.mp3";
    Media timerSound = new Media(getClass().getResource("sound/clock.mp3").toExternalForm());
    Media timeUPSound = new Media(getClass().getResource("sound/buzzer.wav").toExternalForm());
    MediaPlayer mediaPlayer = new MediaPlayer(timerSound);

    @FXML public void startTimer() {
        reset();
        start();
        mediaPlayer.play();
        this.actionEvent= actionEvent;
        /*while (true){
            if (getAgeInSeconds(createdMillis)==1) {
            String second = timer.getText().split(":")[1];
            String minute = timer.getText().split(":")[0];
            int sec = Integer.parseInt(second);
            int min = Integer.parseInt(minute);
            if (sec == 0 && min == 0) {
                break;
            }
            chrono();
            createdMillis = System.currentTimeMillis();
            }
        }*/
    }
    ActionEvent actionEvent;
    @FXML
    private void start() {
        timeline.play();
    }

    @FXML
    private void stop() {
        timeline.stop();
    }

    @FXML
    private void reset() {
        chrono.reset();
    }

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
    private Chronometer chrono;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chrono   = new Chronometer();
        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> chrono.update()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timer.textProperty().bind(Bindings.format("%02d:%02d:%d%d", chrono.mm, chrono.ss, chrono.th, chrono.hd));
        timer.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                if (t.equals("15:00:00")){
                    stop();
                    MediaPlayer mediaPlayer1 = new MediaPlayer(timeUPSound);
                    mediaPlayer1.play();
                    mediaPlayer.stop();
                    JFXButton source = (JFXButton) actionEvent.getSource();
                    //source.getStyleClass().removeAll("button","button1");
                    //source.getStyleClass().add("button1");
                    //source.setDisable(true);

                }
            }
        });
    }

}
