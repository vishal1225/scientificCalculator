package com.calculator.type;

/**
 * Created by vssharma on 28/07/2017.
 */
public class CalculatorFactory {
    public static ICalculator getCalculator(int choice) {
        ICalculator calculator = null;
        switch (choice) {
            case 1 : calculator = new SimpleCalculator();
        }
        return calculator;
    }
}
