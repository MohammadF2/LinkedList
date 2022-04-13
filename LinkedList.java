import java.util.Locale;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;

    protected Node<T> getHead() {
        return head;
    }

    protected void setHead(Node<T> head) {
        this.head = head;
    }

    public void insert(T data){

        Node newNode = new Node<>(data);
        Node curr = head , prev = null;
        for ( ; (curr != null) && (newNode.getData().compareTo(curr.getData()) > 0);
              prev = curr , curr = curr.getNext() ) ;

        if(head == null){
            head = newNode;
        }
        else if(prev == null){
            newNode.setNext(head);
            head = newNode;
        }
        else if(curr==null){
            prev.setNext(newNode);
        }
        else{
            newNode.setNext(curr);
            prev.setNext(newNode);
        }
    }

    public void delete(T data){
        Node<T> prev = head;
        Node <T> curr = head.getNext();
        if(head == null){
            System.out.println("empty list");

        }
        if(head.getData() == data){
            head = head.getNext();

        }
        while(curr!=null){
            if(curr.getData() == data){
                prev.setNext(curr.getNext());
            }
            prev =curr;
            curr = curr.getNext();
        }
    }


    public int length() {
        int l = 0;
        Node<T> curr = head;
        while(curr != null){
            l++;
            curr = curr.getNext();
        }
        return l;
    }

    public void traversList(){
        traversList(head);
    }

    private void traversList(Node curr) {
        if(curr == head)
            System.out.print("head-->");

        if(curr == null)
            System.out.println("NULL");
        else {
            System.out.print("[" + curr + "]-->");
            traversList(curr.getNext());
        }
    }


    public void sortList()
    {
        Node current = head, index = null;
        T temp;
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.getNext();

                while (index != null) {

                    if (current.getData().compareTo(index.getData()) > 0) {
                        temp = (T) current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }

                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }


    public void flipList()
    {
        Node current = head, index = null;
        T temp;
        if (head == null) {
            return;
        }
        else {
            while (current != null) {
                index = current.getNext();

                while (index != null) {

                    if (current.getData().compareTo(index.getData()) < 0) {
                        temp = (T) current.getData();
                        current.setData(index.getData());
                        index.setData(temp);
                    }

                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }



    public Node search(T data){
        Node n = head;
        while(n!=null){
            if(n.getData() == data){
                return n;
            }
            else
                n = n.getNext();
        }
        System.out.print("Data not found [");
        return null;
    }


    public LinkedList<T> marge(LinkedList<T> list1, LinkedList<T> list2){
        LinkedList<T> marged = new LinkedList<T>();

        marged.setHead(margeListS(list1.getHead(),list2.getHead()));

        return marged;
    }



    private Node margeListS(Node A, Node B)
    {

        if(A == null) return B;
        if(B == null) return A;

        if(A.getData().compareTo(B.getData()) > 0)
        {
            A.setNext(margeListS(A.getNext(), B));
            return A;
        }
        else
        {
            B.setNext(margeListS(A, B.getNext()));
            return B;
        }

    }


/*
    public void travers(){
        System.out.print("Head-->");
        Node n = head;
        while(n!=null){

            System.out.print(n.getData()+"-->");
            n=n.getNext();
        }
        System.out.println("null");
    }

 */



}
