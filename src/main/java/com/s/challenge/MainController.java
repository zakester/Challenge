package com.s.challenge;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainController implements Initializable {
    private Timeline timeline;
    @FXML public Label total_group_1, total_group_2;

    @FXML public TextField arabic_group_1, islam_group_1, math_group_1, physics_group_1, scince_group_1, fr_group_1, generalColture_group_1, history_group_1, civil_group_1, info_group_1, english_group_1;
    @FXML public TextField arabic_group_2, islam_group_2, math_group_2, physics_group_2, scince_group_2, fr_group_2, generalColture_group_2, history_group_2, civil_group_2, info_group_2, english_group_2;
    public Label timer;
    public int getAgeInSeconds(long createdMillis) {
        long nowMillis = System.currentTimeMillis();
        return (int)((nowMillis - createdMillis) / 1000);
    }

    @FXML public void startTimer() {
        start();

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

    @FXML
    private void exit() {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @FXML public void showWinner() {

    }
    private Chronometer chrono;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chrono   = new Chronometer();
        timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> chrono.update()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timer.textProperty().bind(Bindings.format("%02d:%02d:%02d:%d%d", chrono.hh, chrono.mm, chrono.ss, chrono.th, chrono.hd));
    }
}