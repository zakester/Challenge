package com.s.challenge;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import java.io.IOException;
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
    String musicFile1 = "sound/clock.mp3";     // For example
    String musicFile2 = "sound/time up.mp3";
    Media timerSound = new Media(getClass().getResource("sound/clock.mp3").toExternalForm());
    Media timeUPSound = new Media(getClass().getResource("sound/buzzer.wav").toExternalForm());
    MediaPlayer mediaPlayer = new MediaPlayer(timerSound);

    public int getAgeInSeconds(long createdMillis) {
        long nowMillis = System.currentTimeMillis();
        return (int)((nowMillis - createdMillis) / 1000);
    }

    @FXML public void startTimer(ActionEvent actionEvent) {
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

    @FXML
    private void exit() {
        stop();
        Platform.exit();
        System.exit(0);
    }
    public Stage stage;
    public void setStage (Stage stage) {
        this.stage=stage;
    }
    public TextField getHistory_group_1() {
        return history_group_1;
    }

    @FXML public void showWinner() {
        stage =(Stage) generalColture_group_1.getScene().getWindow();
        FXMLLoader winnerLoader = new FXMLLoader(getClass().getResource("winner.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(winnerLoader.load(), 1280, 720);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.setFill(Color.TRANSPARENT);
        stage.setTitle("Challenge");
        stage.setScene(scene);
        WinnerController winnerController = winnerLoader.getController();
        double diff = Double.parseDouble(total_group_1.getText()) - Double.parseDouble(total_group_2.getText());
        if (diff<0){
            winnerController.setWinnerLabel("الفوج 2");
        }
        if (diff==0){
            winnerController.setWinnerLabel("تعادل");
        }
        if (diff>0){
            winnerController.setWinnerLabel("الفوج 1");
        }
        stage.setFullScreen(true);
        stage.show();
    }
    @FXML
    public void calculer(){
        total_group_1.setText(""+sumGroup1());
        total_group_2.setText(""+sumGroup2());
    }
    public double sumGroup1(){
        return  Double.parseDouble(arabic_group_1.getText())+Double.parseDouble(civil_group_1.getText())+
                Double.parseDouble(english_group_1.getText())+Double.parseDouble(fr_group_1.getText())+
                Double.parseDouble(info_group_1.getText())+Double.parseDouble(generalColture_group_1.getText())+
                Double.parseDouble(islam_group_1.getText())+Double.parseDouble(math_group_1.getText())+
                Double.parseDouble(scince_group_1.getText())+Double.parseDouble(physics_group_1.getText())+
                Double.parseDouble(history_group_1.getText());
    }
    public double sumGroup2(){
        return  Double.parseDouble(arabic_group_2.getText())+Double.parseDouble(civil_group_2.getText())+
                Double.parseDouble(english_group_2.getText())+Double.parseDouble(fr_group_2.getText())+
                Double.parseDouble(info_group_2.getText())+Double.parseDouble(generalColture_group_2.getText())+
                Double.parseDouble(islam_group_2.getText())+Double.parseDouble(math_group_2.getText())+
                Double.parseDouble(scince_group_2.getText())+Double.parseDouble(physics_group_2.getText())+
                Double.parseDouble(history_group_2.getText());
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
                if (t.equals("00:03:00")){
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