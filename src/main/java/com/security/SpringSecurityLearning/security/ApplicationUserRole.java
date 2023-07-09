package com.security.SpringSecurityLearning.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static com.security.SpringSecurityLearning.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    STUDENT(new HashSet<>()),
    ADMIN(new HashSet<>(Arrays.asList(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE))),
    ADMINTRAINEE(new HashSet<>(Arrays.asList(COURSE_READ,STUDENT_READ)));

    private final Set<ApplicationUserPermission> applicationUserPermission;
    ApplicationUserRole(Set<ApplicationUserPermission> applicationUserPermissions){
        this.applicationUserPermission = applicationUserPermissions;
    }
    public Set<ApplicationUserPermission> getPermissions(){
        return this.applicationUserPermission;
    }
    public Set<SimpleGrantedAuthority> grantedAuthorities(){
        Set<SimpleGrantedAuthority> grantedAuthorities = getPermissions().stream()
                .map(applicationUserPermission1 -> new SimpleGrantedAuthority(applicationUserPermission1.getPermission()))
                .collect(Collectors.toSet());
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return grantedAuthorities;
    }

}
