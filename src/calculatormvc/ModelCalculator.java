/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatormvc;

/**
 *
 * @author Kriss
 */
public class ModelCalculator {

    private double solution, firstNumber, secondNumber;

    private boolean whetherMathOperAdd = false;
    private boolean whetherMathOperSub = false;
    private boolean whetherMathOperMul = false;
    private boolean whetherMathOperDiv = false;
    private boolean whetherMathOper = false;
    private boolean lastIsSign = false;

    private String tmpPartialValue = "";

    public double getSolution() {
        return solution;
    }

    public void additionAction(double firstNumber, double secondNumber) {

        solution = firstNumber + secondNumber;
        whetherMathOperAdd = false;
    }

    public void substractionAction(double... numbers) {

        for (double d : numbers) {
            solution -= d;

        }
        whetherMathOperSub = false;
    }

    public void multiplicationAction(double... numbers) {

        for (int i = 0; i < numbers.length; i++) {

            if (i == 0) {
                solution = numbers[i];
            } else {
                solution *= numbers[i];
            }
        }
        whetherMathOperMul = false;
    }

    public void divisionAction(double... numbers) {

        for (int i = 0; i < numbers.length; i++) {

            if (i == 0) {
                solution = numbers[i];
            } else {
                solution /= numbers[i];
            }
        }
        whetherMathOperDiv = false;
    }

    public void calculatingResult(String text) {

        char[] tmpChar = text.toCharArray();
        double tmpPartialValue = 0;

        for (int i = 0; i < tmpChar.length; i++) {

            switch (tmpChar[i]) {

                case '+':
                    whetherLastSign(i, tmpChar.length, tmpChar[i]);
                    if (lastIsSign == false) {
                        savePartialValue();
                        checkWhaterOper();
                        whetherMathOperAdd = true;
                    } else {
                        lastIsSign = false;
                    }
                    break;
                case '-':
                    savePartialValue();
                    whetherMathOperSub = true;
                    break;
                case '/':
                    whetherMathOperDiv = true;
                    break;
                case '*':
                    whetherMathOperMul = true;
                    break;
                case '.':
                    partialValue(tmpChar[i]);
                    break;
                default:
                    partialValue(tmpChar[i]);
                    checkLast(i, tmpChar.length);

            }

        }
    }

    public void partialValue(char number) {

        tmpPartialValue += number;

    }

    public void savePartialValue() {

        if (whetherMathOper == false) {
            firstNumber = Double.valueOf(tmpPartialValue);
            tmpPartialValue = "";
        } else {

            secondNumber = Double.valueOf(tmpPartialValue);
            tmpPartialValue = "";

        }

    }

    public void checkWhaterOper() {

        if (whetherMathOper == true) {
            if (whetherMathOperAdd == true) {
                additionAction(this.firstNumber, this.secondNumber);
            } else if (whetherMathOperSub == true) {
                substractionAction(this.firstNumber, this.secondNumber);
            } else if (whetherMathOperMul == true) {
                multiplicationAction(this.firstNumber, this.secondNumber);
            } else if (whetherMathOperDiv == true) {
                divisionAction(this.firstNumber, this.secondNumber);
            }

        } else {

            whetherMathOper = true;
        }
    }

    public double checkLast(int valueI, int valueText) {

        if ((valueI) == valueText - 1) {
            savePartialValue();
            checkWhaterOper();
            whetherMathOper = false;
            return solution;

        } else {
            return Double.MIN_VALUE;
        }
    }

    public void whetherLastSign(int valueI, int valueText, char sign) {

        if ((valueI) == valueText - 1) {

            firstNumber = Double.valueOf(tmpPartialValue);
            tmpPartialValue = "0";
            secondNumber = firstNumber;
            switch (sign) {
                case '+':
                    additionAction(this.firstNumber, this.secondNumber);
                    break;
                case '-':
                    substractionAction(this.firstNumber, this.secondNumber);
                    break;
                case '*':
                    multiplicationAction(this.firstNumber, this.secondNumber);
                    break;
                case '/':
                    divisionAction(this.firstNumber, this.secondNumber);
                    break;

            }
        }

    }

    public String enteringNumberOne() {

        return "1".toString();
    }

    public boolean checkLastSign(String text) {

        char tmp = text.charAt(text.length() - 1);

        if (tmp == '+' || tmp == '-' || tmp == '/' || tmp == '*') {
            return false;
        } else {
            return true;
        }

    }

}
