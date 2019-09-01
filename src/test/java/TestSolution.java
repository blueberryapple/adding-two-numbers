import Models.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSolution {
    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void testAddTwoNumbers() {
        testSum(4, 1);
        testSum(0, 0);
        testSum(5, 5);
        testSum(9, 9);
        testSum(185, 148);
        testSum(500, 500);
        testSum(999, 1);
        testSum(1164, 70);
        testSum(20999, 1);
    }

    private void testSum(int summand1, int summand2) {
        Assert.assertEquals(
                ListNode.fromInt(summand1 + summand2),
                solution.addTwoNumbers(
                        ListNode.fromInt(summand1),
                        ListNode.fromInt(summand2)
                )
        );
    }
}
