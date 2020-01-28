package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.pojo.Marrks;

public class EditMarks {
    private Stage dialogStage;

    private Marrks m;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textMark;

    @FXML
    private Label errorMark;

    @FXML
    private Button butEdit;
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    public void setMarks(Marrks m3){
        this.m=m3;
        System.out.println(m.getId());
    }

    @FXML
    void initialize() {

        butEdit.setOnAction(event -> {
            Integer jio=new Integer(textMark.getText());
            System.out.println(jio);
            Menu44 con=new Menu44();
            if(jio>=0&&jio<=100){
            con.editsd(m,jio);
            dialogStage.close();}
            else {
            textMark.clear();
            errorMark.setText("Введите значение от 0 до 100");}

        });


    }
}
