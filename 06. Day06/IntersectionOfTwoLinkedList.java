public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1=headA;
        ListNode list2=headB;
        boolean flag1=false,flag2=false;

        while(list1!=null && list2!=null){
            if(flag1 && flag2 && list1==list2){
                return list1;
            }

            list1=list1.next;
            list2=list2.next;

            if(list1==null && !flag1){
                list1=headB;
                flag1=true;
            }

            if(list2==null && !flag2){
                list2=headA;
                flag2=true;
            }
        }
        return null;
    }
}
