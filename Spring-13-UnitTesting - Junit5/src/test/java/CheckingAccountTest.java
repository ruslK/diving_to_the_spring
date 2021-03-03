import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckingAccountTest {

    CheckingAccount ca;

    @BeforeEach
    void setUp() {
        ca = new CheckingAccount();
        ca.setInfo(100, 1234567L, "Ruslan");
    }

    @Test
    @Order(1)
    void deposit() {
        assertEquals(200, ca.deposit(100));
    }

    @Test
    @Order(2)
    void withdraw() {
        assertEquals(80, ca.withdraw(20));
    }

    @Test
    @Order(3)
    void purchase() {
        assertEquals(-65, ca.purchase("Shoes", 130));
    }

    @Test
    void withDraw_branch() {
        assertThrows(IllegalArgumentException.class, () -> {
            ca.withDraw_branch(6000, false);
        });
    }
}