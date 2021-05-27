package org.perscholas.dao;

/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed

 */

import org.perscholas.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //makes this a repository
public interface IStudentRepo extends JpaRepository<Student, Long> {
    Optional<Student> findStudentBysEmail(final String sEmail);
}
