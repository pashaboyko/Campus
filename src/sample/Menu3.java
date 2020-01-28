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
import sample.pojo.Schedule;
import sun.util.resources.LocaleData;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

public class Menu3 {
    public ObservableList<Schedule> scheduleData = FXCollections.observableArrayList();
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
    private Button buttonCalen;

    @FXML
    private DatePicker calll;

    @FXML
    private TableView<Schedule> tableUsers;
    @FXML
    private TableColumn<Schedule, Integer> idColumn;

    @FXML
    private TableColumn<Schedule, String> nameColumn;

    @FXML
    private TableColumn<Schedule, String> barcodeColumn;

    @FXML
    private Button buttonBals;

    @FXML
    void initialize() {

        calll.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isAfter(LocalDate.of(2019, 1, 25))||date.isBefore(LocalDate.of(2018, 9, 1))||date.isEqual(LocalDate.of(2019, 1, 1))||date.isEqual(LocalDate.of(2019, 1, 7))||date.isEqual(LocalDate.of(2018, 12, 25))||date.getDayOfWeek() == DayOfWeek.SATURDAY||date.getDayOfWeek() == DayOfWeek.SUNDAY);
            }
        });
        calll.setEditable(false);






        idColumn.setCellValueFactory(new PropertyValueFactory<Schedule, Integer>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("subject"));
        barcodeColumn.setCellValueFactory(new PropertyValueFactory<Schedule, String>("room"));

        tableUsers.setItems(scheduleData);

        final String[] dayOfWeek = {new SimpleDateFormat("EEEE", Locale.ENGLISH).format(now)};
        System.out.println(dayOfWeek[0]);
        scheduleData.clear();
        Connectionn b= new Connectionn();
        b.addtoProgrammSched();
        Boolean weekNa2=false;
        DateTimeFormatter dttf = DateTimeFormatter.ofPattern("w"); int week = Integer.parseInt(LocalDate.now().format(dttf));
        if((week)%2==0){
            weekNa2=true;
        }
        for(int i = 0; i< objList.schedules.size(); i++){

            if(dayOfWeek[0].equalsIgnoreCase(objList.schedules.get(i).getDay())){
                if(objList.mainAccuntSt.getGroup().equals(objList.schedules.get(i).getGroup())){
                    if(objList.schedules.get(i).getChange()){
                        if(objList.schedules.get(i).getWeek()==weekNa2){
                            scheduleData.add(objList.schedules.get(i));}}
                    else  scheduleData.add(objList.schedules.get(i));
                }

            }
        }

       xx.setOnAction(event -> {
         LocalDate nde =calll.getValue();
          dayOfWeek[0] = String.valueOf(nde.getDayOfWeek());
          Boolean wwekNa2=false;
           DateTimeFormatter dtf = DateTimeFormatter.ofPattern("w"); int wek = Integer.parseInt(nde.format(dtf));
          if((wek)%2==0){
              wwekNa2=true;
          }
           // dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(nde);
            scheduleData.clear();
            b.addtoProgrammSched();
            for(int i = 0; i< objList.schedules.size(); i++){

                if(dayOfWeek[0].equalsIgnoreCase(objList.schedules.get(i).getDay())){
                    if(objList.mainAccuntSt.getGroup().equals(objList.schedules.get(i).getGroup())){
                     if(objList.schedules.get(i).getChange()){
                         if(objList.schedules.get(i).getWeek()==wwekNa2){
                    scheduleData.add(objList.schedules.get(i));}}
                    else  scheduleData.add(objList.schedules.get(i));
                    }

                }
            }

        });




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
