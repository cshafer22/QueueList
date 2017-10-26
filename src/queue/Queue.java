
package queue;

import java.util.*;

//author 22cshafer
public class Queue {

        //main method creating a new queue only
    public static void main(String[] args) {
        System.out.println("--CREATING NEW QUEUE--");
        createQueue();
    }
    
        //create queue method handles the switch board
    public static void createQueue() {
        Scanner scantron = new Scanner(System.in); //instantiates scanner
        NodeList queue = new NodeList(); //instantiates queue
        controlSwitch(queue, scantron); //handles enqueue and dequeue methods
        finish(queue, scantron); //ends process with recursive restart option
    }
    
        //final method with potential recursive restart
    public static void finish(NodeList list, Scanner scantron) {
            //prompt to get user input
        System.out.print("Done? (y or n or + to start over): ");
        String test = scantron.nextLine();
        
            //if else loop tests : y = end program : n = return to control panel :
            //+ = erase queue and starts over : default = handle error with recursive reboot 
        if (test.equals("y") || test.equals("Y")) {
            return;
        } else if (test.equals("N") || test.equals("n")) {
            controlSwitch(list, scantron);
            finish(list, scantron);
        } else if (test.equals("+")) {
            
                //if loop to prompt whether or not user wants to erase and start over
                //n = recursive return to finish loop : y = start new queue : default = handle error with recursive reboot
            System.out.print("Are you sure you want to create a new queue? (y or n): ");
            String temp = scantron.nextLine();
            if (temp.equals("n") || temp.equals("N")) {
                finish(list, scantron);
            } else if (temp.equals("y") || temp.equals("Y")) {
                System.out.println("--CREATING NEW QUEUE--");
                createQueue();
            } else {
                System.out.println("There was an error. Please try again.");
                finish(list, scantron);
            }
                //end internal if else loop
            
        } else {
            System.out.println("There was an error. Please try again.");
            finish(list, scantron);
        } //end external if else loop
    }
    
        //control switchboard handles methods of enqueueing and dequeueing the queue
    public static void controlSwitch(NodeList list, Scanner scantron) {
        populateQueue(list, scantron); //enqueue
        
        editQueue(list, scantron); //dequeue
        
        list.display(); //display
        list.printSize(list.size); //size
        list.peekTop(); //peek at top
        list.peekBottom(); //peek at bottom
        
    } 
    
        //enqueue
    public static void populateQueue(NodeList list, Scanner scantron) {
        String a;
        System.out.print("Number of items to place in queue: "); //asks user for input on how many to add to queue
        a = scantron.nextLine(); //accepts next line
        
            //tries catch block to turn line into integer
            //*****IT IS IMPORTANT TO PARSE STRING INTO INT INSTEAD OF
            //*****JUST TAKING .nextInt() VALUE BECAUSE OTHERWISE, OPEN
            //*****END OF LINE PROMPT DOES NOT CLOSE LEAVING ERROR IN THE
            //*****FORM OF ARTIFICIAL HEAD/TAIL ON QUEUE
        try {
            int b = Integer.parseInt(a);
        } catch (Exception e) {
            System.out.println("That was an invalid entry. Try again.");
            populateQueue(list, scantron); //recursively reboots if failure
        }
        
            //parses value as int
        int b = Integer.parseInt(a);
        
            //uses int as counter for while loop to iterate through user input adding to queue
        while (b > 0) {
            System.out.print("Enter the data for one object: ");
            list.enqueue(scantron.nextLine());
            b--;
        }
    }
    
        //dequeue
    public static void editQueue(NodeList list, Scanner scantron) {
        String a;
        System.out.print("Number of items to pull from queue: ");
        a = scantron.nextLine();
        
            //try catch block to parse int. see explanation in populateQueue() method
        try {
            int b = Integer.parseInt(a);
        } catch (Exception e) {
            System.out.println("That was an invalid entry. Try again.");
            editQueue(list, scantron);
        }
        
        int b = Integer.parseInt(a);
        
            //while loop with counter to dequeue list amount of times given by user
        while (b > 0) {
            list.dequeue();
            b--;
        }
    }
    
}
