package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import javax.validation.constraints.Email;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.List;

//lombok
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//database
@Entity // tells jpa to use this as an entity and creates this as a table
//springboot
@Component
public class Student implements Serializable {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED", name = "studentid", nullable = false)
    Long studentId;

    @Email(regexp = "^\\b[\\w.-]+@[\\w.-]+\\.\\w{2,4}\\b", message = "Invalid email address")
    @Column(columnDefinition = "VARCHAR(50)", name = "email", nullable = false)
    String sEmail;

    @Column(columnDefinition = "VARCHAR(50)", name = "name", nullable = false)
    @NotBlank(message = "Cannot be empty")
    String sName;

    @Column(columnDefinition = "VARCHAR(50)", name = "password", nullable = false)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$", message = "Must contain at least 8 characters\n" +
            "At least 1 upper case letter\n" +
            "At least 1 lower case letter\n" +
            "At least 1 number\n" +
            "At least 1 special character")
    String sPass;

    @ManyToMany //sets many to many relationship
    @JoinTable( //joins student and course tables
            name = "sCourses", //names the join table in the database
            joinColumns = {@JoinColumn(name = "studentId", referencedColumnName = "studentId",unique = false)}, //joins colums student id and course id
            inverseJoinColumns = {@JoinColumn(name = "courseId", referencedColumnName = "courseId",unique = false)}, //inverse joins both columns
            indexes = {@Index(columnList = "studentId,courseId")} //sets indexes as student id and course id
    )
    List<Course> sCourses;
}
