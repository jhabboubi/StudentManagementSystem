package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;


//Lombok
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long cId;
    @NonNull@NotBlank
    String name;
    @NonNull
    int credits;



}
