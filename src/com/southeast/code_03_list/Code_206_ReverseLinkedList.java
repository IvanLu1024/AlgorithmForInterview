package com.southeast.code_03_list;

/**
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Code_206_ReverseLinkedList {
    public ListNode reverseList1(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;

        while(cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return pre;
    }

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }

        ListNode next=head.next;
        head.next=null;
        ListNode newNode=reverseList(next);
        next.next=head;
        return newNode;
    }
}
