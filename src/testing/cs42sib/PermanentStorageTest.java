/** required package class namespace */
package testing.cs42sib;

/**
 * required imports
 */
import collections.LinkedList;
import io.Dialogs;
import io.FileHandler;
import io.Simulator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javax.swing.JFileChooser;
import io.JFileChooser;
import javax.swing.JOptionPane;
import testing.testclass.TestClass;
import tools.Numbers;
import tools.Text;

/**
 * PermanentStorageTest.java - tests the concepts learned in this unit
 *
 * @author Mr. Wachs
 * @since Jan. 14, 2020, 8:01:03 a.m.
 */
public class PermanentStorageTest {

    /**
     * Default constructor, set class properties
     */
    public PermanentStorageTest() {
        Simulator.header("Permanent Storage Test started...");

//        Simulator.output("Hello World", true);
//        System.out.println("Hello World");
//        JOptionPane.showMessageDialog(null, "Hello World");
//        Simulator.comment("Here is a comment");
        Simulator.comment("Learn about error traps");

        try {

            int[] a = {1, 2, 3};
            a[5] = 0;

            double number = 3 / 0;
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error.toString());
        } catch (ArithmeticException error) {
            System.out.println("Math error");
        }

        Simulator.comment("Now some file handling");
        Simulator.comment("Create data to use");

        String[] poem = {
            "There once was a GME stock",
            "As it aged it sank like a rock",
            "A hedge fund wanted to profit",
            "But the stock rose like a rocket"
        };

        String word = "acolyte";

        String first = "C:\\Users\\e.alexander\\Desktop\\";
        String middle = "data";
        String last = ".txt";
        String name = first + middle + last;

        try {
            //creating instancees of file handling classes.
            //connect the 2 classses wiht the file name 
            FileWriter writer = new FileWriter(name);
            PrintWriter printer = new PrintWriter(writer);
            //now write to the file
            printer.println(word);

            printer.close();
        } catch (IOException e) {
            System.out.println("File write error");
        }

        Simulator.header("Permanent Storage Test completed!");

        //Now involve teh user in naming the file
        // get the file name from the user
        //Scanner scanner  = new Scanner(System.in);
        //name = scanner.nextLine();
        // System.out.println(name);
        //name = JOptionPane.showInputDialog("enter name");
        //use a fancier input dialog 
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(null);           //shows the dialog to the user

        //use a file class to work with as well
        File file = chooser.getSelectedFile();  //get the name from the user

        //check the file 
        if (file != null || file.exists()) {    //error check on the file 

            //now the try catch block...
            try {
                FileWriter writer = new FileWriter(file);       //connect file
                PrintWriter printer = new PrintWriter(writer);  //connect writer
                for (String line : poem) {      //enhanced loop throug the array
                    printer.println(line);      //writing one array index
                }
                printer.close();        //server close file connection

            } catch (IOException e) {
                System.out.println("File save error");
            }

            //now open files for one line...
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            if (file != null || file.exists()) {
                name = file.getAbsolutePath();
                try {
                    FileReader reader = new FileReader(name);
                    BufferedReader buffer = new BufferedReader(reader);

                    String line = buffer.readLine();
                    buffer.close();
                    System.out.println(line);
                } catch (IOException e) {
                    System.out.println("File open error");
                }
            }
            //do it again with the array for multiple lines 
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            try {
                FileReader reader = new FileReader(file);
                BufferedReader buffer = new BufferedReader(reader);
                String line = buffer.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = buffer.readLine();
                }
                buffer.close();
            } catch (IOException e) {
                System.out.println("File open error");
            }
            
            
            
            
            Dialogs dialog = new Dialogs();
            
            dialog.output("Hi");
            
            //Now save and open without the user involved
            final int SIZE = 100000;
            LinkedList<TestClass> before = new LinkedList<>();
            for (int i = 0; i < SIZE; i++) {
                before.add(new TestClass(SIZE));
            }
            
            //output list before saving  
            System.out.println(before.toString());
            
            LinkedList<String> list = new LinkedList<>(poem);
            
            try{
                file = new File("data3");
                if(!file.exists()) file.createNewFile();
                
                
                
                FileHandler<LinkedList<TestClass>> 
                fileHandler = new FileHandler<>();
                
                fileHandler.saveObject(before, file);
                
                LinkedList<TestClass> after = fileHandler.openObject(file);
                
                System.out.println(after.toString());
                
                file.delete();
            } 
            catch (IOException error) {
                System.out.println("Error" + error.toString());
                
            }
            
//            Dialogs dialogs = new Dialogs();
//            Numbers numbers = new Numbers();
//            Text text = new Text();
            
          
        }

    }

}
