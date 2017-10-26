
package queue;

//author 22cshafer
    //node class
public class Node {
    protected QueueString data; //instatiates QueueString object
    protected Node next; //instantiates next node for NodeList
    
        //constructors, setters/getters, etc
    Node(QueueString data, Node node) {
        this.data = data;
        this.next = node;
    }
    
    Node () {
        data = null;
        next = null;
    }

    public QueueString getData() {
        return data;
    }

    public void setData(QueueString data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public boolean equals(Node a) {
        if (this.data == a.data) {
            return true;
        }
        return false;
    }
    
    public int compareTo(Node a) {
        int x;
        x = this.data.compareTo(a.data);
        return x;
    }
    
    public void copy(Node a) {
        a.data = this.data;
    }
    
    @Override
    public String toString() {
        String info;
        info = (data.holder);
        return info;
    }
}
