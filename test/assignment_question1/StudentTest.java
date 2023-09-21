/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment_question1;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;



/**
 *
 * @author ST10257468 - Bela Jyoti Premchund
 */
public class StudentTest {
    //this is to assign values to the variables in the constructor
       Student student = new Student("10111", "J.Boyd", 18, "jamesb@gmail.com", "bcad");
        
    @Test
    public void testSaveStudent(){        
        
        //test the getters
        assertEquals("10111", student.getId());
        assertEquals("J.Boyd", student.getName());
        assertEquals(18, student.getAge());
        assertEquals("jamesb@gmail.com", student.getEmail());
        assertEquals("bcad", student.getCourse());
    }
    
    @Test
    public void testSearchStudent(){
           
       student.saveStudent();
       student.searchStudent("10111");
       
       assertEquals("10111", student.getId());
       assertEquals("J.Boyd", student.getName());
       assertEquals(18, student.getAge());
       assertEquals("jamesb@gmail.com", student.getEmail());
       assertEquals("bcad", student.getCourse());
    }
    
    @Test
    public void testSearchStudent_StudentNotFound(){
        student.saveStudent();
       Student testStudent = new Student("10111", "J.Boyd", 18, "jamesb@gmail.com", "bcad");
       student.searchStudent("10112");
       
       testStudent.searchStudent("10112");
     //  assertEquals("Student with Student Id: " + searchQuery + " was not found!");
    }
    
    @Test
    public void testDeleteStudent(){
        // Create a test student and add them to the ArrayLists
    student.saveStudent();

    // Delete the test student using the DeleteStudent method
    student.deleteStudent("10111");

    // Check that the student has been deleted by verifying that the ID is not present in the lists
    assertFalse(student.ID.contains("10111"));
    assertFalse(student.names.contains("J.Boyd"));
    assertFalse(student.ages.contains(18));
    assertFalse(student.emails.contains("jamesb@gmail.com"));
    assertFalse(student.courses.contains("bcad"));
}
    
    
    @Test
    public void testDeleteStudent_StudentNotFound(){
        student.deleteStudent("10114");
        assertFalse(student.ID.contains("10114"));
        assertFalse(student.names.contains("J.Boyd"));
        assertFalse(student.ages.contains(18));
        assertFalse(student.emails.contains("jamesb@gmail.com"));
        assertFalse(student.courses.contains("bcad"));
    }
    
    @Test
    public void testStudentAge_StudentAgeValid(){
        assertEquals(18, student.getAge());
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalid(){
        assertNotEquals(12, student.getAge());
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter(){
        assertNotEquals("c", student.getAge());
    }
    
}
