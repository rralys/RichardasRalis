package hw1;

// TODO Import does not found
import com.epam.tat.module4.Calculator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestSubtractionReturnsCorrectResults {

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
    public void SubtractionLongValuesReturnsCorrectResult() {

        firstL = 10L;
        secondL = 13L;
        expResultL = -3L;

        assertEquals(calc.sub(firstL, secondL), expResultL);

    }

    @Test
    public void SubtractingDoubleValuesReturnsCorrectResults() {

        firstD = 12.5D;
        secondD = 27.3D;
        expResultD = -14.8D;

        assertEquals(calc.sub(firstD, secondD), expResultD);

    }

    @Test
    public void SubtractingZeroFromALongValueDoesNotChangeResult() {

        firstL = 27L;
        secondL = 0L;
        expResultL = 27L;

        assertEquals(calc.sub(firstL, secondL), expResultL);

    }

    @Test
    public void SubtractingZeroFromADoubleValueDoesNotChangeResult() {

        firstD = 100.7D;
        secondD = 0.0D;
        expResultD = 100.7D;

        assertEquals(calc.sub(firstD, secondD), expResultD);

    }

    @Test
    public void SubtractingLongNegativeMakesAPositive() {

        firstL = -25L;
        secondL = -152L;
        expResultL = 127L;

        assertEquals(calc.sub(firstL, secondL), expResultL);

    }

    @Test
    public void SubtractingDoubleNegativeMakesAPositive() {

        firstD = 100.3D;
        secondD = -122.7D;
        expResultD = 223.0D;

        assertEquals(calc.sub(firstD, secondD), expResultD);

    }
}
