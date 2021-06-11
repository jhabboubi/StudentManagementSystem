package org.perscholas;

import lombok.extern.java.Log;
import org.perscholas.dao.ICourseRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Course;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log
@Transactional
public class AppStartupRunner implements CommandLineRunner {

    IStudentRepo studentRepo;
    ICourseRepo courseRepo;
    IAuthGroupRepo userRepo;
    @Autowired
    public AppStartupRunner(IStudentRepo studentRepo, ICourseRepo courseRepo, IAuthGroupRepo userRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("**** Start adding Students sql statements ****");
        studentRepo.save(new Student("habboubi", "habboubi@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        studentRepo.save(new Student("admin", "admin@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        studentRepo.save(new Student("student_one", "student_one@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        studentRepo.save(new Student("student_two", "student_two@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));
        studentRepo.save(new Student("student_three", "student_three@gmail.com", "$2y$11$JcGGFLmi46mM4SKUGKSv8.2srUTueRcyxRoHfHSVK/voHjw9kEKv."));

        log.info("**** End of sql statements ****");
        log.info("**** Start adding Courses sql statements ****");
        courseRepo.save(new Course("Java", 3));
        courseRepo.save(new Course("Database", 3));
        courseRepo.save(new Course("Spring Boot", 3));
        courseRepo.save(new Course("HTML & CSS", 3));
        courseRepo.save(new Course("JavaScript", 3));
        log.info("**** End of sql statements ****");
        log.info("**** Start adding AuthGroup sql statements ****");
        userRepo.save(new AuthGroup("habboubi", "ROLE_ADMIN"));
        userRepo.save(new AuthGroup("habboubi", "ROLE_USER"));
        userRepo.save(new AuthGroup("habboubi", "WRITE"));
        userRepo.save(new AuthGroup("admin", "ROLE_ADMIN"));
        userRepo.save(new AuthGroup("admin", "ROLE_USER"));
        userRepo.save(new AuthGroup("student_one", "ROLE_USER"));
        userRepo.save(new AuthGroup("student_two", "ROLE_USER"));
        userRepo.save(new AuthGroup("student_three", "ROLE_USER"));
        log.info("**** End of sql statements ****");

    }

    @PostConstruct
    public void constructed(){
        log.warning("StartupRunner Constructed!");
    }
}
