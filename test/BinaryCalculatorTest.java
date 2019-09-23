import main.model.BinaryCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryCalculatorTest {

    @Test
    public void testBinaryAdd(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.add("1010", "100");
        assertEquals(result,"1110");
    }

    @Test
    public void testBinarySubtract(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.subtract("10000", "1000");
        assertEquals(result,"1000");
    }
    @Test
    public void testBinaryMultiply(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.multiply("100", "100");
        assertEquals(result,"10000");
    }
    @Test
    public void testBinaryDivide(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.divide("11110", "00011");
        assertEquals(result,"1010");
    }
}
