package hw1;

// TODO Import does not found
import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestAddingReturnsCorrectSum {

    private Calculator calc;

    // TODO What is the purpose of these fields?
    private long firstL;
    private long secondL;
    private long expResultL;

    private double firstD;
    private double secondD;
    private double expResultD;

    // TODO Why do you decide use @BeforeSuite hook?
    @BeforeSuite
    public void setUp() {

        calc = new Calculator();

    }

    @Test
    public void AddingLongVariablesReturnsCorrectResult() {

        firstL = 25L;
        secondL = 78L;
        expResultL = 103L;

        assertEquals(calc.sum(firstL, secondL), expResultL);

    }

    @Test
    public void AddingDoubleVariablesReturnsCorrecrtResults() {

        firstD = 100.25D;
        secondD = 227.37D;
        expResultD = 327.62D;

        assertEquals(calc.sum(firstD, secondD), expResultD);

    }

    @Test
    public void AddingZeroToALongValueDoesNotChangeTheSum() {

        firstL = 100L;
        secondL = 0L;
        expResultL = 100L;

        assertEquals(calc.sum(firstL, secondL), expResultL);

    }

    @Test
    public void AddingZeroToADoubleValueDoesNotChangeTheSum() {

        firstD = 120.0D;
        secondD = 0.0D;
        expResultD = 120.0D;

        assertEquals(calc.sum(firstD, secondD), expResultD);

    }

    @Test
    public void AddingTwoLongNegativesReturnsCorrectResult() {

        firstL = -5L;
        secondL = -10L;
        expResultL = -15L;

        assertEquals(calc.sum(firstL, secondL), expResultL);
    }

    @Test
    public void AddingTwoDoubleNegativesReturnsCorrectResult() {

        firstD = -25.7D;
        secondD = -75.3D;
        expResultD = -101.0D;

        assertEquals(calc.sum(firstD, secondD), expResultD);

    }

}