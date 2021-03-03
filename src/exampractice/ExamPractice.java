
package exampractice;

import io.Simulator;

/**
 * ExamPractice.java - description
 *
 * @author Ethan Alexander
 * @since Feb. 25, 2021,9:57:36 a.m.
 */
public class ExamPractice {
    /**
     * Default constructor, set class properties
     */
    public ExamPractice() {
        Simulator.header("Ethan Alexander exam practice executing...");
        new MatrixProblem();
        new OnlineOrders();
        
        mystery(4);
        
        Simulator.header("Ethan Alexander exam practice terminating...");
    }
    
    public void mystery(int n){
        if(n > 0 && (n % 2 == 0)){
            System.out.println(n);
            mystery(n-2);
        }
        System.out.println(n);
    }
    
}

