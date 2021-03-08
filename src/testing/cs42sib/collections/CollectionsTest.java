
package testing.cs42sib.collections;

import io.Simulator;

/**
 * CollectionsTest.java - description
 *
 * @author Ethan Alexander
 * @since Mar. 2, 2021,10:26:45 a.m.
 */
public class CollectionsTest {
    
     /**
     * Default constructor, set class properties
     */
    public CollectionsTest() {
        Simulator.header("Collections Test started...");
        
        // Create a node and change (mutate) its data..........................
        Simulator.comment("Create a node and change (mutate) its data");
        
        Node<String> a = new Node<>();
        a.data = "Hello";        
        
        // Create more nodes and the "links" between them......................
        Simulator.comment("Create more nodes and the 'links' between them");
        
        Node<String> b = new Node<>("Good-bye");        
        Node<String> c = new Node<>("Exist",a);
        
        // Use a 'double reference' to mutate data.............................
        Simulator.comment("Use a 'double reference' to mutate data ");
        
        c.next.data = "Hi";
        
        // Create a node connected to the other nodes..........................
        Simulator.comment("Create a node connected to the other nodes");
        
        Node<String> d = new Node<>("Die",b,c);
        d.previous.next.data = "Sup";
        
        // Output all nodes using overloaded toString method...................
        Simulator.comment("Output all nodes using overloaded toString method");
        
        System.out.println("Node a = " + a.toString());
        System.out.println("Node b = " + b.toString());
        System.out.println("Node c = " + c.toString());
        System.out.println("Node d = " + d.toString());
        
        // Test the clone method
        
        Node e = d.clone();
        Node f = c.clone();
        Node g = b.clone();
        Node h = a.clone();
        
        System.out.println("Node e = " + e.toString());
        System.out.println("Node f = " + f.toString());
        System.out.println("Node g = " + g.toString());
        System.out.println("Node h = " + h.toString());
        
        //Test equals method
        
        System.out.println(a.equals(h));
        System.out.println(b.equals(g));
        System.out.println(c.equals(f));
        System.out.println(d.equals(e));
        
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(c.equals(d));
        System.out.println(d.equals(h));
        
        // Test finalize.....
        
        a.finalize();
        System.out.println("Node a = " + a.toString());

        // create(instantitate) a Linked List object.....
        
        LinkedList<String> list1 = new LinkedList<>();
        
        // test the size and isEmpty methods...
        System.out.println("size = " + list1.size());
        System.out.println("is empty = " + list1.isEmpty());
        System.out.println(list1.toString());
        
        //add content to the front 
        System.out.println(list1.addFront("Tiger"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront("Quail"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront("Cockatoo"));
        System.out.println(list1.toString());
        System.out.println(list1.addFront(null));
        System.out.println(list1.toString());
        
        //add content to the front 
        System.out.println(list1.addBack("Whale"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack("Monkey"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack("Dog"));
        System.out.println(list1.toString());
        System.out.println(list1.addBack(null));
        System.out.println(list1.toString());
        
        // Test our get method (*accessor")
        for (int i = -1; i <= list1.size(); i++) {
           System.out.println("index " + i +" = " + list1.get(i)); 
        }
        
        System.out.println(list1.set(1, "Gorilla"));
        System.out.println(list1.toString());
      
        
        
        
        
        
        
        
        
        
        Simulator.header("Collections Test completed!");
     
    }
}
