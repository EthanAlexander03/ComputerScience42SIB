
package exampractice;

import java.util.Random;
import tools.Numbers;



/**
 * MatrixProblem.java - description
 *
 * @author Ethan Alexander
 * @since Feb. 25, 2021,10:05:45 a.m.
 */
public class MatrixProblem {

    int N = 6;
    int array[][] = new int[N][N];
    

    /**
     * Default constructor, set class properties
     */
    public MatrixProblem() {
        readArray(makeArray(N));
        
    }

    public int[][] makeArray(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            array[i][i] = random(1, N);
        }
        for (int i = 0; i < n-1; i++) {
            array[i][i+1] = random(i, N);
        }
        for (int i = 0; i < n-1; i++) {
            array[i+1][i] = random(i, N);
        }
        return array;
    }
    private void readArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            String line = "";
            for (int j = 0; j < array.length; j++) {
                line = line + array[i][j] + " ";
            }
            System.out.println(line);
        }
    }

    private int random(int min, int max) {
        int number = (int) ((Math.random() * ((max - min) + 1)) + min);
        return number;
    }
    
    
}

