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
        ListNode nextNode;
        int i = 0;
        int result = 0;
        while (next != null) {
            result += next.val * Math.pow(10, i);
            i++;
        }
        return result;
    }

    public static ListNode fromInt(int sum) {
        Stack<ListNode> nodeStack = getStackFromSum(sum);
        return getListNodeFromStack(nodeStack);
    }

    public static Stack<ListNode> getStackFromSum(int sum) {
        switch(sum) {
            case 0:
            case 1:
                Stack<ListNode> result = new Stack<>();
                result.push(new ListNode(sum));
                return result;
            default:
        }

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

    private static int extractDigitFromPlace(int sum, int i) {
        return (int) ((sum % (int) Math.pow(10, i) - sum % Math.pow(10, i - 1)) / (Math.pow(10, i-1)));
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
