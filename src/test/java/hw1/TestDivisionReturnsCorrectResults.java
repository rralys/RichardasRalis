package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestDivisionReturnsCorrectResults {

    private Calculator calc;

    private long firstL;
    private long secondL;
    private long expResultL;

    private double firstD;
    private double secondD;
    private double expResultD;

    @BeforeSuite
    public void setUp() {

        calc = new Calculator();

    }

    @Test
    public void DivisionOfLongByLongReturnsCorrectResult() {

        firstL = Long.MAX_VALUE;
        secondL = 25L;
        expResultL = Long.MAX_VALUE/25L;

        assertEquals(calc.div(firstL, secondL), expResultL);

    }

    @Test
    public void DivisionOfDoubleByDoubleReturnsCorrectResult() {

        firstD = Double.MAX_VALUE;
        secondD = 1.2E305;
        expResultD = Double.MAX_VALUE/1.2E305;

        assertEquals(calc.div(firstD, secondD), expResultD);

    }

    @Test
    public void DivisionOfANongByUnityReturnsItself() {

        firstL = Long.MAX_VALUE;
        secondL = 1;
        expResultL = Long.MAX_VALUE;

        assertEquals(calc.div(firstL, secondL), expResultL);

    }

    @Test
    public void DivisionOfADoubleByUnityReturnsItself() {

        firstD = 103.1D;
        secondD = 1.0;
        expResultD = 103.1D;

        assertEquals(calc.div(firstD, secondD), expResultD);

    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void DivisionALongByZeroThrowsException() {

        firstL = Long.MAX_VALUE;
        secondL = 0;
        expResultL = Long.MAX_VALUE;

        assertEquals(calc.div(firstL, secondL), expResultL);

    }

    @Test
    public void DivisionOfADoubleByZeroReturnsInfitnity() {

        firstD = Double.MAX_VALUE;
        secondD = 0.0D;
        expResultD = Double.POSITIVE_INFINITY;

        assertEquals(calc.div(firstD, secondD), expResultD);
    }

}
