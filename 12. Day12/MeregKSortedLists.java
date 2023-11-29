class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode listNode:lists){
            if(listNode!=null)minHeap.add(listNode);
        }

        ListNode ans=new ListNode();
        ListNode temp=ans;
        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            if(node.next!=null){
                minHeap.add(node.next);
            }
            ans.next=node;
            ans=node;
        }

        return temp.next;
    }
}
