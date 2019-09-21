import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinaryCalculatorTest {

    @Test
    public void testBinaryAdd(){
        BinaryCalculator calculator = new BinaryCalculator();
        int result = calculator.binaryAdd(1,2);
        assertEquals(result,3);
    }
}
