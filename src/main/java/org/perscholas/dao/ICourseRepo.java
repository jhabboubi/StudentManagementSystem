package org.perscholas.dao;

/*
        - add annotation
        - extend spring jpa
        - add custom methods if needed

 */

        import org.perscholas.models.Course;
        import org.perscholas.models.Student;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.Optional;

@Repository //makes this a repository
public interface ICourseRepo extends JpaRepository<Course, Long> {

    Optional<Course> findCourseBycName(final String cName);
}