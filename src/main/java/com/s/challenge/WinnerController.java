package com.s.challenge;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class WinnerController implements Initializable {
    @FXML public Label winnerLabel;
    Media timerSound = new Media(getClass().getResource("sound/crowd.mp3").toExternalForm());
    MediaPlayer mediaPlayer = new MediaPlayer(timerSound);

    public void setWinnerLabel(String winnerLabel) {
        this.winnerLabel.setText(winnerLabel);
    }
    @FXML
    public void cheer(){
        mediaPlayer.play();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
