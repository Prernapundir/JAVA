
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        int len=1;
        ListNode temp=head;
        while(temp.next!=null){
            temp=temp.next;
            len++;
        }
        k%=len;
        int t=len-k;
        temp.next=head;
        while(t>0){
            temp=temp.next;
            t--;
        }

        head=temp.next;
        temp.next=null;
        return head;
    }
}
