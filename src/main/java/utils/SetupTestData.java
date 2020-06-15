/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entity.Course;
import entity.Instructor;
import entity.SignedUp;
import entity.Student;
import entity.YogaClass;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author root
 */
public class SetupTestData {
    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();
        Student student1 = new Student("Alexander", 30405060, "Alexander@mail.dk");
        Student student2 = new Student("Oscar", 40506070, "Oscar@mail.dk");
        Student student3 = new Student("Benjamin", 10203010, "Benjamin@mail.dk");
        Student student4 = new Student("Mads", 40503020, "Mads@mail.dk");
        Student student5 = new Student("Michael", 20304060, "Michael@mail.dk");
        Instructor instructor1 = new Instructor("Bo");
        Instructor instructor2 = new Instructor("Jens");
        Instructor instructor3 = new Instructor("Arne");
        List<Instructor> instructorList1 = new ArrayList<>();
        List<Instructor> instructorList2 = new ArrayList<>();
        List<Instructor> instructorList3 = new ArrayList<>();
        instructorList1.add(instructor1);
        instructorList2.add(instructor2);
        instructorList3.add(instructor3);
        Course course1 = new Course("Klassisk Yoga", "Undervisningen omfatter klassisk yoga, åndedrætsøvelser, koncentrationsøvelser, dybdeafspænding og meditation");
        Course course2 = new Course("Esoteriske Yogakursus", "Esoteriske Yogakursus er for dig, der gerne vil gå dybere i din yogatræning. Hvor yoga kan bruges som redskab til selvudvikling, øget velvære og balance, og med tiden gøre det til en del af din livsstil.");
        Course course3 = new Course("Hatha Yoga", "Hatha Yoga er den mest kendte yogaform og indeholder flere forskellige elementer som fysiske øvelser, åndedrætsøvelser og afspænding.");
        SignedUp signedUp1 = new SignedUp(true, new Date());
        SignedUp signedUp2 = new SignedUp(true, new Date());
        SignedUp signedUp3 = new SignedUp(true, new Date());
        SignedUp signedUp4 = new SignedUp(true, new Date());
        SignedUp signedUp5 = new SignedUp(true, new Date());
        SignedUp signedUp6 = new SignedUp(true, new Date());
        SignedUp signedUp7 = new SignedUp(true, new Date());
        SignedUp signedUp8 = new SignedUp(true, new Date());
        SignedUp signedUp9 = new SignedUp(true, new Date());
        SignedUp signedUp10 = new SignedUp(true, new Date());
        List<SignedUp> student1ListSignedUp = new ArrayList<>();
        List<SignedUp> student2ListSignedUp = new ArrayList<>();
        List<SignedUp> student3ListSignedUp = new ArrayList<>();
        List<SignedUp> student4ListSignedUp = new ArrayList<>();
        List<SignedUp> student5ListSignedUp = new ArrayList<>();
        student1ListSignedUp.add(signedUp1);
        student1ListSignedUp.add(signedUp2);
        student2ListSignedUp.add(signedUp3);
        student2ListSignedUp.add(signedUp4);
        student3ListSignedUp.add(signedUp5);
        student3ListSignedUp.add(signedUp6);
        student4ListSignedUp.add(signedUp7);
        student4ListSignedUp.add(signedUp8);
        student5ListSignedUp.add(signedUp9);
        student5ListSignedUp.add(signedUp10);
        YogaClass yogaclass1 = new YogaClass(10, new Date(), 350);
        YogaClass yogaclass2 = new YogaClass(10, new Date(), 350);
        YogaClass yogaclass3 = new YogaClass(10, new Date(), 350);
        List<SignedUp> yogaClass1SignUp = new ArrayList<>();
        List<SignedUp> yogaClass2SignUp = new ArrayList<>();
        List<SignedUp> yogaClass3SignUp = new ArrayList<>();
        yogaClass1SignUp.add(signedUp1);
        yogaClass1SignUp.add(signedUp2);
        yogaClass1SignUp.add(signedUp3);
        yogaClass2SignUp.add(signedUp4);
        yogaClass2SignUp.add(signedUp5);
        yogaClass2SignUp.add(signedUp6);
        yogaClass3SignUp.add(signedUp7);
        yogaClass3SignUp.add(signedUp8);
        yogaClass3SignUp.add(signedUp9);
        yogaClass3SignUp.add(signedUp10);
        
        
        em.getTransaction().begin();
        em.persist(instructor1);
        em.persist(instructor2);
        em.persist(instructor3);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(course1);
        em.persist(course2);
        em.persist(course3);
        em.persist(yogaclass1);
        em.persist(yogaclass2);
        em.persist(yogaclass3);
        em.persist(signedUp1);
        em.persist(signedUp2);
        em.persist(signedUp3);
        em.persist(signedUp4);
        em.persist(signedUp5);
        em.persist(signedUp6);
        em.persist(signedUp7);
        em.persist(signedUp8);
        em.persist(signedUp9);
        em.persist(signedUp10);
        student1.setSignedUp(student1ListSignedUp);
        student2.setSignedUp(student2ListSignedUp);
        student3.setSignedUp(student3ListSignedUp);
        student4.setSignedUp(student4ListSignedUp);
        student5.setSignedUp(student5ListSignedUp);
        yogaclass1.setInstructors(instructorList1);
        yogaclass2.setInstructors(instructorList2);
        yogaclass3.setInstructors(instructorList3);
        yogaclass1.setCourse(course1);
        yogaclass2.setCourse(course2);
        yogaclass3.setCourse(course3);
        yogaclass1.setSignedUp(yogaClass1SignUp);
        yogaclass1.setSignedUp(yogaClass2SignUp);
        yogaclass1.setSignedUp(yogaClass3SignUp);
        em.getTransaction().commit();
    }
    
}