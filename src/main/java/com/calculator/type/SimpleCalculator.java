package com.calculator.type;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vssharma on 28/07/2017.
 */
public class SimpleCalculator implements ICalculator {


    public BigDecimal calculate(String calculationString)throws NumberFormatException {
        takeInput(calculationString);
        List<BigDecimal> operands = getOperands();
        List<Character> operators = getOperators();
        int operationCount = ICalculator.operators.size();
        BigDecimal operand1 = new BigDecimal(0);
        BigDecimal operand2 = new BigDecimal(0);
        BigDecimal result = new BigDecimal(0);
        while(operationCount>0)
        {
            if(operators.contains('*') || operators.contains('/'))
            {
                int currentPositionMultiplication=operators.indexOf('*');
                int currentPositionDividation=operators.indexOf('/');

                if((currentPositionMultiplication<currentPositionDividation && currentPositionMultiplication!=-1) || currentPositionDividation==-1)
                {
                    operand1=operands.get(currentPositionMultiplication);
                    operand2=operands.get(currentPositionMultiplication+1);
                    result=operand1.multiply(operand2);

                    listUpdater(operators,operands,currentPositionMultiplication,result);
                }
                else if((currentPositionMultiplication>currentPositionDividation && currentPositionDividation!=-1) || currentPositionMultiplication==-1)
                {
                    operand1=operands.get(currentPositionDividation);
                    operand2=operands.get(currentPositionDividation+1);
                    result=operand1.divide(operand2, 10, RoundingMode.HALF_UP);

                    listUpdater(operators,operands,currentPositionDividation,result);
                }

            } else if(operators.contains('-') || operators.contains('+'))
            {
                int currentPositionSubstraction=operators.indexOf('-');
                int currentPositionAddition=operators.indexOf('+');

                if((currentPositionSubstraction<currentPositionAddition && currentPositionSubstraction!=-1) || currentPositionAddition==-1)
                {
                    operand1=operands.get(currentPositionSubstraction);
                    operand2=operands.get(currentPositionSubstraction+1);
                    result=operand1.subtract(operand2);

                    listUpdater(operators,operands,currentPositionSubstraction,result);
                }
                else if((currentPositionSubstraction>currentPositionAddition && currentPositionAddition!=-1) || currentPositionSubstraction==-1)
                {

                    operand1=operands.get(currentPositionAddition);
                    operand2=operands.get(currentPositionAddition+1);
                    result=operand1.add(operand2);

                    listUpdater(operators,operands,currentPositionAddition,result);
                }

            }
            operationCount--;
        }
        Iterator<BigDecimal> iterator=operands.iterator();

        BigDecimal finalResult=new BigDecimal(0);

        while(iterator.hasNext())
        {
            finalResult=iterator.next();
            iterator.remove();
        }

        return finalResult;
    }

}
