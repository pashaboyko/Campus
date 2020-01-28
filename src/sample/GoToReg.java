package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Connectionn;

public class GoToReg {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonIn;

    @FXML
    private DatePicker dateIn;

    @FXML
    private TextField studNum;

    @FXML
    private PasswordField PawStud;

    @FXML
    private PasswordField PawText;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField logText;
    @FXML
    private Label textError;


    @FXML
    void initialize() {


        buttonBack.setOnAction(event -> {
            buttonBack.getScene().getWindow().hide();
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

        buttonIn.setOnAction(event -> {
            Connectionn b=new Connectionn();
if(logText.getText().isEmpty()||PawStud.getText().isEmpty()||PawText.getText().isEmpty()||studNum.getText().isEmpty())
    textError.setText("Введите все поля");

else{
    b.addtoProgramm();
    Boolean trueLogin=true;
            for(int i = 0; i< objList.accounts.size(); i++){
              if(objList.accounts.get(i).getLogin().equals(logText.getText()))
                  trueLogin=false;
            }
            if(trueLogin) {
                try {
                    Integer d1 = new Integer(studNum.getText());
                    if (b.studackCheck(d1, PawStud.getText(), logText.getText(), PawText.getText())) {
                        buttonIn.getScene().getWindow().hide();
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
                    } else textError.setText("Неверные данные или уже были использованые");
                } catch (NumberFormatException e) {
                    studNum.clear();
                    textError.setText("Студенческий номер состоит только из цифр");
                }
            }
            else textError.setText("Логин был использован");
        }});



    }
}