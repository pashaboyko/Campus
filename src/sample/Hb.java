package sample;

import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Hb {
    private Stage dialogStage;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonExit;

    @FXML
    private MediaView mediaView;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    @FXML
    void initialize() {

        MediaPlayer mediaPlayer = new MediaPlayer(new Media(Paths.get("src/sample/1.mp4").toUri().toString()));
        mediaPlayer.setAutoPlay(true);
        mediaView.setMediaPlayer(mediaPlayer);

        buttonExit.setOnAction(event -> {
            dialogStage.close();
        });
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            public void run() {
                dialogStage.close();
            }});

        if(mediaPlayer.getCurrentTime()==mediaPlayer.getStopTime()){
            System.out.println("1");
        }


    }


}
