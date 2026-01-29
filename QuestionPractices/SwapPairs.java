package QuestionPractices;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode p1 = prev.next;       // first node
            ListNode p2 = p1.next;         // second node

            // ---- SWAP ----
            p1.next = p2.next;
            p2.next = p1;
            prev.next = p2;
            // --------------

            prev = p1; // move prev to end of swapped pair
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        
    }
}
