/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatormvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kriss
 */
public class ContollerCalculator {

    ModelCalculator actionModel;
    ViewCalculator viewCalculator;

    public ContollerCalculator(ModelCalculator actionModel, ViewCalculator viewCalculator) {
        this.actionModel = actionModel;
        this.viewCalculator = viewCalculator;

        this.viewCalculator.bNumberOneActionListener(new AddNumerbOne());
        this.viewCalculator.bAdditionActionListener(new AdditionListener());
        this.viewCalculator.bEqualActionActionListener(new EqualsListener());

    }

    class AdditionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (actionModel.checkLastSign(String.valueOf(viewCalculator.getTFActions())) == true) {
                viewCalculator.setTFActions(viewCalculator.getTFActions() + "+");
            }
        }

    }

    class AddNumerbOne implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            viewCalculator.setTFActions(viewCalculator.getTFActions() + "1");

        }

    }

    class EqualsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            actionModel.calculatingResult(viewCalculator.getTFActions().toString());
            //viewCalculator.setCleanTFActions();
            viewCalculator.setTFActions(String.valueOf(actionModel.getSolution()));
        }

    }

}
