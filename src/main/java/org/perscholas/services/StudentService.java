package org.perscholas.services;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.dao.ICourseRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class StudentService {

    /*
            - add class annotations
            - add @Transactional on class or on each method
            - add crud methods
     */
    private final IStudentRepo studentRepo;

    @Autowired
    public StudentService(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    //returns all courses
    public List<Student> getStudents() {
        log.info("Printing students");
        return studentRepo.findAll();
    } // end of getStudent()

    public Student addNewStudent(Student student) {
        //creates studentOptional and sets it to find student by email
        Optional<Student> studentOptional = studentRepo.findStudentBysEmail(student.getSEmail());
        // check if studentOptional is present and set
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("email taken"); // throws error is email is already taken
        }
        return studentRepo.save(student); //saves the student to the database
    } //end of addNewStudent()


}


