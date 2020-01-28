package sample;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.pojo.Student;
import sample.pojo.Teacher;

public class GoToAcc {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonIn;
    @FXML
    private Label textError;

    @FXML
    private Button biuttonReg;

    @FXML
    private PasswordField PawText;

    @FXML
    private TextField logText;

    @FXML
    void initialize() {

        biuttonReg.setOnAction(event -> {
            biuttonReg.getScene().getWindow().hide();
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("goToReg.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Stage primaryStage_2 = new Stage();
            primaryStage_2.setTitle("Reg");

            primaryStage_2.setScene(new Scene(root));

            primaryStage_2.setResizable(false);
            primaryStage_2.show();
        });

        buttonIn.setOnAction(event -> {

            objList.accounts.clear();;
            objList.teachers.clear();
            Connectionn b= new Connectionn();
            b.addtoProgramm();
            boolean f=false;

            for(int i = 0; i< objList.accounts.size(); i++){
                if(objList.accounts.get(i).getLogin().equals(logText.getText())){
                    if(objList.accounts.get(i).getPassword().equals(PawText.getText())){
                        f=true;
                        objList.mainAccuntSt=new Student(objList.accounts.get(i));
                    }
                }
            }

            if(f){
                Parent root = null;
                buttonIn.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("menu1.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if(objList.mainAccuntSt.getDate().toLocalDate().getMonthValue()==LocalDate.now().getMonthValue()){
                    if(objList.mainAccuntSt.getDate().toLocalDate().getDayOfMonth()==LocalDate.now().getDayOfMonth()){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("hb.fxml"));

                        AnchorPane page = null;
                        try {
                            page = (AnchorPane) loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // Create the dialog Stage.
                        Stage dialogStage = new Stage();
                        dialogStage.setTitle("Happy Birthday");
                        dialogStage.initModality(Modality.WINDOW_MODAL);

                        Scene scene = new Scene(page);
                        dialogStage.setScene(scene);

                        // Set the person into the controller.
                        Hb controller = loader.getController();
                        controller.setDialogStage(dialogStage);
                        // Show the dialog and wait until the user closes it
                        dialogStage.showAndWait();}}


                Stage primaryStage_2 = new Stage();
                primaryStage_2.setTitle("IASA");

                primaryStage_2.setScene(new Scene(root));

                primaryStage_2.setResizable(false);
                primaryStage_2.show();}
            else{

            for(int i = 0; i< objList.teachers.size(); i++){
                if(objList.teachers.get(i).getLogin().equals(logText.getText())){
                    if(objList.teachers.get(i).getPassword().equals(PawText.getText())){
                        f=true;
                        objList.mainAccuntTh=new Teacher(objList.teachers.get(i));
                    }
                }
            }

            if(f){
                Parent root = null;
                buttonIn.getScene().getWindow().hide();
                try {
                    root = FXMLLoader.load(getClass().getResource("menu11.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if(objList.mainAccuntTh.getDate().toLocalDate().getMonthValue()==LocalDate.now().getMonthValue()){
                    if(objList.mainAccuntTh.getDate().toLocalDate().getDayOfMonth()==LocalDate.now().getDayOfMonth()){
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("hb.fxml"));

                        AnchorPane page = null;
                        try {
                            page = (AnchorPane) loader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // Create the dialog Stage.
                        Stage dialogStage = new Stage();
                        dialogStage.setTitle("Happy Birthday");
                        dialogStage.initModality(Modality.WINDOW_MODAL);

                        Scene scene = new Scene(page);
                        dialogStage.setScene(scene);

                        // Set the person into the controller.
                        Hb controller = loader.getController();
                        controller.setDialogStage(dialogStage);
                        // Show the dialog and wait until the user closes it
                        dialogStage.showAndWait();}}


                Stage primaryStage_2 = new Stage();
                primaryStage_2.setTitle("IASA");

                primaryStage_2.setScene(new Scene(root));

                primaryStage_2.setResizable(false);
                primaryStage_2.show();}
            else{


                textError.setText("Неверный логин или пароль");

            }}





        });


    }
}