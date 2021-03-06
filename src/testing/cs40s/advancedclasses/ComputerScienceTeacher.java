
/** required package class namespace */
package testing.cs40s.advancedclasses;

 
/**
 * ComputerScienceTeacher.java - represents a CS teacher person
 *
 * @author Mr. Wachs
 * @since Oct. 21, 2019, 10:44:16 a.m.
 */
public class ComputerScienceTeacher extends Teacher
{

    /**
     * Default constructor, set class properties
     */
    public ComputerScienceTeacher() {
        
    }

    /**
     * String representation of this object
     *
     * @return The object represented as a String
     */
    @Override
    public String toString() {
        return "ComputerScienceTeacher: " + super.toString();
    }
    
    /**
     * Deep comparison, determines if two objects are "equal" in this context
     *
     * @param object the object to compare to
     * @return the objects are "equal" (true) or not (false)
     */
    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }
        
    /**
     * a Deep clone, creates a duplicate object using new memory
     *
     * @return a "clone" of the object using new memory
     */
    @Override
    public ComputerScienceTeacher clone() {
        return this;
    }

}
