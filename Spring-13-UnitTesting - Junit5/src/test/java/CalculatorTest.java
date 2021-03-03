import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        assertEquals(20, 20);
    }

    @Test
    void tc1() {
        int act = Calculator.add(2, 2);
        assertEquals(4, act);
    }

    @Test
    void tc2() {
        int act = Calculator.add(2, 2);
        assertTrue(Calculator.operator.equals("add"));
    }

    @Test
    void tc3() {
        assertArrayEquals(new int[] {1, 2, 3}, new int[] {1, 2, 3});
    }

    @Test
    void tc4() {
        String nullString = null;
        String notNullString = "notNUll";

        assertNotNull(notNullString);
        assertNull(nullString);
    }

    @Test
    void tc5() {
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        assertNotSame(c1, c3);
        assertSame(c1, c2);
    }
}