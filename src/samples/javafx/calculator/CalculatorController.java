package samples.javafx.calculator;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController implements Initializable {

    @FXML
    Button btnClear;
    @FXML
    TextField textDisplay;
    @FXML
    Button btn0;
    @FXML
    Button btn1;
    @FXML
    Button btn2;
    @FXML
    Button btn3;
    @FXML
    Button btn4;
    @FXML
    Button btn5;
    @FXML
    Button btn6;
    @FXML
    Button btn7;
    @FXML
    Button btn8;
    @FXML
    Button btn9;
    @FXML
    Button btnPuls;
    @FXML
    Button btnEquals;

    private Calc calc = new Calc();

    StringBuilder displayNumber = new StringBuilder();

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println("initialize");
        displayNumber.append("0");
        EventHandler<ActionEvent> handler = (ActionEvent e) -> {
            Button btn = (Button) e.getSource();
            String no = btn.getText();
            if ("0".equals(displayNumber.toString()) && "0".equals(no)) {
                // ignore
            } else if ("0".equals(displayNumber.toString())) {
                displayNumber = new StringBuilder();
                displayNumber.append(no);
            } else {
                displayNumber.append(no);
            }
            textDisplay.setText(displayNumber.toString());
            calc.pushNumber();
        };
        btn0.setOnAction(handler);
        btn1.setOnAction(handler);
        btn2.setOnAction(handler);
        btn3.setOnAction(handler);
        btn4.setOnAction(handler);
        btn5.setOnAction(handler);
        btn6.setOnAction(handler);
        btn7.setOnAction(handler);
        btn8.setOnAction(handler);
        btn9.setOnAction(handler);
        btnEquals.setOnAction((ActionEvent) -> {
            calc.pushEquals(Double.parseDouble(displayNumber.toString()));
        });
        btnPuls.setOnAction((ActionEvent) -> {
            calc.pushPuls(Double.parseDouble(displayNumber.toString()));
        });
        btnClear.setOnAction((ActionEvent) -> {
            calc.pushClear();
        });
        calc.addCalculationListener((Double result) -> {
            textDisplay.setText(Double.toString(result));
            displayNumber = new StringBuilder("0");
        });
    }
}

class Calc {
    @FunctionalInterface
    public interface CalculationListener {
        public abstract void calculated(Double result);
    }

    List<CalculationListener> listeners = new ArrayList<>();

    public void addCalculationListener(CalculationListener listener) {
        listeners.add(listener);
    }

    public void removeCalculationListener(CalculationListener listener) {
        listeners.remove(listener);
    }

    private void fireCalculated() {
        for (CalculationListener listener : listeners) {
            listener.calculated(result);
        }
    }

    Double result = 0.0d;

    enum LogicType {
        NONE, PULS, EQUALS;
    }

    LogicType currentType = LogicType.NONE;

    public void pushEquals(Double number) {
        if (currentType == LogicType.NONE) {
            pushClear();
        } else {
            calc(number);
        }
        currentType = LogicType.EQUALS;
    }

    public void pushNumber() {
        if( currentType == LogicType.EQUALS){
            
        }
    }

    public void pushPuls(Double number) {
        currentType = LogicType.PULS;
        calc(number);
    }

    public void calc(Double number) {
        if (currentType == null) {
            return;
        }
        switch (currentType) {
        case PULS:
            result = result + number;
            break;
        default:
            break;
        }
        fireCalculated();
    }

    public void pushClear() {
        result = 0.0d;
        currentType = null;
        fireCalculated();
    }
}