
package collections;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * Stack.java - description
 *
 * @author Ethan Alexander
 * @since Mar. 15, 2021,10:00:35 a.m.
 */
public class Stack <T> implements Serializable
{

    
    
    private Node top;
    
    private int length;


    /**
     * Default constructor, set class properties
     */
    public Stack() {
        finalize();
    }
     
    public final void finalize(){
        length = 0;
        top = null;
        System.gc();
    }
    
    public int size(){
        return length;
    }
     ///////////////////////////////////////////////////
    // START
    ///////////////////////////////////////////////////
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param list the LinkedList to set the stack to
     */
    public Stack(LinkedList<T> list) {
        finalize();                                     // wipe any current data
        for (int i = list.size()-1; i >= 0; i--) {      // traverse list
            T data = (T)list.get(i);                    // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param array the array to set the stack to
     */
    public Stack(T[] array) {
        finalize();                                     // wipe any current data
        for (int i = array.length-1; i >= 0; i--) {     // traverse array
            T data = (T)array[i];                       // retrieve data
            push(data);                                 // push onto stack
        }
    }
    
    /**
     * Constructor sets class data to the parameter 
     * 
     * @param queue the queue to set the stack to
     */
//    public Stack(Queue queue) {
//        this(queue.toLinkedList());
//    }
    
    /**
     * Turns the stack into a ADT Queue object
     * 
     * @return the Stack as a ADT Queue
     */
//    public Queue toQueue() {
//        return new Queue(this);
//    }

    /**
     * Turns the stack into a ADT LinkedList object
     * 
     * @return the Stack as a ADT LinkedList
     */
    public LinkedList<T> toLinkedList() {
        LinkedList<T> list = new LinkedList<>();        // create new list
        Node current = top;                             // start at top node        
        while (current != null) {                       // traverse stack   
            T data = (T)current.data;                   // retrieve data
            list.add(data);                             // add to list
            current = current.next;                     // move to next node
        }
        return list;                                    // return list
    }
    
    /**
     * Returns an array that contains the same data as the list
     * 
     * @param array the data type array
     * @return an array of generic type T
     */
    public T[] toArray(T[] array) {
        array = (T[])(Array.newInstance(
                array.getClass().getComponentType(), 
                length));                               // create array 
        Node current = top;                             // start at top node 
        for (int i = 0; i < length; i++) {              // traverse array
            array[i] = (T)current.data;                 // retrieve data
            current = current.next;                     // move to next node
        }
        return array;                                   // return array
    }

    /**
     * Just "peeks" at the top of the stack without mutating (changing it) 
     * the structure of this stack
     * 
     * @return the data on the top
     */
    public T peek() {
        if (isEmpty()) return null;                     // no nodes in stack
        return (T)top.data;                             // return top data       
    }
    
    /**
     * Just "peeks" at top of stack without mutating the structure
     * 
     * @return the data on the top
     */
    public T top() {
        return peek();
    }
    
    ///////////////////////////////////////////////////
    // END
    ///////////////////////////////////////////////////
    
    
    
    /**
     * String representation of this object
     *
     * @return The object represented as a Sring
     */
    @Override
    public String toString() {
        if(isEmpty()) return "Empty Stack";
        else{
            String text = "Stack Top - > [";
            Node current = top;
            while(current.next != null){
                text += current.toString() + ",";
                current = current.next;
            }
            return text + current.toString() + "]";
        }
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Stack)) return false;   // check object type
        try {                                           // error trap
            Stack stack1 = ((Stack)object).clone();     // clone/cast parameter
            Stack stack2 = this.clone();                // clone this stack
            if (stack1.size() != stack2.size()) return false;   // not same size
            while (!stack2.isEmpty()) {                 // traverse stacks
                T data1 = (T)stack1.pop();              // retrieve data
                T data2 = (T)stack2.pop();
                if (!data1.equals(data2)) return false; // compare data
            }
            return true;                                // all tests passed
        }
        catch (ClassCastException | NullPointerException e) {
            return false;                               // cannot cast, or null
        }
    }
       
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public Stack clone() {
        
        Stack<T> that = new Stack<>();
        Node current = top;
        while(current != null){
            T data = (T)current;
            that.push(data);
            current = current.next;
        }
        Stack<T> copy = new Stack<>();
        while(!that.isEmpty()){
            T data = that.pop();
            copy.push(data);
        }
        return copy;
    }
    
    public boolean push(T data){
        
        if(data ==  null) return false;
        Node node = new Node(data);
        if(!isEmpty()) node.next = top;
        top = node;
        length++;
        return true;
    }
    
    public T pop(){
        
        if(isEmpty()) return null;
        else{
            length--;
            T data = (T)top.data;
            top = top.next;
            
            System.gc();
            return data;
        }
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
}

