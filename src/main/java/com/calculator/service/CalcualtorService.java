package com.calculator.service;
import com.calculator.type.CalculatorFactory;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by vssharma on 28/07/2017.
 */
public class CalcualtorService {

    public static void main (String[] args) {
        CalcualtorService calcualtorService = new CalcualtorService();
        Scanner sc = new Scanner(System.in);
        calcualtorService.showCalcualtorTypes();
        int choice = calcualtorService.checkChoice();
        BigDecimal result = new BigDecimal(0);
        String calculatorInput = calcualtorService.takeCalculatorInput();
        try {
             result = CalculatorFactory.getCalculator(choice).calculate(calculatorInput);
        } catch (NumberFormatException exception) {
            System.out.println("Invalid Operation");
        }

        System.out.println(result);

    }

    private String takeCalculatorInput() {
        System.out.println("Enter the calculation you want to do:");
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    private int checkChoice() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);

        while (choice >= 1 || choice <= 4) {
            System.out.println("Enter your choice (1 or 2:): ");
            choice = sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Invalid Calculatortype.");
            } else if (choice == 2) {
                System.out.println("Trigonometric Calculator coming soon.");
            }
            else {
                break;
            }
        } ;

        return choice;
    }

    private void showCalcualtorTypes() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose the type of calculator you want to use.");
        System.out.println("1. Simple Calculator");
        System.out.println("2. Trigonometric Calculator.");
    }
}
