/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

}
