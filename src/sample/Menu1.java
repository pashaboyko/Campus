package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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

public class Menu1 {

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
        String br= objList.mainAccuntSt.getName()+"  "+ objList.mainAccuntSt.getSurname();
        LabelNameSurname.setText(br);

        LabelDate.setText(String.valueOf(objList.mainAccuntSt.getDate()));
        Labelgroup.setText(objList.mainAccuntSt.getGroup());
        LabelLogin.setText(objList.mainAccuntSt.getLogin());
        LabelNum.setText(String.valueOf(objList.mainAccuntSt.getId()));
        Image image = new Image(getClass().getResource(objList.mainAccuntSt.getPhotos()).toExternalForm());

        imAcc.setImage(image);


        buttonNews.setOnAction(event -> {
            buttonNews.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu2.fxml"));
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
            objList.mainAccuntSt=new Student();
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
