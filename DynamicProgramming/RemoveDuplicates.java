package DynamicProgramming;

// import MergeSortedList.ListNode;

class ListNode{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode temp = head;
        ListNode t = head;
        while (t.next != null){
            if (temp.val == t.next.val){
                t = t.next;
                continue;
            }
            temp.next = t.next;
            temp = temp.next;
            t = t.next;
        }
        temp.next = null;
        return head;
    }
}
