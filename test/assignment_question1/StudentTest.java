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
       
    @Test
    public void testSaveStudent(){ 
        //this is to assign values to the variables in the constructor
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        //test the getters
        assertEquals("10111", student.getStudentId());
        assertEquals("J.Boyd", student.getStudentName());
        assertEquals(18, student.getStudentAge());
        assertEquals("jamesb@gmail.com", student.getStudentEmail());
        assertEquals("bcad", student.getStudentCourse());
    }
    
    @Test
    public void testSearchStudent(){
       Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
           
       student.searchStudent("10111");
       
       assertEquals("10111", student.getStudentId());
       assertEquals("J.Bloggs", student.getStudentName());
       assertEquals(19, student.getStudentAge());
       assertEquals("jbloggs@gmail.com", student.getStudentEmail());
       assertEquals("disd", student.getStudentCourse());
    }
    
    @Test
    public void testSearchStudent_StudentNotFound(){
       Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       Student testStudent = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
       student.searchStudent("10112");
       testStudent.searchStudent("10112");
       
    }
    
    @Test
    public void testDeleteStudent(){  
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        student.deleteStudent("10111"); // Delete the test student using the DeleteStudent method

        // Check that the student has been deleted by verifying that the ID is not present in the lists
        assertFalse(student.ID.contains("10111"));
        assertFalse(student.name.contains("J.Bloggs"));
        assertFalse(student.age.contains(19));
        assertFalse(student.email.contains("jbloggs@gmail.com"));
        assertFalse(student.course.contains("disd"));
}
    
    
    @Test
    public void testDeleteStudent_StudentNotFound(){
        Student student = new Student("10111", "J.Bloggs", 19, "jbloggs@gmail.com", "disd");
       
        student.deleteStudent("10114");
        assertFalse(student.ID.contains("10114"));
        assertFalse(student.name.contains("J.Bloggs"));
        assertFalse(student.age.contains(19));
        assertFalse(student.email.contains("jbloggs@gmail.com"));
        assertFalse(student.course.contains("disd"));
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