//package ro.upt.ac.planuri.utilizatori;
//
//import jakarta.persistence.*;
//import java.util.Set;
//
//@Entity
//public class Privilege {
//	
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//
//    @ManyToMany(mappedBy = "privileges")
//    private Set<Role> roles;
//
//	public Privilege(String name) {
//		// TODO Auto-generated constructor stub
//	}
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
//    
//
//}
