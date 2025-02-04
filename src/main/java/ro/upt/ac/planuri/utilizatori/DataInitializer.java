package ro.upt.ac.planuri.utilizatori;

import java.util.List;

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
    public void init() {
        // Creare privilegii
        Privilege createCourses = createPrivilegeIfNotFound("CREATE_COURSES");
        Privilege manageCourses = createPrivilegeIfNotFound("MANAGE_COURSES");
        Privilege viewCourses = createPrivilegeIfNotFound("VIEW_COURSES");

        // Creare roluri și asocierea privilegiilor
        Role adminRole = createRoleIfNotFound("ROLE_ADMIN", List.of(createCourses, manageCourses, viewCourses));
        Role teacherRole = createRoleIfNotFound("ROLE_TEACHER", List.of(manageCourses, viewCourses));
        Role studentRole = createRoleIfNotFound("ROLE_STUDENT", List.of(viewCourses));

        // Creare utilizatori și asignare roluri
        createUserIfNotFound("admin", "admin@upt.ro", "admin123", List.of(adminRole));
        createUserIfNotFound("profesor", "profesor@upt.ro", "profesor123", List.of(teacherRole));
        createUserIfNotFound("student", "student@upt.ro", "student123", List.of(studentRole));
    }

    // Metodă pentru crearea unui privilegiu dacă nu există
    private Privilege createPrivilegeIfNotFound(String name) {
        return privilegeRepository.findByName(name).orElseGet(() -> {
            Privilege privilege = new Privilege(name);
            privilegeRepository.save(privilege);
            return privilege;
        });
    }

    // Metodă pentru crearea unui rol cu privilegii
    private Role createRoleIfNotFound(String name, List<Privilege> privileges) {
        return roleRepository.findByName(name).orElseGet(() -> {
            Role role = new Role(name);
            role.getPrivileges().addAll(privileges);
            roleRepository.save(role);
            return role;
        });
    }

    // Metodă pentru crearea unui utilizator cu roluri
    private void createUserIfNotFound(String username, String email, String password, List<Role> roles) {
        if (userRepository.findByUsername(username).isEmpty()) {
            User user = new User(username, email, passwordEncoder.encode(password));
            user.getRoles().addAll(roles);
            userRepository.save(user);
        }
    }
}




