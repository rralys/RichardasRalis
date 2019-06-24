package hw1;

// TODO Import does not found
import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestMultiplicationReturnsCorrectResults {

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
    public void MultiplicationOfLongsReturnsCorrectResult() {

        firstL = 25L;
        secondL = 12L;
        expResultL = 300L;

        assertEquals(calc.mult(firstL, secondL), expResultL);

    }

    @Test
    public void MultiplicationOfDoublesReturnsCorrectResult() {

        firstD = 12.5D;
        secondD = 3.5D;
        expResultD = 43.0D;

        assertEquals(calc.mult(firstD, secondD), expResultD);

    }

    @Test
    public void MultiplicationOfALongByZeroReturnsZero() {

        firstL = Long.MAX_VALUE;
        secondL = 0L;
        expResultL = 0L;

        assertEquals(calc.mult(firstL, secondL), expResultL);

    }

    @Test
    public void MultiplicationOfADoubleByZeroReturnsZero() {

        firstD = Double.MAX_VALUE;
        secondD = 0.0D;
        expResultD = 0.0D;

        assertEquals(calc.mult(firstD, secondD), expResultD);
    }
}
