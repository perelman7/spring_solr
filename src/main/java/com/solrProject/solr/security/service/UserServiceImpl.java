package com.solrProject.solr.security.service;

import com.solrProject.solr.security.dto.singin.UserSinginDto;
import com.solrProject.solr.security.model.Role;
import com.solrProject.solr.security.model.Status;
import com.solrProject.solr.security.model.User;
import com.solrProject.solr.security.repository.RoleRepository;
import com.solrProject.solr.security.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(@Qualifier("authuserRepository") UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(UserSinginDto user) {

        if (user != null) {
            List<Role> roles = roleRepository.findByNameIn(user.getRoles());
            User result = new User();
            result.setEmail(user.getEmail());
            result.setFirstName(user.getFirstName());
            result.setLastName(user.getLastName());
            result.setCreated(new Date());
            result.setRoles(roles);
            result.setUsername(user.getUsername());
            result.setPassword(passwordEncoder.encode(user.getPassword()));
            result.setStatus(Status.ACTIVE);

            User registeredUser = userRepository.save(result);
            log.info("IN register - user: {} successfully registered", registeredUser);

            return registeredUser;
        }
        return null;
    }

    @Override
    public Role createRole(String role) {
        if (role != null && !role.isEmpty()) {
            Role roleForPersist = new Role();
            roleForPersist.setName(role);
            roleForPersist.setUsers(null);
            roleForPersist.setCreated(new Date());
            roleForPersist.setStatus(Status.ACTIVE);

            Role save = roleRepository.save(roleForPersist);
            log.info("Role with name : {} and id: {} was successful added", save.getName(), save.getId());
            return save;
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByUsername(String username) {
        User result = userRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted", id);
    }
}
