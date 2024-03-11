

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Node temp=head;
        while(temp!=null){
            Node node=new Node(temp.val);
            node.next=temp.next;
            temp.next=node;
            temp=node.next;
        }
        temp=head;
        while(temp!=null){
            temp.next.random=temp.random==null?null:temp.random.next;
            temp=temp.next.next;
        }
        temp=head;
        Node copy=temp.next;
        Node ans=copy;

        while(temp!=null && copy!=null){
            temp.next=temp.next==null?null:temp.next.next;
            copy.next=copy.next==null?null:copy.next.next;
            copy=copy.next;
            temp=temp.next;
        }
        return ans;
    }
}
