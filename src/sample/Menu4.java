package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.pojo.Marrks;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu4 {
    public ObservableList<Marrks> marksData = FXCollections.observableArrayList();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableView<Marrks> tableUsers;

    @FXML
    private TableColumn<Marrks, String> idColumn;

    @FXML
    private TableColumn<Marrks, String> nameColumn;

    @FXML
    private Button buttonNews;

    @FXML
    private Button buttonInfo;

    @FXML
    private Button buttonCalen;

    @FXML
    private Button buttonBals;

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<Marrks, String>("subject"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Marrks, String>("mark"));
        marksData.clear();
        Connectionn b= new Connectionn();
        b.addtoProgrammMarks();
        for(int i = 0; i< objList.markss.size(); i++){
            if(objList.markss.get(i).getId()==objList.mainAccuntSt.getId()){
                marksData.add(objList.markss.get(i));
            }
        }


        tableUsers.setItems(marksData);





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
    }
}
