package fast_n_low_pointers;

import utils.Assurance;

public class LinkedListCycle {
  public static boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    var slow = head;
    var fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    } 

    return false;
  }
  public static void main(String[] args) {
    ListNode tail;
    // head = [3,2,0,-4], pos = 1
    var head1 = new ListNode(3);
    tail = head1.next = new ListNode(2);
    tail = tail.next = new ListNode(0);
    tail = tail.next = new ListNode(-4);
    
    tail.next = head1.next;

    Assurance.isEquals(hasCycle(head1), true);

    // head = [1], pos = -1
    var head2 = new ListNode(1);
    Assurance.isEquals(hasCycle(head2), false);
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
