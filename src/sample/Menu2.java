package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import jdk.nashorn.internal.runtime.Context;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class Menu2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNews;
    @FXML
    private Label errorText;
    @FXML
    private Button buttonInfo;
    @FXML
    private WebView webView;

    @FXML
    private Button buttonCalen;



    @FXML
    private Button buttonBals;

    @FXML
    private ProgressIndicator progres;

    @FXML
    void initialize() {

        WebEngine webengine=webView.getEngine();
        WebEngine webengine1=webView.getEngine();
        webengine.load("http://studsovet.ipsa.kpi.ua/news/");
        progres.progressProperty().bind(webengine.getLoadWorker().progressProperty());
        webengine.getLoadWorker().stateProperty().addListener(
                new ChangeListener<Worker.State>() {
                    public void changed(ObservableValue ov, Worker.State oldState, Worker.State newState) {
                        if (newState == Worker.State.SUCCEEDED) {

                            progres.visibleProperty().bind(progres.progressProperty().lessThan(1));


                        } else {
                        }
                    }});

            try {
                final URL url = new URL("http://studsovet.ipsa.kpi.ua/news/");
                final URLConnection conn = url.openConnection();
                conn.connect();
                conn.getInputStream().close();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                errorText.setText("Нет подключения к интернету или сайту");
                progres.setVisible(false);
            }





        buttonInfo.setOnAction(event -> {
            buttonInfo.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu1.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Информация");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });

        buttonCalen.setOnAction(event -> {
            buttonCalen.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu3.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Расписание");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });
        buttonBals.setOnAction(event -> {
            buttonBals.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu4.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Оценки");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });
    }
}
