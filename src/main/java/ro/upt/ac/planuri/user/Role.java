//package ro.upt.ac.planuri.user;
//
//import java.util.Collection;
//
//import org.apache.catalina.User;
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
//public class Role {
//	
//	@Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    
//    @ManyToMany(mappedBy = "roles")
//    private Collection<User> users;
//
//    @ManyToMany
//    @JoinTable(
//        name = "roles_privileges", 
//        joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), 
//        inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id")
//        )
//    
//    private Collection<Privilege> privileges;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public Collection<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(Collection<User> users) {
//		this.users = users;
//	}
//
//	public Collection<Privilege> getPrivileges() {
//		return privileges;
//	}
//
//	public void setPrivileges(Collection<Privilege> privileges) {
//		this.privileges = privileges;
//	}
//
//}
