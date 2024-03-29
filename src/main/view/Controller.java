package main.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.model.BinaryCalculator;

public class Controller {
    @FXML
    public Button num0;

    @FXML
    public Button num1;

    @FXML
    private Label actionView;

    @FXML
    private Label historyView;

    @FXML
    private Button plus;

    @FXML
    private Button minus;

    @FXML
    private Button divide;

    @FXML
    private Button multiply;

    @FXML
    private Button square;

    @FXML
    private Button sqrt;

    @FXML
    private Button equals;

    private String active = "";
    private int operation = 0;
    private String firstValue = "";
    private String secondValue = "";

    @FXML
    public void giveOne(){
        giveNum("1");
    }

    @FXML
    public void giveZero(){
        giveNum("0");
    }

    @FXML
    private void giveNum(String num){
        if (active.length() < 5){
            active += num;
            actionView.setText(active);
        }
    }

    @FXML
    public void clearActionView(){
        active = "";
        actionView.setText(active);
    }

    @FXML
    public void clearAll(){
        clearActionView();
        firstValue = "";
        secondValue = "";
        historyView.setText("");
        redoUI();
    }

    @FXML
    private void operate(int opValue, String symbol){
        updateUI();
        firstValue = active;
        historyView.setText(active + " " + symbol + " ");
        operation=opValue;
        clearActionView();
    }

    @FXML
    public void division(){
        operate(1,"/");
    }

    @FXML
    public void addition(){
        operate(2,"+");
    }

    @FXML
    public void subtraction(){
        operate(3,"-");
    }

    @FXML
    public void multiplication(){
        operate(4,"*");
    }

    @FXML
    public void square(){
        operate(5,"^ 2");
        equals();
    }
    @FXML
    public void sqrt(){
        operate(6,"^ 1/2");
        equals();
    }

    @FXML
    private void reiterate(){
        redoUI();
        active=actionView.getText();
    }

    @FXML
    public void equals(){
        secondValue = active;
        String original = historyView.getText();

        historyView.setText(original + active);
        BinaryCalculator calculator = new BinaryCalculator();
        switch (operation){
            case 1:
                if(!secondValue.equals("")){
                    actionView.setText(calculator.divide(firstValue,secondValue));
                    reiterate();
                }
                break;
            case 2:
                if(!secondValue.equals("")){
                    actionView.setText(calculator.add(firstValue,secondValue));
                    reiterate();
                }
                break;
            case 3:
                if(!secondValue.equals("")){
                    actionView.setText(calculator.subtract(firstValue,secondValue));
                    reiterate();
                }
                break;
            case 4:
                if(!secondValue.equals("")){
                    actionView.setText(calculator.multiply(firstValue,secondValue));
                    reiterate();
                }
                break;
            case 5:
                if(!firstValue.equals("")){
                    actionView.setText(calculator.squared(firstValue));
                    reiterate();
                }
                break;
            case 6:
                if(!firstValue.equals("")){
                    actionView.setText(calculator.sqrt(firstValue));
                    reiterate();
                }
                break;
            default: break;
        }
    }


    @FXML
    private void updateUI(){
        plus.setDisable(!plus.isDisabled());
        minus.setDisable(!minus.isDisabled());
        multiply.setDisable(!multiply.isDisabled());
        divide.setDisable(!divide.isDisabled());
        square.setDisable(!square.isDisabled());
        sqrt.setDisable(!sqrt.isDisabled());
        equals.setDisable(!equals.isDisabled());
    }
    @FXML
    private void redoUI(){
        plus.setDisable(false);
        minus.setDisable(false);
        multiply.setDisable(false);
        divide.setDisable(false);
        square.setDisable(false);
        sqrt.setDisable(false);
        equals.setDisable(true);
    }
}
