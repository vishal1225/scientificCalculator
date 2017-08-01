import com.calculator.type.CalculatorFactory;
import com.calculator.type.ICalculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by vssharma on 28/07/2017.
 */
@RunWith(JUnitParamsRunner.class)
public class SimpleCalculatorTest {

    public Object[] scenarios_for_calculation() {
        return new Object[]{
                new Object[]{"2+1",    "3"},
                new Object[]{"2*1",    "2"},
                new Object[]{"2.9090*1+3-1.123+5/3",    "8.0917177724"},
                new Object[]{"2    +1",    "3"}
        };
    }

    @Test
    @Parameters(method = "scenarios_for_calculation")
    public void simpleSuccessfullCalculation(String calculationString, String result) {
        ICalculator simpleCalculator = CalculatorFactory.getCalculator(1);
        BigDecimal calculationResult = simpleCalculator.calculate(calculationString);
        assertThat(calculationResult.compareTo(new BigDecimal(result)), is(0));
    }

    public Object[] scenarios_for_unsuccessful_calculation() {
        return new Object[]{

                new Object[]{"2%1",    "2"},
                new Object[]{"2.9090$1+3-1.123+5/3",    "8.0917177724"}
        };
    }

    @Test(expected = NumberFormatException.class)
    @Parameters(method = "scenarios_for_unsuccessful_calculation")
    public void simpleUnsuccessfullCalculation(String calculationString, String result) {
        ICalculator simpleCalculator = CalculatorFactory.getCalculator(1);
        BigDecimal calculationResult = simpleCalculator.calculate(calculationString);

    }
}
