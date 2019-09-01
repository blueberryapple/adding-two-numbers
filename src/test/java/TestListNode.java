import Models.ListNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class TestListNode {
    @Test
    public void testGetStackFromSum() {
        Stack<ListNode> stackFromSum = ListNode.getStackFromSum(5);
        int nodeValue = stackFromSum.pop().val;
        Assert.assertEquals(
                5,
                nodeValue
        );

        stackFromSum = ListNode.getStackFromSum(1);
        Assert.assertEquals(
                1,
                stackFromSum.pop().val
        );

        stackFromSum = ListNode.getStackFromSum(21);
        List<Integer> results = new LinkedList<>(stackFromSum).stream()
                .map(e -> e.val)
                .collect(Collectors.toList());

        Assert.assertEquals(
                Arrays.asList(2, 1),
                results
        );
    }

    @Test
    public void testListNodeFromInt() {
        ListNode node = ListNode.fromInt(5);
        Assert.assertEquals(
                new ListNode(5),
                node
        );

        node = ListNode.fromInt(21);
        ListNode testingListNode = new ListNode(1);
        testingListNode.next = new ListNode(2);

        Assert.assertEquals(
                testingListNode,
                node
        );

        node = ListNode.fromInt(999);
        testingListNode = new ListNode(9);
        testingListNode.next = new ListNode(9);
        testingListNode.next.next = new ListNode(9);
        Assert.assertEquals(
                testingListNode,
                node
        );

        node = ListNode.fromInt(100);
        testingListNode = new ListNode(0);
        testingListNode.next = new ListNode(0);
        testingListNode.next.next = new ListNode(1);
        Assert.assertEquals(
                testingListNode,
                node
        );
    }

    @Test
    public void testListNodeToInt() {
        ListNode listNode = new ListNode(5);
        Assert.assertEquals(
                5,
                listNode.toInt()
        );

        listNode = new ListNode(0);
        listNode.next = new ListNode(0);
        listNode.next.next = new ListNode(1);
        Assert.assertEquals(
                100,
                listNode.toInt()
        );

        listNode = new ListNode(5);
        listNode.next = new ListNode(6);
        listNode.next.next = new ListNode(9);
        Assert.assertEquals(
                965,
                listNode.toInt()
        );

        listNode = new ListNode(0);
        Assert.assertEquals(
                0,
                listNode.toInt()
        );
    }
}
