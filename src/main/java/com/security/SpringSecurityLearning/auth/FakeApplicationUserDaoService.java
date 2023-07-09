package com.security.SpringSecurityLearning.auth;

import com.security.SpringSecurityLearning.security.ApplicationUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return  getApplicationUsers().stream()
                        .filter(user -> user.getUsername()
                        .equals(username))
                        .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> list = new ArrayList<>(Arrays.asList(
                new ApplicationUser(
                        ApplicationUserRole.STUDENT.grantedAuthorities(),
                        "vadim",
                        passwordEncoder.encode("vitalii"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        ApplicationUserRole.ADMIN.grantedAuthorities(),
                        "vadim",
                        passwordEncoder.encode("vadim"),
                        true,
                        true,
                        true,
                        true),
                new ApplicationUser(
                        ApplicationUserRole.ADMINTRAINEE.grantedAuthorities(),
                        "tom",
                        passwordEncoder.encode("tom"),
                        true,
                        true,
                        true,
                        true)));
        return list;
    }
}
