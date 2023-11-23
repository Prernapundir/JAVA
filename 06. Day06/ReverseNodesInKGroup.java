class Solution {
    public ListNode reverse(ListNode head ,int count,int k){
        if(head==null || head.next==null || count>=k-1){
            return head;
        }

        ListNode node=reverse(head.next,count+1,k);
        head.next.next=head;
        head.next=null;

        return node;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode temp=head;

        while(count<k){
            if(temp==null) return head;
            temp=temp.next;
            count++;
        }
        ListNode node=reverse(head,0,k);
        head.next=reverseKGroup(temp,k);
        return node;
    }
}
