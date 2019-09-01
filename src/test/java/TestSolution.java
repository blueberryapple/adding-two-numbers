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
        testSum(5, 4, 1);
        testSum(0, 0, 0);
        testSum( 10, 5, 5);
        testSum(18, 9, 9);
        testSum(333, 185, 148);
        testSum(1000, 500, 500);
        testSum(1000, 999, 1);
    }

    private void testSum(int sum, int summand1, int summand2) {
        Assert.assertEquals(
                ListNode.fromInt(sum),
                solution.addTwoNumbers(
                        ListNode.fromInt(summand1),
                        ListNode.fromInt(summand2)
                )
        );
    }
}
