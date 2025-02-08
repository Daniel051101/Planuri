package ro.upt.ac.planuri.utilizatori;

import org.springframework.stereotype.Service;

@Service
public class UserService 
{
    // Metodele necesare
    public boolean authenticate(String username, String email, String password) {
        // Implementarea metodei de autentificare
        return "adminTest".equals(username) && "adminTest@upt.ro".equals(email) && "Test".equals(password);
    }
}
