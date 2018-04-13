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

    private double solution;
    private double[] partialNumbers = new double[100];

    private void additionAction(double... numbers) {

        for (double d : numbers) {
            solution += d;
        }
    }

    private void substractionAction(double... numbers) {

        for (double d : numbers) {
            solution -= d;
        }

    }

    private void multiplicationAction(double... numbers) {

        for (int i = 0; i < numbers.length; i++) {

            if (i == 0) {
                solution = numbers[i];
            } else {
                solution *= numbers[i];
            }
        }
    }

    private void divisionAction(double... numbers) {

        for (int i = 0; i < numbers.length; i++) {

            if (i == 0) {
                solution = numbers[i];
            } else {
                solution /= numbers[i];
            }
        }
    }
    
    private String enteringNumberOne(){
        
        return "1".toString();
    }
    

}
