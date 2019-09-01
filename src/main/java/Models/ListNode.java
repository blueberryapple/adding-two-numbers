package Models;

import java.util.Objects;
import java.util.Stack;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public int toInt() {
        ListNode nextNode = next;
        int i = 1;
        int result = val;
        while (nextNode != null) {
            result += nextNode.val * Math.pow(10, i);
            i++;
            nextNode = nextNode.next;
        }
        return result;
    }

    public static ListNode fromInt(int sum) {
        Stack<ListNode> nodeStack = getStackFromSum(sum);
        return getListNodeFromStack(nodeStack);
    }

    public static Stack<ListNode> getStackFromSum(int sum) {
        int numberOfNodes = (int) Math.ceil(Math.log10(sum + 1));
        Stack<ListNode> nodeStack = new Stack<>();

        for (int i = numberOfNodes; i > 0; i--) {
            nodeStack.push(
                    new ListNode(
                            extractDigitFromPlace(sum, i)
                    )
            );
        }
        return nodeStack;
    }

    // ex. extractDigitFromPlace(9516, 2)
    // onePlaceOff = 10^1 = 10
    // return (9516 % 100 - 9516 % 10) / 10 = (16 - 6) / 10
    //                                      = 10 / 10
    //                                      = 1.
    private static int extractDigitFromPlace(int sum, int i) {
        double onePlaceOff = Math.pow(10, i - 1);
        return (int) ((sum % (int) Math.pow(10, i) - sum % onePlaceOff) / onePlaceOff);
    }

    public static ListNode getListNodeFromStack(Stack<ListNode> nodeStack) {
        ListNode root = null;
        ListNode cur = root;
        while (!nodeStack.empty()) {
            ListNode newNode = nodeStack.pop();
            if (root == null) {
                root = newNode;
            } else {
                cur.next = newNode;
            }
            cur = newNode;
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
