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
    
    String id;
    //I set ID to be a String value, because even if a user's ID starts with 0, the whole ID number wil be printed
    String name;
    int age;
    String email;
    String course;
    
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> names = new ArrayList<>();
    ArrayList<Integer> ages = new ArrayList<>();
    ArrayList<String> emails = new ArrayList<>();
    ArrayList<String> courses = new ArrayList<>();

    //constructor
    //I used a constructor instead of setters since it is, firstly, less code, and secondly, easier to understand 
    public Student(String id, String name, int age, String email, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.course = course;
    }

    //getters
    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getEmail(){
        return email;
    }
    public String getCourse(){
        return course;
    }
    
    //methods
    public void saveStudent(){
        System.out.println("CAPTURE A NEW STUDENT" 
                       + "\n**************************");
        System.out.print("Enter the student id: ");
        id = kb.next();
        ID.add(getId());
        
        System.out.print("Enter the student name: ");
        name = kb.next();
        names.add(getName());
        
        while (true) {
            System.out.print("Enter the student age: ");
            if (kb.hasNextInt())//this line ensures that only numbers can be accepted
            {
                age = kb.nextInt();
                if (age >= 16) {
                    ages.add(age);
                    break; // Exit the loop if age is valid
                } else {
                    System.out.println("You have entered an incorrect student age!!!");
                    System.out.println("Please re-enter the student age >>");
                    age = kb.nextInt();
                }
            } else {
                System.out.println("You have entered an incorrect student age!!!");
                System.out.println("Please re-enter the student age >>");
                age = kb.nextInt();
                kb.next(); // Consume invalid input
            }
        }
        
        System.out.print("Enter the student email: ");
        email = kb.next();
        emails.add(getEmail());
        
        System.out.print("Enter the student course: ");
        course = kb.next();
        courses.add(getCourse());
    
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
            if (ID.get(i).equalsIgnoreCase(searchQuery)) {
                //display info
                System.out.println("STUDENT ID: " + ID.get(i));
                System.out.println("STUDENT NAME: " + names.get(i));
                System.out.println("STUDENT AGE: " + ages.get(i));
                System.out.println("STUDENT EMAIL: " + emails.get(i));
                System.out.println("STUDENT COURSE: " + courses.get(i));
                studentFound = true;
                break;
            }
            if(!studentFound){
                System.out.println("Student with Student Id: " + searchQuery + " was not found!");
            }
        }
        /*
        why is size() used instead of .length?
        size() is used to get the number of elements in an array,
        whereas .length is used for arrays that have a fixed number of elements
        */
        System.out.println("---------------------------------------------------------");
    }
    
    public void deleteStudent(String deleteQuery){
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
                    names.remove(i);
                    ages.remove(i);
                    emails.remove(i);
                    courses.remove(i);
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
        
    }
    
    public void studentReport(){
        System.out.println("REPORT: ");
        System.out.println("---------------------------------------------------------");
        
        for (int i = 0; i < ID.size(); i++) {
            System.out.println("STUDENT " + (i + 1));
            System.out.println("---------------------------------------------------------");
            System.out.println("\nID: " + ID.get(i) + "\n"
                             + "Name: " + names.get(i) + "\n"
                             + "Age: " + ages.get(i) + "\n"
                             + "Email: " + emails.get(i) + "\n"
                             + "Course: " + courses.get(i) + "\n");
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

