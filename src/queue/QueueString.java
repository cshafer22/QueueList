
package queue;

//author 22cshafer
    //queuestring class
public class QueueString {
    
    protected String holder; //instantiates string value within object
    
        //constructor, setters/getters, etc
    QueueString(String holder) {
        this.holder = holder;
    }
    
    QueueString () {
        holder = null;
    }

    public String getData() {
        return holder;
    }

    public void setData(String holder) {
        this.holder = holder;
    }
    
    public boolean equals(QueueString a) {
        if (this.holder == a.holder) {
            return true;
        }
        return false;
    }
    
    public int compareTo(QueueString a) {
        int x;
        x = this.holder.compareTo(a.holder);
        return x;
    }
    
    public void copy(QueueString a) {
        a.holder = this.holder;
    }
    
    @Override
    public String toString() {
        String info;
        info = (holder);
        return info;
    }
}
