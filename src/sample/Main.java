package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;


import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.awt.peer.DialogPeer;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;


public class Main extends Application {





    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("goToAcc.fxml"));
        primaryStage.setTitle("IASA");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();




        Connectionn b=new Connectionn();
       // b.OutInfo();
        b.addtoProgramm();


    }




    public static void main(String[] args) {
        launch(args);
    }
}
