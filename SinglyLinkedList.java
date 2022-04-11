class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
    }
}
public class SinglyLinkedList{
    private Node Head;
    public void InsertAtBeginning(int data)
    {
        Node temp = new Node(data);
        temp.next = Head;
        Head = temp;
    }
    public void InsertAtTheEnd(int data)
    {
        Node temp = new Node(data);
        Node ptr = Head;
        while(ptr.next!=null)
        {
            ptr = ptr.next;
        }
        ptr.next = temp;
    }
    public void InsertAtIndex(int data,int position)
    {
        Node ptr = Head;
        Node temp = new Node(data);
        if(position == 1)
        {
            temp.next = Head;
            Head = temp;
        }     
        else
        {
            for(int i=1;i<position-1;i++)
            {
                ptr = ptr.next;
                if(ptr == null)
                {
                    return;
                }
            }
            temp.next = ptr.next;
            ptr.next = temp;
        }

    }
    void DeleteAtBeginning()
    {
        if(Head==null)
        {
            return;
        }
        else
        {
            int data = Head.data;
            Head = Head.next;
            System.out.println("Deleted Node From Beginning "+ data);
        }
    }
    void DeleteAtEnd()
    {
        if(Head == null)
        {
            return;
        }
        else
        {
            Node ptr = Head;
            while(ptr.next.next!=null)
            {
                ptr = ptr.next;
            }
            int data = ptr.next.data;
            ptr.next = null;
            System.out.println("Deleted Node From End "+ data);
        }
    }
    void DeleteAtIndex(int index)
    {
        if(Head == null)
        {
            return;
        }
        else
        {
            Node ptr = Head;
            if(index==1)
            {
                Head = Head.next;
            }
            else
            {
                for(int i=0;i<index-1;i++)
                {
                    ptr = ptr.next;
                }
                if(ptr.next == null)
                {
                    DeleteAtEnd();
                    return;
                }
                ptr.data = ptr.next.data;
                ptr.next = ptr.next.next;
            }
        }
    }
    public void Print()
    {
        Node ptr = Head;
        while(ptr!=null)
        {
            System.out.print(ptr.data+"  ");
            ptr = ptr.next;
        }
        System.out.println();
    }
    public void Helper(Node p)
    {
        if(p==null)
        {
            return;
        }
        Helper(p.next);
        System.out.print(p.data + " ");
    }
    public void PrintReverse()
    {
        Node ptr = Head;
        Helper(ptr);
        System.out.println();
    }

     public static void main(String args[])
         {
             SinglyLinkedList list = new SinglyLinkedList();  
             list.InsertAtBeginning(100);
             list.InsertAtBeginning(200);
             list.InsertAtTheEnd(900);
             list.InsertAtIndex(400,1);      
             list.Print();   
             list.PrintReverse();  
         }
}