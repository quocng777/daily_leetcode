package fast_n_low_pointers;

import utils.Assurance;

public class MiddleOfLinkedList {
  public static ListNode middleNode(ListNode head) {
    if (head == null) {
      return null;
    }

    var slow = head;
    var fast = head;

    while (fast != null && fast.next != null) { 
        slow = slow.next;
        fast = fast.next.next;
    }

    return slow;
  }
  public static void main(String[] args) {
    // [1,2,3,4,5]
    ListNode tail1;
    ListNode head1 = new ListNode(1);
    tail1 = head1.next = new ListNode(2);
    tail1 = tail1.next = new ListNode(3);
    tail1 = tail1.next = new ListNode(4);
    tail1 = tail1.next = new ListNode(5);

    System.err.println(middleNode(head1).val);
    Assurance.isEquals(3, middleNode(head1).val);

    tail1.next = new ListNode(6);
    Assurance.isEquals(4, middleNode(head1).val);
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
