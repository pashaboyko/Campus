package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.pojo.Account;
import sample.pojo.Schedule;
import sample.pojo.Student;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Menu33 {
    public ObservableList<Student> studentsdate = FXCollections.observableArrayList();
    Date now=new Date();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonNews;
    @FXML
    private Button xx;

    @FXML
    private Button buttonInfo;



    @FXML
    private Label errorCur;

    @FXML
    private TableView<Student> tableUsers;
    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, Integer> barcodeColumn;

    @FXML
    private Button buttonBals;

    @FXML
    void initialize() {
        studentsdate.clear();
        idColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("name"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("surname"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<Student, Integer>("numPhone"));

        tableUsers.setItems(studentsdate);

        if(objList.mainAccuntTh.getYourGroup().equals("Нет кураторства")){
            tableUsers.setVisible(false);
            errorCur.setText("Нет кураторства");
        }
        else{
            for(int i = 0; i< objList.accounts.size(); i++){
                if(objList.accounts.get(i).getGroup().equals(objList.mainAccuntTh.getYourGroup())){
                    studentsdate.add(objList.accounts.get(i));
                }
            }




        }





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
        buttonInfo.setOnAction(event -> {
            buttonInfo.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("menu11.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Информация");
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
