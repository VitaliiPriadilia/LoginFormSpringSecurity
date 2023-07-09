package com.security.SpringSecurityLearning.auth;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectApplicationUserByUsername(String username);


}
