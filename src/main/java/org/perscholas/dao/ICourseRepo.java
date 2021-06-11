package org.perscholas.dao;

import org.perscholas.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed

 */
@Repository
public interface ICourseRepo extends JpaRepository<Course,Long> {
}
