import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParametrizesTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
    void testCase1(String arg) {
        Assertions.assertTrue(!arg.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})
    void testCase2(int number) {
        Assertions.assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3 (String input) {
        Assertions.assertTrue(!input.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringMethod")
    void testCase4(String arg){
        Assertions.assertNotNull(arg);
    }

    static String[] stringMethod() {
        String [] args = {"Java", "JS", "TS"};
        return args;
    }

    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 30, 50",
            "30, 40, 70"
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }
}
