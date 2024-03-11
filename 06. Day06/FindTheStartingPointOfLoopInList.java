
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                while(head!=fast){
                    head=head.next;
                    fast=fast.next;
                }
                return head;
            }
        }

        return null;
    }
}
