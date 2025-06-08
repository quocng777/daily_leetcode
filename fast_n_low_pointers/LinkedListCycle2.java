package fast_n_low_pointers;

import utils.Assurance;

public class LinkedListCycle2 {
  public static ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    var slow = head;
    var fast = head;

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      var res = fast;

      if (slow == fast) {
        while(slow != fast) {
          res = fast;
          slow = slow.next;
          fast = fast.next;
        }

        return res;
      }
    }

    return null;
  }
  public static void main(String[] args) {
    // head = [3,2,0,-4], pos = 1
    ListNode tail1;
    ListNode head1 = new ListNode(3);
    tail1 = head1.next = new ListNode(2);
    tail1 = tail1.next = new ListNode(0);
    tail1 = tail1.next = new ListNode(-4);
    tail1.next = head1.next;

    System.err.println(detectCycle(head1).val);
    Assurance.isEquals(tail1.val, detectCycle(head1).val);

  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
       val = x;
       next = null;
    }
 }  
}
