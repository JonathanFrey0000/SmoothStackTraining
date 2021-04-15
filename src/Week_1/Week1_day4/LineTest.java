package Week_1.Week1_day4;
import static org.junit.jupiter.api.Assertions.*;
/**
 * @author  Jonathan Frey
 * Test class for Line class
 */
class LineTest {

    private Line line;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        line = new Line(1,1,2,2);
    }

    @org.junit.jupiter.api.Test
    void getSlope() {
        assertEquals(1, line.getSlope());
    }

    @org.junit.jupiter.api.Test
    void getDistance() {
        assertEquals(Math.sqrt(2), line.getDistance());
    }

    @org.junit.jupiter.api.Test
    void parallelTo() {
        Line line2 = new Line(2,2,3,3);
        assertEquals(true, line.parallelTo(line2));

    }
}