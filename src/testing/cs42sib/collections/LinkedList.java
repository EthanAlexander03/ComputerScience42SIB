
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
        LinkedList<T> copy = new LinkedList<>();    // create new list memory
        for (int i = 0; i < length; i++) {          // traverse list
            copy.addBack((T)this.getNode(i).data);  // get and add node data          
        }        
        return copy;                                // new list returned
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
        current.data = data;
        return true;
                
    }
    
    public T front(){
//        return head.data;
//        return (T) getFirstNode().data;
        return get(0);
    }
    
    public T back(){
//        return getLastNode().data;
//        return tail.data;
//        return get(size() - 1);
        return get(length - 1);
    }
    
    public T removeFront(){
        
        if(isEmpty()) return null;
        T data = front();
        if(length == 1) finalize();
        else {
            head = head.next;
            head.previous.next = null;
            head.previous = null;
            length--;
            System.gc();
        }
        return data;
    }
    
    public T removeBack(){
        
        if(isEmpty()) return null;
        T data = back();
        if(length == 1) finalize();
        else {
            tail = tail.previous;
            tail.next.previous = null;
            tail.next = null;
            length--;
            System.gc();
        }
        return data;
    }
    
    /**
     * Checks (searches) if the specified data is inside the list
     * 
     * @param data the data to check for
     * @return data is in the list (true) or not (false)
     */ 
    public boolean contains(T data) {
        if (data == null) return false;         // invalid data to search for
        Node current = head;                    // start reference at head
        while (current != null) {               // traverse list
            if (current.data.equals(data)) {    // found first occurrence
                return true;                    // indicate found
            }
            current = current.next;             // move to next node
        }
        return false;                           // not found in list
    } 
    
    /**
     * Inserts data as a new node after the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert after
     * @return the operation was successful (true) or not (false)
     */
    public boolean addAfter(T data, int index) {
        if (data == null)    return false;              // invalid data to add
        if (!inRange(index)) return false;              // index out of range        
        if (index == length-1) return addBack(data);    // add to end of list
        Node<T> node = new Node<>(data);                // create node object
        Node current = getNode(index);                  // get to index spot
        node.next = current.next;                       // set proper references
        current.next.previous = node;
        current.next = node;
        node.previous = current;            
        length++;                                       // increase length
        return true;                                    // opperation successful
    }
    
    /**
     * Inserts data as a new node before the passed index
     * 
     * @param data the data type to insert
     * @param index the index location to insert before
     * @return the operation was successful (true) or not (false)
     */
    public boolean addBefore(T data, int index) {
        if (data == null)    return false;              // invalid data to add
        if (!inRange(index)) return false;              // index out of range        
        if (index == 0)      return addFront(data);     // add to start of list
        Node<T> node = new Node<>(data);                // create node object
        Node current = getNode(index);                  // get to index spot
        node.previous = current.previous;               // set proper references
        current.previous.next = node;
        current.previous = node;
        node.next = current;            
        length++;                                       // increase length
        return true;                                    // opperation successful
    }
    
    public boolean add(T data){
        return addBack(data);
    }
    
    public boolean add(T data, int index){
        return addBefore(data,index);
    }
    
    /**
     * Deletes the node at the specified index and mutates the list
     * 
     * @param index the index location to remove
     * @return the data at the specified index (or null)
     */
    public T remove(int index) {
        if (!inRange(index))   return null;             // not in range
        if (index == 0)        return removeFront();    // remove first
        if (index == length-1) return removeBack();     // remove last
        Node current = getNode(index); 
        current.next.previous = current.previous;       // change references
        current.previous.next = current.next;
        current.next = current.previous = null;        
        length--;                                       // reduce list length
        return (T)current.data;                         // return index data
    }
    
    /**
     * Finds the node matching the data at the first occurrence in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of first occurrence or -1 (NOT_FOUND)
     */
    public int firstIndexOf(T data) {
        if (data == null) return NOT_FOUND;     // null data rejected
        Node current = head;                    // start at head
        int index = 0;                          // start count at 0
        while (current != null) {               // traverse list
            if (current.data.equals(data)) {    // found first occurrence
                return index;                   // return location
            }
            current = current.next;             // advance to next node
            index++;                            // advance count
        }
        return NOT_FOUND;                       // data not found
    }
    
    /**
     * Finds the node matching the data at the last occurrence in the list
     * and returns it's index or -1 (NOT_FOUND) if not in the list
     * 
     * @param data the node data to search for
     * @return index of last occurrence or -1 (NOT_FOUND) 
     */
    public int lastIndexOf(T data) {
        if (data == null) return NOT_FOUND;     // null data rejected
        Node current = tail;                    // start at head
        int index = length-1;                   // start count at total nodes
        while (current != null) {               // traverse list
            if (current.data.equals(data)) {    // found last occurrence
                return index;                   // return location
            }
            current = current.previous;         // return to previous node
            index--;                            // decrease count
        }
        return NOT_FOUND;                       // data not found
    }
    
    /**
     * The number of instances this data occurs in the list
     * 
     * @param data the data to search for
     * @return the number of instances of the data
     */
    public int numberOf(T data) {
        if (data == null) return 0;             // reject null data
        int counter = 0;                        // start a counter
        Node current = head;                    // start at head of list
        while (current != null) {               // traverse list
            if (current.data.equals(data)) {    // item found in list
                counter++;                      // increase counter
            }
            current = current.next;             // advance to next node
        }
        return counter;                         // counter returned
    }
    
    /**
     * Accesses all occurrences of the passed data in the list and returns an
     * integer array containing all index values the data occurred at
     * 
     * @param data the data to search for
     * @return all indices location in an array or null if no indices
     */
    public int[] allIndices(T data) {
        if (data == null)    return null;       // reject null data
        if (!contains(data)) return null;       // no data in the list
        int size = numberOf(data);              // get number of occurrences
        int[] array = new int[size];            // create array 
        Node current = head;                    // start at head
        int counter = 0;                        // start counter
        for (int i = 0; i < length; i++) {      // traverse list
            if (current.data.equals(data)) {    // item encountered
                array[counter] = i;             // insert index into array
                counter++;                      // increase counter
                if (counter >= size) {
                    return array;
                }
            }
            current = current.next;             // move to next node
        }
        return array;                           // return completed array
    }
    
    /**
     * Deletes the first occurrence of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean remove(T data) {
        if (data == null) return false;         // nothing to remove
        int index = firstIndexOf(data);         // get first location
        if (index == NOT_FOUND) return false;   // not in list
        remove(index);                          // remove
        return true;                            // operation successful
    }
    
    /**
     * Deletes the last occurrence of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false) 
     */
    public boolean removeLast(T data) {
        if (data == null) return false;         // nothing to remove
        int index = lastIndexOf(data);          // get first location
        if (index == NOT_FOUND) return false;   // not in list
        remove(index);                          // remove
        return true;                            // operation successful
    }
    
    /**
     * Deletes all occurrences of the data in the list
     * 
     * @param data the node data to remove
     * @return the operation was successful (true) or not (false)
     */
    public boolean removeAll(T data) {
        if (data == null)    return false;      // nothing to remove
        if (!contains(data)) return false;      // not in list
        while(contains(data)) {                 // loop continuously
            remove(data);                       // removing the data
        }
        return true;                            // operation successful
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

