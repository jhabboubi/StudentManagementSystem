package org.perscholas.dao;

import org.perscholas.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed

 */
@Repository
public interface IStudentRepo extends JpaRepository<Student,Long> {
    Optional<Student> findBysUsername(String username);
}
