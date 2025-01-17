//package ro.upt.ac.planuri.user;
//
//import java.util.Collection;
//import java.util.List;
//
//import javax.management.relation.Role;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinTable;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToMany;
//
//@Entity
//public class User {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String firstName;
//    private String lastName;
//    private String email;
//    private String password;
//    private boolean enabled;
//    private boolean tokenExpired;
//
//    @ManyToMany 
//    @JoinTable( 
//        name = "users_roles", 
//        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), 
//        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//        ) 
//    
//    private Collection<Role> roles;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
//
//	public boolean isTokenExpired() {
//		return tokenExpired;
//	}
//
//	public void setTokenExpired(boolean tokenExpired) {
//		this.tokenExpired = tokenExpired;
//	}
//
//	public Collection<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Collection<Role> roles) {
//		this.roles = roles;
//	}
//
//	public void setRoles(List<ro.upt.ac.planuri.user.Role> asList) {
//		// TODO Auto-generated method stub
//		
//	}
//    
//}
