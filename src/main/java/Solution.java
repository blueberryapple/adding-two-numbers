import Models.ListNode;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode candidate1 = l1;
        ListNode candidate2 = l2;

        ListNode result = null;
        ListNode cur = result;
        boolean overflow = false;

        while (candidate1 != null || candidate2 != null || overflow) {
            int sum = 0;

            if (candidate1 != null) {
                sum += candidate1.val;
                candidate1 = candidate1.next;
            }

            if (candidate2 != null) {
                sum += candidate2.val;
                candidate2 = candidate2.next;
            }

            if (overflow ) {
                sum += 1;
                overflow = false;
            }

            if (sum >= 10) {
                overflow = true;
                sum %= 10;
            }

            if (result == null) {
                result = new ListNode(sum);
                cur = result;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }
        return result;
    }
}
