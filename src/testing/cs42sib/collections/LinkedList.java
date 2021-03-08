
package testing.cs42sib.collections;

/** required imports */
import java.io.Serializable;
import java.lang.reflect.Array;
/**
 * /**
 * LinkedList.java - an implementation of a linked list abstract (advanced)
 * data (dynamic) type (ADT) and useful methods, and could be "visualized" as:
 * 
 * <pre>
 *             +------+       +------+       +------+       +------+      
 *  null {---- |      | {---- |      | {---- |      | {---- |      |  
 *             | NODE |       | NODE |       | NODE |       | NODE |       
 *             |      |----}  |      |----}  |      |----}  |      |----} null  
 *             +------+       +------+       +------+       +------+      
 *                 ^                                           ^
 *                 |                                           |
 *                head                                        tail
 *
 * </pre>
 * 
 *
 * @author Ethan Alexander
 * @param <T>
 * @since Mar. 2, 2021,10:21:35 a.m.
 */
public class LinkedList <T> implements Serializable {

    /** Flag to indicate a search was not found */
    public final int NOT_FOUND = -1;
    
    /** Reference (link) to the first (front) node in the list (entry point) */
    private Node head;
    
    /** Reference (link) to the last (back) node in the list (entry point) */
    private Node tail;
    
    /** The number of nodes in the list, immutable property */
    private int length;
    
    /** the longest "word" size of the largest node data */
    public int longestWord;


    /**
     * Default constructor, set class properties
     */
    public LinkedList() {
        finalize();
    }
    
    /**
     * Frees up all memory used by this object
     */
    @Override
    public void finalize(){
        length = 0;
        head = tail = null;
        System.gc();
    }
    
    /**
     * Determines if the list is empty (no content)
     * 
     * @return is empty (true) or not empty (false)
     */
    public boolean isEmpty(){
        return length == 0;
    }
    
    public int size(){
        return length;
    }
    
    public boolean addFront(T data){
        if(data == null) return false;
        Node<T> node = new Node<>(data);
        
        //senerios to consider
        // 1. empty list
        // 2. list of one or more nodes
        if(isEmpty()){
            head = tail = node;
        }
            
        else{
            node.next = head;
            head.previous = node;
            head = node;
        }
        length ++;
        return true;
    }
    
    public boolean addBack(T data){
        if(data == null) return false;
        Node<T> node = new Node<>(data);
        
        //senerios to consider
        // 1. empty list
        // 2. list of one or more nodes
        if(isEmpty()){
            head = tail = node;
        }
            
        else{
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
        length ++;
        return true;
    }
    
     /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        if (isEmpty()) return "Empty LinkedList";       // no nodes to display
        String text = "Linked List [";                  // starting character
        Node current = head;                            // start at head node
        while (current.next != null) {                  // traverse list
            text += current.toString() + ",";           // append data
            current = current.next;                     // move to next node
        }            
        return text + current.toString() + "]";         // append end character      
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        LinkedList<T> that = (LinkedList<T>)object;     // cast object to list
        if (this.size() != that.size()) return false;   // not same sizes      
        Node current1 = this.getFirstNode();            // get reference to
        Node current2 = that.getFirstNode();            // nodes in each list    
        while (current1 != null) {                      // traverse lists
            if (!current1.equals(current2)) {           // not equal data 
                return false;                           // not equal lists
            }                
            current1 = current1.next;                   // move each reference
            current2 = current2.next;                   // to next node
        }
        return true;                                    // lists are equal
    }
        
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public LinkedList clone() {
        LinkedList<T> list = new LinkedList<>();    // create new list memory
        for (int i = 0; i < length; i++) {          // traverse list
            list.addBack((T)this.getNode(i).data);  // get and add node data          
        }        
        return list;                                // new list returned
    }
    
    /**
     * Accessor Method
     * 
     * @param index
     * @return 
     */
    public T get(int index){
        if(!inRange(index))return null;
        return (T) getNode(index).data;
        
        
    }
            
    public boolean set(int index, T data){
        if (!inRange(index)) return false;
        if(data == null ) return false;
        Node current = getNode(index);
        return current.data;
                
    }
    
    
    
    
    
    
    
    
    protected Node getFirstNode() {
        return head;
    }
    
    
    protected Node getLastNode() {
        return tail;
    }
    
    protected Node getNode(int index) {
        if(!inRange(index))     return null;
        if(index == 0)          return getFirstNode();
        if(index == -1)         return getLastNode();
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
    
    private boolean inRange(int index){
        if(isEmpty()) return false;
        if(index < 0) return false;
        if(index >= length) return false;
        return true;
    }
        
    
    
    
    
}

