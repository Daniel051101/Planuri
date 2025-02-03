package ro.upt.ac.planuri.utilizatori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() 
    {
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            Privilege manageUsers = new Privilege();
            manageUsers.setName("MANAGE_USERS");
            privilegeRepository.save(manageUsers);

            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            adminRole.getPrivileges().add(manageUsers);
            roleRepository.save(adminRole);

            User admin = new User();
            admin.setUsername("admin");
            admin.setEmail("admin@upt.ro");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.getRoles().add(adminRole);
            userRepository.save(admin);
        }
    }
}


