import main.model.BinaryCalculator;
import org.junit.jupiter.api.Test;

class BinaryCalculatorTest {

    private void assertEquals(String result, String s) {
    }

    @Test
    void testBinaryAdd(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.add("1010", "100");
        assertEquals(result,"1110");
    }

    @Test
    void testBinarySubtract(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.subtract("10000", "1000");
        assertEquals(result,"1000");
    }
    @Test
    void testBinaryMultiply(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.multiply("100", "100");
        assertEquals(result,"10000");
    }
    @Test
    void testBinaryDivide(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.divide("11110", "00011");
        assertEquals(result,"1010");
    }

    @Test
    void testBinarySquared() {
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.squared("111");
        assertEquals(result, "0110001");
    }
    @Test
    void testBinarySqrt() {
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.sqrt( "1100100");
        assertEquals(result, "1010");
    }
}
