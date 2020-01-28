package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.pojo.Marrks;
import sample.pojo.Teacher;
import sample.pojo.TeacherCombination;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Menu44 {
    public static ObservableList<Marrks> marksData = FXCollections.observableArrayList();
    public TeacherCombination setone;
    private static int fff;
    private static String dddd;

    public boolean editsd (Marrks marrks, int g) {
            Connectionn gf=new Connectionn();
            gf.edElement(marrks.getId(),marrks.getSubject(),g);
            EdTabl();
        return true;
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private  TableView<Marrks> tableUsers;

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
    private ChoiceBox<TeacherCombination> comBox;
    @FXML
    public void EdTabl() {
        marksData.clear();
        Connectionn gd=new Connectionn();
        gd.addtoProgrammMarks();
        gd.addtoProgramm();
        String sub=Connectionn.stringKA72[fff];
        for(int i = 0; i< objList.markss.size(); i++){
            if(objList.markss.get(i).getSubject().equals(sub)){

                for(int j = 0; j< objList.accounts.size(); j++){
                    if(objList.accounts.get(j).getGroup().equals(dddd)){

                        if (objList.accounts.get(j).getName().equals(objList.markss.get(i).getName())) {
                            if(objList.accounts.get(j).getSurname().equals(objList.markss.get(i).getSurname())){
                                marksData.add(objList.markss.get(i));

                            }
                        }
                    }
                }
            }
        }
    }


    @FXML
    void initialize() {

        marksData.clear();

        tableUsers.setItems(marksData);
        ObservableList<TeacherCombination> strt = FXCollections.observableArrayList();
        strt.clear();

        Connectionn g=new Connectionn();
        g.addtoProgrammTeacherCombinatoin();
        for(int i = 0; i< objList.teacherCombinations.size(); i++){
            if(objList.mainAccuntTh.getId()==objList.teacherCombinations.get(i).getId())
                strt.add(objList.teacherCombinations.get(i));
        }


        comBox.setItems(strt);

        idColumn.setCellValueFactory(new PropertyValueFactory<Marrks, String>("surname"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Marrks, String>("mark"));



        comBox.setOnAction(event -> {
            fff=comBox.getValue().getSubject();
            dddd=new String(comBox.getValue().getGroup());
            setone=comBox.getValue();
            tableUsers.refresh();
            marksData.clear();
            g.addtoProgrammMarks();
            g.addtoProgramm();
            String sub=Connectionn.stringKA72[comBox.getValue().getSubject()];
            for(int i = 0; i< objList.markss.size(); i++){
                if(objList.markss.get(i).getSubject().equals(sub)){
                    for(int j = 0; j< objList.accounts.size(); j++){
                        if(objList.accounts.get(j).getGroup().equals(comBox.getValue().getGroup())){
                            if (objList.accounts.get(j).getName().equals(objList.markss.get(i).getName())) {
                                if(objList.accounts.get(j).getSurname().equals(objList.markss.get(i).getSurname())){
                                    marksData.add(objList.markss.get(i));
                                }
                            }
                        }
                    }
                }
            }




        });



       tableUsers.setRowFactory(tv -> {
            TableRow<Marrks> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Marrks rowData = row.getItem();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("editMarks.fxml"));

                    AnchorPane page = null;
                    try {
                        page = (AnchorPane) loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Create the dialog Stage.
                    Stage dialogStage = new Stage();
                    dialogStage.setTitle("Изменение оценки");
                    dialogStage.initModality(Modality.WINDOW_MODAL);

                    Scene scene = new Scene(page);
                    dialogStage.setScene(scene);

                    // Set the person into the controller.
                    EditMarks controller = loader.getController();
                    controller.setDialogStage(dialogStage);
                    controller.setMarks(rowData);
                    // Show the dialog and wait until the user closes it
                    dialogStage.showAndWait();

                    tableUsers.setItems(marksData);
                }
            });
            return row;
        });










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
    }
}
