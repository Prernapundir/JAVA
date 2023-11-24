
class Solution {
    public ListNode reverse(ListNode head ){
        if(head==null || head.next==null){
            return head;
        }

        ListNode node=reverse(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }

    public ListNode middle(ListNode head){
        ListNode fast=head,slow=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null ) return true;

        ListNode middle=middle(head);
        ListNode rev=reverse(middle);
        ListNode l1=head,l2=rev;

        while(l1!=middle && l1.val==l2.val){
            l1=l1.next;
            l2=l2.next;
        }

        return l1==middle;
    }
}
