package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.pojo.Student;
import sample.pojo.Teacher;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu11 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Label LabelNum;

    @FXML
    private Label LabelNameSurname;

    @FXML
    private Label LabelDate;

    @FXML
    private ImageView imAcc;

    @FXML
    private Label LabelLogin;

    @FXML
    private Button buttonNews;

    @FXML
    private Button buttonInfo;

    @FXML
    private Label Labelgroup;

    @FXML
    private Button buttLock;


    @FXML
    private Button buttonCalen;

    @FXML
    private Button buttonBals;

    @FXML
    void initialize() {
        String br= objList.mainAccuntTh.getName()+"  "+ objList.mainAccuntTh.getSurname();
        LabelNameSurname.setText(br);

        LabelDate.setText(String.valueOf(objList.mainAccuntTh.getDate()));
        Labelgroup.setText(objList.mainAccuntTh.getYourGroup());
        LabelLogin.setText(objList.mainAccuntTh.getLogin());
        LabelNum.setText(String.valueOf(objList.mainAccuntTh.getId()));
        Image image = new Image(getClass().getResource(objList.mainAccuntTh.getPhotos()).toExternalForm());

        imAcc.setImage(image);


        buttonNews.setOnAction(event -> {
            buttonNews.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu22.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Новости");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });

        buttLock.setOnAction(event -> {
            buttLock.getScene().getWindow().hide();
            objList.mainAccuntTh=new Teacher();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("goToAcc.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("IASA");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });


        buttonCalen.setOnAction(event -> {
            buttonCalen.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu33.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Кураторство");
            primaryStage_2.setScene(new Scene(root));
            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });
        buttonBals.setOnAction(event -> {
            buttonBals.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu44.fxml"));
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
