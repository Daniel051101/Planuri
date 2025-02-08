package ro.upt.ac.aplicatie.api;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ro.upt.ac.planuri.utilizatori.User;
import ro.upt.ac.planuri.utilizatori.UserRepository;
import ro.upt.ac.planuri.utilizatori.UserService;

public class UserServiceTest 
{
    @Mock
    private UserRepository userRepository;
    
    @InjectMocks
    private UserService userService;
    
    public UserServiceTest() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testAutentificareUtilizatorValid() {
        User user = new User("adminTest", "adminTest@upt.ro", "Test");
        
        // Returnează un Optional<User> în loc de User simplu
        when(userRepository.findByUsername("adminTest")).thenReturn(Optional.of(user));
        
        // Testează autentificarea
        assertTrue(userService.authenticate("adminTest", "adminTest@upt.ro", "Test"));
    }
}
