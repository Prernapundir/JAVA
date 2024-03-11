import java.awt.geom.FlatteningPathIterator;

public class Solution {
    public static Node flattenLinkedList(Node head) {
        if(head==null || head.next==null) return head;
        Node l1=head;
        Node l2=flattenLinkedList(head.next);
        Node temp=new Node();
        Node temp2=temp;

        while(l1!=null && l2!=null){
            if(l1.data>=l2.data){
                temp.child=l2;
                l2=l2.child;
            }else{
                temp.child=l1;
                l1=l1.child;
            }
            temp=temp.child;
        }
        if(l1==null) temp.child=l2;
        else temp.child=l1;

        return temp2.child;
    }
}
