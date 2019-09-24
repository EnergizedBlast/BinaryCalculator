package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.model.BinaryCalculator;

import java.io.IOException;

public class Main extends Application {

    @FXML
    private Label actionView;

    @FXML
    private Label historyView;

    @FXML
    private Button num0;

    @FXML
    private Button num1;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button divide;

    @FXML
    private Button multiply;

    @FXML
    private Button sqrt;

    @FXML
    private Button square;

    @FXML
    private Button clear;

    @FXML
    private Button equals;

    public static void main(String[] args) {
        launch(args);
    }
    public String active = "";
    public int operation = 0;
    public String firstValue = "";
    public String secondValue = "";


    @Override
    public void start(Stage primaryStage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("view/calculator.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Binary Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    @FXML
    public void giveOne(){
        if (active.length() < 5){
            active += "1";
            actionView.setText(active);
        }
    }

    @FXML
    public void giveZero(){
        if (active.length() < 5){
            active += "0";
            actionView.setText(active);
        }
    }

    @FXML
    public void clear(){
        active = "";
        actionView.setText(active);
    }



    @FXML
    public void division(){
        updateUI();
        firstValue = active;
        historyView.setText(active + "/");
        clear();
        operation=1;
    }

    @FXML
    public void addition(){
        updateUI();
        firstValue = active;
        historyView.setText(active + "+");
        clear();
        operation=2;
    }

    @FXML
    public void subtraction(){
        firstValue = active;
        historyView.setText(active + "-");
        updateUI();
        clear();
        operation=3;
    }

    @FXML
    public void multiplication(){
        updateUI();
        firstValue = active;
        historyView.setText(active + "*");
        clear();
        operation=4;

    }

    @FXML
    public void square(){
        updateUI();
        firstValue = active;
        historyView.setText(active);
        clear();
        operation=5;
        equals();
        historyView.setText(active);
    }

    @FXML
    public void equals(){
        secondValue = active;
        String original = historyView.getText();

        historyView.setText(original + active);
        BinaryCalculator calculator = new BinaryCalculator();
        switch (operation){
            case 1: actionView.setText(calculator.divide(firstValue,secondValue));
                break;
            case 2: actionView.setText(calculator.add(firstValue,secondValue));
                break;
            case 3: actionView.setText(calculator.subtract(firstValue,secondValue));
                break;
            case 4: actionView.setText(calculator.multiply(firstValue,secondValue));
                break;
            case 5: actionView.setText(calculator.square(firstValue));
                break;
            default: break;
        }
        redoUI();
        active=actionView.getText();
    }


    @FXML
    public void updateUI(){
        plus.setDisable(true);
        minus.setDisable(true);
        multiply.setDisable(true);
        divide.setDisable(true);
        equals.setDisable(false);
    }
    @FXML
    public void redoUI(){
        plus.setDisable(false);
        minus.setDisable(false);
        multiply.setDisable(false);
        divide.setDisable(false);
        equals.setDisable(true);
    }
}