package Week_1.A1.Recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupSumClumpTest {

    private GroupSumClump obj;

    @Test
    void groupSumClump() {
        obj = new GroupSumClump();
        assertTrue(obj.groupSumClump(0, new int[]{2, 4, 8}, 12));
    }
}