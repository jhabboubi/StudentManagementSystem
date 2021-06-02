package org.perscholas.services;


import org.perscholas.dao.ICourseRepo;
import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

     /*
            - add class annotations
            - add @Transactional on class or on each method
            - add crud methods
     */
    private final ICourseRepo courseRepo;

    @Autowired
    public CourseService(ICourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    //returns all courses
    public List<Course> getCourses() {
        return courseRepo.findAll();
    } // end of getStudent()


    //********************* NEEDS WORKS TO GET STUDENT ID AND PUT THE STUDENT ID AND COURSE ID INTO sCourses TABLE **********************

    //saves the course to the database
//    public Course addNewCourse(Course course) {
//
//        Optional<Course> c = courseRepo.findCourseByCourseId(course.getCourseId());
//
//        if (c.isPresent()) {
//            throw new IllegalStateException("Course Name Taken"); // throws error is email is already taken
//        }
//        courseRepo.save(course); //saves the student to the database
//        return course;
//
//        }
}
