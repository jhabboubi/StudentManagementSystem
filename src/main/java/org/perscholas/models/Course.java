package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
//Lombok
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//Database
@Entity
//Spring Boot
@Component
public class Course implements Serializable {
    static final long serialVersionUID = 6381462249347345007L;

    /*
          note use annotation  '@ToString.Exclude' for Lists
          ----------------
          - add validation for fields
          - relationships
          - utilities methods if any
   */

    //fields
    @Id
    // make id auto generate and assign it as int and not null
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(columnDefinition = "INT(11) UNSIGNED", name = "courseId", nullable = false)
    Long courseId;
    //assign as varchar in database, name it, and not null
    @Column(columnDefinition = "VARCHAR(50)", name = "name", nullable = false)
    String cName;
    @Column(columnDefinition = "VARCHAR(50)", name = "instructor", nullable = false)
    String cInstructorName;

    // sets many to many relationship
    @ManyToMany(mappedBy = "sCourses") //sets relationship to many to many and maps it to sCourses
    List<Student> sCourses;

}
