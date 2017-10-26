/*
PROGRAM TO POPULATE AND MANAGE A QUEUE WITH USER-DRIVEN DATA, RECURSIVE METHODOLOGY,
AND ALL THE BELLS AND WHISTLES
*/
package queue;

//author 22cshafer
    //queue list class
public class NodeList {
    protected Node top; //head of queue
    protected Node bottom; //tail of queue
    protected int size; //size of queue
    
        //contructors, getters/setters, etc
    NodeList(Node top, Node bottom, int size) {
        this.top = top;
        this.bottom = bottom;
        this.size = size;
    }
    
    NodeList() {
        top = null;
        bottom = null;
        size = 0;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Node getBottom() {
        return bottom;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean equals(NodeList a) {
        if (this.top.data == a.top.data && this.bottom.data == a.bottom.data) {
            return true;
        }
        return false;
    }
    
    public int compareTo(Node a) {
        int x;
        x = this.top.data.compareTo(a.data);
        return x;
    }
    
    public void copy(Node a) {
        a.data = this.top.data;
    }
    
    @Override
    public String toString() {
        String info;
        info = (top.data.holder + " :queue: " + bottom.data.holder);
        return info;
    }
    
        //is empty
    public boolean isEmpty() {
        return (top == null);
    }
    
        //print size method
    public static void printSize(int size) {
        System.out.println("The size of your queue:\n" + size);
    }
    
        //enqueue method
    public void enqueue(String holder) {
        QueueString place = new QueueString(holder);
        Node temp = new Node(place, null);
        
        if (bottom == null) {
            bottom = temp;
            top = temp;
        } else {
            bottom.setNext(temp);
            bottom = bottom.getNext();
        }
        size++;
    }
    
        //dequeue method
    public String dequeue() {
        try {
            Node temp = top;
            top = temp.getNext();
            if (top == null) {
                bottom = null;
            }
            size--;
            return temp.getData().holder;
        } catch (Exception e) {
            System.out.println("-Empty Stack-\n");
        }
        String test = null;
        return test;
    }
    
        //allows user to peek at top of queue
    public void peekTop() {
        if (size == 0) {
            System.out.println("The head of your queue is:");
            System.out.print("-Empty Queue-\n");
        } else {
            System.out.println("The head of your queue is:\n" + top.getData());
        }
    }
    
        //allows user to peek at bottom of queue
    public void peekBottom() {
        if (size == 0) {
            System.out.println("The tail of your queue is:");
            System.out.print("-Empty Queue-\n");
        } else {
            System.out.println("The tail of your queue is:\n" + bottom.getData());
        }
    }
    
        //prints full queue
    public void display() {
        System.out.println("\nThe data in your queue from next to last: ");
        
        if (size == 0) {
            System.out.print("-Empty Queue-\n");
            return;
        }
        
        Node value = top;
        
        while (value != bottom.getNext()) {
            System.out.print(value.getData() + "\n");
            value = value.getNext();
        }
    }
    

}
