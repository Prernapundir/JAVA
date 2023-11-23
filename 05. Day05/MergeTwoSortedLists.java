class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode list=null;
        if(list1.val>=list2.val){
            list2.next=mergeTwoLists(list1,list2.next);
            list=list2;
        }else{
            list1.next=mergeTwoLists(list1.next,list2);
            list=list1;
        }

        return list;
    }
}
Console
