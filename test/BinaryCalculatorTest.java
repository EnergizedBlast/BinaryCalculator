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
    public void testBinaryAddTemp(){
        BinaryCalculator calculator = new BinaryCalculator();
        String result = calculator.add("111", "111");
        assertEquals(result,"1110");
    }
}
