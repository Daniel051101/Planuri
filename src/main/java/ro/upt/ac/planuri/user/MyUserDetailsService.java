//package ro.upt.ac.planuri.user;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//
//import javax.security.auth.login.AccountNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import jakarta.transaction.Transactional;
//
////Spring security
//
//@Service("userDetailsService")
//@Transactional
//public class MyUserDetailsService implements UserDetailsService {
//	
//	@Autowired
//    private UserRepository userRepository;
// 
////    @Autowired
////    private IUserService service;
//// 
////    @Autowired
////    private MessageSource messages;
// 
//    @Autowired
//    private RoleRepository roleRepository;
//
////    @Override
//    public UserDetails loadUserByEmail(String email) throws AccountNotFoundException {
// 
//        User user = userRepository.findByEmail(email);
//        if (user == null) {
//            return new org.springframework.security.core.userdetails.User(
//            		" ", 
//            		" ", 
//            		true, 
//            		true, 
//            		true, 
//            		true, 
//            		getAuthorities(Arrays.asList(roleRepository.findByName("ROLE_USER")))
//            		);
//        }
//
//        return new org.springframework.security.core.userdetails.User(
//        		user.getEmail(), 
//        		user.getPassword(), 
//        		user.isEnabled(), 
//        		true, 
//        		true, 
//        		true, 
//        		getAuthorities(user.getRoles())
//        		);
//    }
//
//    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
// 
//        return getGrantedAuthorities(getPrivileges(roles));
//    }
//
//    private List<String> getPrivileges(Collection<Role> roles) {
// 
//        List<String> privileges = new ArrayList<>();
//        List<Privilege> collection = new ArrayList<>();
//        for (Role role : roles) {
//            privileges.add(role.getName());
//            collection.addAll(role.getPrivileges());
//        }
//        for (Privilege item : collection) {
//            privileges.add(item.getName());
//        }
//        return privileges;
//    }
//
//    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        for (String privilege : privileges) {
//            authorities.add(new SimpleGrantedAuthority(privilege));
//        }
//        return authorities;
//    }
//    
//    @Bean
//    public RoleHierarchy roleHierarchy() 
//    {
//        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
//        String hierarchy = "ROLE_ADMIN > ROLE_STAFF \n ROLE_STAFF > ROLE_USER";
//        roleHierarchy.setHierarchy(hierarchy);
//        return roleHierarchy;
//    }
//    //We use the > symbol in the expression to define the role hierarchy. Here, we’ve configured the role ADMIN to include the role STAFF, which in turn includes the role USER.
//    
//    @Bean
//    public DefaultWebSecurityExpressionHandler customWebSecurityExpressionHandler() 
//    {
//        DefaultWebSecurityExpressionHandler expressionHandler = new DefaultWebSecurityExpressionHandler();
//        expressionHandler.setRoleHierarchy(roleHierarchy());
//        return expressionHandler;
//    }
//
//}
