package calc.services;

import javafx.scene.control.TextArea;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Result {
    private BigDecimal tempResult;
    private String tempRegex;
    private String operand;
    private Operation lastOperation;

    public Result(TextArea textField) {
        this.tempResult = null;
        this.tempRegex = "";
        this.operand = "";
        this.lastOperation = Operation.NONE;
    }

    public void addSymbol(TextArea textField, String symbol) {
        if (lastOperation.equals(Operation.NONE)) {
            newOperation(textField);
        }
        operand += symbol;
        print(textField);
    }

    public void addSeparator(TextArea textField) {
        if (!operand.matches("\\.")) {
            if (operand.isEmpty()) {
                if (lastOperation.equals(Operation.NONE)) {
                    newOperation(textField);
                }
                operand = "0.";
            } else {
                operand += ".";
            }
            print(textField);
        }
    }

    private void newOperation(TextArea textField) {
        tempResult = null;
        tempRegex = "";
        print(textField);
    }

    public void minusSign(TextArea textField) {
        if (!operand.isEmpty()) {
            if (operand.startsWith("-")) {
                operand = operand.substring(1);
            } else {
                operand = "-" + operand;
            }
            print(textField);
        }
    }

    public void backspace(TextArea textField) {
        if (!operand.isEmpty()) {
            operand = operand.substring(0, operand.length() - 1);
            if (operand.equals("-")) {
                operand = "";
            }
            print(textField);
        }
    }

    public void ce(TextArea textField) {
        operand = "";
        print(textField);
    }

    public void cancel(TextArea textField) {
        tempResult = null;
        tempRegex = "";
        operand = "";
        print(textField);
    }

    public void add(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() || !tempRegex.isEmpty()) {
            operation();
            tempRegex += formatDecimal(operand) + " + ";
            operand = "";
            lastOperation = Operation.ADD;
            print(textField);
        }
    }

    public void sub(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() || !tempRegex.isEmpty()) {
            operation();
            tempRegex += formatDecimal(operand) + " - ";
            operand = "";
            lastOperation = Operation.SUB;
            print(textField);
        }
    }

    public void mul(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() || !tempRegex.isEmpty() ) {
            operation();
            tempRegex += formatDecimal(operand) + " * ";
            operand = "";
            lastOperation = Operation.MUL;
            print(textField);
        }
    }

    public void div(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() || !tempRegex.isEmpty() ) {
            operation();
            tempRegex += formatDecimal(operand) + " / ";
            operand = "";
            lastOperation = Operation.DIV;
            print(textField);
        }
    }

    public void sqrt(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() ) {
            tempRegex += String.format("sqrt(%s)", formatDecimal(operand));
            operand = Math.sqrt(Double.parseDouble(operand)) + "";
            operation();
            operand = "";
            lastOperation = Operation.NONE;
            print(textField);
        }
    }

    public void percent(TextArea textField) {
        if (!operand.isEmpty() && !tempRegex.isEmpty()) {
            BigDecimal percent = tempResult.multiply(new BigDecimal(operand));
            percent = percent.divide(new BigDecimal(100), 15, RoundingMode.CEILING);
            operand = percent.toString();
            operation();
            tempRegex += formatDecimal(operand);
            operand = "";
            lastOperation = Operation.NONE;
            print(textField);
        }
    }

    public void graph(TextArea textField) {
        if (operand.isEmpty() && tempRegex.isEmpty() && tempResult != null) {
            operand = tempResult.toString();
        }

        if (!operand.isEmpty() ) {
            tempRegex += String.format("reciproc(%s)", formatDecimal(operand));
            operand = new BigDecimal(1).divide(new BigDecimal(operand), 15, RoundingMode.CEILING).toString();
            operation();
            operand = "";
            lastOperation = Operation.NONE;
            print(textField);
        }
    }

    public void equals(TextArea textField) {
        if (!operand.isEmpty()) {
            operation();
        }

        tempRegex = "";
        operand = "";
        lastOperation = Operation.NONE;
        print(textField);
    }

    private void operation() {
        switch (lastOperation) {
            case ADD: tempResult = tempResult.add(new BigDecimal(operand));
                break;
            case SUB: tempResult = tempResult.subtract(new BigDecimal(operand));
                break;
            case MUL: tempResult = tempResult.multiply(new BigDecimal(operand));
                break;
            case DIV: tempResult = tempResult.divide(new BigDecimal(operand), 15, RoundingMode.CEILING);
                break;
            case NONE: if (!operand.isEmpty()) {
                    tempResult = new BigDecimal(operand);
                }
                break;
        }
    }


    public void print(TextArea textField) {
        textField.clear();
        textField.appendText(tempRegex + "\n");
        if (operand.isEmpty() && tempResult != null) {
            textField.appendText(formatDecimal(tempResult.toString()));

        } else {
            textField.appendText(formatDecimal(operand));
        }
    }

    private String formatDecimal(String value) {
        value = value.replaceAll("(\\d+\\.[1-9]+)0+\\b", "$1");
        value = value.replaceAll("(\\d+)\\.0+\\b", "$1");
        return value;
    }
}
