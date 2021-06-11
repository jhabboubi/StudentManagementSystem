package org.perscholas.services;

import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class StudentService {


    /*
            - add class annotations
            - add @Transactional on class or on each method
            - add crud methods
     */

    IStudentRepo studentRepo;
    @Autowired
    public StudentService(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Student save(Student s){
        return studentRepo.save(s);
    }

}
