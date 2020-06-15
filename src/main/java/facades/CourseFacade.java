/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CourseDTO;
import dtos.InstructorDTO;
import dtos.YogaClassDTO;
import entity.Course;
import entity.YogaClass;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author root
 */
public class CourseFacade {

    private static EntityManagerFactory emf;
    private static CourseFacade instance;

    private CourseFacade() {
    }

    /**
     *
     * @param _emf
     * @return the instance of this facade.
     */
    public static CourseFacade getCourseFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<CourseDTO> getAllCourses() {
        List<CourseDTO> listOfCourseDTOs = new ArrayList<>();
        EntityManager em = getEntityManager();
        try {
            List<Course> listOfCourses = em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
            for (Course course : listOfCourses) {
                List<YogaClassDTO> listOfYogaClassDTOs = new ArrayList<>();
                for (YogaClass yogaclass : course.getYogaClasses()) {
                    listOfYogaClassDTOs.add(new YogaClassDTO(yogaclass));
                }
                CourseDTO courseDTO = new CourseDTO(course);
                courseDTO.setYogaClass(listOfYogaClassDTOs);
                listOfCourseDTOs.add(courseDTO);
            }
        } finally {
            em.close();
        }
        return listOfCourseDTOs;
    }
    
   

}
