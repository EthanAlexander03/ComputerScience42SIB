
/** required package class namespace */
package testing.cs42sib;

/** required imports */
import collections.LinkedList;
import io.Simulator;
import tools.Numbers;
import tools.Search;
import tools.Sort;
import tools.Text;


/**
 * SearchSortTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class SearchSortTest 
{

    /**
     * Default constructor, set class properties
     */
    public SearchSortTest() {
        Simulator.header("Searching and Sorting Test started...");
                
        // For the I.B. Exam, you only need to know:
        Simulator.comment("For the I.B. Exam, you only need to know:");
        // Search: linear (sequential) search and binary search
        Simulator.comment("Search: linear search and binary search");
        // Sort: bubble sort and the selection sort
        Simulator.comment("Sort: bubble sort and the selection sort");
        
        // Create some constants for the data
        Simulator.comment("Create some constants for the data");
        
        final int MIN      = 0;
        final int MAX      = 10;
        final int LARGEST  = MAX;
        final int SMALLEST = MIN;
        
        Numbers numbers = new Numbers();
        
        // Create some random data to search through and sort
        Simulator.comment("Create some random data to search through and sort");
        // Including all "edge" cases to test for (using unit testing)
        Simulator.comment("Including edge cases to test");
        
        int[] array    = numbers.random(SMALLEST, LARGEST, MAX);
        int randomItem = numbers.random(SMALLEST, LARGEST);
        int itemInList = array[numbers.random(MIN+1, MAX-2)];
        int firstItem  = array[0];
        int lastItem   = array[MAX-1];
        int notInList  = LARGEST + 1;
        
        int[] findItems = {
            randomItem,
            itemInList,
            firstItem,
            lastItem,
            notInList
        };
        
        // Create data to store the results...
        Simulator.comment("Create data to store the results...");
        
        boolean found  = false;
        int     index  = -1;
        int[]   sorted = new int[MAX];
        
        // The simpliest of searches
        Simulator.comment("The simpliest of searches");
        
        found = search(array,randomItem);
                
        // Now the linear (sequential) search on all test data
        Simulator.comment("Now the linear search on all test data");
        
        for (int i = 0; i < findItems.length; i++) {
            index = linearSearch(array,findItems[i]);        
            results(array, findItems[i], index);
        }
        
        // Simple sort...  
        Simulator.comment("Simple sort...");
        //sort(array);
        
        // Now execute the bubble sort (named after bubbles rising from water)
        Simulator.comment("Now bubble sort (from bubbles rising from water)");
        
        sorted = bubbleSort(array);
        results(array, sorted);
        
        // Now execute the selection sort (named after selecting the smallest)
        Simulator.comment("Now selection sort (from selecting the smallest)");
        
        sorted = selectionSort(array);
        results(array, sorted);
               
        // Now the binary search (named after "two" or "dividing")
        // NOTE: binary search can only happen on a sorted list
        
        // Redo some of the test data...
        
        findItems[1] = sorted[numbers.random(MIN+1, MAX-2)];
        findItems[2] = sorted[0];
        findItems[3] = sorted[MAX-1];
        
        for (int i = 0; i < findItems.length; i++) {
            index = binarySearch(sorted,findItems[i]);
            results(sorted, findItems[i], index);
        }
        
            // use class for searching and sorting
            // create objects to help
            
            Text text = new Text();
            Search search = new Search();
            Sort sort = new Sort();
            
            // create random linked list data
            // include all edge cases to test
            
            LinkedList<String> unsortedWords = text.randomList(MAX);
            LinkedList<String> sortedWords = new LinkedList<>();
            
            // Place all test cases into another linked list 
            LinkedList<String> testCases = new LinkedList<>();

            String randomWord = text.randomWord();
            String inListWord = unsortedWords.get(numbers.random(MIN+1, MAX-2));
            String firstWord = unsortedWords.front();
            String lastWord = unsortedWords.back();
            String notWord = "Wachs";
            
            testCases.add(randomWord);
            testCases.add(inListWord);
            testCases.add(firstWord);
            testCases.add(lastWord);
            testCases.add(notWord);
            
            // now the linear search on all the test data ...
            
            for (int i = 0; i < testCases.size(); i++) {
            String word = testCases.get(i);
            index = search.linear(word, unsortedWords);
                System.out.println("Linear:" +      "\t" +
                        unsortedWords.toString() +  "\t" +
                        "word: " + word +           "\t" + 
                        "index: " + index);
        }
            
            //Now sort the list...
            
            //Bubble
            
            sortedWords = unsortedWords.clone();
            sort.bubble(sortedWords);
            System.out.println("Bubble before: \t" + unsortedWords.toString());
            System.out.println("Bubble after: \t" + sortedWords.toString());
            
            
        Simulator.header("Searching and Sorting Test completed!");
    }
    
    /**
     * Displays the results of a search
     * 
     * @param array the array to search through
     * @param item the item to search for
     * @param index which array index it was found at (or -1 if not found)
     */
    private void results(int[] array, int item, int index) {
        Text display = new Text();
        String text = "";
        text += "Array " + display.toString(array);
        text += "\n\tSearching for:\t " + item;
        text += "\n\tLocation index:\t " + index;
        System.out.println(text);
    }

    /**
     * Displays the results of a sort
     * 
     * @param array the original array
     * @param sorted the sorted array
     */
    private void results(int[] array, int[] sorted) {
        Text display = new Text();
        String text = "";
        text += "Original Array \t" + display.toString(array);
        text += "\nSorted Array \t"   + display.toString(sorted);
        System.out.println(text);
    }

    /**
     * A simple search, determines if the item is in the array or not
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return found (true) or not (false)
     */
    private boolean search(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return true;
            }
        }
        return false;
    }

    /**
     * An implementation of a linear search (sequential search) algorithm. It 
     * will find the first occurance of an item in the array and return the
     * index where it found it, or a -1 if not found
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return the first index found at, or a -1 if not found
     */
    private int linearSearch(int[] array, int item) {
        // Catch a potential error before we begin
        if (array == null) return -1;
        // Traverse the array
        for (int i = 0; i < array.length; i++) {
            // If I encounter the item
            if (array[i] == item) {
                // Return the spot I found it at (and stop)
                return i;
            }
        }
        // Make it through the entire list, never find it, return
        // a "flag" value indicating not found
        return -1;
    }

    /**
     * A simple sort, it will sort the array into ascending order
     * 
     * @param array the array of items to sort 
     */
    private void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {            
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    int temp   = array[j];
                    array[j]   = array[j+1];
                    array[j+1] = temp;
                }                    
            }            
        }
    }

    /**
     * An implementation of a bubble sort algorithm it will sort the array into  
     * ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] bubbleSort(int[] array) {
        // Create a new array, same size as the passed array
        int[] sorted = new int[array.length];
        // Make it a copy of that original
        System.arraycopy(array, 0, sorted, 0, array.length);        
        // Sort the copy, using the bubblesort algorithm...        
        // We need to traverse the array aas many times as there are items in
        // that array (n items, for example array size 10, n =10)        
        for (int times = 0; times < sorted.length; times++) {
            // Nested for loop, to traverse the entire array up to the
            // second last spot
            for (int i = 0; i < sorted.length - 1; i++) {
                // Check  each item and the item after it
                int item1 = sorted[i];
                int item2 = sorted[i+1];
                // Now check
                if (item1 > item2) {
                    // Swap them
                    sorted[i]   = item2;
                    sorted[i+1] = item1;
                }                                
            }
        }
        return sorted;
    }

    /**
     * An implementation of a selection sort algorithm it will sort the array   
     * into ascending order
     * 
     * @param array the array of items to sort
     */
    private int[] selectionSort(int[] array) {
        // Create a new array, same size as the passed array
        int[] sorted = new int[array.length];
        // Make it a copy of that original
        System.arraycopy(array, 0, sorted, 0, array.length);        
        // Sort that array using the selection sort algorithm...
        // Traverse the entire array
        for (int i = 0; i < sorted.length; i++) {
            // Track the lowest index, assume it's the first spot
            int lowest = i;
            // Nested inner for loop, starts at one over from current position
            // of the outer for loop used to find the lowest spot
            for (int j = i+1; j < sorted.length; j++) {
                int item1 = sorted[j];
                int item2 = sorted[lowest];
                // check the spots
                if (item1 < item2) {
                    // found a new low
                    lowest = j;
                }
            }
            // Outside the inner loop, now that we have the lowest spot, swap
            // the content of the lowest spot with the current spot i
            if (lowest != i) {
                int temp       = sorted[i];
                sorted[i]      = sorted[lowest];
                sorted[lowest] = temp;
            }
        }
        return sorted;
    }

    /**
     * An implementation of a binary search algorithm. It will find the first 
     * occurance of an item in the array and return the index where it found 
     * it, or a -1 if not found
     * 
     * @param array an array to search through
     * @param item the item to search for
     * @return the first index found at, or a -1 if not found
     */
    private int binarySearch(int[] array, int item) {
        // Track the low and high indices of the array with "markers"
        int high = array.length - 1;
        int low  = 0;        
        // Loop while the markers are not collapsed on themselves
        while (low <= high) {         
            // find (calculate) the middle between low and high
            int mid = (high + low) / 2;            
            // check if found
            if (array[mid] == item) return mid;            
            // check if the spot I'm at is bigger than item
            else if (array[mid] > item) high = mid - 1;            
            // check if the spot I'm at is smaller than item
            else if (array[mid] < item) low = mid + 1;            
        }        
        return -1;  // not found!        
    }
}