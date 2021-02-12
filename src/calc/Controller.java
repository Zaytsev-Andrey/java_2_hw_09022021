package calc;

import calc.services.Result;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class Controller {
    private static Result result;

    @FXML
    private TextArea inputText;

    public Controller() {
        result = new Result(inputText);
    }

    public void btnOneClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "1");
    }

    public void btnTwoClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "2");
    }

    public void btnThreeClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "3");
    }

    public void btnFourClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "4");
    }

    public void btnFiveClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "5");
    }

    public void btnSixClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "6");
    }

    public void btnSevenClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "7");
    }

    public void btnEightClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "8");
    }

    public void btnNineClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "9");
    }

    public void btnZeroClick(ActionEvent actionEvent) {
        result.addSymbol(inputText, "0");
    }

    public void btnBackspaceAction(ActionEvent actionEvent) {
        result.backspace(inputText);
    }

    public void btnCancelAction(ActionEvent actionEvent) {
        result.cancel(inputText);
    }

    public void btnSeparatorAction(ActionEvent actionEvent) {
        result.addSeparator(inputText);
    }

    public void btnPlusMinusAction(ActionEvent actionEvent) {
        result.minusSign(inputText);
    }

    public void btnAddAction(ActionEvent actionEvent) {
        result.add(inputText);
    }

    public void btnEqualsAction(ActionEvent actionEvent) {
        result.equals(inputText);
    }

    public void btnSubAction(ActionEvent actionEvent) {
        result.sub(inputText);
    }

    public void btnMulAction(ActionEvent actionEvent) {
        result.mul(inputText);
    }

    public void btnDivAction(ActionEvent actionEvent) {
        result.div(inputText);
    }

    public void btnCEAction(ActionEvent actionEvent) {
        result.ce(inputText);
    }

    public void btnSqrtAction(ActionEvent actionEvent) {
        result.sqrt(inputText);
    }

    public void btnPercentAction(ActionEvent actionEvent) {
        result.percent(inputText);
    }

    public void btnGraphAction(ActionEvent actionEvent) {
        result.graph(inputText);
    }
}
