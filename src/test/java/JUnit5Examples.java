import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Examples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Action!");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Time to chill");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Starting");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Ending");
    }

    @Test
    void firstTest() {
        System.out.println("###    Test");
        assertTrue(3 > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###    Test2");
        assertFalse(3 > 2);
    }
}
