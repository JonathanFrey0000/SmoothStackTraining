package Week_1.A1.Lambdas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerformOperationDemoTest {

    private PerformOperationDemo ob;
    private PerformOperation po;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        ob = new PerformOperationDemo();
    }

    @Test
    void isOdd() {
        po = ob.isOdd();
        assertTrue(ob.checker(po, 31));
    }

    @Test
    void isPrime() {
        po = ob.isPrime();
        assertTrue(ob.checker(po, 71));
    }

    @Test
    void isPalindrome() {
        po = ob.isPalindrome();
        assertTrue(ob.checker(po, 88988));
    }
}