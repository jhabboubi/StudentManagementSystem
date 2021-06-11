package org.perscholas.security;

import org.perscholas.dao.IAuthGroupRepo;
import org.perscholas.dao.IStudentRepo;
import org.perscholas.models.AuthGroup;
import org.perscholas.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
        2.

 */

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final IStudentRepo studentRepo;
    private final IAuthGroupRepo iAuthGroupRepo;
    @Autowired
    public AppUserDetailsService(IStudentRepo studentRepo, IAuthGroupRepo iAuthGroupRepo) {
        this.studentRepo = studentRepo;
        this.iAuthGroupRepo = iAuthGroupRepo;
    }





    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Student> student = studentRepo.findBysUsername(s);
        if(student.isEmpty())
            throw new UsernameNotFoundException("Cannot find Username: " + s);
            List<AuthGroup> authGroups = this.iAuthGroupRepo.findByaUsername(s);
            return new AppUserPrincipal(student.get(),authGroups);
        }
    }

