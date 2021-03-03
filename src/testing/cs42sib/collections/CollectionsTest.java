
package testing.cs42sib.collections;

/**
 * CollectionsTest.java - description
 *
 * @author Ethan Alexander
 * @since Mar. 2, 2021,10:26:45 a.m.
 */
public class CollectionsTest {
    
    public CollectionsTest() {
        Node<String> a = new Node<>();
        a.data = "Hello";
        Node<String> b = new Node<>("Bye");
        Node<String> c = new Node<>("Book",a);
        c.next.data = "HI";
        Node<String> d = new Node<>("can",b,c);
        d.previous.next.data.equals("sup");
        
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println(d.toString());
        
    }
     
    
    
}

