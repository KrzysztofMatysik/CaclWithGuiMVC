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

    }

    class AdditionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

    class AddNumerbOne implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            viewCalculator.setTFActions(viewCalculator.getTFActions() + "1");

        }

    }

}
