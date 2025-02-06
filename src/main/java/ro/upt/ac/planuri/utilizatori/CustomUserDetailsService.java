package ro.upt.ac.planuri.utilizatori;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        System.out.println("Autentificare încercată pentru utilizatorul: " + username);

        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("Utilizator negasit"));
        
        System.out.println("Utilizator găsit: " + user.getUsername());
        
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            mapRolesToAuthorities(user.getRoles())

        );
    }

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) 
    {
        return roles.stream()
            .flatMap(role -> role.getPrivileges().stream()
                .map(privilege -> new SimpleGrantedAuthority(privilege.getName()))
            )
            .collect(Collectors.toSet());
    }
}
