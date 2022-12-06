package iitu.diploma.documentworkflow.services;

import iitu.diploma.documentworkflow.entities.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Users getUserByEmail(String email);
}
