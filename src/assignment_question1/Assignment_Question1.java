/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignment_question1;

import java.util.Scanner;

/**
 *
 * @author ST10257468 - Bela Jyoti Premchund
 */
public class Assignment_Question1 {
   
    //variables
    public static int option = 0;
    public static int menuChoice = 0;
    public static boolean exit = false;
        
    //Scanner and the array lists are global declarations since they will be used in more than 1 method
    public static Scanner kb = new Scanner(System.in);
    
      
    public static void main(String[] args) {
        Student student = new Student("", "", 0, "", "");
       
        System.out.println("STUDENT MANAGEMENT APPLICATION"
                      + "\n***************************************");
        
        while(true){
        System.out.println("Enter (1) to launch menu or any other key to exit");
        option = kb.nextInt();
        
        
        if(option == 1) {
            
            System.out.println("Please select one of the following menu items:" 
                    + " \n(1) Capture a new student."
                    + " \n(2) Search for a student."
                    + " \n(3) Delete a student."
                    + " \n(4) Print a student report."
                    + " \n(5) Exit application.");
            
           menuChoice = kb.nextInt();
           
           /*
           I used a switch case instead of nested if statements as it is less code.
           this makes the code easier to understand and makes the code easy to follow
           */
            switch (menuChoice) {
                case 1: student.saveStudent(); break;
                case 2: student.searchStudent(""); break;
                case 3: student.deleteStudent(""); break;
                case 4: student.studentReport(); break;
                case 5: student.exitStudentApplication(); return;
                //return will exit the method and the switch 
                default:
                    System.out.println("Invalid choice. Please choose a valid menu option."); 
            }//end of switch
        }else{
                System.out.println("Exiting program now...");
                return;
        }//end of if else statement
        }
    }
        
}
/*
REFERENCES:
- javaTpoint - Difference between length of array and size() of ArrayList in Java - https://www.javatpoint.com/difference-between-length-of-array-and-size-of-arraylist-in-java#:~:text=ArrayList%20doesn't%20have%20length,the%20intialization%20of%20the%20array.
- codecademy - Do we need to use break; after return in a switch statement? - Ahsan Shahid - https://www.codecademy.com/forum_questions/533415567c82ca30fd002201#:~:text=return%20jumps%20back%20directly%20to,no%20further%20break%20is%20required.
*/