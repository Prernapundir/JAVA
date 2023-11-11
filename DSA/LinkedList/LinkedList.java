public class LinkedList {
    public class Node{
        int data;
        Node next;
        Node(){};
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head;
    private int size=0;

    public void insertAtFront(int data){
        Node newNode=new Node(data);
        newNode.next=head;
        head=newNode;
        size++;
    }

    public void insertAtLast(int data){
        if(head==null) insertAtFront(data);
        else{
            Node newNode=new Node(data);
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
            size++;
        }
    }

    public void insertAtMid(int data,int index){
        if(index==0) insertAtFront(data);
        else if(index==size) insertAtLast(data);
        else{
            int k=0;
            Node temp=head,prev=null;
            while(k!=index){
                k++;
                prev=temp;
                temp=temp.next;
            }
            Node newNode=new Node(data);
            prev.next=newNode;
            newNode.next=temp;
            size++;
        }
    }

    public void deleteFromHead(){
        if(size==0){
            System.out.println("LinkedList is empty!");
        }else{
            head=head.next;
            size--;
        }
    }

    public void deleteFromEnd(){
        if(size==0){
            System.out.println("LinkedList is empty!");
        }else{
            Node temp=head;
            while(temp.next.next!=null){
                temp=temp.next;
            }
            temp.next=null;
            size--;
        }
    }

    public void deleteFromMid(int index){
        if(index==0) deleteFromHead();
        else if(index==size) deleteFromEnd();
        else{
            int k=0;
            Node temp=head,prev=null;
            while(k!=index){
                k++;
                prev=temp;
                temp=temp.next;
            }
            prev.next=temp.next;
            size--;
        }
    }

    public void reverseIterative(){
        Node curr=head,prev=null,next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public void reverseRecur(){
        Node node=reverseRecursive(head);
        head=node;
    }

    private Node reverseRecursive(Node head){
        if(head==null || head.next==null) return head;
        Node node=reverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return node;
    }

    public void mergeLists(LinkedList l1,LinkedList l2){
        Node node=merge(l1.head,l2.head);
        display(node);
    }

    private Node merge(Node l1,Node l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        if (l1.data>l2.data){
            l2.next=merge(l1,l2.next);
            return l2;
        }

        l1.next=merge(l1.next,l2);
        return l1;
    }

    public void display(){
        display(head);
    }

    private void display(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();

        linkedList.insertAtFront(30);
        linkedList.insertAtFront(20);
        linkedList.insertAtFront(10);
        linkedList.display();

        linkedList.insertAtLast(40);
        linkedList.insertAtLast(50);
        linkedList.display();

        linkedList.insertAtMid(70,2);
        linkedList.display();

        linkedList.deleteFromHead();
        linkedList.display();

        linkedList.deleteFromEnd();
        linkedList.display();

        linkedList.deleteFromMid(2);
        linkedList.display();

        linkedList.reverseIterative();
        linkedList.display();

        linkedList.reverseRecur();
        linkedList.display();

        LinkedList linkedList2=new LinkedList();
        linkedList2.insertAtFront(3);
        linkedList2.insertAtFront(2);
        linkedList2.insertAtFront(1);

        linkedList2.display();
        linkedList.display();

        linkedList.mergeLists(linkedList2,linkedList);
    }
}

