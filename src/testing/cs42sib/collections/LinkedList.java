
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
 * @since Mar. 2, 2021,10:21:35 a.m.
 */
public class LinkedList {

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


//    /**
//     * Default constructor, set class properties
//     */
//    public LinkedList() {
//        
//    }
//     /**
//     * String representation of this object
//     *
//     * @return The object represented as a String
//     */
//    @Override
//    public String toString() {
//        if (isEmpty()) return "Empty LinkedList";       // no nodes to display
//        String text = "Linked List [";                  // starting character
//        Node current = head;                            // start at head node
//        while (current.next != null) {                  // traverse list
//            text += current.toString() + ",";           // append data
//            current = current.next;                     // move to next node
//        }            
//        return text + current.toString() + "]";         // append end character      
//    }
//        
//    /**
//     * Deep comparison, determines if two objects are "equal" in this context
//     *
//     * @param object the object to compare to
//     * @return the objects are "equal" (true) or not (false)
//     */
//    @Override
//    public boolean equals(Object object) {
//        LinkedList<T> that = (LinkedList<T>)object;     // cast object to list
//        if (this.size() != that.size()) return false;   // not same sizes      
//        Node current1 = this.getFirstNode();            // get reference to
//        Node current2 = that.getFirstNode();            // nodes in each list    
//        while (current1 != null) {                      // traverse lists
//            if (!current1.equals(current2)) {           // not equal data 
//                return false;                           // not equal lists
//            }                
//            current1 = current1.next;                   // move each reference
//            current2 = current2.next;                   // to next node
//        }
//        return true;                                    // lists are equal
//    }
//        
//    /**
//     * a Deep clone, creates a duplicate object using new memory
//     *
//     * @return a "clone" of the object using new memory
//     */
//    @Override
//    public LinkedList clone() {
//        LinkedList<T> list = new LinkedList<>();    // create new list memory
//        for (int i = 0; i < length; i++) {          // traverse list
//            list.addBack((T)this.getNode(i).data);  // get and add node data          
//        }        
//        return list;                                // new list returned
//    }
    
}

