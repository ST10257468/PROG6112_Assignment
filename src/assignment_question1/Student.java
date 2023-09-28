/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment_question1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ST10257468 - Bela Jyoti Premchund
 */
class Student {
    Scanner kb = new Scanner(System.in);
    
    String studentId;
    //I set ID to be a String value, because even if a user's ID starts with 0, the whole ID number wil be printed
    String studentName;
    int studentAge;
    String studentEmail;
    String studentCourse;
    
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Integer> age = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> course = new ArrayList<>();

    //constructor
    //I used a constructor instead of setters since it is, firstly, less code, and secondly, easier to understand 
    public Student(String studentId, String studentName, int studentAge, String studentEmail, String studentCourse) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentCourse = studentCourse;
    }

    
    //getters
    public String getStudentId(){
        return studentId;
    }
    public String getStudentName(){
        return studentName;
    }
    public int getStudentAge(){
        return studentAge;
    }
    public String getStudentEmail(){
        return studentEmail;
    }
    public String getStudentCourse(){
        return studentCourse;
    }
    
    //methods
    public void saveStudent(){
        System.out.println("CAPTURE A NEW STUDENT" 
                       + "\n**************************");
        System.out.print("Enter the student id: ");
        studentId = kb.next();
        ID.add(getStudentId());
        
        System.out.print("Enter the student name: ");
        studentName = kb.next();
        name.add(getStudentName());
        
        while (true) {
            System.out.print("Enter the student age: ");
            if (kb.hasNextInt())//this line ensures that only numbers can be accepted
            {
                studentAge = kb.nextInt();
                if (studentAge >= 16) {
                    age.add(getStudentAge());
                    break; // Exit the loop if age is valid
                } else {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                    studentAge = kb.nextInt();
                }
            } else {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
                studentAge = kb.nextInt();
                kb.next(); // Consume invalid input
            }
        }
        
        System.out.print("Enter the student email: ");
        studentEmail = kb.next();
        email.add(getStudentEmail());
        
        System.out.print("Enter the student course: ");
        studentCourse = kb.next();
        course.add(getStudentCourse());
    
    }
    
    public void searchStudent(String searchQuery){
        //i declared all my variables first so I have all my variables together
        boolean studentFound = false; //flag to track if the student is found
        
        System.out.print("Please enter the ID number you wish to search: ");
        kb.nextLine();
        searchQuery = kb.nextLine();
        System.out.println("---------------------------------------------------------");
        
        //search through the arrays
        for (int i = 0; i < ID.size(); i++) {
        /*
        why is size() used instead of .length?
        size() is used to get the number of elements in an array,
        whereas .length is used for arrays that have a fixed number of elements
        */
            if (ID.get(i).equalsIgnoreCase(searchQuery)) {
                //display info
                System.out.println("STUDENT ID: " + ID.get(i));
                System.out.println("STUDENT NAME: " + name.get(i));
                System.out.println("STUDENT AGE: " + age.get(i));
                System.out.println("STUDENT EMAIL: " + email.get(i));
                System.out.println("STUDENT COURSE: " + course.get(i));
                studentFound = true;
                break;
            }
            if(!studentFound){
                System.out.println("Student with Student Id: " + searchQuery + " was not found!");
            }
        }
        
        System.out.println("---------------------------------------------------------");
    }
    
    public boolean deleteStudent(String deleteQuery){
        //I chose to declare all the variables together to make it easier to see whcich variables are used
        String conform = "";
        boolean studentDeleted = false;
        
        System.out.print("Enter the student id to delete: ");
        deleteQuery = kb.nextLine();
        System.out.println("Are you sure you want to delete Student " + deleteQuery + " from the system? Yes(y) to delete.");
        conform = kb.nextLine();
        System.out.println("---------------------------------------------------------");
        
        if (conform.equals("y")) {
            //The .equals allows the variable 'conform' equals to 'y'
            for (int i = 0; i < ID.size(); i++) {
                if (ID.get(i).equalsIgnoreCase(deleteQuery)) {
                    
                    ID.remove(i);
                    name.remove(i);
                    age.remove(i);
                    email.remove(i);
                    course.remove(i);
                    System.out.println("Student with Student Id: " + deleteQuery + " WAS deleted!");
                    studentDeleted = true;
                    break;
                }
                if(!studentDeleted){
                    System.out.println("Student with Student Id: " + deleteQuery + " was not found!");
                }
            }
        } else {
            System.out.println("Student with Student Id: " + deleteQuery + " WAS NOT deleted!");
        }
        System.out.println("---------------------------------------------------------");
        return studentDeleted;
        
    }
    
    public void studentReport(){
        System.out.println("REPORT: ");
        System.out.println("---------------------------------------------------------");
        
        for (int i = 0; i < ID.size(); i++) {
            System.out.println("STUDENT " + (i + 1));
            System.out.println("---------------------------------------------------------");
            System.out.println("\nID: " + ID.get(i) + "\n"
                             + "Name: " + name.get(i) + "\n"
                             + "Age: " + age.get(i) + "\n"
                             + "Email: " + email.get(i) + "\n"
                             + "Course: " + course.get(i) + "\n");
            System.out.println("---------------------------------------------------------");
        }
        if (ID.isEmpty()) {
            System.out.println("No information has been entered yet");
        }
    }
    
    public void exitStudentApplication(){
        System.out.println("Exiting program now...");
        //there is no boolean value to exit the program due to the 'return' statement
        
    }
    
}
