/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignment_question1;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ST10257468 - Bela Jyoti Premchund
 */
public class StudentTest {
    
    private Student student;

    @Before
    public void setUp() {
        // Initialize a new student object before each test
        //this is to assign values to the variables in the constructor
        student = new Student("10111", "J.Boyd", 19, "jamesb@gmail.com", "bcad");
    }
       
    @Test
    public void testSaveStudent(){ 
        //test the getters
        assertEquals("10111", student.getStudentId());
        assertEquals("J.Boyd", student.getStudentName());
        assertEquals(19, student.getStudentAge());
        assertEquals("jamesb@gmail.com", student.getStudentEmail());
        assertEquals("bcad", student.getStudentCourse());
    }
    
    @Test
    public void testSearchStudent(){   
        
       student.searchStudent("10111");
       assertEquals("10111", student.getStudentId());
       assertEquals("J.Bloggs", student.getStudentName());
       assertEquals(19, student.getStudentAge());
       assertEquals("jbloggs@gmail.com", student.getStudentEmail());
       assertEquals("disd", student.getStudentCourse());
    }
    
   @Test
    public void testSearchStudent_StudentNotFound() {
        // Call the searchStudent method with a non-existent student ID
        student.searchStudent("10112");

        // Verify the output by checking the content of the standard output stream
        String expectedOutput = "Please enter the ID number you wish to search: " +
                                "Student with Student Id: 10112 was not found!\n" +
                                "---------------------------------------------------------\n";
        assertEquals(expectedOutput, System.out.toString());
        
        // Ensure that the student object remains unchanged
        assertEquals("10111", student.getStudentId());
        assertEquals("J.Bloggs", student.getStudentName());
        assertEquals(19, student.getStudentAge());
        assertEquals("jbloggs@gmail.com", student.getStudentEmail());
        assertEquals("disd", student.getStudentCourse());
    }

    @Test
    public void testDeleteStudent() {
        // Delete an existing student
        boolean deleted = student.deleteStudent("10111");

        // Check that the student has been deleted
        assertTrue(deleted);

        // Verify that the student data has been removed from the lists
        assertFalse(student.ID.contains("10111"));
        assertFalse(student.name.contains("J.Bloggs"));
        assertFalse(student.age.contains(19));
        assertFalse(student.email.contains("jbloggs@gmail.com"));
        assertFalse(student.course.contains("disd"));
    }

    @Test
    public void testDeleteStudent_StudentNotFound() {
        // Delete a non-existent student
        boolean deleted = student.deleteStudent("10114");

        // Check that the student has not been deleted
        assertFalse(deleted);

        // Verify that the student data remains unchanged
        assertTrue(student.ID.contains("10111"));
        assertTrue(student.name.contains("J.Bloggs"));
        assertTrue(student.age.contains(19));
        assertTrue(student.email.contains("jbloggs@gmail.com"));
        assertTrue(student.course.contains("disd"));
    }

    
    @Test
    public void testStudentAge_StudentAgeValid(){
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        assertEquals(19, student.getStudentAge());
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalid(){
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        assertNotEquals(12, student.getStudentAge());
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter(){
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        assertNotEquals("c", student.getStudentAge());
    }
    
}