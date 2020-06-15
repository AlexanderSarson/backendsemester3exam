/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import dtos.CourseDTO;
import errorhandling.CourseException;
import errorhandling.UserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 *
 * @author root
 */
public class CourseFacadeTest extends BaseFacadeTest{
    private static final CourseFacade FACADE = CourseFacade.getCourseFacade(getEntityManagerFactory());


    @Test
    public void testGetAllCourses() {
        int expectedNumberOfCourses = 3;
        int resultNumberOfCourses = FACADE.getAllCourses().size();
        assertEquals(expectedNumberOfCourses, resultNumberOfCourses);
    }
    
    @Test
    public void testCreateCourse() {
        CourseDTO courseDTO = new CourseDTO("new yoga course", "brand new course");
        CourseDTO createCourseDTO = FACADE.createCourse(courseDTO);
        assertTrue(createCourseDTO.getId() > 0);
    }
    
    
    @Test
    public void testFindCourseByName() throws CourseException{
        String expectedCourseName = "Hatha Yoga";
        CourseDTO courseDTO = FACADE.findCourseByName(expectedCourseName);
        assertEquals(expectedCourseName, courseDTO.getCourseName());
    }
    
    @Test
    public void testFindCourseByName_throwsCourseException() {
        Assertions.assertThrows(CourseException.class, () -> FACADE.findCourseByName("This doesn't exist"));
    }
    
    @Test
    public void testFindCourseById() throws CourseException{
        CourseDTO courseDTO = FACADE.findCourseByName("Hatha Yoga");
        long expectedId = courseDTO.getId();
        long resultId = FACADE.findCourseById(expectedId).getId();
        assertEquals(expectedId, resultId);
    }
    
    @Test
    public void testFindCourseById_throwsCourseException() {
        Assertions.assertThrows(CourseException.class, () -> FACADE.findCourseById(-1));
    }   
    
    @Test
    public void testEditCourse() throws CourseException{
        String expectedCourseName = "new course name bla bla";
        CourseDTO courseDTO = FACADE.findCourseByName("Hatha Yoga");
        courseDTO.setCourseName(expectedCourseName);
        CourseDTO resultDTO = FACADE.editCourse(courseDTO); 
        assertEquals(expectedCourseName, resultDTO.getCourseName());
    }
    
    @Test
    public void testDeleteCourseById() throws CourseException {
        CourseDTO courseDTO = FACADE.findCourseByName("Hatha Yoga");
        CourseDTO deletedDTO = FACADE.deleteCourseById(courseDTO.getId());
        assertEquals(deletedDTO.getCourseName(), courseDTO.getCourseName());
    }
    
    @Test
    public void testDeleteCourseById_throwsCourseException() {
        Assertions.assertThrows(CourseException.class, () -> FACADE.deleteCourseById(1));
    } 
    
}
