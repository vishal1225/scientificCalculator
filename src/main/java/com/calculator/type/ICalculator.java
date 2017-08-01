package com.calculator.type;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by vssharma on 28/07/2017.
 */
public interface ICalculator {
    List<Character> operators=new LinkedList<Character>();
    LinkedList<BigDecimal> operands = new LinkedList<BigDecimal>();
    default void takeInput(String calculationString) throws NumberFormatException {
        calculationString = calculationString.replace(" ","");
        for(int i=0;i<calculationString.length();i++)
        {
            char inputChar=calculationString.charAt(i);
            if(inputChar=='-' || inputChar=='+' || inputChar=='*' || inputChar=='/')
            {
                operators.add(inputChar);
            }
        }
        operands.addAll(Arrays.stream(calculationString.split("-|\\+|\\*|\\/")).map(BigDecimal::new).collect(Collectors.toCollection(LinkedList::new)));

    }
    default List<Character> getOperators() {
        return operators;
    }

    default LinkedList<BigDecimal> getOperands() {
        return operands;
    }
    default void listUpdater(List<Character> operators,List<BigDecimal> operands,int position,BigDecimal result)
    {
        operators.remove(position);
        operands.remove(position);
        operands.remove(position);
        operands.add(result);
    }
    BigDecimal calculate(String calculationString);
}
